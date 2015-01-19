package nz.ac.auckland.lmzwidget.generator.builders;

import nz.ac.auckland.lmzwidget.configuration.model.WidgetMetadata;
import nz.ac.auckland.lmzwidget.generator.ConfigurationQuery;
import nz.ac.auckland.lmzwidget.generator.ConfigurationTransformation;
import nz.ac.auckland.lmzwidget.generator.annotations.Widget;
import nz.ac.auckland.lmzwidget.generator.mockwidget.MockWidget;
import org.junit.Test;

import static org.junit.Assert.*;

public class WidgetMetadataBuilderTest {

    private ConfigurationQuery query = new ConfigurationQuery();
    private WidgetMetadataBuilder builder = new WidgetMetadataBuilder();

    @Test
    public void testBuild() throws Exception {
        Widget widget = query.findWidgetAnnotation(MockWidget.class);
        WidgetMetadata metadata = builder.build(widget);

        assertNotNull(metadata);
        assertEquals("Test widget", metadata.name)
        assertEquals("This is my widget", metadata.description)
    }
}