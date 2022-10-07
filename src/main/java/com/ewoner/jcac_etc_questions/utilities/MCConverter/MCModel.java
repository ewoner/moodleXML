package com.ewoner.jcac_etc_questions.utilities.MCConverter;

import com.ewoner.jcac_etc_questions.models.questions.Abstracts.Question;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * 
 * MIT License
 * 
 * Copyright (c) 2022 Brion Lang
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 * 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
public class MCModel {

    private JFrame view;
    private JFileChooser fc;
    private MCConverter data;

    public MCModel() {
    }

    MCModel( MCConverter data ) {
        this.data = data;
    }

    /**
     * @return the fc
     */
    public JFileChooser getFc() {
        return fc;
    }

    /**
     * @param newfc
     */
    public void setFc( JFileChooser newfc ) {
        fc = newfc;
        fc.setCurrentDirectory( new File( "/home/student/git-projects/newMoodleXML/src/main" ) );

    }

    public JFrame getView() {
        return view;
    }

    public void setView( JFrame view ) {
        this.view = view;
    }

    public void changeFile() {
        if( fc == null ) {
            System.err.print( "MCModel.fileButtonPressed( ActionEvent ) ran into an error.  MCModel's fc is set to null.  Program terminated." );
            System.exit( 1 );
        }
        if( getFc().showOpenDialog( null ) == JFileChooser.APPROVE_OPTION ) {
            data.setFile( getFc().getSelectedFile() );
            setSaveFile( data.getFile().getParent() + File.separator + "new_" + data.getFile().getName() );
        }
        //System.out.println( "Save filenanme: " + data.getSaveFile().getAbsolutePath() );
    }

    /**
     * @return the fileName
     */
    public String getFileName() {
        String name = "";
        if( data.getFile() != null ) {
            name = data.getFile().getName();
        }
        return name;
    }

    /**
     * @return the saveFileName
     */
    public String getSaveFileName() {
        String name = "";
        if( data.getSaveFile() != null ) {
            name = data.getSaveFile().getName();
        }
        return name;
    }

    public void changeSaveFile() {
        if( fc == null ) {
            System.err.print( "MCModel.fileButtonPressed( ActionEvent ) ran into an error.  MCModel's fc is set to null.  Program terminated." );
            System.exit( 1 );
        }
        if( getFc().showSaveDialog( null ) == JFileChooser.APPROVE_OPTION ) {
            setSaveFile( fc.getSelectedFile().getAbsolutePath() );
        }
        System.out.println( "Save filenanme: " + data.getSaveFile().getAbsolutePath() );
    }

    private void setSaveFile( String newSaveFileName ) {
        System.err.println( "here" );
        data.setSaveFile( new File( newSaveFileName ) );
        try {
            System.out.println( "Createed file:" + data.getSaveFile().getName() + "  " + data.getFile().exists() );
        } catch( Exception ex ) {
            Logger.getLogger( MCModel.class.getName() ).log( Level.SEVERE, null, ex );
        }
        if( data.getSaveFile().exists() == false && data.getSaveFile().getName().endsWith( ".xml" ) == false ) {
            System.err.println( "here" );
            data.setSaveFile( new File( data.getSaveFile().getAbsolutePath() + ".xml" ) );
        }
    }

    public void convertFile() {
        if( data.getFile() == null || data.getFile().exists() == false ) {
            showError( "There is no file selected to load questions from.", "No File" );
            return;
        }
        if( this.data.getSaveFile() == null ) {
            showError( "There is no file selected to save question to.", "No Save File" );
            return;
        }
        data.parseQuestions();
        data.changeQuestionTypes();
        boolean saveMe = true;
        if( data.getSaveFile().isAbsolute() ) {
            System.err.println( "File exsits and needs a warning later." );
        }
        if( saveMe ) {
            PrintWriter fout;
            try {
                System.err.println( data.getSaveFile().createNewFile() );
                fout = new PrintWriter( new BufferedWriter( new FileWriter( data.getSaveFile() ) ) );
            } catch( FileNotFoundException ex ) {
                Logger.getLogger( MCModel.class.getName() ).log( Level.SEVERE, null, ex );
                return;
            } catch( IOException ex ) {
                Logger.getLogger( MCModel.class.getName() ).log( Level.SEVERE, null, ex );
                return;
            }
            for( Question q : data.getNewQuestions() ) {
                fout.println( q.toXMLString() );
            }
            fout.close();

        }
    }

    public void showError( String message, String title ) {
        showJOptionPaneDialog( message, title, JOptionPane.ERROR_MESSAGE );
    }

    private void showJOptionPaneDialog( String message, String title, int type ) {
        JOptionPane.showMessageDialog( null, message, title, type );
    }

}
