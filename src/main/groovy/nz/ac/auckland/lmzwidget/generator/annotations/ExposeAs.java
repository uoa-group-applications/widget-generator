package nz.ac.auckland.lmzwidget.generator.annotations;

import java.lang.annotation.*;

/**
 * @author Marnix Cook
 *
 * Variable annotation allow someone to add information about
 * configuration elements
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExposeAs {

    String label();
    boolean required() default false;
    String description() default VariableConstants.EMPTY_STRING;
    String pattern() default VariableConstants.EMPTY_STRING;
    String type() default VariableConstants.EMPTY_STRING;
    String group() default "Config";
    Option[] options() default {};

}
