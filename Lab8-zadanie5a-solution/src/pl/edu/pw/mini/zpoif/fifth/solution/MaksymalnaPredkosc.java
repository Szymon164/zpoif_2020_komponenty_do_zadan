package pl.edu.pw.mini.zpoif.fifth.solution;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.CLASS)
public @interface MaksymalnaPredkosc {
    int maksymalnaPredkosc();
}
