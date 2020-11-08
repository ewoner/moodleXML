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

import com.ewoner.jcac_etc_questions.models.answers.AnswerNumberingEnum;

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
public class AnswerNumberingEnumTest {

    public AnswerNumberingEnumTest() {
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

    /**
     * Test of values method, of class AnswerNumberingEnum.
     */
    @Test
    public void testValues() {
        System.out.println( "values" );
        AnswerNumberingEnum[] expResult = { AnswerNumberingEnum.none,
            AnswerNumberingEnum.abc, AnswerNumberingEnum.ABCD,
            AnswerNumberingEnum.numbers };
        AnswerNumberingEnum[] result = AnswerNumberingEnum.values();
        assertArrayEquals( expResult, result );
    }

    /**
     * Test of valueOf method, of class AnswerNumberingEnum.
     */
    @Test
    public void testValueOf() {
        System.out.println( "valueOf" );
        String string = "ABCD";
        AnswerNumberingEnum expResult = AnswerNumberingEnum.ABCD;
        AnswerNumberingEnum result = AnswerNumberingEnum.valueOf( string );
        assertEquals( expResult, result );
        expResult = null;
        try {
            result = AnswerNumberingEnum.valueOf( "abcde" );
            assertEquals( expResult, result );
        }
        catch ( IllegalArgumentException | NullPointerException ex ) {
        }

    }

    /**
     * Test of getXML method, of class AnswerNumberingEnum.
     */
    @Test
    public void testGetXML() {
        System.out.println( "getXML" );
        AnswerNumberingEnum instance = AnswerNumberingEnum.none;
        String expResult = "none";
        String result = instance.getXML();
        assertEquals( expResult, result );
        
        instance = AnswerNumberingEnum.abc;
        expResult = "abc";
        result = instance.getXML();
        assertEquals( expResult, result );
        
        instance = AnswerNumberingEnum.ABCD;
        expResult = "ABCD";
        result = instance.getXML();
        assertEquals( expResult, result );
        
        instance = AnswerNumberingEnum.numbers;
        expResult = "123";
        result = instance.getXML();
        assertEquals( expResult, result );
    }

}
