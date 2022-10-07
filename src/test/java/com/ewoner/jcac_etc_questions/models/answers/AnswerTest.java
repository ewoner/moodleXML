package com.ewoner.jcac_etc_questions.models.answers;

import com.ewoner.jcac_etc_questions.Main;
import com.ewoner.jcac_etc_questions.models.feedback.Feedback;
import com.ewoner.jcac_etc_questions.models.feedback.FeedbackTypeEnum;
import com.ewoner.jcac_etc_questions.models.text.Text;
import com.ewoner.jcac_etc_questions.models.text.TextFormatEnum;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;
import junit.framework.TestCase;

/**
 *
 * @author student
 */
public class AnswerTest extends TestCase {

    public AnswerTest( String testName ) {
        super( testName );
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of createAnswerFromXML method, of class Answer.
     *
     * @throws java.lang.Exception
     */
    public void testCreateAnswerFromXML() throws Exception {
        System.out.println( "createAnswerFromXML" );
        Answer instance = null;
        try {
            File file = new File( "/home/student/git-projects/newMoodleXML/src/main/answer.xml" );
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLEventReader reader = factory.createXMLEventReader( new FileInputStream( file ) );
            while( reader.hasNext() ) {
                if( reader.peek().isStartElement() ) {
                    if( reader.peek().asStartElement().getName().getLocalPart().equals( "answer" ) ) {
                        instance = Answer.Factory.createAnswerFromXML( reader, ( StartElement ) reader.nextEvent() );
                    }
                }
                reader.next();
            }
        } catch( FileNotFoundException | XMLStreamException ex ) {
            Logger.getLogger( Main.class.getName() ).log( Level.SEVERE, null, ex );
            fail( ex.getMessage() );
        }
        double testFraction = -50.0;
        TextFormatEnum testFormat = TextFormatEnum.html;
        String testText = "<p><b>if</b>/<b>else</b><br></p>";
        FeedbackTypeEnum testFeedbackType = FeedbackTypeEnum.Answer;
        String testFeedbackText = "This is a text";
        if( instance == null ) {
            fail( "Instance was not initilized." );
        } else {
            assertEquals( instance.getFraction(), testFraction, 0.0 );
            assertEquals( instance.getText().getText(), testText );
            assertEquals( instance.getText().getFormat(), testFormat );
            assertEquals( instance.getFeedback().getType(), testFeedbackType );
            assertEquals( instance.getFeedback().getText().getFormat(), testFormat );
            assertEquals( instance.getFeedback().getText().getText(), testFeedbackText );
            System.out.println( "\n\n\n" + instance.toXMLString() );

        }
    }

    /**
     * Test of getFeedback method, of class Answer.
     */
    public void testGetFeedback() {
        System.out.println( "getFeedback" );
        Answer instance = new Answer();
        Feedback expResult = new Feedback();
        Feedback result = instance.getFeedback();
        assertEquals( expResult.getType(), result.getType() );
        assertEquals( expResult.getText().getFormat(), result.getText().getFormat() );
        assertEquals( expResult.getText().getText(), result.getText().getText() );

    }

    /**
     * Test of setFeedback method, of class Answer.
     */
    public void testSetFeedback() {
        System.out.println( "setFeedback" );
        String testString = "This is a test";
        FeedbackTypeEnum testType = FeedbackTypeEnum.Answer;
        Feedback feedback = new Feedback();
        feedback.setType( testType );
        TextFormatEnum testFormat = TextFormatEnum.html;
        feedback.getText().setFormat( testFormat );
        feedback.getText().setText( testString );
        Answer instance = new Answer();
        instance.setFeedback( feedback );
        assertEquals( instance.getFeedback().getType(), testType );
        assertEquals( instance.getFeedback().getText().getFormat(), testFormat );
        assertEquals( instance.getFeedback().getText().getText(), testString );

    }

    /**
     * Test of getText method, of class Answer.
     */
    public void testGetText() {
        System.out.println( "getText" );
        Answer instance = new Answer();
        Text expResult = new Text( "This is a test" );
        instance.setText( expResult );
        Text result = instance.getText();
        assertEquals( expResult, result );

    }

    /**
     * Test of setText method, of class Answer.
     */
    public void testSetText() {
        System.out.println( "setText" );
        String testString = "This is a test";
        TextFormatEnum testFormat = TextFormatEnum.html;
        Text test = new Text( testString, testFormat );
        Answer instance = new Answer();
        instance.setText( test );
        assertEquals( instance.getText(), test );

    }

    /**
     * Test of getFraction method, of class Answer.
     */
    public void testGetFraction() {
        System.out.println( "getFraction" );
        Answer instance = new Answer();
        double expResult = 10.125;
        instance.setFraction( expResult );
        double result = instance.getFraction();
        assertEquals( expResult, result, 0.0 );
    }

    /**
     * Test of setFraction method, of class Answer.
     */
    public void testSetFraction() {
        System.out.println( "setFraction" );
        double fraction = 10.125;
        Answer instance = new Answer();
        instance.setFraction( fraction );
        assertEquals( instance.getFraction(), fraction );

    }

}
