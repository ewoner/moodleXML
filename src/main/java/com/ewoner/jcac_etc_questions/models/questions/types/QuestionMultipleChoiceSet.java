package com.ewoner.jcac_etc_questions.models.questions.types;

import com.ewoner.jcac_etc_questions.NewXMLParser;
import com.ewoner.jcac_etc_questions.models.answers.Answer;
import com.ewoner.jcac_etc_questions.models.feedback.Feedback;
import com.ewoner.jcac_etc_questions.models.feedback.FeedbackTypeEnum;
import com.ewoner.jcac_etc_questions.models.questions.Abstracts.AnswerNumberingEnum;
import com.ewoner.jcac_etc_questions.models.questions.Abstracts.MultiAnswerQuestions;
import com.ewoner.jcac_etc_questions.models.questions.Abstracts.Question;
import com.ewoner.jcac_etc_questions.models.questions.Abstracts.QuestionTypeEnum;
import com.ewoner.jcac_etc_questions.models.text.Text;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

/**
 * @author Brion Lang
 * @date 20 July 2022
 * @version 0.0.0
 */
public class QuestionMultipleChoiceSet extends Question implements MultiAnswerQuestions {

    public static final QuestionMultipleChoiceSet Factory = new QuestionMultipleChoiceSet();

    private AnswerNumberingEnum answernumbering;
    private Feedback correctfeedback;
    private Feedback incorrectfeedback;
    private boolean shuffeanswers;
    private Feedback generalfeedback;
    private List<Answer> answers;

    public QuestionMultipleChoiceSet() {
        this( new Text(), new Text(), new Feedback(), new Feedback() );
    }

    public QuestionMultipleChoiceSet( Text name, Text text ) {
        this( name, text, new Feedback(), new Feedback() );
    }

    public QuestionMultipleChoiceSet( Text name, Text text, Feedback correctfeedback ) {
        this( name, text, correctfeedback, new Feedback() );
    }

    public QuestionMultipleChoiceSet( Text name, Text text,
            Feedback correctfeedback, Feedback incorrectfeedback ) {
        super( QuestionTypeEnum.MultipleChoiceSet, name, text );
        this.generalfeedback = new Feedback();
        this.correctfeedback = correctfeedback;

        this.incorrectfeedback = incorrectfeedback;
        this.shuffeanswers = false;
        answers = new ArrayList<>();
    }

    public QuestionMultipleChoiceSet( QuestionMultipleChoice oldQ ) {
        this( oldQ.getName(), oldQ.getQuestiontext(), oldQ.getCorrectfeedback(), oldQ.getIncorrectfeedback() );
        this.generalfeedback = oldQ.getGeneralfeedback();
        this.shuffeanswers = oldQ.isShuffeanswers();
        this.answernumbering = oldQ.getAnswernumbering();
        this.setDefaultgrade( oldQ.getDefaultgrade() );
        this.setHidden( oldQ.isHidden() );
        this.setIdnumber( oldQ.getIdnumber() );
        this.setPenalty( oldQ.getPenalty() );
        this.setShowstandardinstruction( oldQ.isShowstandardinstruction() );

        answers = new ArrayList<>( oldQ.getAnswers() );
        for( Answer a : answers ) {
            if( a.getFraction() > 0 ) {
                a.setFraction( 100 );
            } else {
                a.setFraction( 0 );
            }
        }
    }

