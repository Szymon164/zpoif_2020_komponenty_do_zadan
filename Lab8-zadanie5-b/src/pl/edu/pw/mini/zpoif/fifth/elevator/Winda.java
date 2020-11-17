package pl.edu.pw.mini.zpoif.fifth.elevator;

public abstract class Winda {
	
	protected abstract void jedzDoGory(int predkosc);
	protected abstract void jedzNaDol(int predkosc);
	
	protected void logujFaktUruchomienia(boolean krotkiLog) {
		if(krotkiLog) {
			System.out.println("Start...");
		}else {
			System.out.println("Nasza winda startuje");
		}
	}
	
}
