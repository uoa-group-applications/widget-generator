package nz.ac.auckland.lmzwidget.generator

import nz.ac.auckland.lmzwidget.generator.annotations.ExposeAs
import nz.ac.auckland.lmzwidget.generator.annotations.Widget

import java.lang.annotation.Annotation
import java.lang.reflect.Field

/**
 * @author Marnix Cook
 *
 */
class ConfigurationQuery {

    /**
     * @return the widget annotation for this class
     */
    public Widget findWidgetAnnotation(Class<?> widgetClass) {
        if (!widgetClass) {
            throw new IllegalArgumentException("No widget class instance provided")
        }

        Annotation rawAnnotation =
                widgetClass.declaredAnnotations.find { Annotation ann ->
                    ann.annotationType() == Widget
                }

        if (rawAnnotation) {
            return rawAnnotation as Widget
        }

        return null
    }

    /**
     *
     * @param configClass
     * @return
     */
    public List<Field> getConfigurationFields(Class<?> configClass) {
        return configClass.declaredFields.findAll { Field field ->
            return hasVariableAnnotation(field)
        }
    }


    /**
     * @return true if the variable annotation is present on this field
     */
    public boolean hasVariableAnnotation(Field field) {
        return getVariableAnnotationFor(field) != null
    }

    /**
     * @return the @Variable annotation instance for `method`
     */
    public ExposeAs getVariableAnnotationFor(Field field) {
        Annotation ann =
                field.declaredAnnotations.find { Annotation methodAnnotation ->
                    methodAnnotation.annotationType() == ExposeAs
                }

        return (ann ? ann as ExposeAs : null)
    }


}
