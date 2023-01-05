package errorChecking;

import java.util.ArrayList;

public class ViewerErrorCheck implements Command {

    private ErrorCheckExecutor receiver;
	
	public ViewerErrorCheck(ErrorCheckExecutor reciever) {
		this.receiver = reciever;
	}
	
	public boolean execute(ArrayList<String> s) {
		return this.receiver.checkViewerError(s);
	} 
}