    @Override
    public Question parseXMLQuestion( XMLEventReader reader ) throws XMLStreamException {
        QuestionMultipleChoiceSet q = new QuestionMultipleChoiceSet();
        XMLEvent event = reader.nextEvent();
        while( !( event.isEndElement() && event.asEndElement().getName().getLocalPart().equals( "question" ) ) ) {
            if( event.isStartElement() ) {
                StartElement ele = event.asStartElement();
                switch( ele.getName().getLocalPart() ) {
                    case "name":
                        q.setName( NewXMLParser.parseTextXML( ele, reader ) );
                        break;
                    case "questiontext":
                        q.setQuestiontext( NewXMLParser.parseTextXML( ele, reader ) );
                        break;
                    case "generalfeedback":
                        q.getGeneralfeedback().setType( FeedbackTypeEnum.General );
                        q.getGeneralfeedback().setText( NewXMLParser.parseTextXML( ele, reader ) );
                        break;
                    case "defaultgrade":
                        q.setDefaultgrade( NewXMLParser.parseNumberData( reader ) );
                        break;
                    case "penalty":
                        q.setPenalty( NewXMLParser.parseNumberData( reader ) );
                        break;
                    case "hidden":
                        q.setHidden( NewXMLParser.parseBooleanDataAsNumber( reader ) );
                        break;
                    case "idnumber":
                        q.setIdnumber( NewXMLParser.parseStringData( reader ) );
                        break;
                    case "shuffleanswers":
                        q.setShuffeanswers( NewXMLParser.parseBooleanData( reader ) );
                        break;
                    case "correctfeedback":
                        q.getCorrectfeedback().setType( FeedbackTypeEnum.Correct );
                        q.getCorrectfeedback().setText( NewXMLParser.parseTextXML( ele, reader ) );
                        break;
                    case "incorrectfeedback":
                        q.getIncorrectfeedback().setType( FeedbackTypeEnum.Incorrect );
                        q.getIncorrectfeedback().setText( NewXMLParser.parseTextXML( ele, reader ) );
                        break;
                    case "answernumbering":
                        try {
                        q.setAnswernumbering( AnswerNumberingEnum.valueOf( NewXMLParser.parseStringData( reader ) ) );
                    } catch( IllegalArgumentException illegalArgumentException ) {
                        q.setAnswernumbering( AnswerNumberingEnum.none );
                        Logger.getLogger( QuestionMultipleChoiceSet.class.getName() ).log( Level.WARNING, "AnswerNumbering not excepted, set to 'none'" );
                    }
                    break;
                    case "showstandardinstruction":
                        q.setShowstandardinstruction( NewXMLParser.parseBooleanDataAsNumber( reader ) );
                        break;
                    case "answer":
                        q.addAnswer( new Answer().parseXMLAnswer( reader, ele ) );
                        break;
                    default:
                        Logger.getLogger( QuestionMultipleChoiceSet.class.getName() ).log( Level.WARNING, "Unknow tag " + ele.getName().getLocalPart() + " in Parsing question" );
                        break;
                }
            }
            event = reader.nextEvent();
        }

        return q;
    }

    public AnswerNumberingEnum getAnswernumbering() {
        return answernumbering;
    }

    public void setAnswernumbering( AnswerNumberingEnum answernumbering ) {
        this.answernumbering = answernumbering;
    }

    public Feedback getCorrectfeedback() {
        return correctfeedback;
    }

    public void setCorrectfeedback( Feedback correctfeedback ) {
        this.correctfeedback = correctfeedback;
    }

    public Feedback getIncorrectfeedback() {
        return incorrectfeedback;
    }

    public void setIncorrectfeedback( Feedback incorrectfeedback ) {
        this.incorrectfeedback = incorrectfeedback;
    }

    public boolean isShuffeanswers() {
        return shuffeanswers;
    }

    public void setShuffeanswers( boolean shuffeanswers ) {
        this.shuffeanswers = shuffeanswers;
    }

    @Override
    public boolean addAllAnswers( Collection<Answer> answersToAdd ) {
        return this.answers.addAll( answers );
    }

    @Override
    public boolean addAnswer( Answer answerToAdd ) {
        return this.answers.add( answerToAdd );
    }

    @Override
    public List<Answer> getAnswers() {
        return this.answers;
    }

    @Override
    public void setAnswers( List<Answer> answers ) {
        this.answers = answers;
    }

    @Override
    public int numOfAnswers() {
        return this.answers.size();
    }

    @Override
    public boolean removeAnswer( Answer answerToRemove ) {
        return this.answers.remove( answerToRemove );
    }

    @Override
    public Answer removeAnswer( int index ) {
        return this.answers.remove( index );
    }

    /**
     * @return the generalfeedback
     */
    public Feedback getGeneralfeedback() {
        return generalfeedback;
    }

    /**
     * @param generalfeedback the generalfeedback to set
     */
    public void setGeneralfeedback( Feedback generalfeedback ) {
        this.generalfeedback = generalfeedback;
    }

