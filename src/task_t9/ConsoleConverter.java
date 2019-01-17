package task_t9;

import task_t9.converter.ConverterT9Impl;

public class ConsoleConverter {

	public static void main(String[] args) {

		String res = (new ConverterT9Impl()).convert("hello world");

		System.out.println(res);

	}

}
