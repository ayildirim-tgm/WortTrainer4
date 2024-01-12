package model;
import java.net.URL;
import java.net.URISyntaxException;
import java.net.MalformedURLException;
/**
 * Speichert ein Wort und ein URL ab
 * @author Aran Yildirim
 * @version 2022-09-27
 */
public class WortEintrag {
	private String wort;
	private String URL;

	/**
	 * Konstruktor f�r den WortEintrag
	 * @param wort abgespeichertes Wort
	 * @param URL abgespeicherte URL
	 */
	public WortEintrag ( String wort, String URL ) {
		this.setWort(wort);
		this.setURL(URL);
	}
	/**
	 * Setzt das Wort des Worteintrags
	 * @param wort abgespeichertes Wort
	 */
	public void setWort( String wort ) {
		if( wort.length() < 2) {
			throw new IllegalArgumentException("Zu kurz");
		}
		this.wort = wort;
	}
	/**
	 * Setzt die URL des Worteintrags
	 * @param url abgespeicherte URL
	 */
	public void setURL( String url ) {
		if( checkURL(url) ) {
			this.URL = url;
		} 
		else {
			throw new IllegalArgumentException( "Die URL ist nicht richtig." );
		}
	}
	/**
	 * Returned das abgespeicherte Wort
	 * @return das abgespeicherte Wort
	 */
	public String getWort() {
		return this.wort;
	}
	/**
	 * Returned die abgespeicherte URL
	 * @return die abgespeicherte URL
	 */
	public String getUrl() {
		return this.URL;
	}
	/**
	 * �berpr�ft ob die URL valid ist
	 * @param url die URL die �berpr�ft werden soll
	 * @return gibt zur�ck ob die URL valid ist
	 */
	public static boolean checkURL( String url ) {
		try {
			new URL(url).toURI();
			return true;
		} catch ( URISyntaxException | MalformedURLException e ) {
			System.err.println(e);
			return false;
		}
	}
	
	@Override
	public String toString() {
		return this.wort + "; " + this.URL;
	}
	
}