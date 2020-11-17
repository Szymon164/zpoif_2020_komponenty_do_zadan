package pl.edu.pw.mini.zpoif.graded.fourth.generator;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import pl.edu.pw.mini.zpoif.graded.fourth.auta.Samochod;

public interface Strumienie {
	
	Samochod getNajdluzszySamochod();
	Samochod getSamochodONajmniejszejSzerokosci();
	Samochod getNajlzejszySamochodWloski();
	List<Samochod> getCoNajwyzej3ZSamochodowMieszczacychSieWGarazu();
	Set<Samochod> getSamochodyPosortowaneMalejacoWzgledemMasyPomniejszonejOSumeWymiarow();
	
	List<Samochod> getSamochodyNieLzejszeNiz1000KgINieSzerszeNiz170();
	List<Samochod> getPierwszePiecZPosortowanychMalejacoSNWzglWysok();
	long getSumaSzerokosciSamochodowJaponskichNieCiezszychNiz1000kgBezDwochPierwszych();
	
	List<Samochod> getCoNajwyzej4ZPosortowanychMalejacoWzglMasyPoczawszyOd10tego();
	Map<String, Samochod> mapujModelNaSamochodTylkoWloskie(); 
	Collection<Integer> getJaponskieSamochodyZamienioneNaWartosciIchMasy();
	
}
