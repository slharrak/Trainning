package com.nespresso.heating;

import com.nespresso.facade.Writer;

public enum HeatingSystemState {
	ON,
	OFF;
	
	public void writeUsing(final Writer writer) {
		writer.write(this.toString());
	}

}
