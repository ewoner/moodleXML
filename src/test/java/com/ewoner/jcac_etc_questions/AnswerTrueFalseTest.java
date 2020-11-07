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

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;


/**
 *
 * @author Brion Lang
 */
public class AnswerTrueFalseTest {

    public AnswerTrueFalseTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testDefaultConstructor() {
        System.out.println( "constructor()" );
        AnswerTrueFalse instance = new AnswerTrueFalse();
        boolean expResult = true;
        String expFeedback = "";
        double expFraction = 0.0;
        boolean result = instance.getAnswer();
        assertEquals( expResult, result );
        assertEquals( expFeedback, instance.getFeedback() );
        assertEquals( expFraction, instance.getFraction(), 0.0 );

    }

    @Test
    public void testOneParmConstructor() {
        System.out.println( "constructor(boolean)" );
        AnswerTrueFalse instance = new AnswerTrueFalse( false );
        boolean expResult = false;
        boolean result = instance.getAnswer();
        assertEquals( expResult, result );
    }

    /**
     * Test of getAnswer method, of class AnswerTrueFalse.
     */
    @Test
    public void testGetAnswer() {
        System.out.println( "getAnswer" );
        AnswerTrueFalse instance = new AnswerTrueFalse();
        boolean expResult = true;
        boolean result = instance.getAnswer();
        assertEquals( expResult, result );
    }

    /**
     * Test of setAnswer method, of class AnswerTrueFalse.
     */
    @Test
    public void testSetAnswer() {
        System.out.println( "setAnswer" );
        boolean text = false;
        AnswerTrueFalse instance = new AnswerTrueFalse();
        instance.setAnswer( text );
        assertEquals(text, instance.getAnswer());
    }

}
