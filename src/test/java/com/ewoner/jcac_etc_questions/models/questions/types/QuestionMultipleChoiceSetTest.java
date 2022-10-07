package com.ewoner.jcac_etc_questions.models.questions.types;

import com.ewoner.jcac_etc_questions.Main;
import com.ewoner.jcac_etc_questions.models.answers.Answer;
import com.ewoner.jcac_etc_questions.models.feedback.Feedback;
import com.ewoner.jcac_etc_questions.models.feedback.FeedbackTypeEnum;
import com.ewoner.jcac_etc_questions.models.questions.Abstracts.AnswerNumberingEnum;
import com.ewoner.jcac_etc_questions.models.questions.Abstracts.Question;
import com.ewoner.jcac_etc_questions.models.text.TextFormatEnum;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;
import junit.framework.TestCase;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;

/**
 *
 * @author student
 */
public class QuestionMultipleChoiceSetTest extends TestCase {
    
    public QuestionMultipleChoiceSetTest( String testName ) {
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
     * Test of parseXMLQuestion method, of class QuestionMultipleChoiceSet.
     */
    public void testParseXMLQuestion() throws Exception {
        System.out.println( "createAnswerFromXML" );
        QuestionMultipleChoiceSet instance = null;
        try {
            File file = new File( "/home/student/git-projects/newMoodleXML/src/main/multichoiceset.xml" );
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLEventReader reader = factory.createXMLEventReader( new FileInputStream( file ) );
            while( reader.hasNext() ) {
                if( reader.peek().isStartElement() ) {
                    if( reader.peek().asStartElement().getName().getLocalPart().equals( "question" ) ) {
                        instance = ( QuestionMultipleChoiceSet ) QuestionMultipleChoiceSet.Factory.parseXMLQuestion( reader );
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
//            assertEquals( instance.getFraction(), testFraction, 0.0 );
//            assertEquals( instance.getText().getText(), testText );
//            assertEquals( instance.getText().getFormat(), testFormat );
//            assertEquals( instance.getFeedback().getType(), testFeedbackType );
//            assertEquals( instance.getFeedback().getText().getFormat(), testFormat );
//            assertEquals( instance.getFeedback().getText().getText(), testFeedbackText );
            System.out.println( "\n\n\n" + instance.toXMLString() );

        }
    }

    /**
     * Test of getAnswernumbering method, of class QuestionMultipleChoiceSet.
     */
    public void testGetAnswernumbering() {
        System.out.println( "getAnswernumbering" );
        QuestionMultipleChoiceSet instance = new QuestionMultipleChoiceSet();
        AnswerNumberingEnum expResult = null;
        AnswerNumberingEnum result = instance.getAnswernumbering();
        assertEquals( expResult, result );
        // TODO review the generated test code and remove the default call to fail.
        fail( "The test case is a prototype." );
    }

    /**
     * Test of setAnswernumbering method, of class QuestionMultipleChoiceSet.
     */
    public void testSetAnswernumbering() {
        System.out.println( "setAnswernumbering" );
        AnswerNumberingEnum answernumbering = null;
        QuestionMultipleChoiceSet instance = new QuestionMultipleChoiceSet();
        instance.setAnswernumbering( answernumbering );
        // TODO review the generated test code and remove the default call to fail.
        fail( "The test case is a prototype." );
    }

    /**
     * Test of getCorrectfeedback method, of class QuestionMultipleChoiceSet.
     */
    public void testGetCorrectfeedback() {
        System.out.println( "getCorrectfeedback" );
        QuestionMultipleChoiceSet instance = new QuestionMultipleChoiceSet();
        Feedback expResult = null;
        Feedback result = instance.getCorrectfeedback();
        assertEquals( expResult, result );
        // TODO review the generated test code and remove the default call to fail.
        fail( "The test case is a prototype." );
    }

    /**
     * Test of setCorrectfeedback method, of class QuestionMultipleChoiceSet.
     */
    public void testSetCorrectfeedback() {
        System.out.println( "setCorrectfeedback" );
        Feedback correctfeedback = null;
        QuestionMultipleChoiceSet instance = new QuestionMultipleChoiceSet();
        instance.setCorrectfeedback( correctfeedback );
        // TODO review the generated test code and remove the default call to fail.
        fail( "The test case is a prototype." );
    }

    /**
     * Test of getIncorrectfeedback method, of class QuestionMultipleChoiceSet.
     */
    public void testGetIncorrectfeedback() {
        System.out.println( "getIncorrectfeedback" );
        QuestionMultipleChoiceSet instance = new QuestionMultipleChoiceSet();
        Feedback expResult = null;
        Feedback result = instance.getIncorrectfeedback();
        assertEquals( expResult, result );
        // TODO review the generated test code and remove the default call to fail.
        fail( "The test case is a prototype." );
    }

    /**
     * Test of setIncorrectfeedback method, of class QuestionMultipleChoiceSet.
     */
    public void testSetIncorrectfeedback() {
        System.out.println( "setIncorrectfeedback" );
        Feedback incorrectfeedback = null;
        QuestionMultipleChoiceSet instance = new QuestionMultipleChoiceSet();
        instance.setIncorrectfeedback( incorrectfeedback );
        // TODO review the generated test code and remove the default call to fail.
        fail( "The test case is a prototype." );
    }

    /**
     * Test of isShuffeanswers method, of class QuestionMultipleChoiceSet.
     */
    public void testIsShuffeanswers() {
        System.out.println( "isShuffeanswers" );
        QuestionMultipleChoiceSet instance = new QuestionMultipleChoiceSet();
        boolean expResult = false;
        boolean result = instance.isShuffeanswers();
        assertEquals( expResult, result );
        // TODO review the generated test code and remove the default call to fail.
        fail( "The test case is a prototype." );
    }

    /**
     * Test of setShuffeanswers method, of class QuestionMultipleChoiceSet.
     */
    public void testSetShuffeanswers() {
        System.out.println( "setShuffeanswers" );
        boolean shuffeanswers = false;
        QuestionMultipleChoiceSet instance = new QuestionMultipleChoiceSet();
        instance.setShuffeanswers( shuffeanswers );
        // TODO review the generated test code and remove the default call to fail.
        fail( "The test case is a prototype." );
    }

    /**
     * Test of addAllAnswers method, of class QuestionMultipleChoiceSet.
     */
    public void testAddAllAnswers() {
        System.out.println( "addAllAnswers" );
        Collection<Answer> answersToAdd = null;
        QuestionMultipleChoiceSet instance = new QuestionMultipleChoiceSet();
        boolean expResult = false;
        boolean result = instance.addAllAnswers( answersToAdd );
        assertEquals( expResult, result );
        // TODO review the generated test code and remove the default call to fail.
        fail( "The test case is a prototype." );
    }

    /**
     * Test of addAnswer method, of class QuestionMultipleChoiceSet.
     */
    public void testAddAnswer() {
        System.out.println( "addAnswer" );
        Answer answerToAdd = null;
        QuestionMultipleChoiceSet instance = new QuestionMultipleChoiceSet();
        boolean expResult = false;
        boolean result = instance.addAnswer( answerToAdd );
        assertEquals( expResult, result );
        // TODO review the generated test code and remove the default call to fail.
        fail( "The test case is a prototype." );
    }

    /**
     * Test of getAnswers method, of class QuestionMultipleChoiceSet.
     */
    public void testGetAnswers() {
        System.out.println( "getAnswers" );
        QuestionMultipleChoiceSet instance = new QuestionMultipleChoiceSet();
        List<Answer> expResult = null;
        List<Answer> result = instance.getAnswers();
        assertEquals( expResult, result );
        // TODO review the generated test code and remove the default call to fail.
        fail( "The test case is a prototype." );
    }

    /**
     * Test of setAnswers method, of class QuestionMultipleChoiceSet.
     */
    public void testSetAnswers() {
        System.out.println( "setAnswers" );
        List<Answer> answers = null;
        QuestionMultipleChoiceSet instance = new QuestionMultipleChoiceSet();
        instance.setAnswers( answers );
        // TODO review the generated test code and remove the default call to fail.
        fail( "The test case is a prototype." );
    }

    /**
     * Test of numOfAnswers method, of class QuestionMultipleChoiceSet.
     */
    public void testNumOfAnswers() {
        System.out.println( "numOfAnswers" );
        QuestionMultipleChoiceSet instance = new QuestionMultipleChoiceSet();
        int expResult = 0;
        int result = instance.numOfAnswers();
        assertEquals( expResult, result );
        // TODO review the generated test code and remove the default call to fail.
        fail( "The test case is a prototype." );
    }

    /**
     * Test of removeAnswer method, of class QuestionMultipleChoiceSet.
     */
    public void testRemoveAnswer_Answer() {
        System.out.println( "removeAnswer" );
        Answer answerToRemove = null;
        QuestionMultipleChoiceSet instance = new QuestionMultipleChoiceSet();
        boolean expResult = false;
        boolean result = instance.removeAnswer( answerToRemove );
        assertEquals( expResult, result );
        // TODO review the generated test code and remove the default call to fail.
        fail( "The test case is a prototype." );
    }

    /**
     * Test of removeAnswer method, of class QuestionMultipleChoiceSet.
     */
    public void testRemoveAnswer_int() {
        System.out.println( "removeAnswer" );
        int index = 0;
        QuestionMultipleChoiceSet instance = new QuestionMultipleChoiceSet();
        Answer expResult = null;
        Answer result = instance.removeAnswer( index );
        assertEquals( expResult, result );
        // TODO review the generated test code and remove the default call to fail.
        fail( "The test case is a prototype." );
    }

    /**
     * Test of getGeneralfeedback method, of class QuestionMultipleChoiceSet.
     */
    public void testGetGeneralfeedback() {
        System.out.println( "getGeneralfeedback" );
        QuestionMultipleChoiceSet instance = new QuestionMultipleChoiceSet();
        Feedback expResult = null;
        Feedback result = instance.getGeneralfeedback();
        assertEquals( expResult, result );
        // TODO review the generated test code and remove the default call to fail.
        fail( "The test case is a prototype." );
    }

    /**
     * Test of setGeneralfeedback method, of class QuestionMultipleChoiceSet.
     */
    public void testSetGeneralfeedback() {
        System.out.println( "setGeneralfeedback" );
        Feedback generalfeedback = null;
        QuestionMultipleChoiceSet instance = new QuestionMultipleChoiceSet();
        instance.setGeneralfeedback( generalfeedback );
        // TODO review the generated test code and remove the default call to fail.
        fail( "The test case is a prototype." );
    }

    /**
     * Test of parseXMLdata method, of class QuestionMultipleChoiceSet.
     */
    public void testParseXMLdata() throws Exception {
        System.out.println( "parseXMLdata" );
        XMLEventReader reader = null;
        QuestionMultipleChoiceSet instance = new QuestionMultipleChoiceSet();
        instance.parseXMLdata( reader );
        // TODO review the generated test code and remove the default call to fail.
        fail( "The test case is a prototype." );
    }

    /**
     * Test of toXMLString method, of class QuestionMultipleChoiceSet.
     */
    public void testToXMLString() {
        System.out.println( "toXMLString" );
        QuestionMultipleChoiceSet instance = new QuestionMultipleChoiceSet();
        String expResult = "";
        String result = instance.toXMLString();
        assertEquals( expResult, result );
        // TODO review the generated test code and remove the default call to fail.
        fail( "The test case is a prototype." );
    }
    
}