    @Override
    public void parseXMLdata( XMLEventReader reader ) throws XMLStreamException {
        throw new UnsupportedOperationException( "not in use any more" );

//        XMLEvent event = reader.nextEvent();
//        while( !( event.isEndElement() && event.asEndElement().getName().getLocalPart().equals( "question" ) ) ) {
//            if( event.isStartElement() ) {
//
//                StartElement ele = event.asStartElement();
//                switch( ele.getName().getLocalPart() ) {
//                    case "name":
//                        NewXMLParser.parseTextXML( getName(), ele, reader );
//                        break;
//                    case "questiontext":
//                        NewXMLParser.parseTextXML( getQuestiontext(), ele, reader );
//                        break;
//                    case "generalfeedback":
//                        getGeneralfeedback().setType( FeedbackTypeEnum.General );
//                        NewXMLParser.parseTextXML( getGeneralfeedback().getFeedback(), ele, reader );
//                        break;
//                    case "defaultgrade":
//                        setDefaultgrade( NewXMLParser.parseNumberData( reader ) );
//                        break;
//                    case "penalty":
//                        setPenalty( NewXMLParser.parseNumberData( reader ) );
//                        break;
//                    case "hidden":
//                        setHidden( NewXMLParser.parseBooleanDataAsNumber( reader ) );
//                        break;
//                    case "idnumber":
//                        setIdnumber( NewXMLParser.parseStringData( reader ) );
//                        break;
//                    case "shuffleanswers":
//                        setHidden( NewXMLParser.parseBooleanData( reader ) );
//                        break;
//                    case "correctfeedback":
//                        getCorrectfeedback().setType( FeedbackTypeEnum.Correct );
//                        NewXMLParser.parseTextXML( getCorrectfeedback().getFeedback(), ele, reader );
//                        break;
//                    case "incorrectfeedback":
//                        getIncorrectfeedback().setType( FeedbackTypeEnum.Incorrect );
//                        NewXMLParser.parseTextXML( getIncorrectfeedback().getFeedback(), ele, reader );
//                        break;
//                    case "answernumbering":
//                        try {
//                        setAnswernumbering( AnswerNumberingEnum.valueOf( NewXMLParser.parseStringData( reader ) ) );
//                    } catch( IllegalArgumentException illegalArgumentException ) {
//                        setAnswernumbering( AnswerNumberingEnum.none );
//                        Logger.getLogger( QuestionMultipleChoiceSet.class.getName() ).log( Level.WARNING, "AnswerNumbering not excepted, set to 'none'" );
//                    }
//                    break;
//                    case "showstandardinstruction":
//                        setShowstandardinstruction( NewXMLParser.parseBooleanDataAsNumber( reader ) );
//                        break;
//                    case "answer":
//                        Answer a = new Answer();
//                        a.parseXMLdata( reader );
//                        this.answers.add( a );
//                        break;
//                    default:
//                        break;
//                }
//            }
//            event = reader.nextEvent();
//        }
    }

    @Override
    public String toXMLString() {
        return "<question type=\"" + getType().getXMLString() + "\">\n"
                + getName().toXML( "name", false ) + '\n'
                + getQuestiontext().toXML( "questiontext" ) + '\n'
                + getGeneralfeedback().toXML() + '\n'
                + NewXMLParser.doubleToXML( "defaultgrade", getDefaultgrade() ) + "\n"
                + NewXMLParser.doubleToXML( "penalty", getPenalty() ) + "\n"
                + NewXMLParser.boolNumberToXML( "hidden", isHidden() ) + "\n"
                + NewXMLParser.stringToXML( "idnumber", getIdnumber() ) + "\n"
                + NewXMLParser.boolToXML( "shuffleanswers", isShuffeanswers() ) + "\n"
                + getCorrectfeedback().toXML() + '\n'
                + getIncorrectfeedback().toXML() + '\n'
                + "<answernumbering>" + this.getAnswernumbering().toString() + "</answernumbering>\n"
                + NewXMLParser.boolNumberToXML( "showstandardinstruction", this.isShowstandardinstruction() ) + "\n"
                + answersToXmlString()
                + "</question>\n";

    }

    private String answersToXmlString() {
        String rv = "";
        for( Answer a : answers ) {
            rv += a.toXMLString() + "\n";
        }
        return rv;
    }
}
