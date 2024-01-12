package model;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SpeichernLaden {
	
	public static void speichern(String pfad, WortTrainer wt) throws IOException {
		BufferedWriter bw = null;
		try {
			
			bw = new BufferedWriter(new FileWriter(new File(pfad)));
			bw.write(String.valueOf(wt.getEingaben()));
			bw.newLine();
			bw.write(String.valueOf(wt.getRichtig()));
			bw.newLine();
			bw.write(String.valueOf(wt.getCurrWortEintrag().toString()));
			bw.newLine();
			bw.write(String.valueOf(wt.getObj().length()));
			bw.newLine();
			for(int i = 0; i < wt.getObj().length(); i++) {
				
				bw.write(String.valueOf(wt.getObj().getWortAt(i).getWort()));
				bw.newLine();
				bw.write(String.valueOf(wt.getObj().getWortAt(i).getUrl()));
				bw.newLine();
				
			}
			
		}finally{
			
			bw.close();
			
		}
	}
	
	public static void speichern(WortTrainer wt) throws IOException {
		
		SpeichernLaden.speichern("WortTrainer.txt", wt);
		
	}
	
	public static void laden(String pfad, WortTrainer wt) throws IOException {
		
		try (BufferedReader br = new BufferedReader(new FileReader(new File(pfad)))){
			
			wt.setEingaben(Integer.parseInt(br.readLine()));
			wt.setRichtig(Integer.parseInt(br.readLine()));
			String s = br.readLine();
			WortEintrag we = new WortEintrag(s.split("; ")[0], s.split("; ")[1]);
			wt.setCurrWortEintrag(we);
			int l = Integer.parseInt(br.readLine());
			WortEintrag[] we2 = new WortEintrag [l];
			for( int i = 0; i < l; i++) {
				
				we2[i] = new WortEintrag(String.valueOf(br.readLine()), String.valueOf(br.readLine()));
			}
			wt.getObj().setEintraege(we2);
			
		}
	}
	
	public static void laden(WortTrainer wt) throws IOException {
		SpeichernLaden.laden("WortTrainer.txt", wt);
	}
}

