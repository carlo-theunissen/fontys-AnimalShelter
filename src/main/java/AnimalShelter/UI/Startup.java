package AnimalShelter.UI;

import AnimalShelter.Logic.ReservationSystem;
import AnimalShelter.Models.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Startup extends Application{

    private ComboBox spiecesBox;
    private TextField nameField;
    private TextField badhabitField;
    private RadioButton maleRadioButton;
    private RadioButton femaleRadioButton;
    private ListView addedAnimals;
    private ReservationSystem reservationSystem;

    public Startup(){
        reservationSystem = new ReservationSystem();
        addedAnimals = new ListView();
    }
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello World!");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(15);
        grid.setPadding(new Insets(0, 10, 0, 10));

        VBox spieces = getPiecesVBox();
        grid.add(spieces,1,1);


        VBox name = getNameVBox();
        grid.add(name,1,2);

        VBox gender = getGenderVBox();
        grid.add(gender,1,3);

        VBox badHabits = getBadHabitsVBox();
        grid.add(badHabits,1,4);


        grid.add(addAnimalButton(),1,5);


        grid.add(getSelectVBox(), 2,1,3,2);
        primaryStage.setScene(new Scene(grid, 600, 300));
        primaryStage.show();
    }

    private Button addAnimalButton(){
        Button button = new Button("Add Animal");
        button.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                AnimalReservationCouple couple = new AnimalReservationCouple(reservationSystem, createAnimal());
                addedAnimals.getItems().add(couple);
            }
        });
        return button;
    }
    private VBox getPiecesVBox(){
        VBox box = new VBox(3);
        box.setFillWidth(true);
        box.getChildren().add(new Text("Species"));
        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "Cat",
                        "Dog"
                );
        spiecesBox = new ComboBox(options);

        spiecesBox.getSelectionModel().selectFirst();

        spiecesBox.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                badhabitField.setDisable(spiecesBox.getValue().toString().equals("Dog"));
            }
        });

        box.getChildren().add(spiecesBox);

        return box;
    }

    private VBox getNameVBox(){
        VBox box = new VBox(3);
        nameField = new TextField();
        box.getChildren().add(new Text("Name"));
        box.getChildren().add(nameField);

        return box;
    }

    private VBox getGenderVBox() {
        VBox box = new VBox(3);
        box.getChildren().add(new Text("Gender"));
        final ToggleGroup group = new ToggleGroup();

        maleRadioButton = new RadioButton("Male");
        maleRadioButton.setToggleGroup(group);
        maleRadioButton.setSelected(true);

        femaleRadioButton = new RadioButton("Female");
        femaleRadioButton.setToggleGroup(group);

        HBox radios = new HBox(3);
        radios.getChildren().addAll(maleRadioButton, femaleRadioButton);


        box.getChildren().add(radios);

        return box;
    }

    private VBox getBadHabitsVBox(){
        VBox box = new VBox(3);
        badhabitField = new TextField();
        box.getChildren().add(new Text("Bad Habits"));
        box.getChildren().add(badhabitField);

        return box;
    }

    private VBox getSelectVBox(){
        VBox box = new VBox(3);
        addedAnimals.setMinWidth(350);
        box.getChildren().add(new Text("Animals"));
        box.getChildren().add(addedAnimals);
        return box;
    }

    private Animal createAnimal(){
        String spiece = spiecesBox.getValue().toString();
        if(spiece.equals("Cat")){
            Cat cat =  new Cat(nameField.getText(), femaleRadioButton.isSelected() ? Gender.Female : Gender.Male );
            cat.addHabit(new BadHabit(badhabitField.getText()));
            return cat;
        }
        return new Dog(nameField.getText(), femaleRadioButton.isSelected() ? Gender.Female : Gender.Male );
    }


}
