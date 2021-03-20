package controller;

import model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class DataSimulationApp {

	public static void main(String[] args) {
		DataSimulation sim = new DataSimulation(3, 100, 20, 100);
		sim.start();
		for (String name : sim.getSuggestions().keySet()) {
			System.out.println(name);
			System.out.println(sim.getSuggestions().get(name).getDescription());
			System.out.println(sim.getSuggestions().get(name).getIssuer());
			System.out.println(sim.getSuggestions().get(name).getDownvoteCount());
			System.out.println(sim.getSuggestions().get(name).getUpvoteCount());
			System.out.println(sim.getSuggestions().get(name).getVotes());
			System.out.println(sim.getSuggestions().get(name).getName());
			System.out.println();
			
		}
		Suggestion sug1 = new Suggestion("sug1", "desc1", 5, 10, 4, "Hans-Ruedi Müller");
		Suggestion sug2 = new Suggestion("sug2", "desc2", 5, 15, 1, "Günther Jauch");
		if (sug1.compareTo(sug2) > 0) {
			System.out.println("sug1 is more popular than sug2");
		}
		else if (sug1.compareTo(sug2) < 0) {
			System.out.println("sug1 is less popular than sug2");
		}
		else {
			System.out.println("They are equally popular!");
		}

		Map<String, Suggestion> map = sim.getSuggestions();
		List<Suggestion> lst = new ArrayList<Suggestion>(map.values());
		Collections.sort(lst);
		for (Suggestion suggestion : lst) {
			System.out.println(suggestion.getDescription());
			System.out.println(suggestion.getIssuer());
			System.out.println(suggestion.getDownvoteCount());
			System.out.println(suggestion.getUpvoteCount());
			System.out.println(suggestion.getVotes());
			System.out.println(suggestion.getName());
			System.out.println();
		}

	}

}
