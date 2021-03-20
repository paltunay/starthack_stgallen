package controller;

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

	}

}
