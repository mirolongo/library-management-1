package com.librarymanagement.commandconsole;

public class ParsedArguments {

	public final String Arguments = null;

	public static String[] Arguments(String fullinput) {
		
		String[] commandAndArguments = fullinput.split(" ");
		String[] arguments = new String[commandAndArguments.length - 1];
		
		for (int i = 1; i < commandAndArguments.length;i++) {
			arguments[i-1] = commandAndArguments[i];
		}
		return arguments;
	}

	public String fullinput;
}
