package nz.ac.auckland.lmzwidget.generator

import nz.ac.auckland.lmzwidget.generator.mockwidget.MockWidget;
import nz.ac.auckland.lmzwidget.generator.mockwidget.MockWidgetConfig;
import org.junit.Test

import java.lang.reflect.Field
import java.lang.reflect.Method;

import static org.junit.Assert.*;

/**
 * Some tests for most important 'query' related methods
 */
public class ConfigurationQueryTest {

    @Test
    public void testGettingGetters() {
        List<Field> fields = new ConfigurationQuery().getConfigurationFields(MockWidgetConfig);

        assertNotNull(fields);
        assertEquals(7, fields.size());
    }


    @Test
    public void testFindWidgetAnnotation() {
        assertNotNull(new ConfigurationQuery().findWidgetAnnotation(MockWidget));
    }


}