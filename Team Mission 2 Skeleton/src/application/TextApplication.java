package application;
import java.util.Scanner;

import model.Factory;
import model.Party;
import model.Poll;
import model.PollList;
/**
 * This class represents the entire application and pulls together all other classes
 * 
 * @author Ha Do _ Team C1 _ UCID: 30097811
 *
 */

public class TextApplication {
	public static final int MAX_NUMBER_OF_STARS = 25;
	private PollList polls;
	
	public TextApplication() {
	}
	
	/**
	 * 
	 * Take a PollList as an argument and uses it to initialize the polls instance variable
	 * @param initiatePoll initiates the polls variable
	 */
	public TextApplication(PollList polls) {
		this.polls = polls; 
	}
	

	
	/**
	 * 
	 * Visualize the data in a poll provided as an argument to allow the user to compare the parties
	 * @param initiatePoll initiates the polls variable
	 */
	public void displayPollDataBySeat(Poll aPoll, int numOfSeats) {
		for (int i = 0; i < aPoll.getPartiesSortedBySeats().length; i++) {
			System.out.println(aPoll.getPartiesSortedBySeats()[i].textVisualizationBySeats(MAX_NUMBER_OF_STARS, (int)(0.5*MAX_NUMBER_OF_STARS), numOfSeats/MAX_NUMBER_OF_STARS));
		}
	}
	
	/**
	 * 
	 * Take an array of Strings as an argument and generate visualization of a list of polls
	 * @param partyNames are the names of the parties in the election that should be included in the aggregate poll to display
	 */
	public void displayPollsBySeat(String[] partyNames, int numOfSeats) {
		for (int i = 0; i < polls.getPolls().length; i++) {
			displayPollDataBySeat(polls.getPolls()[i], numOfSeats);
			System.out.println();
		}
		displayPollDataBySeat(polls.getAggregatePoll(partyNames), numOfSeats);
	}
	
	public PollList getPolls() {  //getter method for variable polls
		return polls;
	}
	

		public static int readInput(Scanner scan) {
			int value = Integer.parseInt(scan.nextLine());
			return value;
		}
		public String[] readPartyInput(Scanner scan) {
			String input = scan.nextLine();
			return input.split(",");
		}
		public static int promptNumSeats(Scanner scan) {
			System.out.print("How many seats are available in the election? ");
			return readInput(scan);
		}
		public String[] promptParties(Scanner scan) {
			System.out.println("Which parties are in the election (provide names, comma separated): ");
			return readPartyInput(scan);
		}
		public int promptNumPolls(Scanner scan) {
			System.out.print("How many polls do you want to track with this application? ");
			return readInput(scan);
		}
		public void generatePolls(int numSeats, String[] partyNames, int numPolls, Scanner scan) {
			System.out.println("Would you like me to create a random set of polls? yes/no");
			String input = scan.nextLine();
			if(input.equals("yes")) {
				
				Factory factory = new Factory(numSeats);
				factory.setPartyNames(partyNames);
				polls = factory.createRandomPollList(numPolls);
				return;
			}
			polls = new PollList(numPolls, numSeats);
			for(int i = 0; i < numPolls; i++) {
				Poll poll = new Poll("Poll " + (i + 1), partyNames.length);
				for(String name : partyNames) {
					int projNumSeats = Integer.parseInt(scan.nextLine());
					int projVotePercent = Integer.parseInt(scan.nextLine());
					poll.addParty(new Party(name, projNumSeats, (float)projVotePercent/100));
				}
				polls.addPoll(poll);
			}
			
		}
		public void displayMenu() {
			System.out.println("Choose an option");
			System.out.println("  1) All: Show result of all polls by seat");
			System.out.println("  2) Aggregate: Show aggregate result");
			System.out.println("  3) Quit: End application");
		}
		private void enterToContinue(Scanner scan) {
			System.out.println("\n");
			System.out.println("ENTER TO CONTINUE");
			scan.nextLine();
		}
		
		/**
		 * Main run method
		 */
		public void run(Scanner scan) {
			System.out.println("Welcome to the poll tracker");
			int numSeats = promptNumSeats(scan);
			String[] partyNames = promptParties(scan);
			int numPolls = promptNumPolls(scan);
			generatePolls(numSeats, partyNames, numPolls, scan);
			while(true) {
				displayMenu();
				int choice = readInput(scan);
				switch(choice) {
					case 1:
						System.out.println();
						displayPollsBySeat(partyNames, numSeats);
						System.out.println();
						displayPollDataBySeat(polls.getAggregatePoll(partyNames), numSeats);
						break;
					case 2:
						System.out.println();
						displayPollDataBySeat(polls.getAggregatePoll(partyNames), numSeats);
						break;
					case 3:
						return;
				}
				enterToContinue(scan);
			}
		}
		

		public static void main(String[] args) {
			TextApplication app = new TextApplication(null);
			Scanner scan = new Scanner(System.in);
			app.run(scan);
			scan.close();

}}
