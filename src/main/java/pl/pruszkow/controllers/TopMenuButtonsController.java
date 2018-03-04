package pl.pruszkow.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class TopMenuButtonsController {

    public static final String STOCK_FXML = "/fxml/Stock.fxml";
    public static final String ISSUANCE_FXML = "/fxml/Issuance.fxml";
    public static final String RECEPTION_FXML = "/fxml/Reception.fxml";
    public static final String LOCATION_FXML = "/fxml/Location.fxml";
    private MainController mainController;

    @FXML
    public void TopButtonStock() {
        mainController.setCenter(STOCK_FXML);
    }
    @FXML
    public void TopButtonIssuance() {
        mainController.setCenter(ISSUANCE_FXML);
    }
    @FXML
    public void TopButtonRecetion() {
        mainController.setCenter(RECEPTION_FXML);
    }
    @FXML
    public void TopButtonLocation() {
        mainController.setCenter(LOCATION_FXML);
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
