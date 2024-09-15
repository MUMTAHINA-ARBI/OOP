package com.example.bdrcs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

public class director {

    @javafx.fxml.FXML
    private BorderPane directorBorderPane;

    @javafx.fxml.FXML
    public void loadSearchRescueOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void loadFirstAidOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void loadPreviousProjectOnAction(ActionEvent actionEvent) {
        loadFxmlParentToBorderPaneCenter("PreviousProjectChart.fxml");
    }

    @javafx.fxml.FXML
    public void loadViewApplicantsOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void loadDisasterManagementOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void loadOnGoingProjectOnAction(ActionEvent actionEvent) {
        loadFxmlParentToBorderPaneCenter("onGoingProjectChart.fxml");
    }

    private void loadFxmlParentToBorderPaneCenter(String fxmlName) {

        try {

            FXMLLoader nextFxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxmlName));
            directorBorderPane.setCenter(nextFxmlLoader.load());
        }
        catch(Exception e){
            //
        }
    }

    @javafx.fxml.FXML
    public void loadRequestTrainingOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void loadTrainingOftrainerONAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void LoadArrangeMeetingOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void loadFireManagementOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void loadCreatCircularOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void loadMeetingScheduleOnACtion(ActionEvent actionEvent) {
    }
}
