package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.TextField;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import controller.Controller;

public class GUI extends JFrame {
	public JLabel text = new JLabel();
	public JLabel eingaben = new JLabel();
	public JLabel richtig = new JLabel();
	
	private JPanel panel;
	private JPanel panelN;
	private JPanel panelO;
	private JPanel panelS;
	
	public static JTextField textFeld;
	
	private ImageIcon icon;
	private Image bild;
	private JLabel bildLabel;
	
	public JButton check;
	public JButton speichern;
	public JButton laden;
	public JButton neuesSpiel;
	public JButton neuesWort;
	
	Controller c;
	
	public GUI(Controller c) {
		
		super("WortTrainer");
		
		this.c = c;
		
		panel = new JPanel();
		panelN = new JPanel();
		panelO = new JPanel();
		panelS = new JPanel();
		
		eingaben = new JLabel("Eingaben:0");
		richtig = new JLabel("Richtig: 0");
		
		try {
			
			icon = new ImageIcon(new URL(c.getwt().getCurrWortEintrag().getUrl()));
			
		}catch(MalformedURLException e) {
			
			e.printStackTrace();
			return;
			
		}
		
		bild = icon.getImage();
        bild = bild.getScaledInstance(250, 250,  Image.SCALE_SMOOTH);
        bildLabel = new JLabel(new ImageIcon(bild));
        
        check = new JButton("Check");
        speichern = new JButton("Speichern");
        laden = new JButton("Laden");
        neuesSpiel = new JButton("Neues Spiel");
        neuesWort = new JButton("Neues Wort");
        
        check.addActionListener(c);
        speichern.addActionListener(c);
        laden.addActionListener(c);
        neuesSpiel.addActionListener(c);
        neuesWort.addActionListener(c);
        
        textFeld = new JTextField();
        
        panel.setLayout(new BorderLayout());
        
        panelN.setLayout(new BoxLayout(panelN, BoxLayout.Y_AXIS));
        panelS.setLayout(new FlowLayout());
        panelO.setLayout(new BoxLayout(panelO, BoxLayout.Y_AXIS));
        
        text.setText("Welches Wort wird hier gezeigt");
        panelN.add(text);
        panelN.add(textFeld);
        
        panelO.add(check);
        panelO.add(speichern);
        panelO.add(laden);
        
        panelS.add(eingaben);
        panelS.add(neuesSpiel);
        panelS.add(neuesWort);
        panelS.add(richtig);
        
        this.panel.add(this.panelN, BorderLayout.NORTH);
        this.panel.add(this.panelO, BorderLayout.EAST);
        this.panel.add(this.panelS, BorderLayout.SOUTH);
        this.panel.add(this.bildLabel, BorderLayout.CENTER);
        
        super.add(this.panel);
        
        super.setMinimumSize(new Dimension(700, 300));
        super.setSize(super.getMinimumSize());
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.pack();
        super.setVisible(true);
        
	}
	
	public String getInput() {
		
		return textFeld.getText();
		
	}
	
	public void update() {
		
		c.getwt().getRandomEintrag();
		
		try {
			
			icon = new ImageIcon(new URL(c.getwt().getCurrWortEintrag().getUrl()));
			
		}catch(MalformedURLException e) {
			
			e.printStackTrace();
			return;
			
		}
		
		bild = icon.getImage();
        bild = bild.getScaledInstance(250, 250,  Image.SCALE_SMOOTH);
        bildLabel = new JLabel(new ImageIcon(bild));
        
        eingaben.setText(String.valueOf("Eingaben: " + c.getwt().getEingaben()));
        richtig.setText(String.valueOf("Richtig: " + c.getwt().getRichtig()));
        
        textFeld.setText("");
        SwingUtilities.updateComponentTreeUI(this);
	}
}
