package pl.edu.pw.mini.zpoif.graded.fourth;

import org.junit.Assert;
import org.junit.Test;
import pl.edu.pw.mini.zpoif.graded.fourth.auta.Samochod;
import pl.edu.pw.mini.zpoif.graded.fourth.auta.SamochodWloski;
import pl.edu.pw.mini.zpoif.graded.fourth.generator.GeneratorSamochodow;
import pl.edu.pw.mini.zpoif.graded.fourth.generator.StrumienieImpl;
import java.util.*;
import java.util.function.Function;

public class Demostrator {

    @Test
    public void test1(){
        List<Samochod> lista = GeneratorSamochodow.generateAll();
        StrumienieImpl str = new StrumienieImpl(lista);
        Assert.assertEquals(lista.get(7), str.getNajdluzszySamochod());
    }

    @Test
    public void test2(){
        List<Samochod> lista = GeneratorSamochodow.generateAll();
        StrumienieImpl str = new StrumienieImpl(lista);
        Assert.assertEquals(lista.get(11), str.getSamochodONajmniejszejSzerokosci());
    }

    @Test
    public void test3(){
        List<Samochod> lista = GeneratorSamochodow.generateAll();
        StrumienieImpl str = new StrumienieImpl(lista);
        Assert.assertEquals(lista.get(15), str.getNajlzejszySamochodWloski());
    }

    @Test
    public void test4(){
        List<Samochod> lista = GeneratorSamochodow.generateAll();
        StrumienieImpl str = new StrumienieImpl(lista);
        List<Samochod> out = str.getCoNajwyzej3ZSamochodowMieszczacychSieWGarazu();
        Assert.assertTrue(out != null && out.size() <= 3);
        out.forEach(s -> Assert.assertTrue(s.getDlogosc() < 500 && s.getSzerokosc() <160 && s.getWysokosc() < 150));
    }

    @Test
    public void test5(){
        List<Samochod> lista = GeneratorSamochodow.generateAll();
        StrumienieImpl str = new StrumienieImpl(lista);
        Set<Samochod> out = str.getSamochodyPosortowaneMalejacoWzgledemMasyPomniejszonejOSumeWymiarow();
        Function<Samochod, Integer> v = s -> s.getMasaWlasna() - (s.getWysokosc() + s.getSzerokosc() + s.getDlogosc());
        Assert.assertTrue(out != null);
        Samochod last = null;
        for(Samochod s : out){
            Assert.assertTrue(last == null || v.apply(s) <= v.apply(last));
            last = s;
        }
    }

    @Test
    public void test6(){
        List<Samochod> lista = GeneratorSamochodow.generateAll();
        StrumienieImpl str = new StrumienieImpl(lista);
        List<Samochod> out = str.getSamochodyNieLzejszeNiz1000KgINieSzerszeNiz170();
        Assert.assertTrue(out != null);
        out.forEach(s -> Assert.assertTrue(s.getMasaWlasna() >= 1000 && s.getSzerokosc() <= 170));
    }

    @Test
    public void test7(){
        List<Samochod> lista = GeneratorSamochodow.generateAll();
        StrumienieImpl str = new StrumienieImpl(lista);
        List<Samochod> out = str.getPierwszePiecZPosortowanychMalejacoSNWzglWysok();
        Assert.assertTrue(out != null);
        Assert.assertEquals(lista.get(19), out.get(0));
        Assert.assertEquals(lista.get(18), out.get(1));
        Assert.assertEquals(lista.get(7), out.get(2));
        Assert.assertEquals(lista.get(12), out.get(3));
        Assert.assertEquals(lista.get(17), out.get(4));
    }

    @Test
    public void test8(){
        List<Samochod> lista = GeneratorSamochodow.generateAll();
        StrumienieImpl str = new StrumienieImpl(lista);
        Assert.assertEquals(0, str.getSumaSzerokosciSamochodowJaponskichNieCiezszychNiz1000kgBezDwochPierwszych());
    }

    @Test
    public void test9() {
        List<Samochod> lista = GeneratorSamochodow.generateAll();
        StrumienieImpl str = new StrumienieImpl(lista);
        List<Samochod> out = str.getCoNajwyzej4ZPosortowanychMalejacoWzglMasyPoczawszyOd10tego();
        Assert.assertTrue(out != null);
        Assert.assertTrue(out.size() <= 4);
        Samochod last = null;
        for(Samochod s : out){
            Assert.assertTrue(last == null || s.getMasaWlasna() <= last.getMasaWlasna());
            last = s;
        }
    }

    @Test
    public void test10(){
        List<Samochod> lista = GeneratorSamochodow.generateAll();
        StrumienieImpl str = new StrumienieImpl(lista);
        Map<String, Samochod> out = str.mapujModelNaSamochodTylkoWloskie();
        Assert.assertEquals(3, out.size());
        for(Map.Entry<String, Samochod> e : out.entrySet()){
            Assert.assertTrue(e.getValue() instanceof SamochodWloski);
            Assert.assertEquals(e.getKey(), e.getValue().getMarka());
        }
    }

    @Test
    public void test11(){
        List<Samochod> lista = GeneratorSamochodow.generateAll();
        StrumienieImpl str = new StrumienieImpl(lista);
        Collection<Integer> out = str.getJaponskieSamochodyZamienioneNaWartosciIchMasy();
        Assert.assertTrue(out.containsAll(Arrays.asList(900,1090,1185,1260,915,1050)));
        Assert.assertTrue(out.size() == 7 || (out instanceof Set && out.size() == 6));
    }
    
}
