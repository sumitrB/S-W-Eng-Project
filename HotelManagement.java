import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.layout.FlowPane;
import javafx.geometry.Pos;
import javafx.event.ActionEvent; 
import java.text.NumberFormat;

public class HotelManagement extends Application
{
	//First page;
	Button logIn;
	Button createAccount;
	Button adminLogIn;
	Button back;
	
	// If logIn;
	private Text userName;
	private Text password;
	private TextField nameSpace;
	private TextField passwordSpace;
	
	
	// If create new account;
	private Text firstName;
	private Text lastName;
	private Text userId;
	private Text email;
	private Text insertPassword;
	private Text confirmPassword;
	private TextField firstNameSpace;
	private TextField lastNameSpace;
	private TextField userIdSpace;
	private TextField emailSpace;
	private TextField insertPasswordSpace;
	private TextField confirmPasswordSpace;
	
	// If admin;
	private Text adminName;
	private Text adminPassword;
	private TextField adminNameSpace;
	private TextField adminPasswordSpace;
	
	Stage window;
	
	public void start(Stage primaryStage) 
	{
		window = primaryStage;
		primaryStage.setTitle("United 21");
		
		Button logIn = new Button ("LogIn");
		logIn.setOnAction(this::processLogInButton);
		
		Button createAccount = new Button ("CreateAccount");
		createAccount.setOnAction(this::processCreateAccountButton);
		
		Button adminLogIn = new Button ("Admin LogIn");
		adminLogIn.setOnAction(this::processAdminLogInButton);
		
		FlowPane pane = new FlowPane(logIn, createAccount, adminLogIn);
		pane.setAlignment(Pos.CENTER);
		pane.setHgap(15);
		pane.setVgap(5);
		
		Scene scene = new Scene(pane, 300, 300);
		
		window.setScene(scene);
		window.show();
	    
	}
	
	public void processLogInButton(ActionEvent event)
	{
		
		Text userName = new Text ("Username: ");
	 	nameSpace = new TextField();
	    
	  	Text password = new Text ("Password: ");
    	passwordSpace = new TextField();
    	
    	Button back = new Button ("Return");
		back.setOnAction(this::processReturnButton);
	    	
	   	FlowPane pane = new FlowPane (userName, nameSpace, password, passwordSpace, back);
		pane.setAlignment(Pos.CENTER);
		pane.setHgap(15);
		pane.setVgap(5);
		
		Scene scene = new Scene (pane, 300, 300);
		
		window.setScene (scene);
		window.show();
	   
	}
	
	public void processCreateAccountButton(ActionEvent event)
	{
		Text firstName = new Text ("First Name: ");
	    firstNameSpace = new TextField();
	    
	    Text lastName = new Text ("Last Name: ");
	    lastNameSpace = new TextField();
	    
	    Text userId = new Text ("User Id: ");
	    userIdSpace = new TextField();
	    
	    Text insertPassword = new Text ("Password: ");
	    insertPasswordSpace = new TextField();
	    
	    Text email = new Text ("Email: ");
	    emailSpace = new TextField();
	    
		Text confirmPassword = new Text ("Confirm Password: ");
	    confirmPasswordSpace = new TextField();
	    
	    Button back = new Button ("Return");
		back.setOnAction(this::processReturnButton);
	    
	    FlowPane pane = new FlowPane(firstName, firstNameSpace, lastName, lastNameSpace, userId,
	    							 userIdSpace,email,emailSpace, insertPassword, insertPasswordSpace, 
	    							 confirmPassword, confirmPasswordSpace, back);
		pane.setAlignment(Pos.CENTER);
		pane.setHgap(15);
		pane.setVgap(5);
		
		Scene scene = new Scene(pane, 250, 300);
		
		window.setScene(scene);
		window.show();
	}
	
	public void processAdminLogInButton(ActionEvent event)
	{
		
		Text adminName = new Text (" Admin Username: ");
	 	adminNameSpace = new TextField();
	    
	  	Text adminPassword = new Text (" Admin Password: ");
    	adminPasswordSpace = new TextField();
    	
    	Button back = new Button ("Return");
		back.setOnAction(this::processReturnButton);
	    	
	   	FlowPane pane = new FlowPane(adminName, adminNameSpace, adminPassword, adminPasswordSpace, back);
		pane.setAlignment(Pos.CENTER);
		pane.setHgap(15);
		pane.setVgap(5);
		
		Scene scene = new Scene (pane, 300, 300);
		
		window.setScene (scene);
		window.show();
	}
	
	public void processReturnButton(ActionEvent event)
	{
		
		window.setTitle("United 21");
		
		Button logIn = new Button ("LogIn");
		logIn.setOnAction(this::processLogInButton);
		
		Button createAccount = new Button ("CreateAccount");
		createAccount.setOnAction(this::processCreateAccountButton);
		
		Button adminLogIn = new Button ("Admin LogIn");
		adminLogIn.setOnAction(this::processAdminLogInButton);
		
		FlowPane pane = new FlowPane(logIn, createAccount, adminLogIn);
		pane.setAlignment(Pos.CENTER);
		pane.setHgap(15);
		pane.setVgap(5);
		
		Scene scene = new Scene(pane, 300, 300);
		
		window.setScene(scene);
		window.show();
	}
}