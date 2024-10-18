package anagram;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class AnagramTest {

	private Anagram classUnderTest = new Anagram();

	@Test
	public void printAllAnagrams() {
		// given
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));

		// when
		ArrayList<String> result = new ArrayList<String>();
		classUnderTest.printAllAnagrams("", "abc", result);

		// then
		String expectedOutput = "[abc, acb, bac, bca, cab, cba]";
		assertEquals(expectedOutput, result.toString());
	}

	@Test
	public void printNonAnagram() {
		// given
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));

		// when
		ArrayList<String> result = new ArrayList<String>();
		classUnderTest.printAllAnagrams("", "", result);

		// then
		String expectedOutput = "[]";
		assertEquals(expectedOutput, result.toString());
	}

	@Test
	public void checkIfAnagrams() {
		// given
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));

		// when
		classUnderTest.checkIfAnagrams("aBbAmN", "amNbab");

		// then
		String expectedOutput = "Texts are anagram.";
		assertEquals(expectedOutput, outputStream.toString().trim());
	}

	@Test
	public void checkIfNotAnagrams() {
		// given
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));

		// when
		classUnderTest.checkIfAnagrams("aBbdAmN", "amNbab");

		// then
		String expectedOutput = "Texts are not anagram.";
		assertEquals(expectedOutput, outputStream.toString().trim());
	}

}
