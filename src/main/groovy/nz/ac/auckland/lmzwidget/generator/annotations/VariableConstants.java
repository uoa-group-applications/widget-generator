package nz.ac.auckland.lmzwidget.generator.annotations;

/**
 * @author Marnix Cook
 *
 * Contains all the constants related to the Variable annotation
 */
public interface VariableConstants {

    static final String EMPTY_STRING = "";
    static final Option[] NO_OPTIONS = new Option[0];

    static interface Pattern {
        public final static String EMAIL = "email";
        public final static String URL = "url";
    }

    static interface Type {
        public final static String DROPDOWN = "dropdown";
        public final static String TEXTAREA = "textarea";
    }
}
