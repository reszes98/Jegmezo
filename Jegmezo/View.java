package Jegmezo;
//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : View.java
//  @ Date : 2020. 05. 05.
//  @ Author : 
//
//


import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class View {
	private JFrame frame;
	private JPanel jatekPanel;
	private JPanel jegmezoPanel;
	private List<JComboBox<Object>> taskak=new ArrayList<JComboBox<Object>>();
	private JComboBox<Object> aktTaska;
	private JPanel iranyPanel;
	private JPanel taskaPanel;
	private JButton HasznalButton;
	private JButton FelveszButton;
	private JButton KepessegButton;
	private JButton BalraButton;
	private JButton JobbraButton;
	private JButton LepButton;
	private JButton korvegeButton;
	private JButton asasButton;
	private JLabel testho;
	private JLabel munka;
	private List<Drawable> drawable=new ArrayList<Drawable>();
	private Controller controller;
	Menu menu;
	/**
	 * @param c controller
	 * @param m menu
	 */
	public View(Controller c, Menu m) {
		controller=c; menu=m;
		inicializalas();
		
	}
	/**
	 * komponensek l�trehoz�sa
	 */
	public void inicializalas() {
		aktTaska=new JComboBox<Object>();
		munka=new JLabel();
		testho=new JLabel();
		munka.setText("J�t�kos munk�i:");
		testho.setText("J�t�kos testh�je:");
		setButtons();
		setPanels();
		frame=new JFrame("J�g-veled!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			
	    frame.setPreferredSize(new Dimension(940, 740));																						
	    frame.setLocationRelativeTo(null);
	    frame.setLayout(new BorderLayout());
	    
	    frame.add(BorderLayout.CENTER, jegmezoPanel);
		frame.add(BorderLayout.EAST, iranyPanel);
		frame.add(BorderLayout.NORTH, jatekPanel);
		frame.add(BorderLayout.WEST, taskaPanel);
		
		frame.setResizable(false);										
		frame.setVisible(true);
		frame.pack();
	    
	}
	
	
	
	
	/**
	 * @param d drawable, kirajzoland� objektum hozz�ad�s
	 */
	public void addDrawable(Drawable d) {
		drawable.add(d);
	}
	
	/**
	 * k�perny� �jra rajzol
	 */
	public void drawAll() {
		jegmezoPanel.repaint();
		iranyPanel.repaint();
		jatekPanel.repaint();
		taskaPanel.repaint();
	}
	
	/**
	 * gombok l�trehoz�sa
	 */
	public void setButtons() {
		HasznalButton=new JButton("T�rgy Haszn�l");
		HasznalButton.addActionListener(controller.new TargyActionListener(aktTaska));
		FelveszButton=new JButton("Felvesz");
		FelveszButton.addActionListener(controller.new TargyActionListener(aktTaska));
		KepessegButton=new JButton("K�pess�g Haszn�l");
		KepessegButton.addActionListener(controller.new GombokActionListener());
		BalraButton=new JButton("Bal");
		BalraButton.addActionListener(controller.new GombokActionListener());
		JobbraButton=new JButton("Jobb");
		JobbraButton.addActionListener(controller.new GombokActionListener());
		LepButton=new JButton("L�p");
		LepButton.addActionListener(controller.new GombokActionListener());
		korvegeButton=new JButton("J�het a k�vetkez�");
		korvegeButton.addActionListener(controller.new GombokActionListener());
		asasButton=new JButton("�s�s");
		asasButton.addActionListener(controller.new GombokActionListener());
	}
	
	/**
	 * panelek l�trehoz�sa
	 */
	public void setPanels() {
		jatekPanel=new JPanel();
		jatekPanel.setPreferredSize(new Dimension(900,100));
		jegmezoPanel=new JPanel() {
			public void paintComponent(Graphics g) {
				for(int i=0;i<drawable.size();i++)
					drawable.get(i).draw((Graphics2D)g);
			}
		};
		jegmezoPanel.setPreferredSize(new Dimension(640,640));
		iranyPanel=new JPanel();
		iranyPanel.setPreferredSize(new Dimension(150,500));
		taskaPanel=new JPanel();
		taskaPanel.setPreferredSize(new Dimension(150,500));
		
		iranyPanel.add(asasButton);
		iranyPanel.add(FelveszButton);
		iranyPanel.add(KepessegButton);
		iranyPanel.add(JobbraButton);
		iranyPanel.add(BalraButton);
		iranyPanel.add(LepButton);
		iranyPanel.add(korvegeButton);
		
	
		taskaPanel.add(aktTaska);
		taskaPanel.add(HasznalButton);
		
		jatekPanel.add(testho);
		jatekPanel.add(munka);
		
	}
	
	
	/**
	 * j�tt�k v�ge, nyert�nk
	 */
	public void gameWon() {
		frame.dispose();
		menu.GameWon();
	}
	
	/**
	 * j�t�k v�ge, vesztett�nk
	 */
	public void gameLost() {
		frame.dispose();
		menu.GameLost();
	}
	
	
	/**
	 * @param j �j t�ska felv�tele
	 */
	public void AddTaska(JComboBox<Object> j) {
		taskak.add(j);
	}
	/**
	 * @param idx jelenlegi j�t�koshoz tartoz� t�ska
	 */
	public void setAktTaska(int idx) {		
		aktTaska=taskak.get(idx);
	}
	/**
	 * @return jelenleg be�ll�tott t�ska
	 */
	JComboBox<Object> getAktTaska() {
		return aktTaska;
	}
	/**
	 * @return az �sszes j�t�kos t�sk�ja
	 */
	List<JComboBox<Object>> getTaskak() {
		return taskak;
	}
	/**
	 * @param d amit m�r nem kell kirajzolni
	 * drawable objektum elt�vol�t�sa, nem rajzoljuk ki t�bb�
	 */
	public void eltavolitDrawable(Drawable d) {
		drawable.remove(d);
	}
	
	/**
	 * @param n aktu�lis j�t�kos testh�je
	 * ki�rand� testh�, az aktu�lis j�t�kos testh�je
	 */
	public void setTestho(int n) {
		testho.setText("J�t�kos Testh�je: "+n);
	}
	/**
	 * @param n munkadb
	 * aktu�lis j�t�kos munk�i ki�r�sa
	 */
	public void setMunka(int n) {
		munka.setText("J�t�kos Munk�i: "+n);
	}
	
	
}
