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
		dashboard.Main.dashboardSetup(null);
	}

}
