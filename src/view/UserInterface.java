package view;

import model.*;
import controller.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class UserInterface {

    public static void setupWindow() {
        //create main window elements
        JFrame frame = new JFrame();
        JPanel windowPanel = new JPanel();

        //setup windowPanel
        windowPanel.setLayout(new BoxLayout(windowPanel, BoxLayout.Y_AXIS));

        //add data to the UI
        addSuggestions(windowPanel);

        //setup frame
        frame.add(windowPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setVisible(true);

    }

    private static JPanel suggestionPanel(String name, String descriptionText, int upvotes, int downvotes, String issuer){
        //create main components of suggestionPanel
        JPanel panel = new JPanel();
        JLabel text = new JLabel(name);
        JLabel description = new JLabel(descriptionText);
        JLabel issuerName = new JLabel(issuer);
        JButton upvote = new JButton("+" +upvotes);
        JButton downvote = new JButton("-" +downvotes);

        //add components to the panel
        panel.add(text);
        panel.add(upvote);
        panel.add(downvote);
        panel.add(description);
        panel.add(issuerName);

        return panel;
    }

    private static void addSuggestions(JPanel panel) {
        //read map that is saved in file
        Map<String, Suggestion> map = FileHandler.readData();
        //convert map to array list and sort the list
        ArrayList<Suggestion> lst = new ArrayList<Suggestion>(map.values());
        Collections.sort(lst);

        //add each list element to the JPanel
        for (Suggestion suggestion : lst) {
            panel.add(suggestionPanel(suggestion.getName(), suggestion.getDescription(), suggestion.getUpvoteCount(), suggestion.getDownvoteCount(), suggestion.getIssuer()));
        }
    }
}
