package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SetupPollTrackerController extends PollTrackerController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField inputSeat;

    @FXML
    private TextField inputPoll;

    @FXML
    private Button myClear;

    @FXML
    private TextField inputParty;

    @FXML
    private Button mySubmit;

    @FXML
    void clearThing(ActionEvent event) {
    	refresh();
    }

    @FXML
    void submitThing(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert inputSeat != null : "fx:id=\"inputSeat\" was not injected: check your FXML file 'SetupPollTrackerView.fxml'.";
        assert inputPoll != null : "fx:id=\"inputPoll\" was not injected: check your FXML file 'SetupPollTrackerView.fxml'.";
        assert myClear != null : "fx:id=\"myClear\" was not injected: check your FXML file 'SetupPollTrackerView.fxml'.";
        assert inputParty != null : "fx:id=\"inputParty\" was not injected: check your FXML file 'SetupPollTrackerView.fxml'.";
        assert mySubmit != null : "fx:id=\"mySubmit\" was not injected: check your FXML file 'SetupPollTrackerView.fxml'.";

    }

	@Override
	public void refresh() {
		inputSeat.clear();
		inputPoll.clear();
		inputParty.clear();
	}
}
