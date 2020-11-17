package pl.edu.pw.mini.zpoif.graded.fourth.generator;

import pl.edu.pw.mini.zpoif.graded.fourth.auta.Samochod;
import pl.edu.pw.mini.zpoif.graded.fourth.auta.SamochodJaponski;
import pl.edu.pw.mini.zpoif.graded.fourth.auta.SamochodNiemiecki;
import pl.edu.pw.mini.zpoif.graded.fourth.auta.SamochodWloski;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StrumienieImpl implements Strumienie {

    private List<Samochod> cars;

    public StrumienieImpl(List<Samochod> cars) {
        Objects.requireNonNull(cars);
        this.cars = cars;
    }

    @Override
    public Samochod getNajdluzszySamochod() {
        return cars.stream().max(Comparator.comparingInt(Samochod::getDlogosc)).orElse(null);
    }

    @Override
    public Samochod getSamochodONajmniejszejSzerokosci() {
        return cars.stream().min(Comparator.comparingInt(Samochod::getSzerokosc)).orElse(null);
    }

    @Override
    public Samochod getNajlzejszySamochodWloski() {
        return cars.stream().filter(s -> s instanceof SamochodWloski).min(Comparator.comparingInt(Samochod::getMasaWlasna)).orElse(null);
    }

    @Override
    public List<Samochod> getCoNajwyzej3ZSamochodowMieszczacychSieWGarazu() {
        return cars.stream().filter(s -> s.getDlogosc() < 500 && s.getSzerokosc() < 160 && s.getWysokosc() < 150).limit(3).collect(Collectors.toList());
    }

    @Override
    public Set<Samochod> getSamochodyPosortowaneMalejacoWzgledemMasyPomniejszonejOSumeWymiarow() {
        Function<Samochod, Integer> v = s -> s.getMasaWlasna() - (s.getWysokosc() + s.getSzerokosc() + s.getDlogosc());
        return cars.stream().sorted((a,b) -> v.apply(b).compareTo(v.apply(a))).collect(Collectors.toCollection(() -> new TreeSet<>((a,b) -> v.apply(b).compareTo(v.apply(a)))));
    }

    @Override
    public List<Samochod> getSamochodyNieLzejszeNiz1000KgINieSzerszeNiz170() {
        return cars.stream().filter(c -> c.getMasaWlasna() >= 1000 && c.getSzerokosc() <= 170).collect(Collectors.toList());
    }

    @Override
    public List<Samochod> getPierwszePiecZPosortowanychMalejacoSNWzglWysok() {
        return cars.stream().filter(s -> s instanceof SamochodNiemiecki).sorted(Comparator.comparing(Samochod::getWysokosc).reversed()).limit(5).collect(Collectors.toList());
    }

    @Override
    public long getSumaSzerokosciSamochodowJaponskichNieCiezszychNiz1000kgBezDwochPierwszych() {
        return cars.stream().filter(s -> s instanceof  SamochodJaponski).filter(s -> s.getMasaWlasna() <= 1000).skip(2).mapToInt(Samochod::getSzerokosc).sum();
    }

    @Override
    public List<Samochod> getCoNajwyzej4ZPosortowanychMalejacoWzglMasyPoczawszyOd10tego() {
        return cars.stream().skip(5).sorted(Comparator.comparing(Samochod::getMasaWlasna).reversed()).limit(4).collect(Collectors.toList());
    }

    @Override
    public Map<String, Samochod> mapujModelNaSamochodTylkoWloskie() {
        return cars.stream().filter(s -> s instanceof SamochodWloski)
                .collect(Collectors.groupingBy(Samochod::getMarka, Collectors.collectingAndThen(Collectors.toList(),
                                                                                                list -> list.size() > 0 ? list.get(0) : null)));
    }

    @Override
    public Collection<Integer> getJaponskieSamochodyZamienioneNaWartosciIchMasy() {
        return cars.stream().filter(s -> s instanceof SamochodJaponski).mapToInt(Samochod::getMasaWlasna).boxed().collect(Collectors.toList());
    }
}
