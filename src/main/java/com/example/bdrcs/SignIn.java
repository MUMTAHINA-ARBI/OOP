package com.example.bdrcs;

import com.example.bdrcs.user.Director;
import com.example.bdrcs.user.Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SignIn {
    @javafx.fxml.FXML
    private TextField idTextField;
    @javafx.fxml.FXML
    private TextField passwordTextField;
    @javafx.fxml.FXML
    private RadioButton femaleRadioButton;
    @javafx.fxml.FXML
    private TextField emailTextField;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private RadioButton maleRadioButton;
    @javafx.fxml.FXML
    private DatePicker dobDatePicker;
    @javafx.fxml.FXML
    private ComboBox<String> usertypeComboBox;
    @javafx.fxml.FXML
    private RadioButton otherRadioutton;

    ToggleGroup tg;
    @javafx.fxml.FXML
    private AnchorPane signInAnchorPane;

    @javafx.fxml.FXML
    public void initialize() {
        usertypeComboBox.getItems().addAll("Director", "Life Member", "Volunteer", "Donor", "Sponsor", "Manager", "Trainer", "Event Organizer");
        tg = new ToggleGroup();
        maleRadioButton.setToggleGroup(tg);
        femaleRadioButton.setToggleGroup(tg);
        otherRadioutton.setToggleGroup(tg);
        maleRadioButton.setSelected(true);

    }

    @javafx.fxml.FXML
    public void creatAccountButtonOnAction(ActionEvent actionEvent) {
        String selectedGender = null;
        if (maleRadioButton.isSelected()) selectedGender = "Male";
        else if (femaleRadioButton.isSelected()) selectedGender = "Female";
        else if (otherRadioutton.isSelected()) selectedGender = "Other";

        int givenId = Integer.parseInt(idTextField.getText());
        String userType = usertypeComboBox.getValue();

        int idValidationCode = validateNewId(givenId, userType);

        if (idValidationCode == 0) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Validation failed! Given ID has invalid No of digits!");
            a.showAndWait();
        } else if (idValidationCode == -1) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Validation failed! Duplicate, given ID is already used!");
            a.showAndWait();
        } else {   // no duplicate found
            FileOutputStream fos = null;
            ObjectOutputStream oos = null;
            try {
                File f = new File(userType + ".bin");
                if (f.exists())
                    oos = new AppendableObjectOutputStream(new FileOutputStream(f, true));
                else
                    oos = new ObjectOutputStream(new FileOutputStream(f));

                if (userType.equals("Director")) {
                    Director newDirector = new Director(
                            Integer.parseInt(idTextField.getText()),
                            nameTextField.getText(),
                            selectedGender,
                            emailTextField.getText(),
                            dobDatePicker.getValue()

                            //...,...,...,
                    );
                    oos.writeObject(newDirector);
                } else if (userType.equals("Life Member")) {
                    Member newMember = new Member(
                            Integer.parseInt(idTextField.getText()),
                            nameTextField.getText(),
                            selectedGender,
                            emailTextField.getText(),
                            dobDatePicker.getValue()

                    );
                    System.out.println(newMember);
                    oos.writeObject(newMember);
                }
                //else if(userType.equals("Volunteer")){
                //Volunteer newAccountant = new Accountant(
                //...,...,...,
                //);
                //oos.writeObject(newAccountant);
                //}
                // add more else if blocks for remaining user types, too
                oos.close();
            } catch (Exception e) {
                //
            }
        }
    }

    private int validateNewId(int givenId, String selectedUserType) {
        if (selectedUserType.equals("Director")) {
            if (givenId < 1000000 || givenId >= 10000000) {
                return 0; // invalid id length
            }
        } else if (
                selectedUserType.equals("Life Member")
                        || selectedUserType.equals("Volunteer")
                        || selectedUserType.equals("Donor")
                        || selectedUserType.equals("Sponsor")
                        || selectedUserType.equals("Manager")
                        || selectedUserType.equals("Trainer")
                        // || check equality for all other remaining users
                        || selectedUserType.equals("Event Organizer")

        ) {
            if (givenId < 1000 || givenId >= 10000) {
                return 0; // invalid id length
            }
        }
        return User.isDuplicateId(givenId);
    }

    private void loadFxmlIntoAnchorPane(String fxmlName) {
        try {
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("director.fxml"));
            AnchorPane newContent = loader.load();
            signInAnchorPane.getChildren().setAll(newContent);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}