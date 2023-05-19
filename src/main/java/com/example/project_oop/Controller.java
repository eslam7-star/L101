package com.example.project_oop;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static com.example.project_oop.HelloApplication.loginScene;
import static com.example.project_oop.HelloApplication.user;


public class Controller {
    private final Stage stage_tools = new Stage();

    @FXML
    private void handleAddBookUSER(ActionEvent event) throws Exception {
        FXMLLoader fxmlLoader_3 = new FXMLLoader(HelloApplication.class.getResource("add_remove_book_user.fxml"));
        Parent root = fxmlLoader_3.load();
        stage_tools.setScene( new Scene(root));
        stage_tools.setTitle("Handle Books and Users");
        stage_tools.setResizable(false);
        stage_tools.show();
    }

    @FXML
    private void handleSearchBooks(ActionEvent event) throws Exception {
        FXMLLoader fxmlLoader_5 = new FXMLLoader(HelloApplication.class.getResource("search_book_users.fxml"));
        Parent root = fxmlLoader_5.load();
        stage_tools.setScene(new Scene(root));
        stage_tools.setTitle("Search for Books or Users");
        stage_tools.setResizable(false);
        stage_tools.show();
    }

    @FXML
    private void signout(ActionEvent event) throws Exception {
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(loginScene);
        primaryStage.setResizable(false);
        primaryStage.show();
        stage_tools.close();
    }


    @FXML
    private void rentpage_Librarian(ActionEvent event) throws Exception {
        FXMLLoader fxmlLoader_4 = new FXMLLoader(HelloApplication.class.getResource("rent page_Librarian.fxml"));
        Parent root = fxmlLoader_4.load();
        stage_tools.setScene(new Scene(root));
        stage_tools.setTitle("Rent Page");
        stage_tools.setResizable(false);
        stage_tools.show();
    }



    @FXML
    private void rentpage_Reader(ActionEvent event) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("rent_page_reader.fxml"));
        Parent root = fxmlLoader.load();
        stage_tools.setScene(new Scene(root));
        stage_tools.setTitle("Rent Page");
        stage_tools.setResizable(false);
        stage_tools.show();
    }







}