package view;

import controller.DataSimulation;
import model.Suggestion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class Trash {
    public static void main(String[] args) {
        //run data simulation
        DataSimulation simulation = new DataSimulation(5, 100, 10, 20);
        simulation.start();

        Map<String, Suggestion> suggestions = simulation.getSuggestions();

        JFrame frame = new JFrame();
        JPanel windowPanel = new JPanel();

        //create button and set up text and action listener
        JButton button = new JButton();
        button.setText("test");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                windowPanel.add(suggestionPanel("test2", "description2", 0, 1));
                windowPanel.revalidate();
                windowPanel.repaint();
            }
        });

        //adding components to the window
        windowPanel.add(button);
        windowPanel.add(suggestionPanel("test", "description", 2, 3));
        windowPanel.setLayout(new BoxLayout(windowPanel, BoxLayout.Y_AXIS));

        addSuggestions(suggestions, windowPanel);
        //frame setup
        frame.add(windowPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setVisible(true);

    }

    private static JPanel suggestionPanel(String name, String descriptionText, int upvotes, int downvotes){
        JPanel panel = new JPanel();
        JLabel text = new JLabel(name);
        JLabel description = new JLabel(descriptionText);
        JButton upvote = new JButton("+" +upvotes);
        upvote.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        JButton downvote = new JButton("-" +downvotes);
        downvote.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                downvote.setText("changed");
            }
        });
        panel.add(text);
        panel.add(upvote);
        panel.add(downvote);
        panel.add(description);

        return panel;
    }

    private static void addSuggestions(Map<String, Suggestion> suggestions, JPanel panel) {
        for (String name : suggestions.keySet()) {
            Suggestion suggestion = suggestions.get(name);
            panel.add(suggestionPanel(suggestion.getName(), suggestion.getDescription(), suggestion.getUpvoteCount(), suggestion.getDownvoteCount()));
        }
    }
    
    
    // DataSimulation_trash follows
    
    /*final int asciiRange = 123; // define ASCII range
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
	}*/
    
}
