package project3311;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import loginFunctionality.LoginBackend;

public class LoginTest 
{
    /**
     * Rigorous Test :-)
     */
//    @Test
//    public void CSVcheck_1(){
//    	String path = "C:\\Users\\HASHIM\\Desktop\\University\\5th Semester\\EECS3311\\user.csv";
//    	CSVFileReader lg = new CSVFileReader(path);
//    	try {
//    		lg.load();
//    	}
//    	catch(Exception e){
//    		e.printStackTrace();
//    	}
//    	ArrayList<User> users = lg.getUsers();
//		for(User u: lg.users){
//			System.out.println(u.toString());
//		}
//		User newUser = new User("t5", 5, "t5@yorku.ca", "t5t5");
//		lg.addUser(newUser);
//		try {
//			lg.update();
//    	}
//    	catch(Exception e){
//    		e.printStackTrace();
//    	}
//		System.out.println("Updated data");
//		users = lg.getUsers();
//		for(User u: users){
//			System.out.println(u.toString());
//		}
//        assertTrue( true );
//    }
    @Test
    public void logintest_1(){
    	LoginBackend lg = new LoginBackend("t1@yorku.ca" , "t1t1");
    	String s = lg.authenticate();
    	assertTrue(s.equals("passwordmatches"));

    }
    @Test
    public void logintest_2(){
    	LoginBackend lg = new LoginBackend("t1@yorku.ca" , "t2t1");
    	String s = lg.authenticate();
    	assertTrue(s.equals("passworddoesnotmatch"));
    }
    @Test
    public void logintest_3(){
    	LoginBackend lg = new LoginBackend("t9@yorku.ca" , "t2t1");
    	String s = lg.authenticate();
    	assertTrue(s.equals("emaildoesnotexist"));
    }
}
