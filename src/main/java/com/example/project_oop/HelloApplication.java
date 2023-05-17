package com.example.project_oop;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;


public class HelloApplication extends Application {

        private TextField emailTextField;
        private PasswordField passwordField;
        private ComboBox<String> userTypeComboBox;

        protected Stage primaryStage;
        public static Scene loginScene;
        private Scene librarianScene;
        private Scene readerScene;
        private Button loginButton;
        protected static Library library;
        private Stage stage_new = new Stage();


    @Override
        public void start(Stage primaryStage) throws IOException {
            this.primaryStage = primaryStage;
            primaryStage.setTitle("Login");
            primaryStage.setResizable(false);
            library = new Library();

            FXMLLoader fxmlLoader_1 = new FXMLLoader(HelloApplication.class.getResource("librarian.fxml"));
            librarianScene =  new Scene(fxmlLoader_1.load());

            // reader scene
            FXMLLoader fxmlLoader_2 = new FXMLLoader(HelloApplication.class.getResource("reader.fxml"));
            readerScene = new Scene(fxmlLoader_2.load());
            GridPane gridPane = new GridPane();
            gridPane.setPadding(new Insets(10, 10, 10, 10));
            gridPane.setVgap(10);
            gridPane.setHgap(10);

            Label emailLabel = new Label("Email:");
            GridPane.setConstraints(emailLabel, 0, 0);

            emailTextField = new TextField();
            emailTextField.setPromptText("Enter your email");
            GridPane.setConstraints(emailTextField, 1, 0);

            Label passwordLabel = new Label("Password:");
            GridPane.setConstraints(passwordLabel, 0, 1);

            passwordField = new PasswordField();
            passwordField.setPromptText("Enter your password");
            GridPane.setConstraints(passwordField, 1, 1);

            Label userTypeLabel = new Label("User type:");
            GridPane.setConstraints(userTypeLabel, 0, 2);

            userTypeComboBox = new ComboBox<>();
            userTypeComboBox.getItems().addAll("Librarian", "Reader");
            userTypeComboBox.setValue("Librarian");
            GridPane.setConstraints(userTypeComboBox, 1, 2);

            loginButton = new Button("Login");
            GridPane.setConstraints(loginButton, 1, 3);

            loginButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    String email = emailTextField.getText(); // Get the email from the email field in your GUI
                    String password = passwordField.getText(); // Get the password from the password field in your GUI
                    boolean loginSuccessful = library.checkLogin(email, password); // Call the login check method
                    if (loginSuccessful) {
                        //
                        System.out.println("Login successful");
                    } else {
                        signup(email, password, userTypeComboBox.getSelectionModel().getSelectedItem());
                    }
                }
            });

            gridPane.getChildren().addAll(emailLabel, emailTextField, passwordLabel, passwordField,
                    userTypeLabel, userTypeComboBox, loginButton);

            Scene scene = new Scene(gridPane, 300, 200);
            primaryStage.setScene(scene);
            primaryStage.show();
    }


    private void signup(String email, String password, String userType) {
        // Get additional information from the user
        Label firstNameLabel = new Label("First Name:");
        TextField firstNameField = new TextField();
        HBox firstNameBox = new HBox(10, firstNameLabel, firstNameField);

        Label lastNameLabel = new Label("Last Name:");
        TextField lastNameField = new TextField();
        HBox lastNameBox = new HBox(10, lastNameLabel, lastNameField);

        Label addressLabel = new Label("Address:");
        TextField addressField = new TextField();
        HBox addressBox = new HBox(10, addressLabel, addressField);

        Label cellPhoneLabel = new Label("Cell Phone:");
        TextField cellPhoneField = new TextField();
        HBox cellPhoneBox = new HBox(10, cellPhoneLabel, cellPhoneField);

        VBox inputBox = new VBox(20, firstNameBox, lastNameBox, addressBox, cellPhoneBox);
        Button submitButton = new Button("Submit");
        VBox container = new VBox(20, inputBox, submitButton);
        container.setAlignment(Pos.CENTER);
        container.setPadding(new Insets(20));

        // Create a new scene with the input form
        Scene scene = new Scene(container, 400, 300);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Sign up");
        stage.setResizable(false);

        // Handle form submission
        submitButton.setOnAction(event -> {
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String address = addressField.getText();
            String cellPhone = cellPhoneField.getText();
            User user;

            //Authenticate user and navigate to appropriate page based on user type and input values
            if (userType.equals("Librarian")) {
                set_scene(true , stage);
                user = new Librarian(password, firstName, lastName, address, cellPhone, email);
                library.addUser(user);

            } else if (userType.equals("Reader")) {
                set_scene(false , stage);
                user = new Reader(password, firstName, lastName, address, cellPhone, email);
                library.addUser(user);
            }
            LibraryController lbc = new LibraryController();
            try{
                lbc.setUser(user);
            }catch ( NullPointerException e )
            {
                e.printStackTrace();
                System.out.println("user not found ");
            }
        });

        primaryStage.hide();
        stage.show();
    }

    private void set_scene(boolean type , Stage stage){
        stage_new.setResizable(false);
        stage_new.setTitle("Dashboard ");
        if (type)
        {
            stage_new.setScene(librarianScene);
        }
        else
        {
            stage_new.setScene(readerScene);
        }
        stage.hide();
        stage_new.show();
    }






    public static void main(String[] args) throws Exception{
       try {
           launch(args);
       }catch (Exception e)
       {
           e.printStackTrace();
       }

    }
}