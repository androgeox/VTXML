package ru.xml.vt;

import java.io.File;
import java.nio.file.Paths;
import java.util.logging.Logger;

public class Main {
    private static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        validation(args[0], args[1]);
        String result = transformation(args[1], args[2]);
        ValidateAndSave.validateAndSave(args[0], result);
    }

    public static String validation(String xsd, String xml) {
        DocumentValidator.validate(xsd, xml);
        logger.info("incoming XML has been validated");
        return xml;
    }

    public static String transformation(String xml, String xsl) {
        String result;
        XsltTransforming xsltTransforming = new XsltTransforming();
        result = xsltTransforming.transformOrder(xml, xsl);
        logger.info("incoming XML has been transformed in new XML file");
        return result;
    }

    private static class ValidateAndSave {
        public static File validateAndSave(String xsd, String xml) {
            DocumentValidator.validate(xsd, xml);
            logger.info("new XML has been validated");
            File file = Paths.get(xml).toFile();
            logger.info("XML file has been created");
            return file;
        }
    }

}
