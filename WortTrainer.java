package model;
public class WortTrainer {
	private WortListe obj;
	private WortEintrag currWortEintrag;
	int richtig;
	int eingaben;
	
	public WortTrainer(WortListe list) {
		this.obj = list;
		richtig = 0;
		eingaben = 0;
	}
	
	public WortEintrag getRandomEintrag() {
		int max = this.obj.getWortEintraege().length;
		int idx = (int) Math.random() * (max + 1);
		this.currWortEintrag = this.obj.getWortAt(idx);
		return obj.getWortAt(idx);
	}
	
	public WortEintrag getCurrWortEintrag() {
		return this.currWortEintrag;
	}
	
	public boolean check(String wort) {
		eingaben++;
		if(wort.equals(this.currWortEintrag.getWort())) {
			richtig++;
			return true;
		}
		return false;
	}
	
	public void setCurrWortEintrag(WortEintrag currWortEintrag) {
		this.currWortEintrag = currWortEintrag;
	}

	public boolean checkIgnoreCase(String wort) {
		eingaben++;
		if(wort.equalsIgnoreCase(this.currWortEintrag.getWort())) {
			richtig++;
			return true;
		}
		return false;
	}

	public WortListe getObj() {
		return obj;
	}

	public void setObj(WortListe obj) {
		this.obj = obj;
	}

	public int getRichtig() {
		return richtig;
	}

	public void setRichtig(int richtig) {
		this.richtig = richtig;
	}

	public int getEingaben() {
		return eingaben;
	}

	public void setEingaben(int eingaben) {
		this.eingaben = eingaben;
	}
	
	
}
