package com.librarymanagement.commandconsole;

enum Command{
	LIST,
	CHECKOUT,
	CHECKIN,
	REGISTER,
	DEREGISTER,
	INFO,
	QUIT,
	NOTALLOWED
}

public class ParsedCommand {

	public static Command Command (String fullinput) {
		

		String specificCommand = fullinput.split(" ")[0];
		if (specificCommand.equals("list")) {
			return Command.LIST;
		} else if (specificCommand.equals("checkout")) {
			return Command.CHECKOUT;
		} else if (specificCommand.equals("checkin")) {
			return Command.CHECKIN;
		} else if (specificCommand.equals("register")) {
			return Command.REGISTER;
		} else if (specificCommand.equals("deregister")) {
			return Command.DEREGISTER;
		} else if (specificCommand.equals("info")) {
			return Command.INFO;
		} else if (specificCommand.equals("quit")) {
			return Command.QUIT;
		} else {
			return Command.NOTALLOWED;
		}
	}
	
	
}
