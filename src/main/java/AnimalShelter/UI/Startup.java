package AnimalShelter.UI;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Startup extends Application{
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello World!");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(15);
        grid.setMaxWidth(600);
        grid.setPadding(new Insets(0, 10, 0, 10));

        VBox spieces = GetPiecesVBox();
        grid.add(spieces,1,1);


        VBox name = GetNameVBox();
        grid.add(name,1,2);

        VBox gender = GetGenderVBox();
        grid.add(gender,1,3);

        VBox badHabits = GetBadHabitsVBox();
        grid.add(badHabits,1,4);


        grid.add(new Button("Add Animal"),1,5);


        grid.add(GetSelectVBox(), 2,1,3,2);
        primaryStage.setScene(new Scene(grid, 600, 300));
        primaryStage.show();
    }

    private VBox GetPiecesVBox(){
        VBox box = new VBox(3);
        box.setFillWidth(true);
        box.getChildren().add(new Text("Species"));
        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "Option 1",
                        "Option 2",
                        "Option 3"
                );
        ComboBox combo = new ComboBox(options);

        box.getChildren().add(combo);

        return box;
    }

    private VBox GetNameVBox(){
        VBox box = new VBox(3);
        box.getChildren().add(new Text("Name"));
        box.getChildren().add(new TextField());

        return box;
    }

    private VBox GetGenderVBox() {
        VBox box = new VBox(3);
        box.getChildren().add(new Text("Gender"));
        final ToggleGroup group = new ToggleGroup();

        RadioButton rb1 = new RadioButton("Male");
        rb1.setToggleGroup(group);
        rb1.setSelected(true);

        RadioButton rb2 = new RadioButton("Female");
        rb2.setToggleGroup(group);

        HBox radios = new HBox(3);
        radios.getChildren().addAll(rb1, rb2);


        box.getChildren().add(radios);

        return box;
    }

    private VBox GetBadHabitsVBox(){
        VBox box = new VBox(3);
        box.getChildren().add(new Text("Bad Habits"));
        box.getChildren().add(new TextField());

        return box;
    }

    private VBox GetSelectVBox(){
        VBox box = new VBox(3);
        ListView listView = new ListView();

        listView.getItems().add("Item 1");
        listView.getItems().add("Item 2");
        listView.getItems().add("Item 3");
        box.getChildren().add(new Text("Animals"));
        box.getChildren().add(listView);
        return box;
    }

}
