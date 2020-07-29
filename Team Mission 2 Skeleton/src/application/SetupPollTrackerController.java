package application;

import java.net.URL;
import java.util.ResourceBundle;
import model.Factory;
import model.PollList;

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
    private TextField pollsToTrack;

    @FXML
    private TextField partiesRunning;

    @FXML
    private Button myClear;

    @FXML
    private Button mySubmit;

    @FXML
    private TextField seatsAvailable;

    @FXML
    void clearThing(ActionEvent event) {
    	refresh();
    }

    @FXML
    void submitThing(ActionEvent event) {
    	Integer getPollsToTrack = Integer.valueOf(pollsToTrack.getText());
    	Integer getSeatsAvailable = Integer.valueOf(seatsAvailable.getText());
    	Integer getPartiesRunning = Integer.valueOf(partiesRunning.getText());
    	
    	
    }

    @FXML
    void initialize() {
        assert pollsToTrack != null : "fx:id=\"pollsToTrack\" was not injected: check your FXML file 'SetupPollTrackerView.fxml'.";
        assert partiesRunning != null : "fx:id=\"partiesRunning\" was not injected: check your FXML file 'SetupPollTrackerView.fxml'.";
        assert myClear != null : "fx:id=\"myClear\" was not injected: check your FXML file 'SetupPollTrackerView.fxml'.";
        assert mySubmit != null : "fx:id=\"mySubmit\" was not injected: check your FXML file 'SetupPollTrackerView.fxml'.";
        assert seatsAvailable != null : "fx:id=\"seatsAvailable\" was not injected: check your FXML file 'SetupPollTrackerView.fxml'.";

    }

	@Override
	public void refresh() {
		pollsToTrack.clear();
		partiesRunning.clear();
		seatsAvailable.clear();	
	}
}
