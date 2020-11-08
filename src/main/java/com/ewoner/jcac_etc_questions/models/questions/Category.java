package com.ewoner.jcac_etc_questions.models.questions;

import com.ewoner.jcac_etc_questions.models.TextFormatEnum;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;


public class Category extends Question {

    public static Category parseXMLElement( XMLEventReader reader ) throws XMLStreamException {
        Category rv = new Category();
        XMLEvent event = reader.nextEvent();
        while ( !( event.isEndElement() && event.asEndElement().getName().getLocalPart().equals( "question" ) ) ) {
            if ( event.isStartElement() ) {
                StartElement ele = event.asStartElement();
                if ( ele.getName().getLocalPart().equals( "category" ) ) {
                    reader.nextTag();
                    rv.setName( reader.nextEvent().asCharacters().getData() );
                }
                else if ( ele.getName().getLocalPart().equals( "info" ) ) {
                    rv.setTextFormat( TextFormatEnum.valueOf( ele.getAttributeByName( new QName( "format" ) ).getValue() ) );
                    reader.nextTag();
                    event = reader.nextEvent();
                    if ( event.isCharacters() ) {
                        rv.setText( event.asCharacters().getData() );
                    }
                    else {
                        rv.setText( "" );
                    }
                }
                else if ( ele.getName().getLocalPart().equals( "idnumber" ) ) {
                    if ( event.isCharacters() ) {
                        rv.setId( reader.nextEvent().asCharacters().getData() );
                    }
                    else {
                        rv.setId( "" );
                    }
                }
            }
            event = reader.nextEvent();
        }
        return rv;
    }

    private List<Question> questions;
//    private String name;
//    private String text;
//    private TextFormatEnum textType;
//    private String id;

    public Category() {
        this( "" );
    }

    public Category( String name ) {
        this( name, new ArrayList<>() );
    }

    public Category( String name, List<Question> questions ) {
        super( QuestionTypeEnum.Category, name, "" );
//        this.questions = questions;

    }

    public List<Question> getQuestions() {
        return Collections.unmodifiableList( questions );

    }

    public void setQuestions( List<Question> questions ) {
        this.questions = questions;
    }
}
/*
    switch ( type ) {
            case "truefalse":
                tf++;
                break;
            case "numerical":
                n++;
                rv = QuestionShortAnswer.parseXMLElement( reader );
                break;
            case "shortanswer":
                sa++;
                break;
            case "multichoice":
                mc++;
                break;
            case "cloze":
                cloze++;
                break;
            case "regexp":
                rx++;
                break;
            case "category":
               
                break;
            case "ddmatch":
                ddm++;
                break;
            case "matching":
                mat++;
                break;
            case "essay":
                essay++;
                break;
            case "ddwtos":
                ddwtos++;
                break;
            case "calculated":
                cal++;
                break;
            case "coderunner":
                code++;
                break;
            case "randomsamatch":
                rsam++;
                break;
            case "gapselect":
                gap++;
                break;
            case "calculatedmulti":
                calm++;
                break;
            default:
                other++;
                System.out.println( type );
        }
 */
