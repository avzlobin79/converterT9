package test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import task_t9.converter.ConverterT9Impl;
import task_t9.errors.CharacterNotSupportedException;

public class Test_ConverterT9Impl {

	static String[] input = { "hi", "yes", "foo  bar", "hello world" };

	static String[] expected = { "44 444", "999337777", "333666 6660 022 2777", "4433555 555666096667775553" };

	static String[] inputError = { "hi", "yes!", "foo  bar", "hello world" };

	static ConverterT9Impl converter;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		converter = new ConverterT9Impl();

	}

	@Test
	public void test_convert() {

		String[] result = new String[input.length];

		for (int i = 0; i < input.length; i++)
			result[i] = converter.convert(input[i]);

		assertArrayEquals(result, expected);

	}

	@Test(expected = CharacterNotSupportedException.class)
	public void testCharacterNotSupportedException() {

		for (int i = 0; i < input.length; i++)
			converter.convert(inputError[i]);

	}

}
