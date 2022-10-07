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
		userName.setPrefWidth(110);
	 	nameSpace = new TextField();
	 	nameSpace.setPrefWidth(110);
	    
	  	Text password = new Text ("Password: ");
	  	password.setPrefWidth(110);
    	passwordSpace = new TextField();
    	passwordSpace.setPrefWidth(110);
    	
    	Button back = new Button ("Return");
    	back.setPrefWidth(110);
		back.setOnAction(this::processReturnButton);
	    	
	    GridPane inputPane = new GridPane();
    	GridPane mainPane  = new GridPane();
    	
    	inputPane.setAlignment(Pos.CENTER);
		mainPane.setAlignment(Pos.CENTER);
		
		GridPane.setHalignment(userName, HPos.CENTER);
		GridPane.setHalignment(nameSpace, HPos.CENTER);
		GridPane.setHalignment(password, HPos.CENTER);
		GridPane.setHalignment(passwordSpace, HPos.CENTER);
		GridPane.setHalignment(back, HPos.CENTER);
		
		inputPane.add(userName,		0,0,1,1);
		inputPane.add(nameSpace,	1,0,1,1);
		inputPane.add(password, 	2,0,1,1);
		inputPane.add(passwordSpace,0,0,1,1);
		inputPane.add(back,			1,0,1,1);
		
	   
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