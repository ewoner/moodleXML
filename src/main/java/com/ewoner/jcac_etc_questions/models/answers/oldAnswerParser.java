package com.ewoner.jcac_etc_questions.models.answers;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;

/**
 *
 * @author Brion Lang
 * @param <A>
 */
@Deprecated
public interface oldAnswerParser<A extends Answer> {

    public A createAnswerFromXML( XMLEventReader reader, StartElement ele ) throws XMLStreamException;

    public String toXMLString();
}
