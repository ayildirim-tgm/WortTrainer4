package model;
public class WortListe {
	
	private WortEintrag[] eintraege;
	
	public WortListe(String[] woerter, String[] urls) {
		 this.eintraege = new WortEintrag[woerter.length];
	        
	        for(int i = 0; i < eintraege.length; i++) {
	            this.eintraege[i] = new WortEintrag(woerter[i], urls[i]);
	        }
	        
	        for(int i = 0; i < urls.length; i++) {
	            this.eintraege[i].setURL(urls[i]);
	        }
	}
	
	public WortEintrag[] getWortEintraege() {
		if(this.eintraege == null) throw new IllegalArgumentException("Noch gibt es keine Eintr�ge");
		return this.eintraege;
	}
	
	
	public void addEintrag(String wort, String url) {
		int length = this.eintraege == null ? 1 : this.eintraege.length + 1;
		
		if(wort.length() >= 2 && WortEintrag.checkURL(url)) {
			WortEintrag[] clonArr = new WortEintrag[length + 1];
			for(int i = 0; i < length - 1; i++) {
				clonArr[i] = eintraege[i];
			}
			clonArr[length - 1] = new WortEintrag(wort, url);
			eintraege = clonArr;
		} else {
			throw new IllegalArgumentException("Die Parameter sind nicht g�ltig.");
		}
		
	}
	
	public WortEintrag getWortAt(int idx) {
		return this.eintraege[idx];
	}
	
	public boolean deleteWord(String wort) {
		if(wort.length() < 2) {
			throw new IllegalArgumentException("Wort ist zu kurz.");
		}
		int rmvIdx;
		for(int i = 0; i < this.eintraege.length; i++) {
			if(this.eintraege[i].getWort().equals(wort)) {
				rmvIdx = i;
			
				WortEintrag[] clon = new WortEintrag[this.eintraege.length - 1];
				for(int j = 0, k=0; j < clon.length; j++, k++) {
					if(j == rmvIdx) {
						continue;
					}
					clon[k] = this.eintraege[j];
				}
				this.eintraege = clon;
				return true;
			}
		}
		return false;
	}
	
	public WortEintrag[] getEintraege() {
		return eintraege;
	}


	public void setEintraege(WortEintrag[] eintraege) {
		this.eintraege = eintraege;
	}


	@Override
	public String toString() {
		String s = "";
		for(int i = 0; i < this.eintraege.length; i++) {
			s += this.eintraege[i] + "\n";
		}
		return s;
	}
	public int length() {
		return this.eintraege.length;
	}
}

