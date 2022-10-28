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
import java.sql.*;

public class HotelManagement extends Application 
{
	//First page;
	private Text hotelName;
	Button logIn;
	Button createAccount;
	Button adminLogIn;
	Button back;
	Button enter;
	
	// If logIn;
	
	private Text userName;
	private Text password;
	private TextField nameSpace;
	private TextField passwordSpace;
	
	
	// If create new account;
	
	private Text userId;
	private Text insertPassword;
	private Text confirmPassword;
	private TextField userIdSpace;
	private TextField insertPasswordSpace;
	private TextField confirmPasswordSpace;
	
	// If AdminlogIn;
	
	private Text adminUserName;
	private Text adminPassword;
	private TextField adminNameSpace;
	private TextField adminPasswordSpace;
	
	//If HotelBooking
	
	private Text name;
	private Text numberOfGuests;
	private Text numberOfBeds;
	private Text numberOfNights;
	private Button luxury;
	private Button modest;
	private Button reset;
	private Text intro1;
	private Text intro2;
	private TextField field1;
	private TextField field2;
	private TextField field3;
	private TextField field4;
	
	
	Stage window;
	Connection con = null;
	
	public void start(Stage primaryStage) 
	{
		window = primaryStage;
		
		try
		{
			Class.forName("com.mysql.cj.jbdc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/?user=root", "root", "SumitrBanik00");

			Statement s = con.createStatement();
			ResultSet r=s.executeQuery("select * from Users;");
			r.next();
			String testName = r.getString("U_Password");
			System.out.println(testName);
			s.close();
			con.close();
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		Text hotelName = new Text ("<HOTEL NAME>");
		hotelName.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 30));
		
		Button logIn = new Button ("LogIn");
		logIn.setPrefWidth(300);
		logIn.setOnAction(this::processLogInButton);
		
		Button createAccount = new Button ("CreateAccount");
		createAccount.setPrefWidth(300);
		createAccount.setOnAction(this::processCreateAccountButton);
		
		Button adminLogIn = new Button ("AdminLogIn");
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
		
