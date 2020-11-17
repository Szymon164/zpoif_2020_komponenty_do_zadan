package pl.edu.pw.mini.zpoif.fifth.elevator;

import pl.edu.pw.mini.zpoif.fifth.elevator.adnotations.DomyslneWartosciBezpiecznika;

public class BezpiecznikZasilania {
	
	private int amperaz = 20;
	private Stan stan = Stan.ROZLACZONY;

	@DomyslneWartosciBezpiecznika
	public BezpiecznikZasilania(int amperaz, Stan stan) {
		super();
		this.amperaz = amperaz;
		this.stan = stan;
	}

	public enum Stan {
		WLACZONY, ROZLACZONY
	}
	
	public void wlacz() {
		stan = Stan.WLACZONY;
	}
	
	public void wylacz() {
		stan = Stan.ROZLACZONY;
	}
	
}
