import entity.Salad;
import util.SaxXmlParser;
import util.StaxXmlParser;

import java.io.InputStream;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        InputStream stream = Main.class.getClassLoader().getResourceAsStream("salad.xml");

        StaxXmlParser parser = new StaxXmlParser();
        //SaxXmlParser parser=new SaxXmlParser();
        //JaxbXmlParser parser= new JaxbXmlParser();
        ArrayList<Salad> salad = parser.parse(stream);

        for (Salad sd : salad) {
            System.out.println(sd);
        }

    }
}