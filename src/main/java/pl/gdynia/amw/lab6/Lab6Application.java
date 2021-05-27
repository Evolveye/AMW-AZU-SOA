package pl.gdynia.amw.lab6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.MalformedURLException;

@SpringBootApplication
public class Lab6Application {

	public static void main(String[] args) {
		SpringApplication.run( Lab6Application.class, args );

//		try {
//			new ApiCommunicator();
//		} catch (MalformedURLException e) {
//			System.out.println("\nMalformedURLException\n");
//		} catch (IOException e) {
//			System.out.println("\nIOException\n");
//		} catch (ParserConfigurationException e) {
//			System.out.println("\nParserConfigurationException\n");
//		} catch (SAXException e) {
//			System.out.println("\nSAXException\n");
//		}
	}

}
