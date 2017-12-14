package com.home.docfilter;

import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;
import javax.swing.text.DocumentFilter;

public class Filter {
	
	public static final DocumentFilter NUMBER = new NumberDocumentFilter();
	public static final DocumentFilter ZIP = new ZIPDocumentFilter();
	public static final DocumentFilter PHONE = new PhoneDocumentFilter();
	public static final DocumentFilter UPPERCASE = new UppercaseDocumentFilter();
	public static final DocumentFilter FIRSTUPPERCASE = new FirstNameDocumentFilter();
	public static final DocumentFilter CURRENCY = new CurrencyDocumentFilter();
	
	public static void TextField(JTextField tf, DocumentFilter df) {
		((AbstractDocument) tf.getDocument()).setDocumentFilter(df);
	}
}
