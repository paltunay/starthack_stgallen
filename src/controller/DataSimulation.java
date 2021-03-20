package controller;

import java.util.Map;
import java.util.HashMap;
import java.util.Random;

import model.*;

public class DataSimulation {
	
	final private int suggestionCount;
	final private int voteCount;
	final private int maxNameLength;
	final private int maxDescLength;
	public Map<String, Suggestion> suggestions;
	

	public DataSimulation(int suggestionCount, int voteCount, int maxNameLength, 
			int maxDescLength) {
		
		this.suggestionCount = suggestionCount;
		this.voteCount = voteCount;
		this.maxNameLength = maxNameLength;
		this.maxDescLength = maxDescLength;
	}
	
	public void start() {
		this.suggestions = generateSuggestions();
		
	}
	
	private Map generateSuggestions() {
		Map<String, Suggestion> suggestions = new HashMap<String, Suggestion>();
		final int asciiRange = 123; // define ASCII range
		int count = 0;
		Random rnd = new Random();
		while (count < suggestionCount) {
			// generate name
			String name = "";
			int i = 0;
			while (i < maxNameLength) { // generate name
				name += (char) rnd.nextInt(asciiRange) + 32; // start at ASCII 32
				++i;
				if (rnd.nextInt(20) == 1) // 5% probability to stop name generation here
					break;
			}
			// name must be unique!
			
			if (suggestions.containsKey(name)) { // begin again
				continue;
			}
			
			// generate description
			i = 0;
			String desc = "";
			while (i < maxDescLength) {
				desc += (char) rnd.nextInt(asciiRange) + 32;
				++i;
				if (rnd.nextInt(40) == 1) // 2.5% probability to stop name generation here
					break; // description is ~2x as long as name
			}
			suggestions.put(name, new Suggestion(name, desc));
			++count;
		}
		return suggestions;
	}
}
