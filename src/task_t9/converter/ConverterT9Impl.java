package task_t9.converter;

import task_t9.errors.CharacterNotSupportedException;

public class ConverterT9Impl implements IConverter<String, String> {

	private static final String DELIMITER = " ";

	@Override
	public String convert(String input) {

		StringBuilder result = new StringBuilder();

		// get array of characters
		int[] chars = input.toUpperCase().chars().toArray();

		for (int i = 0; i < chars.length; i++)

		{

			OutputSymbolType type = OutputSymbolType.getTypeByCode(chars[i]);

			if (type == OutputSymbolType.UNSUPPORTED)
				throw new CharacterNotSupportedException(
						"This character is not supported!Symbol:" + "'" + Character.toString((char) chars[i]) + "'");

			String convertValue = concatEqualString(type.getCharValue(), chars[i] - type.getStartRange() + 1);

			if (i != chars.length - 1) {

				OutputSymbolType typeNext = OutputSymbolType.getTypeByCode(chars[i + 1]);

				if (typeNext != type) {

					result.append(convertValue);
				}

				else {

					result.append(convertValue).append(DELIMITER);

				}
				// last symbol is not checked
			} else

				result.append(convertValue);

			{

			}
		}
		return result.toString();

	}

	// Converting to number symbol

	public String convertLetterToNumber(int code) {

		OutputSymbolType type = OutputSymbolType.getTypeByCode(code);

		if (type == OutputSymbolType.UNSUPPORTED)

			throw new CharacterNotSupportedException(
					"This character is not supported!Symbol:" + Character.toString((char) code));

		return concatEqualString(type.getCharValue(), code - type.getStartRange() + 1);

	}

	// concatenation equal symbols for N step
	private String concatEqualString(char input, int step) {

		StringBuilder sb = new StringBuilder(step);
		for (int i = 0; i < step; i++) {

			sb.append(input);

		}

		return sb.toString();

	}

}