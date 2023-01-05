package errorChecking;

import java.util.ArrayList;

public class CountryErrorCheck implements Command{

	private ErrorCheckExecutor receiver;
	
	public CountryErrorCheck(ErrorCheckExecutor reciever) {
		this.receiver = reciever;
	}
	
	public boolean execute(ArrayList<String> s) {
		return this.receiver.checkCountryError(s);
	}
	
}
