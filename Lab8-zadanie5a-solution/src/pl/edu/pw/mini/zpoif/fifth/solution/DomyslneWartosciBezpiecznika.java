package pl.edu.pw.mini.zpoif.fifth.solution;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.CONSTRUCTOR)
@Retention(RetentionPolicy.RUNTIME)
public @interface DomyslneWartosciBezpiecznika {
    public enum Stan {
        WLACZONY, WYLACZONY
    }

    int amperaz() default 30;
    Stan stan() default Stan.WLACZONY;
}