		Scene scene = new Scene(mainPane, 900, 900);
		window.setScene(scene);
		window.show();
	    
	}
	
	public void processLogInButton(ActionEvent event)
	{
		Text userName = new Text ("Username: ");
		userName.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 30));
	 	nameSpace = new TextField();
	 	nameSpace.setPrefWidth(150);
	    
	  	Text password = new Text ("Password: ");
	  	password.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 30));
    	passwordSpace = new TextField();
    	passwordSpace.setPrefWidth(150);
    	
    	Button back = new Button ("Return");
    	back.setPrefWidth(150);
		back.setOnAction(this::processReturnButton);
		
		Button enter = new Button ("Enter");
    	enter.setPrefWidth(150);
		enter.setOnAction(this::processEnterButtonForLogIn);
		
		GridPane inputPane = new GridPane();
    	GridPane mainPane  = new GridPane();
    	
    	inputPane.setAlignment(Pos.CENTER);
		mainPane.setAlignment(Pos.CENTER);
		
		
		GridPane.setHalignment(userName, HPos.CENTER);
		GridPane.setHalignment(nameSpace, HPos.CENTER);
		
		GridPane.setHalignment(password, HPos.CENTER);
		GridPane.setHalignment(passwordSpace, HPos.CENTER);
		
		GridPane.setHalignment(back, HPos.CENTER);
		GridPane.setHalignment(enter, HPos.CENTER);
		
		
		inputPane.add(userName,    0,0,1,1);
		inputPane.add(nameSpace,	1,0,1,1);
		
		inputPane.add(password,      0,1,1,1);
		inputPane.add(passwordSpace, 1,1,1,1);
		
		inputPane.add(back,    0,2,1,1);
		inputPane.add(enter, 	1,2,1,1);
		
		mainPane.add(inputPane,   0,0,1,1);
		
		inputPane.setHgap(40);
		inputPane.setVgap(40);
		mainPane.setVgap(40);
		
		Scene scene = new Scene(mainPane, 900, 900);
		window.setScene(scene);
		window.show();
		
	}


	public void processCreateAccountButton(ActionEvent event)
	{    
	    Text userId = new Text ("User Id: ");
	    userId.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 30));
	    userIdSpace = new TextField();
	    userIdSpace.setPrefWidth(150);
	    
	    Text insertPassword = new Text ("Password: ");
	    insertPassword.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 30));
	    insertPasswordSpace = new TextField();
	    insertPasswordSpace.setPrefWidth(150);
	    
		Text confirmPassword = new Text ("Confirm Password: ");
		confirmPassword.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 30));
	    confirmPasswordSpace = new TextField();
	    confirmPasswordSpace.setPrefWidth(150);
	    
	    Button back = new Button ("Return");
	    back.setPrefWidth(150);
		back.setOnAction(this::processReturnButton);
		
		Button enter = new Button ("Enter");
	    enter.setPrefWidth(150);
		enter.setOnAction(this::processEnterButtonForCreateAccount);
	    
	    GridPane inputPane = new GridPane();
    	GridPane mainPane  = new GridPane();
    	
    	inputPane.setAlignment(Pos.CENTER);
		mainPane.setAlignment(Pos.CENTER);
		
		
		GridPane.setHalignment(userId, HPos.CENTER);
		GridPane.setHalignment(userIdSpace, HPos.CENTER);
		
		GridPane.setHalignment(insertPassword, HPos.CENTER);
		GridPane.setHalignment(insertPasswordSpace, HPos.CENTER);
		
		GridPane.setHalignment(confirmPassword, HPos.CENTER);
		GridPane.setHalignment(confirmPasswordSpace, HPos.CENTER);
		
		GridPane.setHalignment(back, HPos.CENTER);
		GridPane.setHalignment(enter, HPos.CENTER);
		
		
		inputPane.add(userId,    	0,0,1,1);
		inputPane.add(userIdSpace,	1,0,1,1);
		
		inputPane.add(insertPassword,    	0,1,1,1);
		inputPane.add(insertPasswordSpace,	1,1,1,1);
    	
    	inputPane.add(confirmPassword,   		0,2,1,1);
		inputPane.add(confirmPasswordSpace,	1,2,1,1);
		
		inputPane.add(back,   	0,3,1,1);
		inputPane.add(enter,	1,3,1,1);
		
		mainPane.add(inputPane,   0,0,1,1);
		
		
		inputPane.setHgap(40);
		inputPane.setVgap(40);
		mainPane.setVgap(40);
		
		Scene scene = new Scene(mainPane, 900, 900);
		window.setScene(scene);
		window.show();
    	
	}

	public void processAdminLogInButton(ActionEvent event)
	{
		Text adminUserName = new Text ("Admin name: ");
		adminUserName.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 30));
	 	adminNameSpace = new TextField();
	 	adminNameSpace.setPrefWidth(150);
	    
	  	Text adminPassword = new Text ("Password: ");
	  	adminPassword.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 30));
    	adminPasswordSpace = new TextField();
    	adminPasswordSpace.setPrefWidth(150);
    	
    	Button back = new Button ("Return");
    	back.setPrefWidth(150);
		back.setOnAction(this::processReturnButton);
		
		Button enter = new Button ("Enter");
    	enter.setPrefWidth(150);
		enter.setOnAction(this::processEnterButtonForAdminLogIn);
		
		GridPane inputPane = new GridPane();
    	GridPane mainPane  = new GridPane();
    	
    	inputPane.setAlignment(Pos.CENTER);
		mainPane.setAlignment(Pos.CENTER);
		
		
		GridPane.setHalignment(adminUserName, HPos.CENTER);
		GridPane.setHalignment(adminNameSpace, HPos.CENTER);
		
		GridPane.setHalignment(adminPassword, HPos.CENTER);
		GridPane.setHalignment(adminPasswordSpace, HPos.CENTER);
		
		GridPane.setHalignment(back, HPos.CENTER);
		GridPane.setHalignment(enter, HPos.CENTER);
		
		
		inputPane.add(adminUserName,    0,0,1,1);
		inputPane.add(adminNameSpace,	1,0,1,1);
		
		inputPane.add(adminPassword,      0,1,1,1);
		inputPane.add(adminPasswordSpace, 1,1,1,1);
		
		inputPane.add(back,    0,2,1,1);
		inputPane.add(enter, 	1,2,1,1);
		
		mainPane.add(inputPane,   0,0,1,1);
		
		inputPane.setHgap(40);
		inputPane.setVgap(40);
		mainPane.setVgap(40);
		
		Scene scene = new Scene(mainPane, 900, 900);
		window.setScene(scene);
		window.show();
		
	}
	
	
	public void processReturnButton(ActionEvent event)
	{
		Text hotelName = new Text ("<HOTEL NAME>");
		hotelName.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 30));
		
		Button logIn = new Button ("LogIn");
		logIn.setPrefWidth(300);
		logIn.setOnAction(this::processLogInButton);
		
		Button createAccount = new Button ("CreateAccount");
		createAccount.setPrefWidth(300);
		createAccount.setOnAction(this::processCreateAccountButton);
		
		Button adminLogIn = new Button ("AdminLogIn");
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
		
		Scene scene = new Scene(mainPane, 900, 900);
		window.setScene(scene);
		window.show();
	
	}
	
	public void processEnterButtonForLogIn(ActionEvent event)
	{	
		name = new Text("Name:");
		name.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 30));
		
		numberOfGuests = new Text("Number of Guests:");
		numberOfGuests.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 30));
		
		numberOfBeds = new Text("Number of Beds:");
		numberOfBeds.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 30));
		
		numberOfNights = new Text("Number of Nights:");
		numberOfNights.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 30));
		
		intro1 = new Text("Welcome to The Golden Dragon Inn!");
		intro1.setFont(Font.font("Roboto Blacak", FontPosture.REGULAR, 25));
		
		intro2 = new Text("Take Note of Your check-out time.   Enter Your information.");
		intro2.setFont(Font.font("Roboto Blacak", FontPosture.REGULAR, 25));
	
		luxury = new Button("Luxury");
		luxury.setPrefWidth(150);
		luxury.setOnAction(this::eventHandler1);
		
		modest = new Button("Modest");
		modest.setPrefWidth(150);
		modest.setOnAction(this::eventHandler2);
		
		Button back = new Button ("Return");
		back.setPrefWidth(150);
		back.setOnAction(this::processReturnButton);
	
		field1 = new TextField();
		field1.setPrefWidth(140);
	
		field2 = new TextField();
		field2.setPrefWidth(60);

		field3 = new TextField();
		field3.setPrefWidth(70);

		field4 = new TextField();
		field4.setPrefWidth(40);	
	
		GridPane inputPane  = new GridPane();
		GridPane buttonPane = new GridPane();
		GridPane mainPane   = new GridPane();
	
		inputPane.setAlignment(Pos.CENTER);
		buttonPane.setAlignment(Pos.CENTER);
		mainPane.setAlignment(Pos.CENTER);
	
		GridPane.setHalignment(field1, HPos.CENTER);
		GridPane.setHalignment(field2, HPos.CENTER);
		GridPane.setHalignment(field3, HPos.CENTER);
		GridPane.setHalignment(field4, HPos.CENTER);
		GridPane.setHalignment(name, HPos.CENTER);
		GridPane.setHalignment(numberOfGuests, HPos.CENTER);
		GridPane.setHalignment(numberOfBeds, HPos.CENTER);
		GridPane.setHalignment(numberOfNights, HPos.CENTER);
		GridPane.setHalignment(intro1, HPos.CENTER);
		GridPane.setHalignment(intro2, HPos.CENTER);
		GridPane.setHalignment(luxury, HPos.CENTER);
		GridPane.setHalignment(modest, HPos.CENTER);
		GridPane.setHalignment(back, HPos.CENTER);
	
		inputPane.add(name, 0,0,1,1);
		inputPane.add(field1, 1,0,1,1);
		inputPane.add(numberOfGuests, 2,0,1,1);
		inputPane.add(field2, 3,0,1,1);
		inputPane.add(numberOfBeds, 0,1,1,1);
		inputPane.add(field3, 1,1,1,1);
		inputPane.add(numberOfNights, 2,1,1,1);
		inputPane.add(field4, 3,1,1,1);
		
		buttonPane.add(luxury, 0,2,1,1);
		buttonPane.add(modest, 1,2,1,1);
		buttonPane.add(back, 2,2,1,1);
		
		mainPane.add(inputPane, 0,0,1,1);
		mainPane.add(buttonPane, 0,1,1,1);
		mainPane.add(intro1, 0,2,1,1);
		mainPane.add(intro2, 0,3,1,1);
		
	
		inputPane.setVgap(22);
		inputPane.setHgap(22);
		buttonPane.setHgap(42);
		buttonPane.setVgap(12);
		mainPane.setVgap(22);
	
		Scene scene = new Scene(mainPane, 900, 900);
		window.setScene(scene);
		window.show();
	

	}
	
	public void processEnterButtonForCreateAccount(ActionEvent event)
	{
		Text hotelName = new Text ("<HOTEL NAME>");
		hotelName.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 30));
		
		Button logIn = new Button ("LogIn");
		logIn.setPrefWidth(300);
		logIn.setOnAction(this::processLogInButton);
		
		GridPane mainPane  = new GridPane();
		mainPane.setAlignment(Pos.CENTER);
		
		GridPane.setHalignment(hotelName, HPos.CENTER);
		GridPane.setHalignment(logIn, HPos.CENTER);
		
		mainPane.add(hotelName,     0,0,1,1);
		mainPane.add(logIn,     	0,1,1,1);
		
		mainPane.setVgap(40);
		
		Scene scene = new Scene(mainPane, 900, 900);
		window.setScene(scene);
		window.show();
	    
	
	}
	public void processEnterButtonForAdminLogIn(ActionEvent event)
	{	
		String uAdminName = adminNameSpace.getText();
		String uAdminPassword = adminPasswordSpace.getText();
	}
	public void eventHandler1(ActionEvent event)
	{
		double guests =Double.parseDouble(field2.getText());
		double beds =Double.parseDouble(field3.getText());
		double nights =Double.parseDouble(field4.getText());
 
		double cost = (30 * nights) + (10 * nights * (beds - 1));
		intro1.setText("Your room perk is : keg of wine. Please check-out by:9am");
		intro2.setText("Total Cost : " + cost + "gp");
	}
	
	public void eventHandler2(ActionEvent event)
	{	
		double guests =Double.parseDouble(field2.getText());
		double beds =Double.parseDouble(field3.getText());
		double nights =Double.parseDouble(field4.getText());
		double cost;
		
		if(beds <= 2)
			 cost = (10 * nights) + (0.5 * nights * guests);
	
		else
			 cost = (10 * nights) + (0.5 * nights * guests) + ( 1 * nights * (beds - 2));
		
		intro1.setText("Breakfast included in room cost. Please check-out by:9am");
		intro2.setText("Total Cost : " + cost + "gp");
	}
	
	public void eventHandler3(ActionEvent event)
	{  
	        
		
			intro1.setText("Welcome to The Golden Dragon Inn!");
			intro2.setText("Take Note of Your check-out time.   Enter Your information.");
		
	}

}