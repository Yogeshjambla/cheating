import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.*;
import java.io.File;

public class XMLParserDOM {
    public static void main(String[] args) {
        try {
            // Load XML file
            File inputFile = new File("books.xml");
            
            // Setup DOM parser
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
            
            NodeList bookList = doc.getElementsByTagName("book");
            
            // Iterate through each <book> element
            for (int i = 0; i < bookList.getLength(); i++) {
                Node node = bookList.item(i);
                
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element book = (Element) node;
                    
                    String title = book.getElementsByTagName("title").item(0).getTextContent();
                    String author = book.getElementsByTagName("author").item(0).getTextContent();
                    String isbn = book.getElementsByTagName("isbn").item(0).getTextContent();
                    String publisher = book.getElementsByTagName("publisher").item(0).getTextContent();
                    String edition = book.getElementsByTagName("edition").item(0).getTextContent();
                    String price = book.getElementsByTagName("price").item(0).getTextContent();
                    
                    System.out.println("\nBook " + (i + 1));
                    System.out.println("Title     : " + title);
                    System.out.println("Author    : " + author);
                    System.out.println("ISBN      : " + isbn);
                    System.out.println("Publisher : " + publisher);
                    System.out.println("Edition   : " + edition);
                    System.out.println("Price     : $" + price);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
