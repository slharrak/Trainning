package com.nespresso.heating;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import com.nespresso.heatingSystem.HeatingSystemState;

public class ThermostatTest {

	Thermostat thermostat;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		thermostat = new Thermostat("37.00");
	}

	@Test
	public void testInCaseWhenHeatingSystemTemperatureLessThanThreshold() throws Exception {
		HeatingSystemState state = thermostat.toggleState(22.00);
		assertTrue(state.equals(HeatingSystemState.ON));
	}

	@Test
	public void testInCaseWhenHeatingSystemTemperatureBiggerThanThreshold() throws Exception {
		HeatingSystemState state = thermostat.toggleState(40.0);
		assertTrue(state.equals(HeatingSystemState.OFF));
	}

	@Test(expected = IllegalStateException.class)
	public void testInCaseWhenHeatingSystemTemperatureEqualsThreshold() throws Exception {
		thermostat.toggleState(37.0);
	}
}
