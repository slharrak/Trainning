package com.nespresso.heating;

import java.io.IOException;

import com.nespresso.business.Heating;

public interface HeatingSystem {

	void checkWhitWriteStatus(final Heating heating) throws IOException;

}
