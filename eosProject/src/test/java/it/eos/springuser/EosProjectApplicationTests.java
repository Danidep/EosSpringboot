package it.eos.springuser;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.client.ExpectedCount;
import org.junit.jupiter.api.Assertions;

class EosProjectApplicationTests {

	@Test
	void contextLoads() {
		String t = "test@mail.com";
		
		Assertions.assertTrue(t.contains("@"));
	}
	
	@Test
	void contextEqual() {
		String n = "new@mail.it";
		
		Assertions.assertEquals("new@mail.it", n);
	}

	@Test
	void contextFalse() {
		String f = "Mario Rossi";
		
		Assertions.assertFalse(f.contains("@"));
	}
}
