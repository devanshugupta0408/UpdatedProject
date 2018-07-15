package com.capg.service;

import static org.junit.Assert.*;

import org.junit.Test;

public class AccountValidationTest {

	AccountValidation av = new AccountValidation();

	@Test
	public void testValidatecustomerName() {
		assertEquals(true, av.validatecustomerName("Devanshu Gupta"));
		assertEquals(false, av.validatecustomerName("Devanshu123"));
		assertEquals(false, av.validatecustomerName("devanshu@112"));
		assertNotEquals(true, av.validatecustomerName("devanshu@#12"));
		assertNotNull("", av);
		assertNotSame("", av.validatecustomerName("devanshu@112"));

	}

	@Test
	public void testValidatephoneNumber() {
		assertEquals(false, av.validatephoneNumber("900098s911"));
		assertEquals(false, av.validatephoneNumber("5600985911")); // Number should start from 6/7/8/9
		assertEquals(true, av.validatephoneNumber("9000989131"));
		assertEquals(false, av.validatephoneNumber("90009@eef1"));
		assertEquals(false, av.validatephoneNumber("90009"));
		assertEquals(false, av.validatephoneNumber("90012312we"));
		assertEquals(true, av.validatephoneNumber("6352410031"));
	}

	@Test
	public void testValidatecustomerEmail() {
		assertEquals(true, av.validatecustomerEmail("dev@gmail.com"));
		assertEquals(true, av.validatecustomerEmail("dev_123@gmail.com"));
		assertEquals(false, av.validatecustomerEmail("dev.#@gmail.com"));
		assertEquals(false, av.validatecustomerEmail("dev@helloo@gmail.com"));
		assertNotSame("devanshu@gmail.com", av.validatecustomerEmail("devans@gmail.com"));
	}

	@Test
	public void testValidateusername() {
		assertEquals(true, av.validateusername("dev_1234"));
		assertEquals(true, av.validateusername("devanshu-1234"));
		assertEquals(false, av.validateusername("dev@1234")); // @ cannot be used. only '-' and '_' are allowed
		assertEquals(false, av.validateusername("devanshugupta9876")); // Length of username should not be more than 15
		assertNotEquals(true, av.validateusername("de")); // Min. length should be 3
		assertNotNull(av);
		assertSame(true, av.validateusername("devanshugupta"));

	}

	@Test
	public void testValidatepassword() {
		assertEquals(true, av.validatepassword("Devan@9876"));
		assertEquals(true, av.validatepassword("Deva#12344"));
		assertEquals(false, av.validatepassword("dev"));
		assertEquals(false, av.validatepassword("devan"));
		assertEquals(false, av.validatepassword("devan/1452"));
		assertEquals(true, av.validatepassword("Devan$12"));
		assertEquals(true, av.validatepassword("Dvan#1gupta"));
	}

	@Test
	public void testValidategender() {
		assertEquals(true, av.validategender("M"));
		assertEquals(true, av.validategender("F"));
		assertEquals(true, av.validategender("male"));
		assertEquals(true, av.validategender("Female"));
		assertEquals(true, av.validategender("MaLe"));
		assertEquals(true, av.validategender("feMale"));
		assertEquals(true, av.validategender("Others"));
		assertEquals(false, av.validategender("fem"));
		assertEquals(false, av.validategender("mle"));

	}

	@Test
	public void testValidateLogin() {
		assertNull(av.validateLogin("deva", "Deva1234"));
	}

}
