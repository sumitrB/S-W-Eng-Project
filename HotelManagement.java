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
		hotelName.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 36));
		
		Button logIn = new Button ("LogIn");
		logIn.setPrefWidth(300);
		logIn.setOnAction(this::processLogInButton);
		
		Button createAccount = new Button ("CreateAccount");
		createAccount.setPrefWidth(300);
		createAccount.setOnAction(this::processCreateAccountButton);
		
		GridPane mainPane  = new GridPane();
		mainPane.setAlignment(Pos.CENTER);
		
		GridPane.setHalignment(hotelName, HPos.CENTER);
		GridPane.setHalignment(logIn, HPos.CENTER);
		GridPane.setHalignment(createAccount, HPos.CENTER);
		
		mainPane.add(hotelName,     0,0,1,1);
		mainPane.add(logIn,     	0,1,1,1);
		mainPane.add(createAccount, 0,2,1,1);
		
		mainPane.setVgap(40);
		
		Scene scene = new Scene(mainPane, 700, 700);
		window.setScene(scene);
		window.show();
	    
	}
	
	public void processLogInButton(ActionEvent event)
	{
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
		
		Button enter = new Button ("Enter");
    	enter.setPrefWidth(150);
		enter.setOnAction(this::processEnterButtonForLogIn);
		
		GridPane inputPane1 = new GridPane();
		GridPane inputPane2 = new GridPane();
		GridPane inputPane3 = new GridPane();
    	GridPane mainPane  = new GridPane();
    	
    	inputPane1.setAlignment(Pos.CENTER);
    	inputPane2.setAlignment(Pos.CENTER);
    	inputPane3.setAlignment(Pos.CENTER);
		mainPane.setAlignment(Pos.CENTER);
		
		
		GridPane.setHalignment(userName, HPos.CENTER);
		GridPane.setHalignment(nameSpace, HPos.CENTER);
		
		GridPane.setHalignment(password, HPos.CENTER);
		GridPane.setHalignment(passwordSpace, HPos.CENTER);
		
		GridPane.setHalignment(back, HPos.CENTER);
		GridPane.setHalignment(enter, HPos.CENTER);
		
		
		inputPane1.add(userName,    0,0,1,1);
		inputPane1.add(nameSpace,	1,0,1,1);
		
		inputPane2.add(password,      0,0,1,1);
		inputPane2.add(passwordSpace, 1,0,1,1);
		
		inputPane3.add(back,    0,0,1,1);
		inputPane3.add(enter, 	1,0,1,1);
		
		mainPane.add(inputPane1,   0,0,1,1);
		mainPane.add(inputPane2,   0,1,1,1);
		mainPane.add(inputPane3,   0,2,1,1);
		
		
		inputPane1.setHgap(40);
		inputPane2.setHgap(40);
		inputPane3.setHgap(40);
		mainPane.setVgap(40);
		
		Scene scene = new Scene(mainPane, 700, 700);
		window.setScene(scene);
		window.show();
		
	}	
	
	public void processCreateAccountButton(ActionEvent event)
	{    
	    Text userId = new Text ("User Id: ");
	    userId.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 36));
	    userIdSpace = new TextField();
	    userIdSpace.setPrefWidth(150);
	    
	    Text insertPassword = new Text ("Password: ");
	    insertPassword.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 36));
	    insertPasswordSpace = new TextField();
	    insertPasswordSpace.setPrefWidth(150);
	    
		Text confirmPassword = new Text ("Confirm Password: ");
		confirmPassword.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 36));
	    confirmPasswordSpace = new TextField();
	    confirmPasswordSpace.setPrefWidth(150);
	    
	    Button back = new Button ("Return");
	    back.setPrefWidth(150);
		back.setOnAction(this::processReturnButton);
		
		Button enter = new Button ("Enter");
	    enter.setPrefWidth(150);
		enter.setOnAction(this::processEnterButtonForCreateAccount);
	    
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
		
		
		GridPane.setHalignment(userId, HPos.CENTER);
		GridPane.setHalignment(userIdSpace, HPos.CENTER);
		
		GridPane.setHalignment(insertPassword, HPos.CENTER);
		GridPane.setHalignment(insertPasswordSpace, HPos.CENTER);
		
		GridPane.setHalignment(confirmPassword, HPos.CENTER);
		GridPane.setHalignment(confirmPasswordSpace, HPos.CENTER);
		
		GridPane.setHalignment(back, HPos.CENTER);
		GridPane.setHalignment(enter, HPos.CENTER);
		
		
		inputPane1.add(userId,    	0,0,1,1);
		inputPane1.add(userIdSpace,	1,0,1,1);
		
		inputPane2.add(insertPassword,    	0,0,1,1);
		inputPane2.add(insertPasswordSpace,	1,0,1,1);
    	
    	inputPane3.add(confirmPassword,   		0,0,1,1);
		inputPane3.add(confirmPasswordSpace,	1,0,1,1);
		
		inputPane4.add(back,   	0,0,1,1);
		inputPane4.add(enter,	1,0,1,1);
		
		mainPane.add(inputPane1,   0,0,1,1);
		mainPane.add(inputPane2,   0,1,1,1);
		mainPane.add(inputPane3,   0,2,1,1);
		mainPane.add(inputPane4,   0,3,1,1);
		
		
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
		
		Text hotelName = new Text ("<HOTEL NAME>");
		hotelName.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 36));
		
		Button logIn = new Button ("LogIn");
		logIn.setPrefWidth(300);
		logIn.setOnAction(this::processLogInButton);
		
		Button createAccount = new Button ("CreateAccount");
		createAccount.setPrefWidth(300);
		createAccount.setOnAction(this::processCreateAccountButton);
		
		GridPane mainPane  = new GridPane();
		mainPane.setAlignment(Pos.CENTER);
		
		GridPane.setHalignment(hotelName, HPos.CENTER);
		GridPane.setHalignment(logIn, HPos.CENTER);
		GridPane.setHalignment(createAccount, HPos.CENTER);
		
		mainPane.add(hotelName,     0,0,1,1);
		mainPane.add(logIn,     	0,1,1,1);
		mainPane.add(createAccount, 0,2,1,1);
		
		mainPane.setVgap(40);
		
		Scene scene = new Scene(mainPane, 700, 700);
		window.setScene(scene);
		window.show();
		
	}
	
	public void processEnterButtonForLogIn(ActionEvent event)
	{	
		String uUserName = nameSpace.getText();
		String uPassword = passwordSpace.getText();
	}
	
	public void processEnterButtonForCreateAccount(ActionEvent event)
	{
		String cUserId = userIdSpace.getText();
		String cInsertPassword = insertPasswordSpace.getText();
		String cConfirmPassword = confirmPasswordSpace.getText();
	}
	
}