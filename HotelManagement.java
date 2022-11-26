import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import java.time.LocalDate;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

 
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
	
	private Text intro;
	private Text checkInDate;
	private Text numOfGuests;
	private Text roomType;
	private Text roomNum;
	private Text numDays;
	private ComboBox<String>  roomTypeBox;
	private ComboBox<String>  numOfGuestBox;
	private TextField roomNumSpace;
	private TextField numDaysSpace;
	Button clear;
	Button book;
	
	
	Stage window;
	Connection con = null;
	
	public void start(Stage primaryStage) throws FileNotFoundException
	{
		window = primaryStage;
		
		// try
// 		{
// 			Class.forName("com.mysql.cj.jbdc.Driver");
// 			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/?user=root", "root", "SumitrBanik00");
// 
// 			Statement s = con.createStatement();
// 			ResultSet r=s.executeQuery("select * from Users;");
// 			r.next();
// 			String testName = r.getString("U_Password");
// 			System.out.println(testName);
// 			s.close();
// 			con.close();
// 		}
// 		catch(ClassNotFoundException e)
// 		{
// 			e.printStackTrace();
// 		}
// 		catch(SQLException e)
// 		{
// 			e.printStackTrace();
// 		}

		Image image = new Image(new FileInputStream("/Users/ayushbhosale/Documents/FA22/CS2043/Project/Panthera.png"));
		ImageView view = new ImageView(image);
		view.setX(50);
		view.setY(50);
		view.setFitHeight(100);
		view.setFitWidth(200);
		Group root = new Group(view);
		
		Text hotelName = new Text ("PANTHERA");
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
		
		GridPane.setHalignment(root, HPos.CENTER);
		GridPane.setHalignment(hotelName, HPos.CENTER);
		GridPane.setHalignment(logIn, HPos.CENTER);
		GridPane.setHalignment(createAccount, HPos.CENTER);
		GridPane.setHalignment(adminLogIn, HPos.CENTER);
		
		mainPane.add(root,    		0,0,1,1);
		mainPane.add(hotelName,     0,1,1,1);
		mainPane.add(logIn,     	0,2,1,1);
		mainPane.add(createAccount, 0,3,1,1);
		mainPane.add(adminLogIn,    0,4,1,1);
		
		mainPane.setVgap(40);
		
		Scene scene = new Scene(mainPane, 900, 900);
		scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
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
		Text hotelName = new Text ("PANTHERA");
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
		intro = new Text("Room Selection");
		intro.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 50));
		
		roomType = new Text("Room Type:");
		roomType.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 30));
		
		numOfGuests = new Text("Number of Guests:");
		numOfGuests.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 30));
		
		checkInDate = new Text("Check In Date:");
		checkInDate.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 30));
		
		roomNum = new Text("Room Number:");
		roomNum.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 30));
		roomNumSpace = new TextField();
	 	roomNumSpace.setPrefWidth(150);
	 	
	 	numDays = new Text("Number of days of stay:");
		numDays.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 30));
		numDaysSpace = new TextField();
	 	numDaysSpace.setPrefWidth(150);
		
		Button clear = new Button ("Clear");
		clear.setPrefWidth(300);
		clear.setOnAction(this::processClearButton);
		
		Button book = new Button ("Book");
		book.setPrefWidth(300);
		book.setOnAction(this::processBookButton);
		
		
		roomTypeBox = new ComboBox<String>();
        roomTypeBox.getItems().add("Standard Suite");
        roomTypeBox.getItems().add("Junior Suite");
        roomTypeBox.getItems().add("Presidential Suite");
        roomTypeBox.getItems().add("Penthouse Suite");
		roomTypeBox.getItems().add("Honeymoon Suite");
		
		numOfGuestBox = new ComboBox<String>();
		numOfGuestBox.getItems().add("1");
		numOfGuestBox.getItems().add("2");
 		numOfGuestBox.getItems().add("3");
 	 	numOfGuestBox.getItems().add("4");
 	 	numOfGuestBox.getItems().add("5");
 	 	numOfGuestBox.getItems().add("6");
 	 	
 	 	DatePicker d = new DatePicker();
 	 	HBox box = new HBox(5);
      	box.setPadding(new Insets(15, 50, 50, 50));
     	box.getChildren().addAll(d);
	 	
	 	GridPane inputPane = new GridPane();
    	GridPane mainPane  = new GridPane();
    	
    	inputPane.setAlignment(Pos.CENTER);
		mainPane.setAlignment(Pos.CENTER);
		
		GridPane.setHalignment(intro, HPos.CENTER);
		GridPane.setHalignment(roomType, HPos.CENTER);
		GridPane.setHalignment(numOfGuests, HPos.CENTER);
		GridPane.setHalignment(roomNum, HPos.CENTER);
		GridPane.setHalignment(roomTypeBox, HPos.CENTER);
		GridPane.setHalignment(checkInDate, HPos.CENTER);
		GridPane.setHalignment(box, HPos.CENTER);
		GridPane.setHalignment(numOfGuestBox, HPos.CENTER);
		GridPane.setHalignment(numDays, HPos.CENTER);
		GridPane.setHalignment(numDaysSpace, HPos.CENTER);
		GridPane.setHalignment(roomNumSpace, HPos.CENTER);
		GridPane.setHalignment(clear, HPos.CENTER);
		GridPane.setHalignment(book, HPos.CENTER);
		
		inputPane.add(intro,    0,0,1,1);
		
		inputPane.add(roomType,    	  0,1,1,1);
		inputPane.add(roomTypeBox,    1,1,1,1);
		
		inputPane.add(numOfGuests,    	0,2,1,1);
		inputPane.add(numOfGuestBox,    1,2,1,1);
		
		inputPane.add(checkInDate,    	0,3,1,1);
		inputPane.add(box,    			1,3,1,1);
		
		inputPane.add(numDays,    	  0,4,1,1);
		inputPane.add(numDaysSpace,   1,4,1,1);
		
		inputPane.add(roomNum,    	  0,5,1,1);
		inputPane.add(roomNumSpace,   1,5,1,1);
		
		inputPane.add(clear,  0,6,1,1);
		inputPane.add(book,   1,6,1,1);
		
		mainPane.add(inputPane,   0,0,1,1);
		
		inputPane.setHgap(40);
		inputPane.setVgap(40);
		mainPane.setVgap(40);
		
		Scene scene = new Scene(mainPane, 900, 900);
		window.setScene(scene);
		window.show();
	

	}
	
	public void processEnterButtonForCreateAccount(ActionEvent event) 
	{
		
		
		Text hotelName = new Text ("PANTHERA");
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
		
	}
	
	public void processClearButton(ActionEvent event)
	{
	
	}
	
	private Text line1;
	private Text line2;
	private Text line3;
	double priceForRoom = 0.0;
	double totalPrice;
	
	public void processBookButton(ActionEvent event)
	{
		String op = (String)roomTypeBox.getValue();
		double days = Double.parseDouble(numDaysSpace.getText());
		
		if (op.equals("Standard Suite"))
			priceForRoom = 60.0;
		else if (op.equals("Junior Suite"))
			priceForRoom = 40.0;
		else if (op.equals("Presidential Suite"))
			priceForRoom = 250.0;
		else if (op.equals("Penthouse Suite"))
			priceForRoom = 150.0;
		else if (op.equals("Honeymoon Suite"))
			priceForRoom = 200.0; 
		
		totalPrice = priceForRoom * days;
		
		line1 = new Text("Welcome to Hotel Panthera");
		line1.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 30));
		
		if (op.equals("Standard Suite"))
		{
			line2 = new Text ("Thank you foer booking a Standard Suite with us\n");
			line2.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 30));
		}
			
		if (op.equals("Junior Suite"))
		{
			line2 = new Text ("Thank you foer booking a Junior Suite with us\n");
			line2.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 30));
		}
		
		if (op.equals("Presidential Suite"))
		{
			line2 = new Text ("Thank you foer booking a Presidential Suite with us\n");
			line2.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 30));
		}
		
		if (op.equals("Penthouse Suite"))
		{
			line2 = new Text ("Thank you foer booking a Penthouse Suite with us\n");
			line2.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 30));
		}
		
		if (op.equals("Honeymoon Suite"))
		{
			line2 = new Text ("Thank you foer booking a Honeymoon Suite with us\n");
			line2.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 30));
		}
		
		line3 = new Text("Price for your stay is " + totalPrice);
		line3.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 30));
		
		GridPane mainPane  = new GridPane();
		mainPane.setAlignment(Pos.CENTER);
		
		mainPane.add(line1,     0,0,1,1);
		mainPane.add(line2,     0,1,1,1);
		mainPane.add(line3,     0,2,1,1);
		
		mainPane.setVgap(40);
		
		Scene scene = new Scene(mainPane, 900, 900);
		window.setScene(scene);
		window.show();
	}
	
	
	

}