package pl.edu.pw.mini.zpoif.fifth.elevator;

import pl.edu.pw.mini.zpoif.fifth.elevator.BezpiecznikZasilania.Stan;
import pl.edu.pw.mini.zpoif.fifth.solution.MaksymalnaPredkosc;
import pl.edu.pw.mini.zpoif.fifth.solution.WaznyElement;

public class MiNIWinda extends Winda {
	
	public static final String PRODUCENT = "Windex sp. z o.o.";

	@WaznyElement(stopienWaznosci = WaznyElement.StopienWaznosci.WAZNY)
	protected Kolor kolor;
	protected SterownikWindy sterownikWindy;
	@WaznyElement(stopienWaznosci = WaznyElement.StopienWaznosci.KLUCZOWY)
	protected Integer dopuszczalnaIloscOsob;
	
	private Naped naped = new Naped();
	private Kabina kabina = new Kabina();
	private SzybWindy szybWindy = new SzybWindy();
	
	public enum Kolor {
		ZIELONY, BIALY, NIEBIESKI;
	}
	
	public MiNIWinda() {
		this.kolor = Kolor.ZIELONY;
		this.sterownikWindy = new DedykowanySterownikDoWindy();
		this.dopuszczalnaIloscOsob = 10;
	}
	
	private MiNIWinda(Kolor kolor, SterownikWindy sterownikWindy) {
		this.kolor = kolor;
		this.sterownikWindy = sterownikWindy;
	}
	
	public MiNIWinda(Kolor kolor, SterownikWindy sterownikWindy, Integer dopuszczalnaIloscOsob, Naped naped) {
		this(kolor, sterownikWindy);
		this.dopuszczalnaIloscOsob = dopuszczalnaIloscOsob;
		this.naped = naped;
	}

	private class DedykowanySterownikDoWindy extends SterownikWindy {
		
	}
	
	private class SzybWindy{
		private Kabina kabina;
		private BezpiecznikZasilania bezpiecznikZasilania = new BezpiecznikZasilania(20, Stan.ROZLACZONY);
	}
	
	private class Kabina {
		
		private PanelSterowniczy panelSterowniczy = new PanelSterowniczy();
		
		private class PanelSterowniczy {
			
			private String sygnalPowitalny = "Hello";
			
			public void getSygnalPowitalny(String prefix) {
				System.out.println(prefix + " " + sygnalPowitalny);
			}
			
		}
		
	}

	@Override
	@WaznyElement(stopienWaznosci = WaznyElement.StopienWaznosci.ARCYWAZNY)
	protected void jedzDoGory(@MaksymalnaPredkosc(maksymalnaPredkosc = 5) int predkosc) {
		System.out.println("Jade do gory z predkoscia: " + predkosc);
	}

	@Override
	@WaznyElement(stopienWaznosci = WaznyElement.StopienWaznosci.ARCYWAZNY)
	protected void jedzNaDol(@MaksymalnaPredkosc(maksymalnaPredkosc = 6) int predkosc) {
		System.out.println("Jade do gory z predkoscia: "  + predkosc);
	}
	
}
