package errorChecking;

import java.util.ArrayList;

public class YearErrorCheck implements Command{
	
    private ErrorCheckExecutor receiver;
	
	public YearErrorCheck(ErrorCheckExecutor reciever) {
		this.receiver = reciever;
	}
	
	public boolean execute(ArrayList<String> s) {
		return this.receiver.checkYearError(s);
	}

}
