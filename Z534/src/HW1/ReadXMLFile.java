package HW1;

import java.io.StringReader;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
/*
 * input a String file(XML: <DOC>....</DOC>)
 * @return HashMap contains each field in input fields[] and its content
 */
public class ReadXMLFile {

    public HashMap<String, String> parse(String xmlRecords, String[] fields) throws Exception {
        HashMap<String, String> document = new HashMap<String, String>();

        DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        InputSource is = new InputSource();
        is.setCharacterStream(new StringReader(xmlRecords));
        Document doc = db.parse(is);
        for (String field : fields) {
            String value = "";
            NodeList nodeList = doc.getElementsByTagName(field);
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                value += element.getTextContent();
            }
            document.put(field, value);
        }
        return document;
    }

    
    //test 
//    public static void main(String arg[]) throws Exception {
//        String xmlRecords = "<DOC><DOCNO> AP890101-0001 </DOCNO>" + "<FILEID>AP-NR-01-01-89 2358EST</FILEID>"
//                + "<FIRST>r a PM-APArts:60sMovies     01-01 1073</FIRST>"
//                + "<SECOND>PM-AP Arts: 60s Movies,1100</SECOND>"
//                + "<HEAD>You Don't Need a Weatherman To Know '60s Films Are Here</HEAD>"
//                + "<HEAD>Eds: Also in Monday AMs report.</HEAD>" + "<BYLINE>By HILLEL ITALIE</BYLINE>"
//                + "<BYLINE>Associated Press Writer</BYLINE>" + "<DATELINE>NEW YORK (AP) </DATELINE>"
//                + "<TEXT>The celluloid torch has been passed to a new generation: filmmakers who grew up in the 1960s.</TEXT></DOC>";
//        String[] fields = {"DOCNO", "HEAD", "TEXT"};
//        ReadXMLFile r = new ReadXMLFile();
//        HashMap<String, String> document = r.parse(xmlRecords, fields);
//        System.out.println(document.toString());
//    }

}