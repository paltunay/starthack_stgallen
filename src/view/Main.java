package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import model.*;
import controller.*;

public class Main {

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
}
