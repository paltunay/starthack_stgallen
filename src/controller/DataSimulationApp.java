package controller;

import model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class DataSimulationApp {

	public static void main(String[] args) {
		DataSimulation sim = new DataSimulation(3, 100, 15, 20);
		sim.start();
		FileHandler.saveData(sim.getSuggestions());

		view.UserInterface.setupWindow();

		
//		for (String name : sim.getSuggestions().keySet()) {
//			System.out.println(name);
//			System.out.println(sim.getSuggestions().get(name).getDescription());
//			System.out.println(sim.getSuggestions().get(name).getIssuer());
//			System.out.println(sim.getSuggestions().get(name).getDownvoteCount());
//			System.out.println(sim.getSuggestions().get(name).getUpvoteCount());
//			System.out.println(sim.getSuggestions().get(name).getVotes());
//			System.out.println(sim.getSuggestions().get(name).getName());
//			System.out.println();
//			
//		}



	}

}
