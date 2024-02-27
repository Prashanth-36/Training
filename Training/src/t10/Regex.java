package t10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import myException.InvalidValueException;
import utility.Utils;

public class Regex {  
	public Matcher getMatcher(String regex, String input) throws InvalidValueException {
		Utils.checkNull(regex);
		Utils.checkNull(input);
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		return matcher;
	}

	public boolean matches(String regex, String input) throws InvalidValueException {
		return getMatcher(regex, input).matches();
	}

	public boolean isMobileNumber(String number) throws InvalidValueException {
		return matches("[789]\\d{9}", number);
	}

	public boolean isAlphaNumeric(String input) throws InvalidValueException {
		return matches("[A-Z0-9a-z]+", input);
	}

	public boolean contains(String regex, String input) throws InvalidValueException {
		return getMatcher(regex, input).find();
	}

	public boolean startsWith(String regex, String input) throws InvalidValueException {
		return getMatcher(regex, input).lookingAt();
	}

	public boolean isEmail(String input) throws InvalidValueException {
		return matches("[a-z0-9][\\.a-z0-9]*@[a-z]+\\.[a-z]{2,}(\\.[a-z]{2,})?", input);
	}

	public Map<String, Integer> getMatchMap(List<String> list1, List<String> list2) throws InvalidValueException {
		Map<String, Integer> map = new HashMap<>();
		for (String string2 : list2) {
			for (int i = 0; i < list1.size(); i++) {
				if (matches(list1.get(i), string2)) {
					map.put(string2, i);
					break;
				}
			}
		}
		return map;
	}

	public List<String> getHtmlTags(String html) throws InvalidValueException {
		Matcher matcher = getMatcher("</?[a-z]+>", html);
		List<String> list = new ArrayList<String>();
		while (matcher.find()) {
			list.add(matcher.group());
		}
		return list;
	}

	public boolean isStrongPassword(String password) throws InvalidValueException {
		return matches("(?=.*[a-z].*)(?=.*[A-Z].*)(?=.*[@#$%&!^\\*].*)(?=.*[0-9].*).{8,}", password);
	}
}
