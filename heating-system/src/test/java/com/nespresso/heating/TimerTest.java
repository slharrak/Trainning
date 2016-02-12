package com.nespresso.heating;

import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

public class TimerTest {
	
	Timer timer;

	@Before
	public void setUp() throws Exception {
		timer = new Timer(9, 20);
	}

	@Test
	public void testCanSchedule() {
		assertFalse(timer.canSchedule());
	}
	
}
