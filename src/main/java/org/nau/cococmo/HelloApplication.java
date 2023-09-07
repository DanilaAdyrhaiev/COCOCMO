package org.nau.cococmo;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        StringBuilder projectType = new StringBuilder();

        Pane root = new Pane();
        Label type = new Label("Тип проекта: ");
        type.setLayoutX(10);
        type.setLayoutY(20);
        type.setFont(new Font(14));

        Label numbOfRows = new Label("Кількість рядків: ");
        numbOfRows.setLayoutX(10);
        numbOfRows.setLayoutY(75);
        numbOfRows.setFont(new Font(14));

        Label pmInfo = new Label("Трудоємкість: ");
        pmInfo.setLayoutX(180);
        pmInfo.setLayoutY(20);
        pmInfo.setFont(new Font(14));

        Label tmInfo = new Label("Тривалість: ");
        tmInfo.setLayoutX(180);
        tmInfo.setLayoutY(70);
        tmInfo.setFont(new Font(14));

        Label ssInfo = new Label("Розробників: ");
        ssInfo.setLayoutX(180);
        ssInfo.setLayoutY(120);
        ssInfo.setFont(new Font(14));

        ObservableList<String> langs = FXCollections.observableArrayList("Розповсюджений", "Напівнезалежний", "Вбудований");
        ComboBox<String> langsComboBox = new ComboBox<String>(langs);
        langsComboBox.setOnAction(event -> projectType.append(langsComboBox.getValue()));
        langsComboBox.setLayoutX(10);
        langsComboBox.setLayoutY(45);

        TextField inputText = new TextField("0");
        inputText.setPrefColumnCount(11);
        inputText.setLayoutX(10);
        inputText.setLayoutY(100);

        Button btn = new Button("Розрахувати");
        btn.setOnAction(event -> pmInfo.setText("Трудоємкість: " + click(inputText.getText(), projectType.toString())[0]));
        btn.addEventHandler(ActionEvent.ACTION, event -> tmInfo.setText("Тривалість: " + click(inputText.getText(), projectType.toString())[1]));
        btn.addEventHandler(ActionEvent.ACTION, event -> ssInfo.setText("Розробників: " + click(inputText.getText(), projectType.toString())[2]));
        btn.setLayoutX(10);
        btn.setLayoutY(130);

        root.getChildren().add(type);
        root.getChildren().add(numbOfRows);
        root.getChildren().add(pmInfo);
        root.getChildren().add(tmInfo);
        root.getChildren().add(ssInfo);
        root.getChildren().add(langsComboBox);
        root.getChildren().add(inputText);
        root.getChildren().add(btn);




        Scene scene = new Scene(root, 350, 200);
        stage.setScene(scene);
        stage.setTitle("COCOCMO");
        stage.show();


    }

    private static double[] click(String lines, String type){
        int lns = Integer.parseInt(lines);
        int projType = 0;
        if(type.equals("Розповсюджений"))
            projType=0;
        if(type.equals("Напівнезалежний"))
            projType=1;
        if(type.equals("Вбудований"))
            projType=2;
        COCOCMO.getInstance().init(projType, lns);
        return COCOCMO.getInstance().calc();
    }



    public static void main(String[] args) {
        launch();
    }
}