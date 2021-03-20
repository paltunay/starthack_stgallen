package controller;

import java.util.Map;
import java.util.HashMap;
import java.util.Random;
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
		final int asciiRange = 123; // define ASCII range
		int count = 0;
		Random rnd = new Random();
		while (count < suggestionCount) {
			// generate name
			String name = "";
			int i = 0;
			while (i < maxNameLength) { // generate name
				name += Character.toString(rnd.nextInt(asciiRange) + 32); // start at ASCII 32
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
				desc += Character.toString(rnd.nextInt(asciiRange) + 32);
				++i;
				if (rnd.nextInt(40) == 1) // 2.5% probability to stop name generation here
					break; // description is ~2x as long as name
			}
			
			//generate issuer name
			i = 0;
			String issuerName = "";
			while (i < 15) {
				issuerName += Character.toString(rnd.nextInt(asciiRange) + 32);
				++i;
				if (rnd.nextInt(10) == 1) // 10% probability to stop name generation here
					break;
			}
			
			suggestions.put(name, new Suggestion(name, desc, issuerName));
			++count;
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
