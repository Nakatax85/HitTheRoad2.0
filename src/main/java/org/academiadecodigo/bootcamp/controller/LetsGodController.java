package org.academiadecodigo.bootcamp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.academiadecodigo.bootcamp.model.TravelDistance;
import org.academiadecodigo.bootcamp.service.ServiceRegistry;
import org.academiadecodigo.bootcamp.service.user.UserService;

import static org.academiadecodigo.bootcamp.utils.Constants.OVERALLVIEW;
import static org.academiadecodigo.bootcamp.utils.Constants.PREFERENCE;

public class LetsGodController implements Controller{

    private UserService userService;

    @FXML
    private Label routeNotFoundWarning;

    @FXML
    private TextField originField;

    @FXML
    private TextField destinyField;

    @FXML
    private Button signupButton;

    @FXML
    private Button letsGoBtn;

    @FXML
    void lestGoClick(ActionEvent event) {

        String origin = "";
        String destiny = "";

        if(originField.getText().split(" ").length > 1) {
            origin += originField.getText().replace(" ", "");
        } else {
            origin = originField.getText();
        }
        if(destinyField.getText().split(" ").length > 1) {
            destiny += destinyField.getText().replace(" ", "");
        } else {
            destiny = destinyField.getText();
        }

        origin = origin.toLowerCase();
        destiny = destiny.toLowerCase();

        TravelDistance.distance(origin, destiny);

        if(TravelDistance.getFinalOrigin() == null || TravelDistance.getFinalDestiny() == null) {
            routeNotFoundWarning.setVisible(true);
            return;
        }

        Navigation.getInstance().loadScreen(OVERALLVIEW);
    }

    @FXML
    void onClickSignup(ActionEvent event) {
        Navigation.getInstance().loadScreen(PREFERENCE);

    }

    @FXML
    void onKeyPressed(ActionEvent event) {

    }

    @Override
    public void setUserService(UserService userService) {

    }

    public void initialize() {
        userService = (UserService) ServiceRegistry.getInstance().getService(UserService.class.getSimpleName());
        routeNotFoundWarning.setVisible(false);
    }
}
