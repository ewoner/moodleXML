package com.ewoner.jcac_etc_questions.models.questions.Abstracts;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamException;

/**
 *
 * @author student
 * @param <Q>
 */
public interface QuestionParser{

    @Deprecated
    public void parseXMLdata( XMLEventReader reader ) throws XMLStreamException;  //old style

    public Question parseXMLQuestion( XMLEventReader reader ) throws XMLStreamException;

    public String toXMLString();
}
