package com.ewoner.jcac_etc_questions.models.answers;

import com.ewoner.jcac_etc_questions.NewXMLParser;
import com.ewoner.jcac_etc_questions.models.feedback.Feedback;
import com.ewoner.jcac_etc_questions.models.feedback.FeedbackTypeEnum;
import com.ewoner.jcac_etc_questions.models.text.Text;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

/**
 *
 * @author student
 */
public class Answer implements AnswerParser {
    
    public static final Answer Factory = new Answer();

    public Answer parseXMLAnswer( XMLEventReader reader, StartElement answerEle ) throws XMLStreamException {
        Answer rv = new Answer();
        String fractionString = answerEle.getAttributeByName( new QName( "fraction" ) ).getValue();
        rv.setText( NewXMLParser.parseTextXML( answerEle, reader ) );
        XMLEvent event = reader.nextEvent();
        while( !( event.isEndElement() && event.asEndElement().getName().getLocalPart().equals( "answer" ) ) ) {
            if( event.isStartElement() ) {
                StartElement ele = event.asStartElement();
                switch( ele.getName().getLocalPart() ) {
                    case "feedback" -> {
                        rv.getFeedback().setType( FeedbackTypeEnum.Answer );
                        rv.getFeedback().setText( NewXMLParser.parseTextXML( ele, reader ) );
                    }
                }
            }
            event = reader.nextEvent();
        }
        try {
            rv.setFraction( Double.parseDouble( fractionString ) );
        } catch( NumberFormatException | NullPointerException e ) {
            rv.fraction = 0.0;
            Logger.getLogger( Answer.class.getName() ).log( Level.WARNING, "Fraction was a 'null' or non-number in XML.  Setting to 0.0" );

        }
        return rv;
    }

    private Feedback feedback;
    private Text text;
    private double fraction;

    public Answer() {
        this.feedback = new Feedback();
        this.text = new Text();
        this.fraction = 0.0;
    }

    /**
     * @return the feedback
     */
    public Feedback getFeedback() {
        return feedback;
    }

    /**
     * @param feedback the feedback to set
     */
    public void setFeedback( Feedback feedback ) {
        this.feedback = feedback;
    }

    /**
     * @return the text
     */
    public Text getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText( Text text ) {
        this.text = text;
    }

    /**
     * @return the fraction
     */
    public double getFraction() {
        return fraction;
    }

    /**
     * @param fraction the fraction to set
     */
    public void setFraction( double fraction ) {
        this.fraction = fraction;
    }

    @Override
    public String toXMLString() {
        return "<answer fraction=\"" + getFraction() + "\" format=\"" + getText().getFormat() + "\">\n"+
                getText().toXML() + '\n' +
                getFeedback().toXML( "feedback") + '\n' +
                "</answer>";
    }

    @Override
    public void parseXMLdata( XMLEventReader reader ) throws XMLStreamException {
        throw new UnsupportedOperationException( "Not supported yet." ); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Answer parseXMLAnswer( XMLEventReader reader ) throws XMLStreamException {
        throw new UnsupportedOperationException( "Not supported yet." ); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
