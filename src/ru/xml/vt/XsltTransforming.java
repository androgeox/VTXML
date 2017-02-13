package ru.xml.vt;


import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.StringWriter;
import java.nio.file.Paths;

public class XsltTransforming {
    public String transformOrder(String source, String result){
        StringWriter writer = new StringWriter();

        try {
            File xmlDoc = Paths.get(source).toFile();
            File xls = Paths.get(result).toFile();

            TransformerFactory factory = TransformerFactory.newInstance("net.sf.saxon.TransformerFactoryImpl", null);

            Transformer transformer = factory.newTransformer(new StreamSource(xls));
            transformer.transform(new StreamSource(xmlDoc), new StreamResult(writer));
        } catch (TransformerException e) {
            System.out.println("Exception: " + e.getMessage());
            e.printStackTrace();
        }
        return writer.toString();
    }
}
