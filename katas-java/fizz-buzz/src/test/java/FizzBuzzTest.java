import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import jdk.jfr.StackTrace;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FizzBuzzTest {

	@Test
	public void program_return_100_size_list() {
		List<String> result = FizzBuzz.applyFizzBuzz();
		assertEquals(100, result.size());
	}

	@Test
	public void value_in_list_equal_list_position() {
		List<String> result = FizzBuzz.applyFizzBuzz();
		assertEquals("1", result.get(1 - 1));
		assertEquals("22", result.get(22 - 1));
		assertEquals("98", result.get(98 - 1));

	}

	@Test
	public void if_3multiple_printing_fizz() {
		List<String> result = FizzBuzz.applyFizzBuzz();
		Integer number3 = 3;
		Integer number30 = 33;
		Integer number99 = 99;
		assertEquals("Fizz", result.get(number3 - 1));
		assertEquals("Fizz", result.get(number30 - 1));
		assertEquals("Fizz", result.get(number99 - 1));
	}

	@Test
	public void if_5multiple_printing_fizz() {
		List<String> result = FizzBuzz.applyFizzBuzz();
		Integer number5 = 5;
		assertEquals("Buzz", result.get(number5 - 1));
	}

	@Test
	public void if_5and3multiple_printing_fizzbuzz() {
		List<String> result = FizzBuzz.applyFizzBuzz();
		Integer number15 = 15;
		assertEquals("FizzBuzz", result.get(number15 - 1));
	}
}
