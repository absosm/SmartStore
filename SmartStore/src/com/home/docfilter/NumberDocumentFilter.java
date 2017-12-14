package com.home.docfilter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class NumberDocumentFilter extends DocumentFilter {
	
    private boolean isNumber(String s) {
        
        Pattern pattern = Pattern.compile("^[1-9](\\d*)?$");
        Matcher matcher = pattern.matcher(s);

        if (matcher.find()){
            return true;
        }else {
            return false;
        }
    }
    
    public void insertString(DocumentFilter.FilterBypass fb, int offset,
            String string, AttributeSet attr) throws BadLocationException {
    	
    	String fullstring = fb.getDocument().getText(0, offset)+string;

        if (isNumber(fullstring)) {
            fb.insertString(offset, string, attr);
        }
    }

    public void replace(DocumentFilter.FilterBypass fb, int offset, int length,
            String string, AttributeSet attrs) throws BadLocationException {
    	
    	String fullstring = fb.getDocument().getText(0, offset)+string;

        if (isNumber(fullstring)) {
            fb.replace(offset, length, string, attrs);
        }
    }
}
