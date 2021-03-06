package pl.edu.pw.mini.zpoif.fifth.elevator.adnotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface WaznaAdnotacja {

    Stopien stopienWaznosci();

    enum Stopien {
        Wazny, Arcywazny, Kluczowy, Niewazny, Malo_istotny;
    }
}
