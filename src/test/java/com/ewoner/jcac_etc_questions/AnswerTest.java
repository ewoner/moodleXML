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

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;




/**
 *
 * @author Brion Lang
 */
public class AnswerTest {

    public AnswerTest() {
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
        double expFraction = 0.0;
        String expFeedback = "";
        Answer instance = new Answer();
        double resultFraction = instance.getFraction();
        String resultFeedback = instance.getFeedback();
        assertEquals( expFraction, resultFraction );
        assertEquals( expFeedback, resultFeedback );
        
    }

    @Test
    public void testOneParmConstructor() {
        System.out.println( "constructor(double)" );
        double expFraction = 42.5;
        String expFeedback = "";
        Answer instance = new Answer( 42.5 );
        double resultFraction = instance.getFraction();
        String resultFeedback = instance.getFeedback();
        assertEquals( expFraction, resultFraction );
        assertEquals( expFeedback, resultFeedback );
    }

    @Test
    public void testTwoParmConstructor() {
        System.out.println( "constructor(double,String)" );
        double expFraction = 42.5;
        String expFeedback = "feedback";
        Answer instance = new Answer( 42.5, "feedback" );
        double resultFraction = instance.getFraction();
        String resultFeedback = instance.getFeedback();
        assertEquals( expFraction, resultFraction );
        assertEquals( expFeedback, resultFeedback );
    }

    /**
     * Test of getFraction method, of class Answer.
     */
    @Test
    public void testGetFraction() {
        System.out.println( "getFraction" );
        Answer instance = new Answer();
        double expResult = 0.0;
        double result = instance.getFraction();
        assertEquals( expResult, result );

    }

    /**
     * Test of setFraction method, of class Answer.
     */
    @Test
    public void testSetFraction() {
        System.out.println( "setFraction" );
        double fraction = 3.14;
        Answer instance = new Answer();
        instance.setFraction( fraction );
        assertEquals( fraction, instance.getFraction() );
    }

    /**
     * Test of getFeedback method, of class Answer.
     */
    @Test
    public void testGetFeedback() {
        System.out.println( "getFeedback" );
        Answer instance = new Answer();
        String expResult = "";
        String result = instance.getFeedback();
        assertEquals( expResult, result );
    }

    /**
     * Test of setFeedback method, of class Answer.
     */
    @Test
    public void testSetFeedback() {
        System.out.println( "setFeedback" );
        String feedback = "feedback";
        Answer instance = new Answer();
        instance.setFeedback( feedback );
        assertEquals( feedback, instance.getFeedback() );
    }

}
