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

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 *
 * @author Brion Lang
 */
public class AnswerTextTest {

    public AnswerTextTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testDefaultConstructor() {
        System.out.println( "constructor()" );
        AnswerText instance = new AnswerText();
        String expResult = "";
        String result = instance.getText();
        assertEquals( expResult, result );
    }

    @Test
    public void testOneParmConstructor() {
        System.out.println( "constructor(String)" );
        AnswerText instance = new AnswerText( "This is a test." );
        String expResult = "This is a test.";
        String result = instance.getText();
        assertEquals( expResult, result );
    }

    /**
     * Test of getText method, of class AnswerText.
     */
    @Test
    public void testGetText() {
        System.out.println( "getText" );
        AnswerText instance = new AnswerText( "\"This is a test.\"" );
        String expResult = "\"This is a test.\"";
        String result = instance.getText();
        assertEquals( expResult, result );
    }

    /**
     * Test of setText method, of class AnswerText.
     */
    @Test
    public void testSetText() {
        System.out.println( "setText" );
        String text = "This is a second test;";
        AnswerText instance = new AnswerText();
        instance.setText( text );
        assertEquals( "This is a second test;", instance.getText() );
    }

}
