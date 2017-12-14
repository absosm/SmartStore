/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.home.docfilter;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

/**
 *
 * @author absosm
 */
public class FirstNameDocumentFilter extends DocumentFilter {
    
    private static int lower = 0;
    
    public void insertString(DocumentFilter.FilterBypass fb, int offset,
            String text, AttributeSet attr) throws BadLocationException {
        
        if (offset == 0) {
            fb.insertString(offset, text.toUpperCase(), attr);
        }else {
            if (lower == 1) {
                fb.insertString(offset, text.toUpperCase(), attr);
                lower = 0;
            }else 
                fb.insertString(offset, text.toLowerCase(), attr);
        }
        
        if (text.equals(" ")) {
            lower = 1;
        }
    }

    public void replace(DocumentFilter.FilterBypass fb, int offset, int length,
            String text, AttributeSet attrs) throws BadLocationException {
        
        if (text.isEmpty()) return;
        
        if (text.length() == 1) {
            if (offset == 0) {
                fb.replace(offset, length, text.toUpperCase(), attrs);
            }else {
                if (lower == 1) {
                    fb.replace(offset, length, text.toUpperCase(), attrs);
                    lower = 0;
                }else 
                    fb.replace(offset, length, text.toLowerCase(), attrs);
            }

            if (text.equals(" ")) {
                lower = 1;
            }
        }else {
            String s="";
            for (String retval: text.split(" ")){
                s = s + retval.substring(0, 1).toUpperCase()+retval.substring(1).toLowerCase()+" ";
            }
            fb.replace(offset, length, s.substring(0, s.length()-1), attrs);
        }
    }
}
