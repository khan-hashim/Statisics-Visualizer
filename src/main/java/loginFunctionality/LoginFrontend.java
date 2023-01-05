package loginFunctionality;

import javax.swing.*;

import userInterface.MainPage;

import java.awt.*;  
import java.awt.event.*;  
import java.lang.Exception;  
  
//create CreateLoginForm class to create login form  
//class extends JFrame to create a window where our component add  
//class implements ActionListener to perform an action on button click  
public class LoginFrontend  {  
    //main() method start  
    public static void main(String arg[]){  
        try {  
            //create instance of the CreateLoginForm  
            CreateLoginForm form = new CreateLoginForm();  
            form.setSize(400,200);  //set size of the frame  
            form.setVisible(true);  //make form visible to the user  
        } 
     
        catch(Exception e)  {     
            //handle exception   
            JOptionPane.showMessageDialog(null, e.getMessage());  
        }  
    }  
}

 class CreateLoginForm extends JFrame implements ActionListener  {  
    //initialize button, panel, label, and text field  
    JButton b1;  
    JPanel newPanel;  
    JLabel userLabel, passLabel;  
    final JTextField  textField1, textField2;  
      
    //calling constructor  
    CreateLoginForm() {     
          
        //create label for username   
        userLabel = new JLabel();  
        userLabel.setText("Username");      //set label value for textField1  
          
        //create text field to get username from the user  
        textField1 = new JTextField(15);    //set length of the text  
  
        //create label for password  
        passLabel = new JLabel();  
        passLabel.setText("Password");      //set label value for textField2  
          
        //create text field to get password from the user  
        textField2 = new JPasswordField(15);    //set length for the password  
          
        //create submit button  
        b1 = new JButton("SUBMIT"); //set label to button  
          
        //create panel to put form elements  
        newPanel = new JPanel(new GridLayout(5, 1));  
        newPanel.add(userLabel);    //set username label to panel  
        newPanel.add(textField1);   //set text field to panel  
        newPanel.add(passLabel);    //set password label to panel  
        newPanel.add(textField2);   //set text field to panel  
        newPanel.add(b1);           //set button to panel  
          
        //set border to panel   
        add(newPanel, BorderLayout.CENTER);  
          
        //perform action on button click   
        b1.addActionListener(this);     //add action listener to button  
        setTitle("LOGIN");         //set title to the login form  
    }  
      
    //define abstract method actionPerformed() which will be called on button click   
    public void actionPerformed(ActionEvent ae)     //pass action listener as a parameter  
    {  
        String userValue = textField1.getText();        //get user entered username from the textField1  
        String passValue = textField2.getText();        //get user entered password from the textField2  
          
        LoginBackend userVals = new LoginBackend(userValue, passValue); 
        String backend = userVals.authenticate();
        
        //check whether the credentials are authentic or not
        if (backend == "emaildoesnotexist") {
        	JOptionPane.showMessageDialog(null,"Username does not exist.","Error", JOptionPane.WARNING_MESSAGE);
        	
        }
        
        else if (backend == "passworddoesnotmatch"){
        	JOptionPane.showMessageDialog(null,"Password does not match username.","Error", JOptionPane.WARNING_MESSAGE);
        }
        else if (backend == "passwordmatches"){  //if authentic, navigate user to a new page  
            this.setVisible(false); 
            //create instance of the NewPage  // MainUI page will be singleton will be instantiated only once
            JFrame frame = MainPage.getInstance();
    		
            frame.setSize(900, 600);
    		
            frame.pack();
            //make page visible to the user  
            frame.setVisible(true);
              
       
            
        }  
       
        else{  
        	JOptionPane.showMessageDialog(null,"Unexpected error.","Error", JOptionPane.WARNING_MESSAGE);
        }  
    }  
}  

