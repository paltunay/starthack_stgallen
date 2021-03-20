package controller;

import java.util.Map;
import java.util.HashMap;
import java.util.Random;

import jdk.jshell.SourceCodeAnalysis.Suggestion;

public class DataSimulation {
	
	final private int suggestionCount;
	final private int voteCount;
	final private int maxNameLength;
	final private int maxDescLength;
	private Map<String, Suggestion> suggestions;
	

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
	
	private HashMap generateSuggestions() {
		Map<String, Suggestion> suggestions = new HashMap<String, Suggestion>();
		final int asciiRange = 123; // define ASCII range
		int count = 0;
		Random rnd = new Random();
		while (count < suggestionCount) {
			String name = "";
			int i = 0;
			while (i < maxNameLength) { // generate name
				name += (char) rnd.nextInt(asciiRange) + 32; // start at ASCII 32
				++i;
				if (rnd.nextInt(10))
			}
			i = 0;
			String desc = "";
			while (i < maxDescLength) {
				
			}
		}
	}
}
