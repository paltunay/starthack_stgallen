package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.*;
import controller.*;

public class Main {

    public static void main(String[] args) {
        initComponents();

    }
    private static void initComponents() {
        JFrame frame = new JFrame();
        JPanel windowPanel = new JPanel();

        //create button and set up text and action listener
        JButton button = new JButton();
        button.setText("test");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                windowPanel.add(suggestionPanel("test2", "description2"));
                windowPanel.revalidate();
                windowPanel.repaint();
            }
        });

        //adding components to the window
        windowPanel.add(button);
        windowPanel.add(suggestionPanel("test", "description"));
        windowPanel.setLayout(new BoxLayout(windowPanel, BoxLayout.Y_AXIS));

        //frame setup
        frame.add(windowPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setVisible(true);
    }

    private static JPanel suggestionPanel(String name, String descriptionText){
        JPanel panel = new JPanel();
        JLabel text = new JLabel(name);
        JLabel description = new JLabel(descriptionText);
        JButton upvote = new JButton("+");
        JButton downvote = new JButton("-");
        panel.add(text);
        panel.add(upvote);
        panel.add(downvote);
        panel.add(description);

        return panel;
    }
}
