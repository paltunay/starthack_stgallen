package controller;

import java.util.Map;
import java.util.HashMap;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import model.Suggestion;

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
	
	private Map generateSuggestions() {
		Map<String, Suggestion> suggestions = new HashMap<String, Suggestion>();
		
		File input = new File("suggestionsInput.txt");
		try {
			Scanner fileScanner = new Scanner(input);
			int count = 0;
			while (fileScanner.hasNextLine() && count < suggestionCount) {
				String issuerName = fileScanner.nextLine();
				String name = fileScanner.nextLine();
				String desc = fileScanner.nextLine();
				suggestions.put(name, new Suggestion(name, desc, issuerName));
				++count;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		generateVotes(suggestions);

		return suggestions;

	}

	private void generateVotes(Map<String, Suggestion> suggestions) {
		Random rnd = new Random();
		int remainingVotes = voteCount;
		int i = 0;

		for (Map.Entry<String, Suggestion> entry : suggestions.entrySet()) {
			Suggestion suggestion = entry.getValue();
			if (remainingVotes <= 0) {
				return;
			}
			if (i+1 == suggestionCount) {
				int upvotes = rnd.nextInt(remainingVotes)+1;
				int downvotes = remainingVotes - upvotes;
				suggestion.setDownvoteCount(downvotes);
				return;
			}

			int votes = rnd.nextInt(remainingVotes)+1;
			remainingVotes -= votes;
			int upvotes = rnd.nextInt(votes);
			int downvotes = votes - upvotes;

			suggestion.setUpvoteCount(upvotes);
			suggestion.setDownvoteCount(downvotes);

			i++;
		}
	}

	public Map<String, Suggestion> getSuggestions() {
		return suggestions;
	}
}
