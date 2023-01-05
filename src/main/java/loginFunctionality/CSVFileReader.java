package loginFunctionality;


import java.io.FileWriter;
import java.util.ArrayList;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;


public class CSVFileReader {
	private String path;
	public ArrayList<User> users = new ArrayList<User>();
	//intitialize this class
	public CSVFileReader( String path) {
		this.path = path;
	}
	public ArrayList<User> getUsers(){
		return users;
	}
	public void addUser(User u) {
		users.add(u);
	}
	public void load() throws Exception{
		CsvReader reader = new CsvReader(this.path); 
		reader.readHeaders();
		
		while(reader.readRecord()){ 
			User user = new User();
			//name,id,email,password
			user.setName(reader.get("name"));
			user.setId(Integer.valueOf(reader.get("id")));
			user.setEmail(reader.get("email"));
			user.setPassword(reader.get("password"));
			users.add(user);
		}
		
	}
	
	public void update() throws Exception{
		try {		
				CsvWriter csvOutput = new CsvWriter(new FileWriter(this.path, false), ',');
				//name,id,email,password
				csvOutput.write("name");
				csvOutput.write("id");
		    	csvOutput.write("email");
				csvOutput.write("password");
				csvOutput.endRecord();

				// else assume that the file already has the correct header line
				// write out a few records
				for(User u: users){
					csvOutput.write(u.getName());
					csvOutput.write(String.valueOf(u.getId()));
					csvOutput.write(u.getEmail());
					csvOutput.write(u.getPassword());
					csvOutput.endRecord();
				}
				csvOutput.close();
			
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
	

}
