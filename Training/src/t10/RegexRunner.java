package t10;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import myException.InvalidValueException;
import utility.Utils;

public class RegexRunner {

	static Logger logger = Logger.getLogger(RegexRunner.class.getName());

	public static void main(String[] args) {

		Utils.customLogger(logger, "RegexRunner");

		Regex regex = new Regex();

		try {

			logger.log(Level.INFO, "Number: " + regex.isMobileNumber("9876543210"));

			logger.log(Level.INFO, "AlphaNumeric: " + regex.isAlphaNumeric("a2"));

			logger.log(Level.INFO, "starts with: " + regex.startsWith("\\w", "hill"));

			logger.log(Level.INFO, "contains: " + regex.contains("il", "hill"));

			logger.log(Level.INFO, "ends with: " + regex.matches(".*ll$", "hill"));

			logger.log(Level.INFO, "matches: " + regex.matches("hill", "hill"));

			logger.log(Level.INFO, "case insensitive match: " + regex.matches("(?i)HeLlo", "hello"));

			logger.log(Level.INFO, "Email: " + regex.isEmail("a.7@b.in"));

			List<String> list = List.of("hello", "hi", "", "welcome");

			for (String string : list) {
				boolean match = regex.matches("\\w{1,6}", string);
				String res = string + " length is " + (match ? "within range. " : "out of range.");
				logger.log(Level.INFO, res);
			}

			List<String> list1 = List.of("hi", "hello", "world", "welcome");
			List<String> list2 = List.of("hello", "hi");
			Map<String, Integer> map = regex.getMatchMap(list1, list2);
			logger.log(Level.INFO, map.toString());

			List<String> tags = regex.getHtmlTags(
					"<p>The <code>President</code> of India is the first\n" + "citizen of our country.</p>");
			tags.forEach(logger::info);

			logger.log(Level.INFO, "Strong Password: " + regex.isStrongPassword("Helloo1#"));

		} catch (InvalidValueException e) {
			logger.log(Level.SEVERE, "Regex exception", e);
		}

	}
}
