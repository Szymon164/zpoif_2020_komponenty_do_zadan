package pl.edu.pw.mini.zpoif.fifth.solution;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
public @interface WaznyElement {
    public enum StopienWaznosci {
        WAZNY, ARCYWAZNY, KLUCZOWY
    }

    StopienWaznosci stopienWaznosci();

}
