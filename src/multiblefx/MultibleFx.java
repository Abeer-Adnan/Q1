/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiblefx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author rant
 */
public class MultibleFx extends Application {

    ListView list1, list2;
    Button b;
    Alert a;

    @Override
    public void start(Stage primaryStage) {
        list1 = new ListView();
        list1.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        list2 = new ListView();
        list1.getItems().addAll("Black", "Blue", "Cyan", "Dark Gray", "Gray", "Green");

        b = new Button("Copy>>");
        b.setOnAction(new Copyb());
        HBox hb = new HBox(10, list1, b, list2);
        hb.setAlignment(Pos.CENTER);
        hb.setPadding(new Insets(15));
        a = new Alert(Alert.AlertType.NONE);
        Scene s = new Scene(hb, 650, 165);
        primaryStage.setTitle("Multiple Selection Lists ");
        primaryStage.setScene(s);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private class Copyb implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {

            if (list1.getSelectionModel().getSelectedItems().size() == 0) {
                a.setAlertType(Alert.AlertType.INFORMATION);
                a.setHeaderText("Please select item then click the button");

                a.show();

            } else {
                list2.getItems().addAll(list1.getSelectionModel().getSelectedItems());
            }

        }
    }
}
