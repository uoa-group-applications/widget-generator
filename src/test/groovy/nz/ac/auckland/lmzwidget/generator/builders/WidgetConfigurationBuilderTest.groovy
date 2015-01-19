package nz.ac.auckland.lmzwidget.generator.builders

import com.fasterxml.jackson.databind.ObjectMapper
import nz.ac.auckland.lmzwidget.configuration.model.WidgetTab
import nz.ac.auckland.lmzwidget.generator.ConfigurationQuery
import nz.ac.auckland.lmzwidget.generator.mockwidget.MockWidget
import org.junit.Test

import static junit.framework.Assert.assertNotNull

/**
 * @author Marnix Cook
 *
 */
class WidgetConfigurationBuilderTest {

    @Test
    public void testTabsConfigurationBuilder() {

        Map<String, WidgetTab> tabs =
            new WidgetConfigurationBuilder().build(
                new ConfigurationQuery().findWidgetAnnotation(MockWidget)
            )

        StringWriter strWriter = new StringWriter();
        ObjectMapper map = new ObjectMapper();
        map.writeValue(strWriter, tabs);

        assertNotNull(tabs);
    }


    public void testWidgetConfigurationBuilder() {

    }
}
