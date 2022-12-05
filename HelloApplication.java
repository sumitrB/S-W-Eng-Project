package com.example.hms;

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
import java.time.LocalDate;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.sql.*;
import java.util.Objects;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

public class HelloApplication extends Application
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
    private PasswordField passwordSpace;


    // If create new account;

    private Text userId;
    private Text insertPassword;
    private Text confirmPassword;
    private TextField userIdSpace;
    private PasswordField insertPasswordSpace;
    private PasswordField confirmPasswordSpace;

    // If AdminlogIn;

    private Text adminUserName;
    private Text adminPassword;
    private TextField adminNameSpace;
    private PasswordField adminPasswordSpace;

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

    public void start(Stage primaryStage) throws FileNotFoundException {
        window = primaryStage;

        String imagePath = "panthera.png";
        Image image = new Image(new FileInputStream(imagePath));
        ImageView view = new ImageView(image);
        view.setX(70);
        view.setY(70);
        view.setFitHeight(150);
        view.setFitWidth(300);
        Group root = new Group(view);

        Text hotelName = new Text ("PANTHERA");
        hotelName.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 50));

        Button logIn = new Button ("LogIn");
        logIn.setPrefWidth(300);
        logIn.setPrefHeight(50);
        logIn.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 20));
        logIn.setOnAction(this::processLogInButton);

        Button createAccount = new Button ("CreateAccount");
        createAccount.setPrefWidth(300);
        createAccount.setPrefHeight(50);
        createAccount.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 20));
        createAccount.setOnAction(this::processCreateAccountButton);

        Button adminLogIn = new Button ("AdminLogIn");
        adminLogIn.setPrefWidth(300);
        adminLogIn.setPrefHeight(50);
        adminLogIn.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 20));
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
        window.setScene(scene);
        window.show();

    }

    public void processLogInButton(ActionEvent event)
    {
        Text userName = new Text ("Username: ");
        userName.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 50));
        nameSpace = new TextField();
        nameSpace.setPrefWidth(200);
        nameSpace.setPrefHeight(40);
        nameSpace.setPromptText("Your Username");

        Text password = new Text ("Password: ");
        password.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 50));
        passwordSpace = new PasswordField();
        passwordSpace.setPrefWidth(200);
        passwordSpace.setPrefHeight(40);
        passwordSpace.setPromptText("Your Password");

        Button back = new Button ("Return");
        back.setPrefWidth(150);
        back.setPrefHeight(30);
        back.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 20));
        back.setOnAction(this::processReturnButton);

        Button enter = new Button ("Enter");
        enter.setPrefWidth(150);
        enter.setPrefHeight(30);
        enter.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 20));

        enter.setOnAction(e -> {
            //Retrieving data
            String userN = nameSpace.getText();
            String pass = passwordSpace.getText();
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/hsm", "root", "SumitrBanik00");

                Statement s = con.createStatement();
                String sql = "select U_Password from Users where Username = \""+ userN +"\";";
                ResultSet r=s.executeQuery(sql);
                r.next();
                String realPass = r.getString("U_Password");

                System.out.println("Check Successful");

                if(realPass.equals(pass)){
                    processEnterButtonForLogIn(e);
                }
                else {
                    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                    errorAlert.setHeaderText("Input not valid");
                    errorAlert.setContentText("Passwords Dont Match");
                    errorAlert.showAndWait();
                }
                s.close();
                con.close();
            } catch (SQLException er) {
                er.printStackTrace();
            } catch (ClassNotFoundException er) {
                er.printStackTrace();
            }
        });

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
        userId.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 50));
        userIdSpace = new TextField();
        userIdSpace.setPrefWidth(200);
        userIdSpace.setPrefHeight(40);
        userIdSpace.setPromptText("Enter Username");

        Text insertPassword = new Text ("Password: ");
        insertPassword.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 50));
        insertPasswordSpace = new PasswordField();
        insertPasswordSpace.setPrefWidth(200);
        insertPasswordSpace.setPrefHeight(40);
        insertPasswordSpace.setPromptText("Enter Password");

        Text confirmPassword = new Text ("Confirm Password: ");
        confirmPassword.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 50));
        confirmPasswordSpace = new PasswordField();
        confirmPasswordSpace.setPrefWidth(200);
        confirmPasswordSpace.setPrefHeight(40);
        confirmPasswordSpace.setPromptText("Confirm");
        Button back = new Button ("Return");
        back.setPrefWidth(150);
        back.setPrefHeight(30);
        back.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 20));
        back.setOnAction(this::processReturnButton);

        Button enter = new Button ("Enter");
        enter.setPrefWidth(150);
        enter.setPrefHeight(30);
        enter.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 20));

        enter.setOnAction(e -> {
            //Retrieving data
            String userN = userIdSpace.getText();
            String pass = insertPasswordSpace.getText();
            String confmpass = confirmPasswordSpace.getText();

            if(pass.equals(confmpass)) {
                processEnterButtonForCreateAccount(e);
                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost/hsm", "root", "SumitrBanik00");

                    Statement s = con.createStatement();
                    String sql = "insert into Users values ('" + userN+ "', '" + confmpass + "');";
                    s.executeUpdate(sql);

                    System.out.println("Entry Successful");
                    s.close();
                    con.close();
                } catch (SQLException er) {
                    er.printStackTrace();
                } catch (ClassNotFoundException er) {
                    er.printStackTrace();
                }
            } else {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("Input not valid");
                errorAlert.setContentText("Passwords Dont Match");
                errorAlert.showAndWait();
            }
        });



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
        adminUserName.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 50));
        adminNameSpace = new TextField();
        adminNameSpace.setPrefWidth(200);
        adminNameSpace.setPrefHeight(40);
        adminNameSpace.setPromptText("Your Username");

        Text adminPassword = new Text ("Password: ");
        adminPassword.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 50));
        adminPasswordSpace = new PasswordField();
        adminPasswordSpace.setPrefWidth(200);
        adminPasswordSpace.setPrefHeight(40);
        adminPasswordSpace.setPromptText("Your password");

        Button back = new Button ("Back");
        back.setPrefWidth(150);
        back.setPrefHeight(30);
        back.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 20));
        back.setOnAction(this::processReturnButton);

        Button enter = new Button ("Enter");
        enter.setPrefWidth(150);
        enter.setPrefHeight(30);
        enter.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 20));
        enter.setOnAction(e -> {
            //Retrieving data
            String adminName = adminNameSpace.getText();
            String pass = adminPasswordSpace.getText();
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/hsm", "root", "SumitrBanik00");

                Statement s = con.createStatement();
                String sql = "select A_Password from Admins where AdUsername = \""+ adminName +"\";";
                ResultSet r=s.executeQuery(sql);
                r.next();
                String realPass = r.getString("A_Password");

                System.out.println("Check Successful");

                if(realPass.equals(pass)){
                    processEnterButtonForAdminLogIn(e);
                }
                else {
                    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                    errorAlert.setHeaderText("Input not valid");
                    errorAlert.setContentText("Passwords Dont Match");
                    errorAlert.showAndWait();
                }
                s.close();
                con.close();
            } catch (SQLException er) {
                er.printStackTrace();
            } catch (ClassNotFoundException er) {
                er.printStackTrace();
            }
        });
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


    public void processReturnButton(ActionEvent event) {
//        String imagePath = "panthera.png";
//        Image image = new Image(new FileInputStream(imagePath));
//        ImageView view = new ImageView(image);
//        view.setX(70);
//        view.setY(70);
//        view.setFitHeight(150);
//        view.setFitWidth(300);
//        Group root = new Group(view);

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

//        GridPane.setHalignment(root, HPos.CENTER);
        GridPane.setHalignment(hotelName, HPos.CENTER);
        GridPane.setHalignment(logIn, HPos.CENTER);
        GridPane.setHalignment(createAccount, HPos.CENTER);
        GridPane.setHalignment(adminLogIn, HPos.CENTER);
//
//        mainPane.add(root,    		0,0,1,1);
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
        intro.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 60));

        roomType = new Text("Room Type:");
        roomType.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 40));

        numOfGuests = new Text("Number of Guests:");
        numOfGuests.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 40));

        checkInDate = new Text("Check In Date:");
        checkInDate.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 40));

        roomNum = new Text("Room Number:");
        roomNum.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 40));
        roomNumSpace = new TextField();
        roomNumSpace.setPrefWidth(200);
        roomNumSpace.setPrefHeight(40);

        numDays = new Text("Number of days of stay:");
        numDays.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 40));
        numDaysSpace = new TextField();
        numDaysSpace.setPrefWidth(200);
        numDaysSpace.setPrefHeight(40);

        Button clear = new Button ("Clear");
        clear.setPrefWidth(150);
        clear.setPrefHeight(30);
        clear.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 20));
        clear.setOnAction(this::processClearButton);

        Button book = new Button ("Book");
        book.setPrefWidth(150);
        book.setPrefHeight(30);
        book.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 20));
        book.setOnAction(this::processBookButton);

        Button availableRooms = new Button ("Rooms");
        availableRooms.setPrefWidth(150);
        availableRooms.setPrefHeight(30);
        availableRooms.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 20));
        availableRooms.setOnAction(this::processAvailableRoomButtonforUser);

        Button backToLogIn = new Button ("Back");
        backToLogIn.setPrefWidth(150);
        backToLogIn.setPrefHeight(30);
        backToLogIn.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 20));
        backToLogIn.setOnAction(this::processBackToLogInButton);


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
        GridPane inputPane1 = new GridPane();
        GridPane mainPane  = new GridPane();

        inputPane.setAlignment(Pos.CENTER);
        inputPane1.setAlignment(Pos.CENTER);
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
        GridPane.setHalignment(availableRooms, HPos.CENTER);
        //GridPane.setHalignment(clear, HPos.CENTER);
        //GridPane.setHalignment(book, HPos.CENTER);
        //GridPane.setHalignment(backToLogIn, HPos.CENTER);

        inputPane.add(roomType,    	  0,0,1,1);
        inputPane.add(roomTypeBox,    1,0,1,1);

        inputPane.add(numOfGuests,    	0,1,1,1);
        inputPane.add(numOfGuestBox,    1,1,1,1);

        inputPane.add(checkInDate,    	0,2,1,1);
        inputPane.add(box,    			1,2,1,1);

        inputPane.add(numDays,    	  0,3,1,1);
        inputPane.add(numDaysSpace,   1,3,1,1);

        inputPane.add(roomNum,    	  0,4,1,1);
        inputPane.add(roomNumSpace,   1,4,1,1);
        inputPane.add(availableRooms,   2,4,1,1);

        inputPane.add(clear,  		0,5,1,1);
        inputPane.add(book,   		1,5,1,1);
        inputPane.add(backToLogIn,  2,5,1,1);

        inputPane1.add(intro,    	 0,0,1,1);
        inputPane1.add(inputPane,    0,1,1,1);


        inputPane.setHalignment(intro, HPos.CENTER);
        inputPane.setHalignment(roomType, HPos.CENTER);
        inputPane.setHalignment(numOfGuests, HPos.CENTER);
        inputPane.setHalignment(roomNum, HPos.CENTER);
        inputPane.setHalignment(roomTypeBox, HPos.CENTER);
        inputPane.setHalignment(checkInDate, HPos.CENTER);
        inputPane.setHalignment(box, HPos.CENTER);
        inputPane.setHalignment(numOfGuestBox, HPos.CENTER);
        inputPane.setHalignment(numDays, HPos.CENTER);
        inputPane.setHalignment(numDaysSpace, HPos.CENTER);
        inputPane.setHalignment(roomNumSpace, HPos.CENTER);
        inputPane.setHalignment(availableRooms, HPos.CENTER);
        //inputPane.setHalignment(clear, HPos.CENTER);
        //inputPane.setHalignment(book, HPos.CENTER);
        //inputPane.setHalignment(backToLogIn, HPos.CENTER);

        mainPane.add(inputPane1,   0,0,1,1);

        inputPane.setHgap(30);
        inputPane.setVgap(30);
        inputPane1.setHgap(30);
        inputPane1.setVgap(30);
        mainPane.setVgap(30);

        Scene scene = new Scene(mainPane, 930, 930);
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

    Button availableRooms;
    Button bookings;

    public void processEnterButtonForAdminLogIn(ActionEvent event)
    {
        availableRooms = new Button ("Available Rooms");
        availableRooms.setPrefWidth(300);
        availableRooms.setPrefHeight(50);
        availableRooms.setOnAction(this::processAvailableRoomButtonForAdmin);

        bookings = new Button ("Bookings");
        bookings.setPrefWidth(300);
        bookings.setPrefHeight(50);
        bookings.setOnAction(this::processBookingButton);

        back = new Button ("Back");
        back.setPrefWidth(300);
        back.setPrefHeight(50);
        back.setOnAction(this::processBackButtonForAdminPage);

        GridPane mainPane  = new GridPane();
        mainPane.setAlignment(Pos.CENTER);

        GridPane.setHalignment(availableRooms, HPos.CENTER);
        GridPane.setHalignment(bookings, HPos.CENTER);
        GridPane.setHalignment(back, HPos.CENTER);

        mainPane.add(availableRooms,    0,0,1,1);
        mainPane.add(bookings,     		0,1,1,1);
        mainPane.add(back,              0,8,1,1);
        mainPane.setVgap(40);

        Scene scene = new Scene(mainPane, 900, 900);
        window.setScene(scene);
        window.show();
    }

    public void processBackButtonForAdminPage(ActionEvent event)
    {
        Text adminUserName = new Text ("Admin name: ");
        adminUserName.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 50));
        adminNameSpace = new TextField();
        adminNameSpace.setPrefWidth(200);
        adminNameSpace.setPrefHeight(40);
        adminNameSpace.setPromptText("Your Username");

        Text adminPassword = new Text ("Password: ");
        adminPassword.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 50));
        adminPasswordSpace = new PasswordField();
        adminPasswordSpace.setPrefWidth(200);
        adminPasswordSpace.setPrefHeight(40);
        adminPasswordSpace.setPromptText("Your password");

        Button back = new Button ("Back");
        back.setPrefWidth(150);
        back.setPrefHeight(30);
        back.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 20));
        back.setOnAction(this::processReturnButton);

        Button enter = new Button ("Enter");
        enter.setPrefWidth(150);
        enter.setPrefHeight(30);
        enter.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 20));
        enter.setOnAction(e -> {
            //Retrieving data
            String adminName = adminNameSpace.getText();
            String pass = adminPasswordSpace.getText();
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/hsm", "root", "SumitrBanik00");

                Statement s = con.createStatement();
                String sql = "select A_Password from Admins where AdUsername = \""+ adminName +"\";";
                ResultSet r=s.executeQuery(sql);
                r.next();
                String realPass = r.getString("A_Password");

                System.out.println("Check Successful");

                if(realPass.equals(pass)){
                    processEnterButtonForAdminLogIn(e);
                }
                else {
                    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                    errorAlert.setHeaderText("Input not valid");
                    errorAlert.setContentText("Passwords Dont Match");
                    errorAlert.showAndWait();
                }
                s.close();
                con.close();
            } catch (SQLException er) {
                er.printStackTrace();
            } catch (ClassNotFoundException er) {
                er.printStackTrace();
            }
        });
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

    public void processAvailableRoomButtonForAdmin(ActionEvent event)
    {
        TableView<Room> table1 = new TableView<Room>();
        final ObservableList<Room> data1 =
                FXCollections.observableArrayList(
                        new Room(1,"Presidential Suite","Yes"),
                        new Room(2,"Honeymoon Suite","Yes"),
                        new Room(3,"Junior Suite","Yes"),
                        new Room(4,"Standard Suite","Yes"),
                        new Room(5,"Penthouse Suite","Yes")
                );

        HBox hb = new HBox();

        final Label label = new Label("AVAILABLE ROOMS");
        label.setFont(new Font("Arial", 20));

        table1.setEditable(true);

        TableColumn roomNumberCol = new TableColumn("Room Number");
        roomNumberCol.setMinWidth(200);
        roomNumberCol.setCellValueFactory(
                new PropertyValueFactory<Room, Integer>("roomNumber"));

        TableColumn roomTypeCol = new TableColumn("Room Type");
        roomTypeCol.setMinWidth(200);
        roomTypeCol.setCellValueFactory(
                new PropertyValueFactory<Room, String>("roomType"));

        TableColumn availabilityCol = new TableColumn("Availability");
        availabilityCol.setMinWidth(200);
        availabilityCol.setCellValueFactory(
                new PropertyValueFactory<Room, String>("availability"));


        Button back = new Button ("Back");
        back.setPrefWidth(150);
        back.setPrefHeight(30);
        back.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 20));
        back.setOnAction(this::processBackButtonForAvailableRoomForAdmin);

        hb.getChildren().addAll(back);
        hb.setSpacing(3);

        table1.setItems(data1);
        table1.getColumns().addAll(roomNumberCol, roomTypeCol, availabilityCol);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table1, hb);

        Scene scene = new Scene(new Group());
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
        window.setScene(scene);
        window.show();

    }

    public void processBackButtonForAvailableRoomForAdmin(ActionEvent event)
    {
        availableRooms = new Button ("Available Rooms");
        availableRooms.setPrefWidth(300);
        availableRooms.setPrefHeight(50);
        availableRooms.setOnAction(this::processAvailableRoomButtonForAdmin);

        bookings = new Button ("Bookings");
        bookings.setPrefWidth(300);
        bookings.setPrefHeight(50);
        bookings.setOnAction(this::processBookingButton);

        back = new Button ("Back");
        back.setPrefWidth(300);
        back.setPrefHeight(50);
        back.setOnAction(this::processBackButtonForAdminPage);

        GridPane mainPane  = new GridPane();
        mainPane.setAlignment(Pos.CENTER);

        GridPane.setHalignment(availableRooms, HPos.CENTER);
        GridPane.setHalignment(bookings, HPos.CENTER);
        GridPane.setHalignment(back, HPos.CENTER);

        mainPane.add(availableRooms,    0,0,1,1);
        mainPane.add(bookings,     		0,1,1,1);
        mainPane.add(back,              0,8,1,1);
        mainPane.setVgap(40);

        Scene scene = new Scene(mainPane, 900, 900);
        window.setScene(scene);
        window.show();
    }

    public void processClearButton(ActionEvent event)
    {
        intro = new Text("Room Selection");
        intro.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 60));

        roomType = new Text("Room Type:");
        roomType.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 40));

        numOfGuests = new Text("Number of Guests:");
        numOfGuests.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 40));

        checkInDate = new Text("Check In Date:");
        checkInDate.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 40));

        roomNum = new Text("Room Number:");
        roomNum.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 40));
        roomNumSpace = new TextField();
        roomNumSpace.setPrefWidth(200);
        roomNumSpace.setPrefHeight(40);

        numDays = new Text("Number of days of stay:");
        numDays.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 40));
        numDaysSpace = new TextField();
        numDaysSpace.setPrefWidth(200);
        numDaysSpace.setPrefHeight(40);

        Button clear = new Button ("Clear");
        clear.setPrefWidth(150);
        clear.setPrefHeight(30);
        clear.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 20));
        clear.setOnAction(this::processClearButton);

        Button book = new Button ("Book");
        book.setPrefWidth(150);
        book.setPrefHeight(30);
        book.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 20));
        book.setOnAction(this::processBookButton);

        Button availableRooms = new Button ("Rooms");
        availableRooms.setPrefWidth(150);
        availableRooms.setPrefHeight(30);
        availableRooms.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 20));
        availableRooms.setOnAction(this::processAvailableRoomButtonforUser);

        Button backToLogIn = new Button ("Back");
        backToLogIn.setPrefWidth(150);
        backToLogIn.setPrefHeight(30);
        backToLogIn.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 20));
        backToLogIn.setOnAction(this::processBackToLogInButton);


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
        GridPane inputPane1 = new GridPane();
        GridPane mainPane  = new GridPane();

        inputPane.setAlignment(Pos.CENTER);
        inputPane1.setAlignment(Pos.CENTER);
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
        GridPane.setHalignment(availableRooms, HPos.CENTER);
        //GridPane.setHalignment(clear, HPos.CENTER);
        //GridPane.setHalignment(book, HPos.CENTER);
        //GridPane.setHalignment(backToLogIn, HPos.CENTER);

        inputPane.add(roomType,    	  0,0,1,1);
        inputPane.add(roomTypeBox,    1,0,1,1);

        inputPane.add(numOfGuests,    	0,1,1,1);
        inputPane.add(numOfGuestBox,    1,1,1,1);

        inputPane.add(checkInDate,    	0,2,1,1);
        inputPane.add(box,    			1,2,1,1);

        inputPane.add(numDays,    	  0,3,1,1);
        inputPane.add(numDaysSpace,   1,3,1,1);

        inputPane.add(roomNum,    	  0,4,1,1);
        inputPane.add(roomNumSpace,   1,4,1,1);
        inputPane.add(availableRooms,   2,4,1,1);

        inputPane.add(clear,  		0,5,1,1);
        inputPane.add(book,   		1,5,1,1);
        inputPane.add(backToLogIn,  2,5,1,1);

        inputPane1.add(intro,    	 0,0,1,1);
        inputPane1.add(inputPane,    0,1,1,1);


        inputPane.setHalignment(intro, HPos.CENTER);
        inputPane.setHalignment(roomType, HPos.CENTER);
        inputPane.setHalignment(numOfGuests, HPos.CENTER);
        inputPane.setHalignment(roomNum, HPos.CENTER);
        inputPane.setHalignment(roomTypeBox, HPos.CENTER);
        inputPane.setHalignment(checkInDate, HPos.CENTER);
        inputPane.setHalignment(box, HPos.CENTER);
        inputPane.setHalignment(numOfGuestBox, HPos.CENTER);
        inputPane.setHalignment(numDays, HPos.CENTER);
        inputPane.setHalignment(numDaysSpace, HPos.CENTER);
        inputPane.setHalignment(roomNumSpace, HPos.CENTER);
        inputPane.setHalignment(availableRooms, HPos.CENTER);
        //inputPane.setHalignment(clear, HPos.CENTER);
        //inputPane.setHalignment(book, HPos.CENTER);
        //inputPane.setHalignment(backToLogIn, HPos.CENTER);

        mainPane.add(inputPane1,   0,0,1,1);

        inputPane.setHgap(30);
        inputPane.setVgap(30);
        inputPane1.setHgap(30);
        inputPane1.setVgap(30);
        mainPane.setVgap(30);

        Scene scene = new Scene(mainPane, 930, 930);
        window.setScene(scene);
        window.show();

    }

    private Text line;
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
        String bookingID = userIdSpace.getText() + roomNumSpace.getText();

