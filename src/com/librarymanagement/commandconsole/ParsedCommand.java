package com.librarymanagement.commandconsole;

// This class separate the commands and parameters
public class ParsedCommand {
	private String param;
	private Command command = Command.NONE;

	public String getParam() {
		return param;
	}

	public Command getCommand() {
		return command;
	}

	public int parseParamToInt() {
		try {

			return Integer.parseInt(this.param);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Unknown command");
		}

	}

	public void Command(String fullinput) {
		this.param = null;
		String[] inputs = fullinput.split(" ");
		String specificCommand = inputs[0];
		if (inputs.length == 2) {
			param = inputs[1];
		}
		if (inputs.length > 2) {
			command = Command.NOTALLOWED;
		}
		if (specificCommand.equals("list")) {
			command = Command.LIST;
		} else if (specificCommand.equals("checkout")) {
			command = Command.CHECKOUT;
		} else if (specificCommand.equals("checkin")) {
			command = Command.CHECKIN;
		} else if (specificCommand.equals("register")) {
			command = Command.REGISTER;
		} else if (specificCommand.equals("deregister")) {
			command = Command.DEREGISTER;
		} else if (specificCommand.equals("info")) {
			command = Command.INFO;
		} else if (specificCommand.equals("quit")) {
			command = Command.QUIT;
		} else {
			command = Command.NOTALLOWED;
		}
	}

}
