import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.util.Scanner;
import javax.swing.Timer;
import java.util.Arrays;
import java.util.Random;



public class NumbersGame {
	final JTextField text;
	final JTextArea textArea;
	JTextField nameField;
	String nameInput;
	String guessInput1;
	int guessInput2;
	String guessInput3;
	int guessInput4;
	String guessInput5;
	int guessInput6;
	String guessInput7;
	int guessInput8;
	int attempts;
	String name; 
	Integer randInt1;
	Integer randInt2;
	Integer randInt3;
	Integer randInt4;
	Integer randInt5;
	Integer randInt6;
	Integer randInt7;
	Integer randInt8;
	Integer randInt9;
	Integer randInt10;
	Random rand = new Random();
	ArrayList<String> players = new ArrayList<String>();
	ArrayList<Integer> numList1 = new ArrayList<Integer>();
	ArrayList<Integer> numList2 = new ArrayList<Integer>();
	ArrayList<Integer> numList3 = new ArrayList<Integer>();
	long startA;
	long endA;
	long difference;
	
	
	
	public NumbersGame() {
		String use = "X, X";
		new ButtonListener();
		JFrame jfrm = new JFrame("Numbers Game");
		jfrm.setSize(600, 400);
		jfrm.setLayout(new BorderLayout());
		this.text = new JTextField("");
		this.text.setBounds(375, 35, 200, 20);
		jfrm.add(text);
		JButton start = new JButton("Start Game");
		start.setBounds(57, 15, 130, 30);
		start.addActionListener(new ButtonListener());
		jfrm.add(start);
		JLabel inputGuess = new JLabel("Enter Guess Here");
		inputGuess.setBounds(420, 15, 100, 20);
		jfrm.add(inputGuess);
		JLabel enterEm = new JLabel("Please input guesses of multiple integers as: \"X, X\", etc.");
		enterEm.setBounds(260, 55, 320, 20);
		jfrm.add(enterEm);
		JButton guesser = new JButton("Next Guess");
		guesser.setBounds(270, 35, 100, 20);
		guesser.addActionListener(new ButtonListener());
		jfrm.add(guesser);
		JLabel diffiChose = new JLabel("Choose Difficulty");
		diffiChose.setBounds(83, 45, 100, 25);
		jfrm.add(diffiChose);
		JButton one = new JButton("1");
		one.setBounds(15, 70, 50, 20);
		one.addActionListener(new ButtonListener());
		one.setBackground(Color.GREEN);
		one.setOpaque(true);
		jfrm.add(one);
		JButton two = new JButton("2");
		two.setBounds(68, 70, 50, 20);
		two.addActionListener(new ButtonListener());
		two.setBackground(Color.YELLOW);
		two.setOpaque(true);
		jfrm.add(two);
		JButton three = new JButton("3");
		three.setBounds(120, 70, 50, 20);
		three.addActionListener(new ButtonListener());
		three.setBackground(Color.ORANGE);
		three.setOpaque(true);
		jfrm.add(three);
		JButton four = new JButton("4");
		four.setBounds(172, 70, 50, 20);
		four.addActionListener(new ButtonListener());
		four.setBackground(Color.RED);
		four.setOpaque(true);
		jfrm.add(four);
		this.textArea = new JTextArea(10, 25);
		textArea.setText(null);
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setBounds(1, 98, 583, 175);
		jfrm.add(scroll);
		jfrm.setLayout(new BorderLayout());
		JButton clear = new JButton("Clear Display");
		clear.setBounds(45, 280, 140, 30);
		clear.addActionListener(new ButtonListener());
		jfrm.add(clear);
		jfrm.setLayout(new BorderLayout());
		JButton disStat = new JButton("Display Statistics");
		disStat.setBounds(45, 315, 140, 30);
		disStat.addActionListener(new ButtonListener());
		jfrm.add(disStat);
		jfrm.setLayout(new BorderLayout());
		JLabel options = new JLabel("Statistics Options");
		options.setBounds(400,274,130,20);
		jfrm.add(options);
		jfrm.setLayout(new BorderLayout());
		JButton plays = new JButton("# of Plays");
		plays.setBounds(335, 294, 120, 35);
		plays.addActionListener(new ButtonListener());
		jfrm.add(plays);
		jfrm.setLayout(new BorderLayout());
		JButton topPlayer = new JButton("Time");
		topPlayer.setBounds(460, 294, 120, 35);
		topPlayer.addActionListener(new ButtonListener());
		jfrm.add(topPlayer);
		jfrm.setLayout(new BorderLayout());
		jfrm.setVisible(true);
		jfrm.setDefaultCloseOperation(jfrm.EXIT_ON_CLOSE);
		
	}
	class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ae) {
			JButton key = (JButton)ae.getSource();
			
			if (key.getText().contentEquals("Enter name")) {
				nameInput = nameField.getText();
				
			}
			
			if (key.getText().contentEquals("Clear Display")) {
				textArea.setText(null);
			}
			
			if (key.getText().contentEquals("Start Game")) {
				startA = System.currentTimeMillis();
				attempts = 0;
				name  = JOptionPane.showInputDialog(null, "Enter name: ");
				textArea.append(name + " has started a new game.\n");
				
			}
			if (key.getText().contentEquals("1")) {
				attempts = 0;
				if (name == null) {
					name  = JOptionPane.showInputDialog(null, "Enter name: ");
					textArea.append(name + " has started a new game.\n");
				}
				textArea.append(name + " has selected Level 1 difficulty.\n");
				randInt1 = rand.nextInt(10);
				textArea.append("Guess your number!\n");
			}
			if (key.getText().contentEquals("Next Guess")) {
				attempts++;
				
				if (randInt1 != null) {
					guessInput1 = text.getText();
					guessInput2 = Integer.parseInt(guessInput1);
					if (guessInput2 > randInt1) {
						textArea.append("Less than " + guessInput2 + "\n");
					}
					if (guessInput2 < randInt1) {
						textArea.append("Greater than " + guessInput2 + "\n");
					}
					if (guessInput2 == randInt1) {
						endA = System.currentTimeMillis();
						JOptionPane.showMessageDialog(null, "Congratulations " + name + "! You guessed correctly! Click Start to play again.");
						textArea.append(name + " has guessed correctly within " + attempts + 
								" attempts! The correct number is: " + randInt1 + "\n");	
						String player = (name + ": " + attempts);
						players.add(player);
						randInt1 = null;
						name = null;
					}
				}
				if (randInt2 != null) {
					guessInput3 = text.getText();
					String[] parts = guessInput3.split(", ");
					String guessNum1 = parts[0];
					String guessNum2 = parts[1];
					Integer intNum1 = Integer.parseInt(guessNum1);
					Integer intNum2 = Integer.parseInt(guessNum2);
					
					int numFound = 0;
					int locFound = 0;
					
					if (numList1.contains(intNum1)) {
						numFound++;
					}
					if (numList1.contains(intNum2)) {
						numFound++;
					}
					if (numList1.get(0).equals(intNum1)) {
						locFound++;
					}
					if (numList1.get(1).equals(intNum2)) {
						locFound++;
					}
					
					if ((numFound == 2) & (locFound == 2)) {
						endA = System.currentTimeMillis();
						JOptionPane.showMessageDialog(null, "Congratulations " + name + "! You guessed correctly! Click Start to play again.");
						textArea.append(name + " has guessed correctly within " + attempts + 
								" attempts! The correct numbers are: " + randInt2 + ", " + + randInt3 + "\n");	
						String player = (name + ": " + attempts);
						players.add(player);
						randInt1 = null;
						name = null;
						randInt1 = null;
						randInt2 = null;
					} else {
						textArea.append("(" + numFound + ", " + locFound + ")\n");
					}
	
				}
				if (randInt4 != null) {
					guessInput5 = text.getText();
					String[] parts2 = guessInput5.split(", ");
					String guessNum3 = parts2[0];
					String guessNum4 = parts2[1];
					String guessNum5 = parts2[2];
					Integer intNum3 = Integer.parseInt(guessNum3); //randInt4
					Integer intNum4 = Integer.parseInt(guessNum4); //randInt5
					Integer intNum5 = Integer.parseInt(guessNum5); //randInt6
					int numFound = 0;
					int locFound = 0;
					
					
					if (numList2.contains(intNum3)) {
						numFound++;
					}
					if (numList2.contains(intNum4)) {
						numFound++;
					}
					if (numList2.contains(intNum5)) {
						numFound++;
					}
					if (numList2.get(0).equals(intNum3)) {
						locFound++;
					}
					if (numList2.get(1).equals(intNum4)) {
						locFound++;
					}
					if (numList2.get(2).equals(intNum5)) {
						locFound++;
					}
					if ((numFound == 3) & (locFound == 3)) {
						endA = System.currentTimeMillis();
						JOptionPane.showMessageDialog(null, "Congratulations " + name + "! You guessed correctly! Click Start to play again.");
						textArea.append(name + " has guessed correctly within " + attempts + 
								" attempts! The correct numbers are: " + randInt4 + ", " + randInt5 + ", " + randInt6 + "\n");	
						String player = (name + ": " + attempts);
						players.add(player);
						randInt1 = null;
						name = null;
						randInt4 = null;
						randInt5 = null;
						randInt6 = null;
					} else {
						textArea.append("(" + numFound + ", " + locFound + ")\n");
						
					}
	
				}
				if (randInt7 != null) {
					guessInput7 = text.getText();
					String[] parts3 = guessInput7.split(", ");
					String guessNum6 = parts3[0];
					String guessNum7 = parts3[1];
					String guessNum8 = parts3[2];
					String guessNum9 = parts3[3];
					Integer intNum6 = Integer.parseInt(guessNum6); //randInt7
					Integer intNum7 = Integer.parseInt(guessNum7); //randInt8
					Integer intNum8 = Integer.parseInt(guessNum8); //randInt9
					Integer intNum9 = Integer.parseInt(guessNum9); //randInt10
					int numFound = 0;
					int locFound = 0;
					
					if (numList3.contains(intNum6)) {
						numFound++;
					}
					if (numList3.contains(intNum7)) {
						numFound++;
					}
					if (numList3.contains(intNum8)) {
						numFound++;
					}
					if (numList3.contains(intNum9)) {
						numFound++;
					}
					if (numList3.get(0).equals(intNum6)) {
						locFound++;
					}
					if (numList3.get(1).equals(intNum7)) {
						locFound++;
					}
					if (numList3.get(2).equals(intNum8)) {
						locFound++;
					}
					if (numList3.get(3).equals(intNum9)) {
						locFound++;
					}
					if ((numFound == 4) & (locFound == 4)) {
						endA = System.currentTimeMillis();
						JOptionPane.showMessageDialog(null, "Congratulations " + name + "! You guessed correctly! Click Start to play again.");
						textArea.append(name + " has guessed correctly within " + attempts + 
								" attempts! The correct numbers are: " + randInt7 + ", " + randInt8 + ", " + randInt9 + ", " + randInt10 + "\n");	
						String player = (name + ": " + attempts);
						players.add(player);
						randInt1 = null;
						name = null;
						randInt7 = null;
						randInt8 = null;
						randInt9 = null;
						randInt10 = null;
					} else {
						textArea.append("(" + numFound + ", " + locFound + ")\n");
					}
	
				}
			}
			if (key.getText().contentEquals("2")) {
				attempts = 0;
				if (name == null) {
					startA = System.currentTimeMillis();
					name  = JOptionPane.showInputDialog(null, "Enter name: ");
					textArea.append(name + " has started a new game.\n");
				}
				textArea.append(name + " has selected Level 2 difficulty.\n");
				randInt2 = rand.nextInt(10);
				randInt3 = rand.nextInt(10);
				if(randInt2 == randInt3) {
					randInt3 = rand.nextInt(10);
				}
				if (randInt3 == randInt2) {
					randInt2 = rand.nextInt(10);
				}
				numList1.add(randInt2);
				numList1.add(randInt3);
				textArea.append("2 numbers have been generated, please input your 2 guesses.\n");
			}
			if (key.getText().contentEquals("3")) {
				attempts = 0;
				if (name == null) {
					startA = System.currentTimeMillis();
					name  = JOptionPane.showInputDialog(null, "Enter name: ");
					textArea.append(name + " has started a new game.\n");
				}
				textArea.append(name + " has selected Level 3 difficulty.\n");
				randInt4 = rand.nextInt(10);
				randInt5 = rand.nextInt(10);
				randInt6 = rand.nextInt(10);
				if (randInt4 == randInt5) {
					randInt5 = rand.nextInt(10);
				}
				if (randInt4 == randInt6) {
					randInt6 = rand.nextInt(10);
				}
				
				if (randInt5 == randInt6) {
					randInt6 = rand.nextInt(10);
				}
				if (randInt5 == randInt4) {
					randInt5 = rand.nextInt(10);
				}
				if (randInt6 == randInt5) {
					randInt5 = rand.nextInt(10);
				}
				if (randInt6 == randInt4) {
					randInt4 = rand.nextInt(10);
				}
				numList2.add(randInt4);
				numList2.add(randInt5);
				numList2.add(randInt6);
				textArea.append("3 numbers have been generated, please input your 3 guesses.\n");
			}
			if (key.getText().contentEquals("4")) {
				attempts = 0;
				if (name == null) {
					startA = System.currentTimeMillis();
					name  = JOptionPane.showInputDialog(null, "Enter name: ");
					textArea.append(name + " has started a new game.\n");
				}
				textArea.append(name + " has selected Level 4 difficulty.\n");
				randInt7 = rand.nextInt(10);
				randInt8 = rand.nextInt(10);
				randInt9 = rand.nextInt(10);
				randInt10 = rand.nextInt(10);
				if (randInt7 == randInt8) {
					randInt8 = rand.nextInt(10);
				}
				if (randInt7 == randInt9) {
					randInt9 = rand.nextInt(10);
				}
				if (randInt7 == randInt10) {
					randInt10 = rand.nextInt(10);
				}
				
				if (randInt8 == randInt9) {
					randInt9 = rand.nextInt(10);
				}
				if (randInt8 == randInt10) {
					randInt10 = rand.nextInt(10);
				}
				
				if (randInt9 == randInt8) {
					randInt8 = rand.nextInt(10);
				}
				
				if (randInt9 == randInt10) {
					randInt10 = rand.nextInt(10);
				}
				if (randInt10 == randInt7) {
					randInt7 = rand.nextInt(10);
				}
				
				if (randInt10 == randInt8) {
					randInt8 = rand.nextInt(10);
				}
				if (randInt10 == randInt9) {
					randInt9 = rand.nextInt(10);
				}
				numList3.add(randInt7);
				numList3.add(randInt8);
				numList3.add(randInt9);
				numList3.add(randInt10);
				textArea.append("4 numbers have been generated, please input your 4 guesses.\n");
			}
			if (key.getText().contentEquals("# of Plays")) {
				textArea.append("# of Plays: " + attempts + "\n");
			}
			if (key.getText().contentEquals("Display Statistics")) {
				
				
				
				Collections.sort(players);
				for (String s : players) {
					
					textArea.append(s + " attempts. \n");
				}
			}
			if(key.getText().contentEquals("Time")) {
				difference = (endA - startA) / 1000;
				textArea.append("Time elapsed: " + difference + " seconds\n");
			}
		}
	}
}
