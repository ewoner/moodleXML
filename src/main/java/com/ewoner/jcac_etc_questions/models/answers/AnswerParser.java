package com.ewoner.jcac_etc_questions.models.answers;

import com.ewoner.jcac_etc_questions.models.answers.Answer;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamException;

/**
 *
 * @author student
 */
public interface AnswerParser{

    @Deprecated
    public void parseXMLdata( XMLEventReader reader ) throws XMLStreamException;  //old style

    public Answer parseXMLAnswer( XMLEventReader reader ) throws XMLStreamException;

    public String toXMLString();
}
