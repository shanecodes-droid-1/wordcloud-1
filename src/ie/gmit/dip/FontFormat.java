package ie.gmit.dip;

import java.awt.Font;

/**
 * 
 * @author Shane McGillycuddy
 * @version 1.0
 * @since Java 15.0.1 FontFormat is an enum which contains a number of fonts
 *        with random characteristics
 */
public enum FontFormat {
	FONT_1(new Font(Font.SANS_SERIF, Font.ITALIC, 62)), FONT_2(new Font(Font.SERIF, Font.PLAIN, 50)),
	FONT_3(new Font(Font.MONOSPACED, Font.BOLD, 48)), FONT_4(new Font(Font.DIALOG, Font.ITALIC, 36)),
	FONT_5(new Font(Font.SANS_SERIF, Font.BOLD, 28)), FONT_6(new Font(Font.SERIF, Font.PLAIN, 26)),
	FONT_7(new Font(Font.DIALOG, Font.ITALIC, 24)), FONT_8(new Font(Font.SANS_SERIF, Font.PLAIN, 22)),
	FONT_9(new Font(Font.SANS_SERIF, Font.BOLD, 20)), FONT_10(new Font(Font.SERIF, Font.ITALIC, 18)),
	FONT_11(new Font(Font.SANS_SERIF, Font.PLAIN, 16)), FONT_12(new Font(Font.MONOSPACED, Font.BOLD, 14)),
	FONT_13(new Font(Font.SANS_SERIF, Font.BOLD, 12)), FONT_14(new Font(Font.SERIF, Font.PLAIN, 11)),
	FONT_15(new Font(Font.MONOSPACED, Font.ITALIC, 10)), FONT_16(new Font(Font.DIALOG, Font.PLAIN, 10)),
	FONT_17(new Font(Font.SANS_SERIF, Font.BOLD, 10)), FONT_18(new Font(Font.MONOSPACED, Font.ITALIC, 10)),
	FONT_19(new Font(Font.SERIF, Font.ITALIC, 10)), FONT_20(new Font(Font.SANS_SERIF, Font.BOLD, 10)),
	FONT_21(new Font(Font.MONOSPACED, Font.PLAIN, 10)), FONT_22(new Font(Font.SANS_SERIF, Font.PLAIN, 10)),
	FONT_23(new Font(Font.DIALOG, Font.ITALIC, 10)), FONT_24(new Font(Font.SANS_SERIF, Font.BOLD, 10)),
	FONT_25(new Font(Font.MONOSPACED, Font.ITALIC, 10)), FONT_26(new Font(Font.SANS_SERIF, Font.ITALIC, 10)),
	FONT_27(new Font(Font.SERIF, Font.BOLD, 10)), FONT_28(new Font(Font.MONOSPACED, Font.BOLD, 10)),
	FONT_29(new Font(Font.SANS_SERIF, Font.ITALIC, 10)), FONT_30(new Font(Font.DIALOG, Font.PLAIN, 10));

	// create a constructor which takes a font and assigns it to the instance
	// variable ft.
	private FontFormat(Font ft) {
		this.ft = ft;
	}

	// create an instance variable font
	private Font ft;

	/**
	 * /** getFt is an accessor method which returns the instance variable ft.
	 * 
	 * @return returns the instance variable ft.
	 */
	public Font getFt() {
		return ft;
	}

	/**
	 * /** setFt sets the instance variable font based on the font input as a
	 * parameter.
	 * 
	 * @param ft takes a Font as an input parameter and assigns it to the instance variable Font. 
	 */
	public void setFt(Font ft) {
		this.ft = ft;
	}
}
