package nz.ac.auckland.lmzwidget.generator.annotations

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy;

/**
 * @author Marnix Cook
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Option {

    String key();
    String value();

    ;

}
