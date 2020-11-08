package com.ewoner.jcac_etc_questions.models.questions;

import com.ewoner.jcac_etc_questions.XMLParser;
import com.ewoner.jcac_etc_questions.models.TextFormatEnum;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;


public class QuestionTrueFalse extends QuestionFeedback {

    public static Question parseXMLElement( XMLEventReader reader ) throws XMLStreamException {
        QuestionTrueFalse rv = new QuestionTrueFalse();
        XMLEvent event = reader.nextEvent();
        while ( !( event.isEndElement() && event.asEndElement().getName().getLocalPart().equals( "question" ) ) ) {
            if ( event.isStartElement() ) {
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
                else if ( ele.getName().getLocalPart().equals( "answer" ) ) {
                    double fraction;
                    try {
                        fraction = Double.parseDouble( ele.getAttributeByName( new QName( "fraction" ) ).getValue() );
                    }
                    catch ( NumberFormatException | NullPointerException ex ) {
                        fraction = 0.0;
                    }
                    System.out.println( "Event Type ----" + event.getEventType() );
                    event = reader.nextEvent();
                    boolean answer = false;
                    while ( !( event.isEndElement() && event.asEndElement().getName().getLocalPart().equals( "answer" ) ) ) {

                        if ( event.isStartElement() ) {
                            ele = event.asStartElement();
                            if ( ele.getName().getLocalPart().equals( "text" ) ) {
                                event = reader.nextEvent();

                                answer = Boolean.parseBoolean( event.asCharacters().getData() );
                                if ( fraction > 0 ) {
                                    rv.setAnswer( answer );
                                }
                            }
                            else if ( ele.getName().getLocalPart().equals( "feedback" ) ) {
                                if ( answer ) {
                                    rv.setTrueFeedbackFormat( TextFormatEnum.valueOf( ele.getAttributeByName( new QName( "format" ) ).getValue() ) );
                                }
                                else {
                                    rv.setFalseFeedbackFormat( TextFormatEnum.valueOf( ele.getAttributeByName( new QName( "format" ) ).getValue() ) );
                                }
                                reader.nextTag();
                                event = reader.nextEvent();
                                if ( event.isCharacters() ) {
                                    if ( answer ) {
                                        rv.setTrueFeedback( event.asCharacters().getData() );
                                    }
                                    else {
                                        rv.setFalseFeedback( event.asCharacters().getData() );
                                    }
                                }
                                else {
                                    if ( answer ) {
                                        rv.setTrueFeedback( "" );
                                    }
                                    else {
                                        rv.setFalseFeedback( "" );
                                    }
                                }
                            }
                        }
                        event = reader.nextEvent();
                    }
                }
            }
            event = reader.nextEvent();
        }
        return rv;
    }

    private boolean answer;
    private String trueFeedback;
    private String falseFeedback;
    private TextFormatEnum trueFeedbackFormat;
    private TextFormatEnum falseFeedbackFormat;

    public QuestionTrueFalse() {
        this( "", "" );
    }

    public QuestionTrueFalse( String name, String text ) {
        this( name, text, true );

    }

    public QuestionTrueFalse( String name, String text, boolean answer ) {
        super( QuestionTypeEnum.TrueFalse, name, text );
        this.answer = answer;
        trueFeedback = "";
        falseFeedback = "";
        trueFeedbackFormat = TextFormatEnum.html;
        falseFeedbackFormat = TextFormatEnum.html;

    }

    public boolean getAnswer() {
        return answer;
    }

    public void setAnswer( boolean answer ) {
        this.answer = answer;
    }

    public String getTrueFeedback() {
        return trueFeedback;
    }

    public void setTrueFeedback( String trueFeedback ) {
        this.trueFeedback = trueFeedback;
    }

    public String getFalseFeedback() {
        return falseFeedback;
    }

    public void setFalseFeedback( String falseFeedback ) {
        this.falseFeedback = falseFeedback;
    }

    public TextFormatEnum getTrueFeedbackFormat() {
        return trueFeedbackFormat;
    }

    public void setTrueFeedbackFormat( TextFormatEnum trueFeedbackFormat ) {
        this.trueFeedbackFormat = trueFeedbackFormat;
    }

    public TextFormatEnum getFalseFeedbackFormat() {
        return falseFeedbackFormat;
    }

    public void setFalseFeedbackFormat( TextFormatEnum falseFeedbackFormat ) {
        this.falseFeedbackFormat = falseFeedbackFormat;
    }
}
