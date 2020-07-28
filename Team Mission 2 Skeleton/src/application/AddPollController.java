package application;


import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class AddPollController extends PollTrackerController{

    @FXML
    private ChoiceBox<String> selectPoll;
    @FXML
    private Label pollNameLabel;

    @FXML
    private Button addPoll;

    @FXML
    private Button clear;

    @FXML
    private Label selectLabel;

    @FXML
    private TextField enterPollName;

    @FXML
    void addPoll(ActionEvent event) {
    	System.out.println("buttonClicked");
    	getPollList().getPolls()[selectPoll.getSelectionModel().getSelectedIndex()].setName(enterPollName.getText());
    	
    }

    @FXML
    void clear(ActionEvent event) {
    	System.out.println("clear");
    	enterPollName.clear();
    }

    @FXML
    void selectPoll(ActionEvent event) {
    	
    }

    @FXML
    void selectLabel(ActionEvent event) {

    }

    @FXML
    void pollNameLabel(ActionEvent event) {

    }

    @FXML
    void keyTyped(KeyEvent event) {
    	System.out.println("entered");
    	
    }

	@Override
	public void refresh() {
		
	}
	
	@FXML
	void initialize() {
		String[] choiceBox = {"1(Replace poll Poll0)","2(Replace poll Poll1)","3(Replace poll Poll2)","4(Replace poll Poll3)"
				,"5(Replace poll Poll4)"};
		selectPoll.setItems(FXCollections.observableArrayList(choiceBox));
		
	}
	

}
