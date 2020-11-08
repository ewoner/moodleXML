/*
 * The MIT License
 *
 * Copyright 2020 Brion Lang.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.ewoner.jcac_etc_questions;

import com.ewoner.jcac_etc_questions.models.questions.Category;
import com.ewoner.jcac_etc_questions.models.questions.Question;
import com.ewoner.jcac_etc_questions.models.questions.QuestionMultipleChoice;
import com.ewoner.jcac_etc_questions.models.questions.QuestionTrueFalse;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;


/**
 *
 * @author Brion Lang
 * @version 0.0.0
 */
public class Main {

    private final List<Question> questions;

    public Main() {
        questions = new ArrayList<>();
    }

    public static void main( String[] args ) {
        Main main = new Main();
        main.parseXMLfile( "questions-Brion Lang-Development Course-top-20201107-0938.xml" );
        main.printQuestions();

        System.err.println( "Hit enter to Exit" );
        try {
            System.err.println( System.in.read() );
        }
        catch ( IOException ex ) {
            Logger.getLogger( Main.class.getName() ).log( Level.SEVERE, null, ex );
        }
    }

    private void parseXMLfile( String xmlFilename ) {
        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLEventReader reader = factory.createXMLEventReader( new FileInputStream( xmlFilename ) );
            while ( reader.hasNext() ) {
                if ( reader.peek().isStartElement() ) {
                    if ( reader.peek().asStartElement().getName().getLocalPart().equals( "question" ) ) {
                        String attType = reader.peek().asStartElement().getAttributeByName( new QName( "type" ) ).getValue();
                        if ( attType.equals( "_category" ) ) {
                            questions.add( Category.parseXMLElement( reader ) );
                        }
                        else if ( attType.equals( "_truefalse" ) ) {
                            questions.add( QuestionTrueFalse.parseXMLElement( reader ) );
                        }
                        else if ( attType.equals( "multichoice" ) ) {
                            questions.add( QuestionMultipleChoice.parseXMLElemnet( reader ) );
                        }
                    }
                }
                reader.next();
            }
        }
        catch ( FileNotFoundException | XMLStreamException ex ) {
            Logger.getLogger( Main.class.getName() ).log( Level.SEVERE, null, ex );
        }
    }

    private void printQuestions() {
        for ( Question q1 : questions ) {
            QuestionTrueFalse q = ( QuestionTrueFalse ) q1;
            System.out.println( q.getType().toString() + " - "
                    + q.getPoints() + " - " + q.getPenalty()
                    + " -- " + q.isHidden() );
        }
        System.out.println( "Total size = " + questions.size() );
    }

}
