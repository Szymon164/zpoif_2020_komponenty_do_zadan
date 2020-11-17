package pl.edu.pw.mini.zpoif.fifth.elevator.adnotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface MaksymalnaPredkosc {

    Predkosc maksymalnaPredkosc();

    enum Predkosc{
        SLOW, FAST
    }
}
