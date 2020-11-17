package pl.edu.pw.mini.zpoif.fifth.solution;

import pl.edu.pw.mini.zpoif.fifth.elevator.MiNIWinda;
import pl.edu.pw.mini.zpoif.fifth.elevator.UniwersalnySterownikWindy;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Stream;

public class Demonstrator {

    public static void main(String[] args) throws Exception {
        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
        task7();
        task8(MiNIWinda.class);
        task9();
        task10();
        task13();
    }

    public static void task1() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class clazz = Class.forName("pl.edu.pw.mini.zpoif.fifth.elevator.MiNIWinda");
        MiNIWinda winda = (MiNIWinda) clazz.newInstance();
        System.out.println("winda = " + winda);
    }

    public static void task2() throws ClassNotFoundException {
        Class clazz = Class.forName("pl.edu.pw.mini.zpoif.fifth.elevator.MiNIWinda");
        Constructor[] constructors = clazz.getDeclaredConstructors();
        System.out.println("constructors.length = " + constructors.length);
        Constructor c = Stream.of(constructors).max((a,b) -> Integer.valueOf(a.getParameterCount()).compareTo(b.getParameterCount())).orElseGet(null);
        if (c == null) System.out.println("Klasa nie posiada konstruktowó");
        else {
            Stream.of(c.getParameters()).forEach(p -> System.out.println(p.getName() + " : " + p.getType().getTypeName()));
        }
    }

    public static void task3() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        Class clazz = Class.forName("pl.edu.pw.mini.zpoif.fifth.elevator.MiNIWinda");
        Object producent = clazz.getField("PRODUCENT").get(null);
        System.out.println("producent = " + producent);
    }

    public static void task4() throws IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchFieldException {
        Class clazz = Class.forName("pl.edu.pw.mini.zpoif.fifth.elevator.MiNIWinda");
        MiNIWinda winda = (MiNIWinda) clazz.newInstance();
        Field f = clazz.getDeclaredField("kolor");
        f.setAccessible(true);
        System.out.println("kolor = " + f.get(winda));
        f.setAccessible(false);
    }

    public static void task5() throws ClassNotFoundException {
        Class clazz = Class.forName("pl.edu.pw.mini.zpoif.fifth.elevator.MiNIWinda");
        Stream.of(clazz.getMethods()).filter(m -> clazz != m.getDeclaringClass())
                .map(m -> m.getName() + " : " + m.getDeclaringClass().getCanonicalName()).forEach(System.out::println);
    }

    public static void task6() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class clazz = Class.forName("pl.edu.pw.mini.zpoif.fifth.elevator.MiNIWinda");
        MiNIWinda winda = (MiNIWinda) clazz.newInstance();
        Field f = clazz.getDeclaredField("sterownikWindy");
        f.setAccessible(true);
        System.out.println("sterownikWindy class: " + f.get(winda).getClass().getSimpleName());
    }
    
    public static void task7() throws ClassNotFoundException {
        Class clazz = Class.forName("pl.edu.pw.mini.zpoif.fifth.elevator.MiNIWinda");
        Class superClazz = clazz.getSuperclass();
        Package p = superClazz.getPackage();
        System.out.println("p.getName() = " + p.getName());
    }

    public static void task8(Class clazz) {
        Class tmp = clazz;
        while((tmp = tmp.getSuperclass()) != null) {
            System.out.println(tmp.getSimpleName() + " : " + tmp.getMethods().length);
        }
    }

    public static void task9() throws IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchFieldException {
        Class clazz = Class.forName("pl.edu.pw.mini.zpoif.fifth.elevator.MiNIWinda");
        MiNIWinda winda = (MiNIWinda) clazz.newInstance();
        Field f = clazz.getDeclaredField("sterownikWindy");
        f.setAccessible(true);
        f.set(winda, UniwersalnySterownikWindy.class.newInstance());
        System.out.println("sterownikWindy class: " + f.get(winda).getClass()); // Print result
    }

    public static void task10() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        Class clazz = Class.forName("pl.edu.pw.mini.zpoif.fifth.elevator.MiNIWinda");
        MiNIWinda winda = (MiNIWinda) clazz.newInstance();
        Field fKabina = clazz.getDeclaredField("kabina");
        fKabina.setAccessible(true);
        Object kabina = fKabina.get(winda);
        Class kabinaClazz = kabina.getClass();
        Field fPanel = kabinaClazz.getDeclaredField("panelSterowniczy");
        fPanel.setAccessible(true);
        Object panel = fPanel.get(kabina);
        Field fSygnal = panel.getClass().getDeclaredField("sygnalPowitalny");
        fSygnal.setAccessible(true);
        fSygnal.set(panel, "Guten morgen!");
        Method m = panel.getClass().getDeclaredMethod("getSygnalPowitalny", String.class);
        m.setAccessible(true);
        m.invoke(panel, "");
    }

    private static void printAnnotations(Annotation[] an) {
        for(Annotation a:an){
            System.out.println(a.toString());
        }
    }

    public static void task13() throws ClassNotFoundException {
        Class clazz = Class.forName("pl.edu.pw.mini.zpoif.fifth.elevator.MiNIWinda");
        Method[] methods = clazz.getDeclaredMethods();
        Constructor[] constructors = clazz.getDeclaredConstructors();
        Field[] fields = clazz.getDeclaredFields();
        for(Method m:methods){
            Annotation[] annotations = m.getAnnotations();
            printAnnotations(annotations);
        }

        for(Field f:fields){
            Annotation[] annotations = f.getAnnotations();
            printAnnotations(annotations);
        }
    }
}
