package com.example.JournalApp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
class JournalAppApplicationTests {

	@Test
	void contextLoads() {
		// Dummy test just to check JUnit works
		assertEquals(4, 2 + 2, "2 + 2 should equal 4");

		assertNotEquals(5, 2 + 2, "2 + 2 should not equal 5");

	}
}

