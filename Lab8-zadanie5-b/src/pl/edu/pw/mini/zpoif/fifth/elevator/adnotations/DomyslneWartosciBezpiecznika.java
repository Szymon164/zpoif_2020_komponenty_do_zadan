package pl.edu.pw.mini.zpoif.fifth.elevator.adnotations;

import pl.edu.pw.mini.zpoif.fifth.elevator.BezpiecznikZasilania;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.CONSTRUCTOR)
@Retention(RetentionPolicy.RUNTIME)
public @interface DomyslneWartosciBezpiecznika {
    int amperaz() default 30;
    BezpiecznikZasilania.Stan stan() default BezpiecznikZasilania.Stan.WLACZONY;
}
