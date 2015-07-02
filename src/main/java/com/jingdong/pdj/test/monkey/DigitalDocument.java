/**
 * 
 */
package com.jingdong.pdj.test.monkey;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * @author liufeng6
 *
 */
public class DigitalDocument extends PlainDocument {
	private int len;
	/**
	 * 
	 */
	public DigitalDocument() {}
	
	@Override
	public void insertString(int offs, String str, AttributeSet a)
			throws BadLocationException {
		char[] chrs;
		char[] chrscopy;
		try {
			if (str == null) return;
			chrs = str.toCharArray();
			int j=0;
			for (int i = 0; i < chrs.length; i++) {
				if (Character.isDigit(chrs[i])) {
					chrs[j++] = chrs[i];
				}
			}
			chrscopy = new char[j];
			System.arraycopy(chrs, 0, chrscopy, 0, j);
			super.insertString(offs, new String(chrscopy, 0, j), a);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
