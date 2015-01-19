package nz.ac.auckland.lmzwidget.generator.annotations

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Target;

/**
 * @author Marnix Cook
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Widget {

    String name();
    String description();
    Class<?> configuration();
    String[] groupOrder () default [];

    ;

}
