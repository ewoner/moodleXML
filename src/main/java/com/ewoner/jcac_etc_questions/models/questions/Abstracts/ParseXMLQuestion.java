package com.ewoner.jcac_etc_questions.models.questions.Abstracts;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamException;

/**
 *
 * @author student
 * @param <Q>
 */
@Deprecated
public interface ParseXMLQuestion<Q extends Question> {

    public  Q parseXMLQuestion( XMLEventReader reader ) throws XMLStreamException;
}
