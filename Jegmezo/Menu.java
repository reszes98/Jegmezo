package Jegmezo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Menu {
	private JButton NewGameButton = new JButton("Játék!");
	private JButton Game = new JButton("Játékra fel!");
	private JButton ExitButton = new JButton("Kilépés");
	private JLabel utasitasP = new JLabel();
	private JTextField eszkimoTextf = new JTextField();
	private JLabel eszkimo = new JLabel ("Eszkimó: ");
	private JTextField sarkkutatoTextf = new JTextField();
	private JLabel sarkkutato = new JLabel ("Sarkkutató: ");
	private JFrame jframe = new JFrame("Jég-veled");
	
	
	void MenuDisplay() {
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			
	    jframe.setPreferredSize(new Dimension(500, 500));										
	    jframe.pack();												
	    jframe.setLocationRelativeTo(null);
	    
	    
	    jframe.setLayout(new BorderLayout());
	    
	    JPanel centerpan = new JPanel(new GridLayout(5,1));
	    JPanel empty1 = new JPanel();
	    centerpan.add(empty1);
	    
	    Game.setFont(new Font("Arial", Font.PLAIN, 25));
	    ActionListener GameBActL = new MenuActionListener(jframe, eszkimoTextf, sarkkutatoTextf, utasitasP);
	    Game.addActionListener(GameBActL);
	    centerpan.add(Game);	 
	    
	    JPanel empty2 = new JPanel();
	    centerpan.add(empty2);
	    
	    ExitButton.setFont(new Font("Arial", Font.PLAIN, 25));
	    ActionListener ExitBActL = new MenuActionListener(jframe, eszkimoTextf, sarkkutatoTextf, utasitasP);
	    ExitButton.addActionListener(ExitBActL);
	    centerpan.add(ExitButton);
	    jframe.add(centerpan, BorderLayout.CENTER);
	    

	    JPanel empty3 = new JPanel();
	    empty3.setPreferredSize(new Dimension(120, 500));
	    jframe.add(empty3, BorderLayout.WEST);
	    
	    JPanel empty4 = new JPanel();
	    empty4.setPreferredSize(new Dimension(120, 500));
	    jframe.add(empty4, BorderLayout.EAST);
	    
	    jframe.setResizable(true);										
	    jframe.setVisible(true);
	}
	
	void Game() {
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			
	    jframe.setPreferredSize(new Dimension(500, 250));										
	    jframe.pack();												
	    jframe.setLocationRelativeTo(null);
	    jframe.setLayout(new BorderLayout());
	    
	    JPanel west = new JPanel(new GridLayout(4,1,100, 20));	  
	    JPanel empty1 = new JPanel();
	    west.add(empty1);
	    eszkimo.setFont(new Font("Curier New", Font.BOLD, 15));
	    west.add(eszkimo);	
	    sarkkutato.setFont(new Font("Curier New", Font.BOLD, 15));
	    west.add(sarkkutato);
	    jframe.add(west, BorderLayout.WEST);
	    
	    
	    JPanel centerpan = new JPanel(new GridLayout(4,1, 50, 20));	    
	    centerpan.add(utasitasP);
	    centerpan.add(eszkimoTextf);
	    centerpan.add(sarkkutatoTextf);
	    jframe.add(centerpan, BorderLayout.CENTER);
	    
	    
	    JPanel east = new JPanel(new BorderLayout());
	    east.setPreferredSize(new Dimension(150, 300));
	    
	    JPanel empty4 = new JPanel();
	    east.add(empty4, BorderLayout.WEST);
	    empty4.setPreferredSize(new Dimension(20,15));
	    
	    JPanel empty5 = new JPanel();
	    east.add(empty5, BorderLayout.NORTH);
	    empty5.setPreferredSize(new Dimension(100,80));
	    
	    ActionListener NewGameBActL = new MenuActionListener(jframe, eszkimoTextf, sarkkutatoTextf, utasitasP);
	    NewGameButton.addActionListener(NewGameBActL);
	    NewGameButton.setFont(new Font("Arial", Font.PLAIN, 25));
	    east.add(NewGameButton, BorderLayout.CENTER);
	    
	    JPanel empty6 = new JPanel();
	    east.add(empty6, BorderLayout.SOUTH);
	    empty6.setPreferredSize(new Dimension(100,80));
	    
	    JPanel empty7 = new JPanel();
	    east.add(empty7, BorderLayout.EAST);
	    empty7.setPreferredSize(new Dimension(20,15));
	    
	    jframe.add(east, BorderLayout.EAST);
	    
	    jframe.setResizable(true);										
	    jframe.setVisible(true);
	}
	
}
