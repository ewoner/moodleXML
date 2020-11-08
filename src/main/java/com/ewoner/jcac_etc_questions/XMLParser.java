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

import com.ewoner.jcac_etc_questions.models.TextFormatEnum;
import com.ewoner.jcac_etc_questions.models.questions.Question;
import com.ewoner.jcac_etc_questions.models.questions.QuestionFeedback;
import com.ewoner.pair;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;


/**
 *
 * @author Brion Lang
 */
public class XMLParser {

    public static pair<String, TextFormatEnum> parserFieldTextTag( XMLEventReader reader, StartElement ele ) throws XMLStreamException {
        TextFormatEnum textFormat;
        String data = "";
        pair<String, TextFormatEnum> rv = new pair<>( "", TextFormatEnum.html );
        XMLEvent event;
        textFormat = TextFormatEnum.valueOf( ele.getAttributeByName( new QName( "format" ) ).getValue() );
        reader.nextTag();
        event = reader.nextEvent();
        if ( event.isCharacters() ) {
            data = event.asCharacters().getData();
        }
        return new pair( data, textFormat );
    }

    public static String parseStringData( XMLEventReader reader ) throws XMLStreamException {
        String data = "";
        XMLEvent event = reader.nextEvent();
        if ( event.isCharacters() ) {
            data = event.asCharacters().getData();
        }
        return data;
    }

    public static Double parseNumberData( XMLEventReader reader ) throws XMLStreamException {
        double data;
        try {
            data = Double.parseDouble( reader.nextEvent().asCharacters().getData() );
        }
        catch ( NumberFormatException | NullPointerException ex ) {
            data = 0.0;
        }

        return data;
    }

    public static boolean parseBooleanData( XMLEventReader reader ) throws XMLStreamException {
        boolean data;

        try {
            data = Boolean.parseBoolean( reader.nextEvent().asCharacters().getData() );
        }
        catch ( NumberFormatException | NullPointerException ex ) {
            data = true;
        }
        return data;
    }

    public static void parseDefaultGrade( Question rv, XMLEventReader reader ) throws XMLStreamException {
        double points;
        try {
            points = Double.parseDouble( reader.nextEvent().asCharacters().getData() );
        }
        catch ( NumberFormatException | NullPointerException ex ) {
            points = 1.0;
        }
        rv.setPoints( points );
    }

    public static void parseFeedback( QuestionFeedback rv, StartElement ele, XMLEventReader reader ) throws XMLStreamException {
        XMLEvent event;
        rv.setFeedbackFormat( TextFormatEnum.valueOf( ele.getAttributeByName( new QName( "format" ) ).getValue() ) );
        reader.nextTag();
        event = reader.nextEvent();
        if ( event.isCharacters() ) {
            rv.setFeedback( event.asCharacters().getData() );
        }
        else {
            rv.setFeedback( "" );
        }
    }

    public static void parseHidden( Question rv, XMLEventReader reader ) throws XMLStreamException {
        boolean hidden;
        try {
            hidden = Boolean.parseBoolean( reader.nextEvent().asCharacters().getData() );
        }
        catch ( NumberFormatException | NullPointerException ex ) {
            hidden = true;
        }
        rv.setHidden( hidden );
    }

    public static void parseId( Question rv, XMLEventReader reader ) throws XMLStreamException {
        XMLEvent event = reader.nextEvent();
        if ( event.isCharacters() ) {
            rv.setId( event.asCharacters().getData() );
        }
        else {
            rv.setId( "" );
        }
    }

    public static void parsePenalty( Question rv, XMLEventReader reader ) throws XMLStreamException {
        double penalty;
        try {
            penalty = Double.parseDouble( reader.nextEvent().asCharacters().getData() );
        }
        catch ( NumberFormatException | NullPointerException ex ) {
            penalty = 1.0;
        }
        rv.setPenalty( penalty );
    }

    public static void parseQuestionText( Question rv, StartElement ele, XMLEventReader reader ) throws XMLStreamException {
        XMLEvent event;
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

    public static void parseName( Question rv, XMLEventReader reader ) throws XMLStreamException {
        XMLEvent event;
        reader.nextTag();
        event = reader.nextEvent();
        if ( event.isCharacters() ) {
            rv.setName( event.asCharacters().getData() );
        }
        else {
            rv.setName( "" );
        }
    }

}
