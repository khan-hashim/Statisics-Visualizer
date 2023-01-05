package errorChecking;

import java.util.ArrayList;

public class Invoker {
	
	private Command command;
	
	public Invoker() {
		
	}
	
	public boolean executeErrorChecking(ArrayList<String> s) {
		return this.command.execute(s);
	}
	public Command getCommand() {
		return this.command;
	}
	public void setCommand(Command command) {
		this.command = command;
	}

}
