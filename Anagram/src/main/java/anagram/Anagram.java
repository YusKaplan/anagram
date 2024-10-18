package anagram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class reading from CLI and providing some features related to anagrams
 */
public class Anagram {

	public static void main(String[] args) {
		new Anagram().run();
	}

	public void run() {
		try {
			String firstText;

			firstText = readFromConsole("first text");

			String secondText = readFromConsole("second text");
			checkIfAnagrams(firstText, secondText);

			String thirdText = readFromConsole("Show me all anagrams for the following word");
			ArrayList<String> result = new ArrayList<String>();
			printAllAnagrams("", thirdText, result);
			System.out.println(result);
		} catch (IOException e) {
			System.err.println("There was an error when reading from console");
		}
	}

	/**
	 * Print every possible anagram provided in the parameter remaining.
	 * 
	 * @param prefix    Will be called with empty string for the first time. Through
	 *                  the iterations the first char of the remaining variable will
	 *                  be added here.
	 * @param remaining The string to retrieve all anagrams for
	 * @param result    All anagrams of remaining will be stored here
	 */
	protected void printAllAnagrams(String prefix, String remaining, List<String> result) {
		if (remaining.length() == 0) {
			result.add(prefix);
		} else {
			for (int i = 0; i < remaining.length(); i++) {
				printAllAnagrams(prefix + remaining.charAt(i), remaining.substring(0, i) + remaining.substring(i + 1),
						result);
			}
		}
	}

	/**
	 * Case insensitive check whether the provided Strings are anagrams.
	 * 
	 * @param firstText  First string to check
	 * @param secondText Second string to check
	 */
	protected void checkIfAnagrams(String firstText, String secondText) {
		char[] firstTextArray = firstText.toLowerCase().toCharArray();
		char[] secondTextArray = secondText.toLowerCase().toCharArray();

		Arrays.sort(firstTextArray);
		Arrays.sort(secondTextArray);

		boolean isAnagram = Arrays.equals(firstTextArray, secondTextArray);
		String outputString = String.format("Texts are %sanagram.", isAnagram ? "" : "not ");
		System.out.println(outputString);

	}

	private String readFromConsole(String requestMessage) throws IOException {
		System.out.print(requestMessage + ": ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		return reader.readLine();

	}
}
