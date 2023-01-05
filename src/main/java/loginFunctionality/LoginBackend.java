package loginFunctionality;

import java.util.ArrayList;

public class LoginBackend {
	
	private String email;
	private String password;
	private ArrayList<User> users;
	public LoginBackend(String email , String password) {
		this.email = email;
		this.password = password;
	}
	public void loadData(){ // loads data from the file 
		// update this path before running login Frontend class
		String path = "C:\\Users\\HASHIM\\Desktop\\University\\5th Semester\\EECS3311\\user.csv"; 
		CSVFileReader csvfile = new CSVFileReader(path);
		try {
    		csvfile.load();
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
		users = csvfile.getUsers();
	}
	public String authenticate() {
		this.loadData();
		boolean check = false;
		int index = -1;
		String frontend = "";
		for(int i = 0; i< this.users.size(); i++) {
			User u = this.users.get(i);
			if(u.getEmail().equals(this.email)) {
				check = true;
				index = i;
			}
		}
		if(!check) {
			frontend = "emaildoesnotexist"; // display some msg saying email doesnt exist, and application should terminate
		}
		else {
			String pword = this.users.get(index).getPassword();
			if(pword.equals(this.password)) {
				frontend = "passwordmatches"; // take user to the main UI
			}
			else {
				frontend = "passworddoesnotmatch"; // display some msg saying password doesnt match email, and application should terminate
			}
		}
		
		return frontend;
	}

}
