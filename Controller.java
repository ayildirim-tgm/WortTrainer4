package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import model.SpeichernLaden;
import model.WortListe;
import model.WortTrainer;
import view.GUI;

public class Controller implements ActionListener{
	
	private GUI gui;
	private WortTrainer wt;
	
	public static void main(String[] args) {
		
		Controller c = new Controller();
		c.begin();
	}
	
	private void begin() {
		
		String[] words = {"Apfel", "Haus", "Katze"};
		String[] urls = {"https://image.jimcdn.com/app/cms/image/transf/dimension=1920x10000:format=jpg/path/s773f0b7acb31ce72/image/i1a929c29e53043aa/version/1536147543/roter-apfel-mit-einzelnem-gr%C3%BCnen-blatt-vor-wei%C3%9Fem-hintergrund.jpg", 
						"https://www.gussek-haus.de/fileadmin/user_upload/Fertighaeuser-Haeuser/Kundenhaeuser/Luxushaus/Cannstatt/luxushaus-cannstatt-001-zeltdach-erker.jpg", 
						"https://media.os.fressnapf.com/cms/2020/05/Ratgeber_Katze_Erziehung_KittenOrange_1200x527.jpg"};
		WortListe wl = new WortListe(words, urls);
		wt = new WortTrainer(wl);
		wt.getRandomEintrag();
		gui = new GUI(this);
		
	}
	
	public WortTrainer getwt(){
		
		return this.wt;
		
	}
	@Override
    public void actionPerformed(ActionEvent e) {
		
        if(e.getSource().equals(gui.check)) {
        	
            wt.check(gui.getInput());
            gui.update();
            
        } else if(e.getSource().equals(gui.speichern)) {
            
            try {
                
                SpeichernLaden.speichern(this.wt);
                 
                
            } catch (IOException e1) {
            	
                System.err.println("Error while saving WortTrainer!");
                
            }
            
        } else if(e.getSource().equals(gui.laden)) {
        	
            try {
                
                SpeichernLaden.laden(this.wt);
                gui.update();
                
            } catch (IOException e1) {
            	
                System.err.println("Error while loading WortTrainer!");
                
            }
            
        } else if(e.getSource().equals(gui.neuesWort)) {
        	
        	String s = gui.getInput();
            wt.getObj().addEintrag(s.split("; ")[0], s.split("; ")[1]);
            
        } else {
        	
        	String[] words = {"Apfel", "Haus", "Katze"};
        	String[] urls = {"https://image.jimcdn.com/app/cms/image/transf/dimension=1920x10000:format=jpg/path/s773f0b7acb31ce72/image/i1a929c29e53043aa/version/1536147543/roter-apfel-mit-einzelnem-gr%C3%BCnen-blatt-vor-wei%C3%9Fem-hintergrund.jpg", 
					"https://www.gussek-haus.de/fileadmin/user_upload/Fertighaeuser-Haeuser/Kundenhaeuser/Luxushaus/Cannstatt/luxushaus-cannstatt-001-zeltdach-erker.jpg", 
					"https://media.os.fressnapf.com/cms/2020/05/Ratgeber_Katze_Erziehung_KittenOrange_1200x527.jpg"};
    		WortListe wl = new WortListe(words, urls);
    		wt = new WortTrainer(wl);
            
            gui.update();
            
        }
    }
}