//        try{
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            con = DriverManager.getConnection("jdbc:mysql://localhost/hsm", "root", "SumitrBanik00");
//
//            Statement s = con.createStatement();
//            String sql = "insert into Reservation values ('" + bookingID + "', '" + checkInDate.getText() + "', '" + roomNumSpace.getText() + "');";
//            System.out.println(sql);
//            s.executeUpdate(sql);
//
//            System.out.println("Entry Successful");
//            s.close();
//            con.close();
//        } catch (SQLException er) {
//            er.printStackTrace();
//        } catch (ClassNotFoundException er) {
//            er.printStackTrace();
//        }

        line = new Text("BOOKING CONFIRMED");
        line.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 60));

        line1 = new Text("\nWelcome to Hotel Panthera");
        line1.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 40));

        if (op.equals("Standard Suite"))
        {
            line2 = new Text ("Thank you for booking a Standard Suite with us");
            line2.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 40));
        }

        if (op.equals("Junior Suite"))
        {
            line2 = new Text ("Thank you for booking a Junior Suite with us");
            line2.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 40));
        }

        if (op.equals("Presidential Suite"))
        {
            line2 = new Text ("Thank you for booking a Presidential Suite with us");
            line2.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 40));
        }

        if (op.equals("Penthouse Suite"))
        {
            line2 = new Text ("Thank you for booking a Penthouse Suite with us");
            line2.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 40));
        }

        if (op.equals("Honeymoon Suite"))
        {
            line2 = new Text ("Thank you for booking a Honeymoon Suite with us");
            line2.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 40));
        }

        line3 = new Text("Price for your stay is $" + totalPrice);
        line3.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 40));

        Button backToLogIn = new Button ("Back to LogIn Page");
        backToLogIn.setPrefWidth(200);
        backToLogIn.setPrefHeight(30);
        backToLogIn.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 20));
        backToLogIn.setOnAction(this::processBackToLogInButton);

        GridPane inputPane = new GridPane();
        GridPane inputPane1 = new GridPane();
        GridPane mainPane  = new GridPane();

        inputPane.setAlignment(Pos.CENTER);
        inputPane1.setAlignment(Pos.CENTER);
        mainPane.setAlignment(Pos.CENTER);

        inputPane.add(line1,     	0,0,1,1);
        inputPane.add(line2,     	0,1,1,1);
        inputPane.add(line3,     	0,2,1,1);
        inputPane.add(backToLogIn,  0,3,1,1);

        inputPane1.add(line,    	 0,0,1,1);
        inputPane1.add(inputPane,    0,1,1,1);

        mainPane.add(inputPane1,   0,0,1,1);

        inputPane.setHgap(30);
        inputPane.setVgap(30);
        inputPane1.setHgap(30);
        inputPane1.setVgap(70);
        mainPane.setVgap(30);

        Scene scene = new Scene(mainPane, 900, 900);
        window.setScene(scene);
        window.show();
    }

    public void processBackToLogInButton(ActionEvent event)
    {
        Text userName = new Text ("Username: ");
        userName.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 50));
        nameSpace = new TextField();
        nameSpace.setPrefWidth(200);
        nameSpace.setPrefHeight(40);
        nameSpace.setPromptText("Your Username");

        Text password = new Text ("Password: ");
        password.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 50));
        passwordSpace = new PasswordField();
        passwordSpace.setPrefWidth(200);
        passwordSpace.setPrefHeight(40);
        passwordSpace.setPromptText("Your Password");

        Button back = new Button ("Return");
        back.setPrefWidth(150);
        back.setPrefHeight(30);
        back.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 20));
        back.setOnAction(this::processReturnButton);

        Button enter = new Button ("Enter");
        enter.setPrefWidth(150);
        enter.setPrefHeight(30);
        enter.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 20));

        enter.setOnAction(e -> {
            //Retrieving data
            String userN = nameSpace.getText();
            String pass = passwordSpace.getText();
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/hsm", "root", "SumitrBanik00");

                Statement s = con.createStatement();
                String sql = "select U_Password from Users where Username = \""+ userN +"\";";
                ResultSet r=s.executeQuery(sql);
                r.next();
                String realPass = r.getString("U_Password");

                System.out.println("Check Successful");

                if(realPass.equals(pass)){
                    processEnterButtonForLogIn(e);
                }
                else {
                    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                    errorAlert.setHeaderText("Input not valid");
                    errorAlert.setContentText("Passwords Dont Match");
                    errorAlert.showAndWait();
                }
                s.close();
                con.close();
            } catch (SQLException er) {
                er.printStackTrace();
            } catch (ClassNotFoundException er) {
                er.printStackTrace();
            }
        });

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

    public void processAvailableRoomButtonforUser(ActionEvent event)
    {
        TableView<Room> table1 = new TableView<Room>();
        final ObservableList<Room> data1 =
                FXCollections.observableArrayList(
                        new Room(1,"Presidential Suite","Yes"),
                        new Room(2,"Honeymoon Suite","Yes"),
                        new Room(3,"Junior Suite","Yes"),
                        new Room(4,"Standard Suite","Yes"),
                        new Room(5,"Penthouse Suite","Yes")
                );

        HBox hb = new HBox();

        final Label label = new Label("AVAILABLE ROOMS");
        label.setFont(new Font("Arial", 20));

        table1.setEditable(true);

        TableColumn roomNumberCol = new TableColumn("Room Number");
        roomNumberCol.setMinWidth(200);
        roomNumberCol.setCellValueFactory(
                new PropertyValueFactory<Room, Integer>("roomNumber"));

        TableColumn roomTypeCol = new TableColumn("Room Type");
        roomTypeCol.setMinWidth(200);
        roomTypeCol.setCellValueFactory(
                new PropertyValueFactory<Room, String>("roomType"));

        TableColumn availabilityCol = new TableColumn("Availability");
        availabilityCol.setMinWidth(200);
        availabilityCol.setCellValueFactory(
                new PropertyValueFactory<Room, String>("availability"));


        Button back = new Button ("Back");
        back.setPrefWidth(150);
        back.setPrefHeight(30);
        back.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 20));
        back.setOnAction(this::processBackButtonForAvailableRoomForUser);

        hb.getChildren().addAll(back);
        hb.setSpacing(3);

        table1.setItems(data1);
        table1.getColumns().addAll(roomNumberCol, roomTypeCol, availabilityCol);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table1, hb);

        Scene scene = new Scene(new Group());
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
        window.setScene(scene);
        window.show();


    }

    public void processBackButtonForAvailableRoomForUser(ActionEvent event)
    {
        intro = new Text("Room Selection");
        intro.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 60));

        roomType = new Text("Room Type:");
        roomType.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 40));

        numOfGuests = new Text("Number of Guests:");
        numOfGuests.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 40));

        checkInDate = new Text("Check In Date:");
        checkInDate.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 40));

        roomNum = new Text("Room Number:");
        roomNum.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 40));
        roomNumSpace = new TextField();
        roomNumSpace.setPrefWidth(200);
        roomNumSpace.setPrefHeight(40);

        numDays = new Text("Number of days of stay:");
        numDays.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 40));
        numDaysSpace = new TextField();
        numDaysSpace.setPrefWidth(200);
        numDaysSpace.setPrefHeight(40);

        Button clear = new Button ("Clear");
        clear.setPrefWidth(150);
        clear.setPrefHeight(30);
        clear.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 20));
        clear.setOnAction(this::processClearButton);

        Button book = new Button ("Book");
        book.setPrefWidth(150);
        book.setPrefHeight(30);
        book.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 20));
        book.setOnAction(this::processBookButton);

        Button availableRooms = new Button ("Rooms");
        availableRooms.setPrefWidth(150);
        availableRooms.setPrefHeight(30);
        availableRooms.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 20));
        availableRooms.setOnAction(this::processAvailableRoomButtonforUser);

        Button backToLogIn = new Button ("Back");
        backToLogIn.setPrefWidth(150);
        backToLogIn.setPrefHeight(30);
        backToLogIn.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 20));
        backToLogIn.setOnAction(this::processBackToLogInButton);


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
        GridPane inputPane1 = new GridPane();
        GridPane mainPane  = new GridPane();

        inputPane.setAlignment(Pos.CENTER);
        inputPane1.setAlignment(Pos.CENTER);
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
        GridPane.setHalignment(availableRooms, HPos.CENTER);
        //GridPane.setHalignment(clear, HPos.CENTER);
        //GridPane.setHalignment(book, HPos.CENTER);
        //GridPane.setHalignment(backToLogIn, HPos.CENTER);

        inputPane.add(roomType,    	  0,0,1,1);
        inputPane.add(roomTypeBox,    1,0,1,1);

        inputPane.add(numOfGuests,    	0,1,1,1);
        inputPane.add(numOfGuestBox,    1,1,1,1);

        inputPane.add(checkInDate,    	0,2,1,1);
        inputPane.add(box,    			1,2,1,1);

        inputPane.add(numDays,    	  0,3,1,1);
        inputPane.add(numDaysSpace,   1,3,1,1);

        inputPane.add(roomNum,    	  0,4,1,1);
        inputPane.add(roomNumSpace,   1,4,1,1);
        inputPane.add(availableRooms,   2,4,1,1);

        inputPane.add(clear,  		0,5,1,1);
        inputPane.add(book,   		1,5,1,1);
        inputPane.add(backToLogIn,  2,5,1,1);

        inputPane1.add(intro,    	 0,0,1,1);
        inputPane1.add(inputPane,    0,1,1,1);


        inputPane.setHalignment(intro, HPos.CENTER);
        inputPane.setHalignment(roomType, HPos.CENTER);
        inputPane.setHalignment(numOfGuests, HPos.CENTER);
        inputPane.setHalignment(roomNum, HPos.CENTER);
        inputPane.setHalignment(roomTypeBox, HPos.CENTER);
        inputPane.setHalignment(checkInDate, HPos.CENTER);
        inputPane.setHalignment(box, HPos.CENTER);
        inputPane.setHalignment(numOfGuestBox, HPos.CENTER);
        inputPane.setHalignment(numDays, HPos.CENTER);
        inputPane.setHalignment(numDaysSpace, HPos.CENTER);
        inputPane.setHalignment(roomNumSpace, HPos.CENTER);
        inputPane.setHalignment(availableRooms, HPos.CENTER);
        //inputPane.setHalignment(clear, HPos.CENTER);
        //inputPane.setHalignment(book, HPos.CENTER);
        //inputPane.setHalignment(backToLogIn, HPos.CENTER);

        mainPane.add(inputPane1,   0,0,1,1);

        inputPane.setHgap(30);
        inputPane.setVgap(30);
        inputPane1.setHgap(30);
        inputPane1.setVgap(30);
        mainPane.setVgap(30);

        Scene scene = new Scene(mainPane, 930, 930);
        window.setScene(scene);
        window.show();
    }

    public static class Room
    {
        private final SimpleStringProperty availability;
        private final SimpleStringProperty roomType;
        private final SimpleIntegerProperty roomNumber;

        public Room(int roomNumberIn, String roomTypeIn, String availabilityIn)
        {
            this.availability = new SimpleStringProperty(availabilityIn);
            this.roomType = new SimpleStringProperty(roomTypeIn);
            this.roomNumber = new SimpleIntegerProperty(roomNumberIn);
        }

        public String getAvailability()
        {	return availability.get();
        }

        public String getRoomType()
        {	return roomType.get();
        }

        public int getRoomNumber()
        {	return roomNumber.get();
        }

    }


    public void processBookingButton(ActionEvent event)
    {
        TableView<Reservation> table = new TableView<Reservation>();
        final ObservableList<Reservation> data =
                FXCollections.observableArrayList(
                        new Reservation(1,1,1,"1 May, 2021","3 May, 2021", 2000),
                        new Reservation(2,2,2,"2 May, 2021","4 May, 2021", 2100),
                        new Reservation(3,3,3,"3 May, 2021","5 May, 2021", 2200),
                        new Reservation(4,4,4,"4 May, 2021","6 May, 2021", 2300),
                        new Reservation(5,5,5,"5 May, 2021","7 May, 2021", 2400)
                );

        HBox hb = new HBox();

        final Label label = new Label("BOOKINGS");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);

        TableColumn userIdCol = new TableColumn("User Id");
        userIdCol.setMinWidth(100);
        userIdCol.setCellValueFactory(
                new PropertyValueFactory<Reservation, Integer>("userId"));

        TableColumn roomIdCol = new TableColumn("Room Id");
        roomIdCol.setMinWidth(100);
        roomIdCol.setCellValueFactory(
                new PropertyValueFactory<Reservation, Integer>("roomId"));

        TableColumn roomNumberCol = new TableColumn("Room Number");
        roomNumberCol.setMinWidth(200);
        roomNumberCol.setCellValueFactory(
                new PropertyValueFactory<Reservation, Integer>("roomNumber"));

        TableColumn dateInCol = new TableColumn("Check In Date");
        dateInCol.setMinWidth(200);
        dateInCol.setCellValueFactory(
                new PropertyValueFactory<Reservation, String>("dateIn"));

        TableColumn dateOutCol = new TableColumn("Check Out Date");
        dateOutCol.setMinWidth(200);
        dateOutCol.setCellValueFactory(
                new PropertyValueFactory<Reservation, String>("dateOut"));

        TableColumn invoiceIdCol = new TableColumn("Invoice Id");
        invoiceIdCol.setMinWidth(200);
        invoiceIdCol.setCellValueFactory(
                new PropertyValueFactory<Reservation, Integer>("invoiceId"));


        table.setItems(data);
        table.getColumns().addAll(userIdCol, roomIdCol, roomNumberCol,
                dateInCol, dateOutCol, invoiceIdCol);

        Button back = new Button ("Back");
        back.setPrefWidth(150);
        back.setPrefHeight(30);
        back.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, FontPosture.REGULAR, 20));
        back.setOnAction(this::processBackButtonForBooking);

        hb.getChildren().addAll(back);
        hb.setSpacing(3);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, hb);

        Scene scene = new Scene(new Group());
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
        window.setScene(scene);
        window.show();


    }

    public void processBackButtonForBooking(ActionEvent event)
    {
        availableRooms = new Button ("Available Rooms");
        availableRooms.setPrefWidth(300);
        availableRooms.setPrefHeight(50);
        availableRooms.setOnAction(this::processAvailableRoomButtonForAdmin);

        bookings = new Button ("Bookings");
        bookings.setPrefWidth(300);
        bookings.setPrefHeight(50);
        bookings.setOnAction(this::processBookingButton);

        back = new Button ("Back");
        back.setPrefWidth(300);
        back.setPrefHeight(50);
        back.setOnAction(this::processBackButtonForAdminPage);

        GridPane mainPane  = new GridPane();
        mainPane.setAlignment(Pos.CENTER);

        GridPane.setHalignment(availableRooms, HPos.CENTER);
        GridPane.setHalignment(bookings, HPos.CENTER);
        GridPane.setHalignment(back, HPos.CENTER);

        mainPane.add(availableRooms,    0,0,1,1);
        mainPane.add(bookings,     		0,1,1,1);
        mainPane.add(back,              0,8,1,1);
        mainPane.setVgap(40);

        Scene scene = new Scene(mainPane, 900, 900);
        window.setScene(scene);
        window.show();
    }

    public static class Reservation
    {
        private final SimpleIntegerProperty userId;
        private final SimpleIntegerProperty roomId;
        private final SimpleIntegerProperty roomNumber;
        private final SimpleStringProperty dateIn;
        private final SimpleStringProperty dateOut;
        private final SimpleIntegerProperty invoiceId;

        public Reservation(int useridIn, int roomIdIn, int roomNumberIn,
                           String dateInIn, String dateOutIn, int invoiceIdIn)
        {
            this.userId = new SimpleIntegerProperty(useridIn);
            this.roomId = new SimpleIntegerProperty(roomIdIn);
            this.roomNumber = new SimpleIntegerProperty(roomNumberIn);
            this.dateIn = new SimpleStringProperty(dateInIn);
            this.dateOut = new SimpleStringProperty(dateOutIn);
            this.invoiceId = new SimpleIntegerProperty(invoiceIdIn);
        }

        public int getUserId()
        {	return userId.get();
        }

        public int getRoomId()
        {	return roomId.get();
        }

        public int getRoomNumber()
        {	return roomNumber.get();
        }

        public String getDateIn()
        {	return dateIn.get();
        }

        public String getDateOut()
        {	return dateOut.get();
        }

        public int getInvoiceId()
        {	return invoiceId.get();
        }

    }

}