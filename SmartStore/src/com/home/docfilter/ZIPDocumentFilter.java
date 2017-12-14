package com.home.docfilter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class ZIPDocumentFilter extends DocumentFilter {
    
    private boolean isNumber(String s) {
        
        Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcher = pattern.matcher(s);

        if (matcher.find()){
            return true;
        }else {
            return false;
        }
    }
    
    public void insertString(DocumentFilter.FilterBypass fb, int offset,
            String text, AttributeSet attr) throws BadLocationException {

        if (isNumber(text) && offset < 5) {
            fb.insertString(offset, text, attr);
        }
    }

    public void replace(DocumentFilter.FilterBypass fb, int offset, int length,
            String text, AttributeSet attrs) throws BadLocationException {
        
        if (isNumber(text) && offset < 5) {
            fb.replace(offset, length, text, attrs);
        }
    }
}
