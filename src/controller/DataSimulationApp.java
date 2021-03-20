package controller;

import model.*;

public class DataSimulationApp {

	public static void main(String[] args) {
		DataSimulation sim = new DataSimulation(3, 100, 20, 100);
		sim.start();
		for (String name : sim.suggestions.keySet()) {
			System.out.println(name);
			System.out.println(sim.suggestions.get(name).getDescription());
			System.out.println(sim.suggestions.get(name).getDownvoteCount());
			System.out.println(sim.suggestions.get(name).getUpvoteCount());
			System.out.println(sim.suggestions.get(name).getVotes());
			System.out.println(sim.suggestions.get(name).getName());
			System.out.println();
			
		}
		Suggestion sug1 = new Suggestion("sug1", "desc1", 5, 10, 4);
		Suggestion sug2 = new Suggestion("sug2", "desc2", 5, 15, 1);
		if (sug1.compareTo(sug2) > 0) {
			System.out.println("sug1 is more popular than sug2");
		}
		else if (sug1.compareTo(sug2) < 0) {
			System.out.println("sug1 is less popular than sug2");
		}
		else {
			System.out.println("They are equally popular!");
		}

	}

}
