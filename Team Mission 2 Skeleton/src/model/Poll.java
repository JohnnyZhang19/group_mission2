package model;

import java.util.Arrays;
import java.util.Comparator;

public class Poll {

	private String name;
	private Party[] parties;
	private int partiesInPoll;

	public String getPollName() {
		return name;
	}
	public int getNumberOfParties() {
		return partiesInPoll;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Poll(String name, int maxNumOfParties ) {
		this.name = name;
		if(maxNumOfParties >= 1) {
			parties = new Party[maxNumOfParties]; 
		}else {
			parties = new Party[10];
		}
	}


	public String toString() {
		String nameofthepoll = name + "\n";
		String party = new String(nameofthepoll);
		for(int i = 0;i < partiesInPoll;i++) {
			party = party + parties[i].toString() + "\n";
		}
		return party;                                                   
	}

	public void addParty(Party party){
		if(party == null){
			System.err.println("The party object is null");
			return;
		}
		for (int i = 0; i < partiesInPoll; i++) {
			if(parties[i].getName().equalsIgnoreCase(party.getName())){
				parties[i] = party;
				return;
			}
		}
		if(partiesInPoll<parties.length){
			parties[partiesInPoll] = party;
			partiesInPoll++;
		}else{
			System.err.println("Parties has no more rooms, the poll is full");
		}
	}

	public Party getParty(String name){
		for (int i = 0; i < partiesInPoll; i++) {
			if(parties[i].getName().equalsIgnoreCase(name)){
				return parties[i];
			}
		}
		return null;
	}

	public Party[] getPartiesSortedBySeats(){
		Party[] newParties =  Arrays.copyOf(parties,partiesInPoll);
		Arrays.sort(newParties, new Comparator<Party>() {
			@Override
			public int compare(Party o1, Party o2) {
				return (int)(o2.getProjectedNumberOfSeats() - o1.getProjectedNumberOfSeats());
			}
		});
		return newParties;
	}

	public Party[] getPartiesSortedByVotes(){
		Party[] newParties =  Arrays.copyOf(parties,partiesInPoll);
		Arrays.sort(newParties, new Comparator<Party>() {
			@Override
			public int compare(Party o1, Party o2) {
				return (int)(o2.getProjectedPercentageOfVotes()*100 - o1.getProjectedPercentageOfVotes()*100);
			}
		});
		return newParties;
	}

	public int getAmountOfUndeterSeats(){
		int amount = 0;
		for (int i = 0; i < partiesInPoll; i++) {
			if (parties[i].getProjectedNumberOfSeats() == 0.0) {
				amount++;
			} 
		}
		return amount;
	}

	public int getAmountOfUndeterVotes(){
		int amount = 0;

		for (int i = 0; i < partiesInPoll; i++) {
			if (parties[i].getProjectedPercentageOfVotes() == 0.0) {
				amount++;
			} 
		}
		return amount;
	}
}
