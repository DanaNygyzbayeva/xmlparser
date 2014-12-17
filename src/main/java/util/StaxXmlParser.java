package util;

import entity.Salad;
import entity.SaladEnum;


import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.InputStream;
import java.util.ArrayList;

public class StaxXmlParser {

    public ArrayList<Salad> parse(InputStream stream) {

        XMLInputFactory factory = XMLInputFactory.newFactory();
        ArrayList<Salad> salads = new ArrayList<Salad>();
        try {

            Salad sd = new Salad();
            String name;
            String attribute;

            XMLStreamReader reader = factory.createXMLStreamReader(stream);
            while (reader.hasNext()) {
                int next = reader.next();
                switch (next) {

                    case XMLStreamConstants.START_ELEMENT:

                        name = reader.getLocalName();

                        switch (SaladEnum.valueOf(name.toUpperCase())) {
                            case SALAD:
                                sd = new Salad();
                                attribute = reader.getAttributeValue(null, SaladEnum.ID.getValue());
                                sd.setId(Long.parseLong(attribute));
                                break;
                            case NAME:
                                sd.setName(getXMLText(reader));
                                break;
                            case PRICE:
                                name = getXMLText(reader);
                                sd.setPrice(Double.parseDouble(name));
                                break;
                            case CONTENT:
                                sd.setContent(getXMLAContent(reader));
                                break;
                        }

                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        name = reader.getLocalName();
                        if (SaladEnum.valueOf(name.toUpperCase()) ==
                                SaladEnum.SALAD) {
                            salads.add(sd);
                        }
                        break;

                    case XMLStreamConstants.CHARACTERS:
                        reader.getText().trim();
                        break;

                }
            }
        } catch (XMLStreamException e) {
            throw new RuntimeException(e);
        }
        return salads;
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }

    private Salad.Content getXMLAContent(XMLStreamReader reader)
            throws XMLStreamException {
        Salad.Content content = new Salad.Content();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (SaladEnum.valueOf(name.toUpperCase())) {
                        case VEGETABLE:
                            content.setVegetable(getXMLText(reader));
                            break;
                        case DRESSING:
                            content.setDressing(getXMLText(reader));
                            break;
                        case SEASONING:
                            content.setSeasoning(getXMLText(reader));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (SaladEnum.valueOf(name.toUpperCase()) ==
                            SaladEnum.CONTENT) {
                        return content;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Content");
    }
}
