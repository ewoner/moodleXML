package com.ewoner.jcac_etc_questions.models.questions;

import com.ewoner.jcac_etc_questions.XMLParser;
import com.ewoner.jcac_etc_questions.models.answers.AnswerNumberingEnum;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;


public class QuestionMultipleChoice extends QuestionAbstractMultiAnswer {

    public static Question parseXMLElemnet( XMLEventReader reader ) throws XMLStreamException {
        QuestionMultipleChoice rv = new QuestionMultipleChoice();
        XMLEvent event = reader.nextEvent();
        while ( !( event.isEndElement() && event.asEndElement().getName().getLocalPart().equals( "question" ) ) ) {
            if ( event.isStartElement() ) {
            }
            StartElement ele = event.asStartElement();
            if ( ele.getName().getLocalPart().equals( "name" ) ) {
                XMLParser.parseName( rv, reader );
            }
            else if ( ele.getName().getLocalPart().equals( "questiontext" ) ) {
                XMLParser.parseQuestionText( rv, ele, reader );
            }
            else if ( ele.getName().getLocalPart().equals( "generalfeedback" ) ) {
                XMLParser.parseFeedback( rv, ele, reader );
            }
            else if ( ele.getName().getLocalPart().equals( "defaultgrade" ) ) {
                XMLParser.parseDefaultGrade( rv, reader );
            }
            else if ( ele.getName().getLocalPart().equals( "penalty" ) ) {
                XMLParser.parsePenalty( rv, reader );
            }
            else if ( ele.getName().getLocalPart().equals( "hidden" ) ) {
                XMLParser.parseHidden( rv, reader );
            }
            else if ( ele.getName().getLocalPart().equals( "idnumber" ) ) {
                XMLParser.parseId( rv, reader );
            }
            else if ( ele.getName().getLocalPart().equals( "single" ) ) {
            }
            else if ( ele.getName().getLocalPart().equals( "shuffleanswers" ) ) {
            }
            else if ( ele.getName().getLocalPart().equals( "answernumbering" ) ) {
            }
            else if ( ele.getName().getLocalPart().equals( "correctfeedback" ) ) {
            }
            else if ( ele.getName().getLocalPart().equals( "partiallycorrectfeedback" ) ) {
            }
            else if ( ele.getName().getLocalPart().equals( "incorrectfeedback" ) ) {
            }
            else if ( ele.getName().getLocalPart().equals( "shownumcorrect" ) ) {
            }
            else if ( ele.getName().getLocalPart().equals( "answer" ) ) {
            }
            event = reader.nextEvent();
        }
        return rv;
    }

    private AnswerNumberingEnum answerNumbering;
    private String correctFeedback;
    private String partiallyCorrectFeedback;
    private boolean shuffeAnswers;
    private boolean single;

    public QuestionMultipleChoice() {
        this( "", "", "", "" );
    }

    public QuestionMultipleChoice( String name, String text ) {
        this( name, text, "", "" );
    }

    public QuestionMultipleChoice( String name, String text, String correctFeedback ) {
        this( name, text, correctFeedback, "" );
    }

    public QuestionMultipleChoice( String name, String text,
            String correctFeedback, String partiallyCorrectFeedback ) {
        this( name, text, correctFeedback, partiallyCorrectFeedback, true );
    }

    public QuestionMultipleChoice( String name, String text,
            String correctFeedback, String partiallyCorrectFeedback,
            boolean single ) {
        super( QuestionTypeEnum.MultipleChoice, name, text );
        this.shuffeAnswers = true;
    }

    public AnswerNumberingEnum getAnswerNumbering() {
        return answerNumbering;
    }

    public void setAnswerNumbering( AnswerNumberingEnum answerNumbering ) {
        this.answerNumbering = answerNumbering;
    }

    public String getCorrectFeedback() {
        return correctFeedback;
    }

    public void setCorrectFeedback( String correctFeedback ) {
        this.correctFeedback = correctFeedback;
    }

    public String getPartiallyCorrectFeedback() {
        return partiallyCorrectFeedback;
    }

    public void setPartiallyCorrectFeedback( String partiallyCorrectFeedback ) {
        this.partiallyCorrectFeedback = partiallyCorrectFeedback;
    }

    public boolean isShuffeAnswers() {
        return shuffeAnswers;
    }

    public void setShuffeAnswers( boolean shuffeAnswers ) {
        this.shuffeAnswers = shuffeAnswers;
    }

    public boolean isSingle() {
        return single;
    }

    public void setSingle( boolean single ) {
        this.single = single;
    }
}
