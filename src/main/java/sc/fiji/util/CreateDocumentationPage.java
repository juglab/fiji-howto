package sc.fiji.util;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import org.apache.commons.text.StringEscapeUtils;
import org.scijava.util.XML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CreateDocumentationPage {

	private final File xmlDocFile;
	private final File htmlTemplateFile;
	private final XML docFile;
	private final XML outFile;
	private final Document document;

	public CreateDocumentationPage() throws IOException, SAXException, ParserConfigurationException {
		xmlDocFile = new File("target/javadoc.xml");
		htmlTemplateFile = new File("src/main/resources/template.html");
		docFile = new XML(xmlDocFile);
		outFile = new XML(htmlTemplateFile);
		document = outFile.getDocument();
	}


	public void run() throws IOException {

		Node main = document.getElementsByTagName("main").item(0);
		NodeList packages = docFile.getDocument().getElementsByTagName("package");

		for (int i = 0; i < packages.getLength(); i++) {
			createPackage(main, packages.item(i));
		}

		write(outFile.toString(), "doc/index.html");

	}

	private void createPackage(Node outFile, Node packageItem) throws IOException {
		String packagePath = getName(packageItem);
		if(packagePath.equals("sc.fiji.util")) return;

		Path sourcePath = Paths.get("src/main/java/" + packagePath.replace(".", "/"));
		String name = packagePath.replace("sc.fiji.howto.", "");
		name = name.substring(0,1).toUpperCase() + name.substring(1);
		Element block = document.createElement("div");
		Element header = document.createElement("h2");
		header.setTextContent(name);
		block.appendChild(header);
		NodeList tasks = packageItem.getChildNodes();
		for (int i = 0; i < tasks.getLength(); i++) {
			createHowTo(sourcePath, block, tasks.item(i));
		}
		outFile.appendChild(block);
	}

	private void createHowTo(Path sourcePath, Element block, Node item) {
		if(!item.getNodeName().equals("class")) return;
		String classComment = getComment(item);
		Element header = document.createElement("h3");
		String title = classComment != null? classComment : getName(item);
		header.setTextContent(title);
		block.appendChild(header);
		for (int i = 0; i < item.getChildNodes().getLength(); i++) {
			createSolution(Paths.get(sourcePath.toAbsolutePath() + "/" + getName(item) + ".java"), block, item.getChildNodes().item(i));
		}
	}

	private void createSolution(Path sourcePath, Element block, Node item) {
		if(!item.getNodeName().equals("method")) return;
		if(item.getAttributes().getNamedItem("name").getNodeValue().equals("main")) return;
		String comment = getComment(item);
		if(comment != null) {
			Element commentElement = document.createElement("p");
			commentElement.setTextContent(comment);
			block.appendChild(commentElement);
		}
		String id = item.getAttributes().getNamedItem("name").getNodeValue();

		CompilationUnit compilationUnit = null;
		try {
			compilationUnit = StaticJavaParser.parse(sourcePath);
			List<MethodDeclaration> methods = compilationUnit.findAll(MethodDeclaration.class);
			for (MethodDeclaration method : methods) {
				if (method.getName().toString().equals(id)) {
					Element sourceElement = document.createElement("pre");
					Element codeElement = document.createElement("code");
					codeElement.setAttribute("class", "language-java");
					codeElement.setTextContent(parseBody(method));
					sourceElement.appendChild(codeElement);
					block.appendChild(sourceElement);
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String parseBody(MethodDeclaration method) {
		String body = method.getBody().get().toString();
		//get rid of body parentheses
		body = body.substring(1, body.length()-2);
		String[] lines = body.split("\n");
		//get rid of first indent
		body = "";
		for(String line : lines) {
			body += line.replaceFirst("    ", "") + "\n";
		}
		return body;
	}

	private static String getName(Node item) {
		return item.getAttributes().getNamedItem("name").getNodeValue();
	}

	private static String getComment(Node item) {
		if(!item.hasChildNodes()) return null;
		for (int i = 0; i < item.getChildNodes().getLength(); i++) {
			if(item.getChildNodes().item(i).getNodeName().equals("comment")) {
				String comment = item.getChildNodes().item(i).getTextContent();
//				System.out.println(StringEscapeUtils.unescapeHtml4(comment));
				return StringEscapeUtils.unescapeHtml4(comment);
			}
		}
		return null;
	}

	public static void write(String content, String fileName) throws IOException {
		File file = new File(fileName);
		OutputStream outputStream = new FileOutputStream(file.getAbsoluteFile());
		Writer writer=new OutputStreamWriter(outputStream);
		writer.write(content);
		writer.close();

	}

	public static void main(String...args) throws IOException, SAXException, ParserConfigurationException {
		new CreateDocumentationPage().run();
	}
}
