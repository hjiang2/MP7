/**
 * the GUI.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.util.Scanner;

@SuppressWarnings("serial")
public class ScrabbleMaximizer extends JFrame implements ActionListener {
	private JLabel label; 
	private JTextField textFieldInput;
	private JTextArea textAreaOutput; 	
	private JButton input;	
	private String letters;
	
	public ScrabbleMaximizer() {
	      setLayout(new FlowLayout());
	      setDefaultCloseOperation(EXIT_ON_CLOSE);
	      label = new JLabel("Input Letters");
	      add(label); 
	      
	      textFieldInput = new JTextField("", 20); 
	      textFieldInput.setEditable(true);
	  
	      
	      add(textFieldInput); 	      
	      
	      input = new JButton("Input");   // construct the Button component
	      add(input);
	      input.addActionListener(this);
	      input.setEnabled(true);
	      
	      textAreaOutput = new JTextArea("Output will be displayed here", 100, 40); 
	      textAreaOutput.setEditable(false);
	      add(textAreaOutput);	 
	      
	      
	      setTitle("Scrabble Maximizer"); 
	      setSize(500, 400);
	      
	      setVisible(true);
	 
	}
		
	
	public static void main(String[] args) {
		ScrabbleMaximizer newScrabble = new ScrabbleMaximizer();
		newScrabble.setVisible(true);
		
		Scanner userInput = new Scanner(System.in);
        String letters = userInput.nextLine();
        newScrabble.textFieldInput.setText(letters);
        userInput.close();
        String output = "Error!";
    	Result scrabble = new Result();

    	try {
    		output = scrabble.getMaxPoints(letters);
    		newScrabble.textAreaOutput.setText(output);
    		System.out.println(output);
    	} catch (FileNotFoundException e1) {
    		e1.printStackTrace();
    	}
    	
    	JOptionPane.showMessageDialog(null, output);
    	System.exit(0);
        
        
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Scanner userInput = new Scanner(System.in);
        letters = userInput.nextLine();
        textFieldInput.setText(letters);
        setVisible(true);
        
        if (e.getSource() == input) {
        	String output = "Error!";
        	Result scrabble = new Result();

        	try {
        		output = scrabble.getMaxPoints(letters);
        		textAreaOutput.setText(output);
        		System.out.println(output);
        	} catch (FileNotFoundException e1) {
        		e1.printStackTrace();
        	}
        	userInput.close();
        	JOptionPane.showMessageDialog(null, output);
        	System.exit(0);
        }

	}

}
