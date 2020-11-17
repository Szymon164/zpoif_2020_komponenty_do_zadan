package pl.edu.pw.mini.zpoif.zadanieoceniane.strumienie.rozwiazanie;

import java.util.List;
import java.util.Map;
import java.util.Set;

import pl.edu.pw.mini.zpoif.zadanieoceniane.strumienie.statkipowietrzne.*;

public interface Strumienie {
	
	StatekPowietrzny getNajlzejszyStatekPowietrzny();
	
	StatekPowietrzny getNajciezszySmiglowiec();
	Smiglowiec getSmiglowiecONajmniejszymWirniku();
	
	Set<StatekPowietrzny> getSamolotyLatajaceWyzejNiz19000M();
	List<NapedzanyStatekPowietrzny> getPosortowane();
	Szybowiec getSzybowiecONajwiekszejDoskonalosciINajnizszejMasie();
	
	Map<String, StatekPowietrzny> getSamolotyOPowierzchniNosniejWiekszejNiz20();
	int getSumeDoskonalosciSzybowcowOMasieWiekszejNiz350PoczOdDrugiego();
	List<StatekPowietrzny> getPierwszePiecSamolotowLubSpadochronowPosortowanychMalejacoPoMasiePoczOd2();
	Map<Integer, Spadochron> getMapeSpadochronowODopMasieSkoczkaWiekszejNiz85IgnorujDuplikaty();
	void zmienNazwyTypowWZaleznosciOdPierwszychElementow();
	
}
