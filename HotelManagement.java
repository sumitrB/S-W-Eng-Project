import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.geometry.*;	
import javafx.event.ActionEvent;
import javafx.scene.text.FontWeight; 
import javafx.scene.text.FontWeight; 

public class HotelManagement extends Application
{
	//First page;
	private Text hotelName;
	Button logIn;
	Button createAccount;
	Button adminLogIn;
	Button back;
	
	// If logIn;
	private Text userFirstName;
	private Text userLastName;
	private Text userName;
	private Text password;
	private TextField userFirstNameSpace;
	private TextField userLastNameSpace;
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
	private Text adminFirstName;
	private Text adminLastName;
	private Text adminName;
	private Text adminPassword;
	private TextField adminFirstNameSpace;
	private TextField adminLastNameSpace;
	private TextField adminNameSpace;
	private TextField adminPasswordSpace;
	
	Stage window;
	
	public void start(Stage primaryStage) 
	{
		window = primaryStage;
		
		Text hotelName = new Text ("<HOTEL NAME>");
		hotelName.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 36));
		
		Button logIn = new Button ("LogIn");
		logIn.setPrefWidth(300);
		logIn.setOnAction(this::processLogInButton);
		
		Button createAccount = new Button ("CreateAccount");
		createAccount.setPrefWidth(300);
		createAccount.setOnAction(this::processCreateAccountButton);
		
		Button adminLogIn = new Button ("Admin LogIn");
		adminLogIn.setPrefWidth(300);
		adminLogIn.setOnAction(this::processAdminLogInButton);
		
		GridPane mainPane  = new GridPane();
		mainPane.setAlignment(Pos.CENTER);
		
		GridPane.setHalignment(hotelName, HPos.CENTER);
		GridPane.setHalignment(logIn, HPos.CENTER);
		GridPane.setHalignment(createAccount, HPos.CENTER);
		GridPane.setHalignment(adminLogIn, HPos.CENTER);
		
		mainPane.add(hotelName,     0,0,1,1);
		mainPane.add(logIn,     	0,1,1,1);
		mainPane.add(createAccount, 0,2,1,1);
		mainPane.add(adminLogIn,    0,3,1,1);
		
		mainPane.setVgap(40);
		
		Scene scene = new Scene(mainPane, 700, 700);
		window.setScene(scene);
		window.show();
	    
	}
	
	public void processLogInButton(ActionEvent event)
	{
		Text userFirstName = new Text ("First Name: ");
		userFirstName.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 36));
	 	userFirstNameSpace = new TextField();
	 	userFirstNameSpace.setPrefWidth(150);
	 	
	 	Text userLastName = new Text ("Last Name: ");
		userLastName.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 36));
	 	userLastNameSpace = new TextField();
	 	userLastNameSpace.setPrefWidth(150);
	
		Text userName = new Text ("Username: ");
		userName.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 36));
	 	nameSpace = new TextField();
	 	nameSpace.setPrefWidth(150);
	    
	  	Text password = new Text ("Password: ");
	  	password.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 36));
    	passwordSpace = new TextField();
    	passwordSpace.setPrefWidth(150);
    	
    	Button back = new Button ("Return");
    	back.setPrefWidth(150);
		back.setOnAction(this::processReturnButton);
		
		GridPane inputPane1 = new GridPane();
		GridPane inputPane2 = new GridPane();
		GridPane inputPane3 = new GridPane();
		GridPane inputPane4 = new GridPane();
    	GridPane mainPane  = new GridPane();
    	
    	inputPane1.setAlignment(Pos.CENTER);
    	inputPane2.setAlignment(Pos.CENTER);
    	inputPane3.setAlignment(Pos.CENTER);
    	inputPane4.setAlignment(Pos.CENTER);
		mainPane.setAlignment(Pos.CENTER);
		
		
		GridPane.setHalignment(userFirstName, HPos.CENTER);
		GridPane.setHalignment(userFirstNameSpace, HPos.CENTER);
		
		GridPane.setHalignment(userLastName, HPos.CENTER);
		GridPane.setHalignment(userLastNameSpace, HPos.CENTER);
		
		GridPane.setHalignment(userName, HPos.CENTER);
		GridPane.setHalignment(nameSpace, HPos.CENTER);
		
		GridPane.setHalignment(password, HPos.CENTER);
		GridPane.setHalignment(passwordSpace, HPos.CENTER);
		
		GridPane.setHalignment(back, HPos.CENTER);
		
		inputPane1.add(userFirstName,    	0,0,1,1);
		inputPane1.add(userFirstNameSpace,	1,0,1,1);
		
		inputPane2.add(userLastName,    	0,0,1,1);
		inputPane2.add(userLastNameSpace,	1,0,1,1);
		
		inputPane3.add(userName,    0,0,1,1);
		inputPane3.add(nameSpace,	1,0,1,1);
		
		inputPane4.add(password,      0,0,1,1);
		inputPane4.add(passwordSpace, 1,0,1,1);
		
		mainPane.add(inputPane1,   0,0,1,1);
		mainPane.add(inputPane2,   0,1,1,1);
		mainPane.add(inputPane3,   0,2,1,1);
		mainPane.add(inputPane4,   0,3,1,1);
		mainPane.add(back,         0,4,1,1);
		
		inputPane1.setHgap(40);
		inputPane2.setHgap(40);
		inputPane3.setHgap(40);
		inputPane4.setHgap(40);
		mainPane.setVgap(40);
		
		Scene scene = new Scene(mainPane, 700, 700);
		window.setScene(scene);
		window.show();
		
	}	
	
	public void processCreateAccountButton(ActionEvent event)
	{
		Text firstName = new Text ("First Name: ");
		firstName.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 36));
	    firstNameSpace = new TextField();
	    firstNameSpace.setPrefWidth(150);
	    
	    Text lastName = new Text ("Last Name: ");
	    lastName.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 36));
	    lastNameSpace = new TextField();
	    lastNameSpace.setPrefWidth(150);
	    
	    Text userId = new Text ("User Id: ");
	    userId.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 36));
	    userIdSpace = new TextField();
	    userIdSpace.setPrefWidth(150);
	    
	    Text insertPassword = new Text ("Password: ");
	    insertPassword.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 36));
	    insertPasswordSpace = new TextField();
	    insertPasswordSpace.setPrefWidth(150);
	    
	    Text email = new Text ("Email: ");
	    email.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 36));
	    emailSpace = new TextField();
	    emailSpace.setPrefWidth(150);
	    
		Text confirmPassword = new Text ("Confirm Password: ");
		confirmPassword.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 36));
	    confirmPasswordSpace = new TextField();
	    confirmPasswordSpace.setPrefWidth(150);
	    
	    Button back = new Button ("Return");
	    back.setPrefWidth(150);
		back.setOnAction(this::processReturnButton);
	    
	    GridPane inputPane1 = new GridPane();
		GridPane inputPane2 = new GridPane();
		GridPane inputPane3 = new GridPane();
		GridPane inputPane4 = new GridPane();
		GridPane inputPane5 = new GridPane();
		GridPane inputPane6 = new GridPane();
    	GridPane mainPane  = new GridPane();
    	
    	inputPane1.setAlignment(Pos.CENTER);
    	inputPane2.setAlignment(Pos.CENTER);
    	inputPane3.setAlignment(Pos.CENTER);
    	inputPane4.setAlignment(Pos.CENTER);
    	inputPane5.setAlignment(Pos.CENTER);
    	inputPane6.setAlignment(Pos.CENTER);
		mainPane.setAlignment(Pos.CENTER);
		
		GridPane.setHalignment(firstName, HPos.CENTER);
		GridPane.setHalignment(firstNameSpace, HPos.CENTER);
		
		GridPane.setHalignment(lastName, HPos.CENTER);
		GridPane.setHalignment(lastNameSpace, HPos.CENTER);
		
		GridPane.setHalignment(userId, HPos.CENTER);
		GridPane.setHalignment(userIdSpace, HPos.CENTER);
		
		GridPane.setHalignment(email, HPos.CENTER);
		GridPane.setHalignment(emailSpace, HPos.CENTER);
		
		GridPane.setHalignment(insertPassword, HPos.CENTER);
		GridPane.setHalignment(insertPasswordSpace, HPos.CENTER);
		
		GridPane.setHalignment(confirmPassword, HPos.CENTER);
		GridPane.setHalignment(confirmPasswordSpace, HPos.CENTER);
		
		GridPane.setHalignment(back, HPos.CENTER);
		
		inputPane1.add(firstName,    	0,0,1,1);
		inputPane1.add(firstNameSpace,	1,0,1,1);
		
		inputPane2.add(lastName,    	0,0,1,1);
		inputPane2.add(lastNameSpace,	1,0,1,1);
		
		inputPane3.add(userId,    	0,0,1,1);
		inputPane3.add(userIdSpace,	1,0,1,1);
		
		inputPane4.add(email,    	0,0,1,1);
		inputPane4.add(emailSpace,	1,0,1,1);
		
		inputPane5.add(insertPassword,    	0,0,1,1);
		inputPane5.add(insertPasswordSpace,	1,0,1,1);
    	
    	inputPane6.add(confirmPassword,   		0,0,1,1);
		inputPane6.add(confirmPasswordSpace,	1,0,1,1);
		
		mainPane.add(inputPane1,   0,0,1,1);
		mainPane.add(inputPane2,   0,1,1,1);
		mainPane.add(inputPane3,   0,2,1,1);
		mainPane.add(inputPane4,   0,3,1,1);
		mainPane.add(inputPane5,   0,4,1,1);
		mainPane.add(inputPane6,   0,5,1,1);
		mainPane.add(back,         0,6,1,1);
		
		inputPane1.setHgap(40);
		inputPane2.setHgap(40);
		inputPane3.setHgap(40);
		inputPane4.setHgap(40);
		inputPane5.setHgap(40);
		inputPane6.setHgap(40);
		mainPane.setVgap(40);
		
		Scene scene = new Scene(mainPane, 700, 700);
		window.setScene(scene);
		window.show();
    	
	}
	
	public void processAdminLogInButton(ActionEvent event)
	{		
		Text adminFirstName = new Text ("First Name: ");
		adminFirstName.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 36));
	 	adminFirstNameSpace = new TextField();
	 	adminFirstNameSpace.setPrefWidth(150);
	 	
	 	Text adminLastName = new Text ("Last Name: ");
		adminLastName.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 36));
	 	adminLastNameSpace = new TextField();
	 	adminLastNameSpace.setPrefWidth(150);
	
		Text adminName = new Text ("Username: ");
		adminName.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 36));
	 	adminNameSpace = new TextField();
	 	adminNameSpace.setPrefWidth(150);
	    
	  	Text adminPassword = new Text ("Password: ");
	  	adminPassword.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 36));
    	adminPasswordSpace = new TextField();
    	adminPasswordSpace.setPrefWidth(150);
    	
    	Button back = new Button ("Return");
    	back.setPrefWidth(150);
		back.setOnAction(this::processReturnButton);
		
		GridPane inputPane1 = new GridPane();
		GridPane inputPane2 = new GridPane();
		GridPane inputPane3 = new GridPane();
		GridPane inputPane4 = new GridPane();
    	GridPane mainPane  = new GridPane();
    	
    	inputPane1.setAlignment(Pos.CENTER);
    	inputPane2.setAlignment(Pos.CENTER);
    	inputPane3.setAlignment(Pos.CENTER);
    	inputPane4.setAlignment(Pos.CENTER);
		mainPane.setAlignment(Pos.CENTER);
		
		GridPane.setHalignment(adminFirstName, HPos.CENTER);
		GridPane.setHalignment(adminFirstNameSpace, HPos.CENTER);
		
		GridPane.setHalignment(adminLastName, HPos.CENTER);
		GridPane.setHalignment(adminLastNameSpace, HPos.CENTER);
		
		GridPane.setHalignment(adminName, HPos.CENTER);
		GridPane.setHalignment(adminNameSpace, HPos.CENTER);
		
		GridPane.setHalignment(adminPassword, HPos.CENTER);
		GridPane.setHalignment(adminPasswordSpace, HPos.CENTER);
		
		GridPane.setHalignment(back, HPos.CENTER);
		
		inputPane1.add(adminFirstName,    0,0,1,1);
		inputPane1.add(adminFirstNameSpace,	1,0,1,1);
		
		inputPane2.add(adminLastName,    0,0,1,1);
		inputPane2.add(adminLastNameSpace,	1,0,1,1);
		
		inputPane3.add(adminName,    0,0,1,1);
		inputPane3.add(adminNameSpace,	1,0,1,1);
		
		inputPane4.add(adminPassword,      0,0,1,1);
		inputPane4.add(adminPasswordSpace, 1,0,1,1);
		
		mainPane.add(inputPane1,   0,0,1,1);
		mainPane.add(inputPane2,   0,1,1,1);
		mainPane.add(inputPane3,   0,2,1,1);
		mainPane.add(inputPane4,   0,3,1,1);
		mainPane.add(back,         0,4,1,1);
		
		inputPane1.setHgap(40);
		inputPane2.setHgap(40);
		inputPane3.setHgap(40);
		inputPane4.setHgap(40);
		mainPane.setVgap(40);
		
		Scene scene = new Scene(mainPane, 700, 700);
		window.setScene(scene);
		window.show();
	}
	
	public void processReturnButton(ActionEvent event)
	{
		
		Text hotelName = new Text ("United 21");
		hotelName.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 36));
		
		Button logIn = new Button ("LogIn");
		logIn.setPrefWidth(300);
		logIn.setOnAction(this::processLogInButton);
		
		Button createAccount = new Button ("CreateAccount");
		createAccount.setPrefWidth(300);
		createAccount.setOnAction(this::processCreateAccountButton);
		
		Button adminLogIn = new Button ("Admin LogIn");
		adminLogIn.setPrefWidth(300);
		adminLogIn.setOnAction(this::processAdminLogInButton);
		
		GridPane mainPane  = new GridPane();
		mainPane.setAlignment(Pos.CENTER);
		
		GridPane.setHalignment(hotelName, HPos.CENTER);
		GridPane.setHalignment(logIn, HPos.CENTER);
		GridPane.setHalignment(createAccount, HPos.CENTER);
		GridPane.setHalignment(adminLogIn, HPos.CENTER);
		
		mainPane.add(hotelName,     0,0,1,1);
		mainPane.add(logIn,     	0,1,1,1);
		mainPane.add(createAccount, 0,2,1,1);
		mainPane.add(adminLogIn,    0,3,1,1);
		
		mainPane.setVgap(40);
		
		Scene scene = new Scene(mainPane, 700, 700);
		window.setScene(scene);
		window.show();
		
	}
}