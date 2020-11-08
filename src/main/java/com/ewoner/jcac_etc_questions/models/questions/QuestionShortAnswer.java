package com.ewoner.jcac_etc_questions.models.questions;

import com.ewoner.jcac_etc_questions.models.answers.AnswerText;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;


public class QuestionShortAnswer extends QuestionAbstractMultiAnswer<AnswerText> {

    public static Question parseXMLElement( XMLEventReader reader ) throws XMLStreamException {
        QuestionShortAnswer rv = new QuestionShortAnswer();
        while ( reader.hasNext() && reader.peek().isEndElement() && !reader.peek().asStartElement().getName().equals( new QName( "question" ) ) ) {
            XMLEvent nextEvent = reader.nextEvent();
            if ( nextEvent.isStartElement() ) {
                String name = nextEvent.asStartElement().getName().toString();
                System.out.println( "the name is =" + name );
            }
        }

        return rv;
    }

    private boolean usecase;

    public QuestionShortAnswer() {
        this( "", "" );
    }

    public QuestionShortAnswer( String name, String text ) {
        this( name, text, new ArrayList<>(), false );
    }

    public QuestionShortAnswer( String name, String text, List<AnswerText> answers ) {
        this( name, text, answers, false );
    }

    public QuestionShortAnswer( String name, String text, List<AnswerText> answers, boolean usecase ) {
        super( QuestionTypeEnum.ShortAnswer, name, text );
        this.setAnswers( answers );
        this.usecase = usecase;
    }

    /**
     * @return the usecase
     */
    public boolean isUsecase() {
        return usecase;
    }

    /**
     * @param usecase the usecase to set
     */
    public void setUsecase( boolean usecase ) {
        this.usecase = usecase;
    }
}
