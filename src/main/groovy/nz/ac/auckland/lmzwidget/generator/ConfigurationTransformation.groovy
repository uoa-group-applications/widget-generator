package nz.ac.auckland.lmzwidget.generator

import nz.ac.auckland.lmzwidget.configuration.model.WidgetConfiguration
import nz.ac.auckland.lmzwidget.generator.annotations.Widget
import nz.ac.auckland.lmzwidget.generator.builders.WidgetConfigurationBuilder
import nz.ac.auckland.lmzwidget.generator.builders.WidgetMetadataBuilder

import java.lang.annotation.Annotation

/**
 * @author Marnix Cook
 *
 * This class is able to transform a @Widget annotated class into a
 * WidgetConfiguration class instance.
 */
public class ConfigurationTransformation {

    /**
     * Config builder instance
     */
    private WidgetConfigurationBuilder configBuilder = new WidgetConfigurationBuilder();

    /**
     * Metadata builder instance
     */
    private WidgetMetadataBuilder metadataBuilder = new WidgetMetadataBuilder();

    /**
     * Metadata builder instance
     */
    private ConfigurationQuery query = new ConfigurationQuery();


    /**
     * Transform a class to a WidgetConfiguration instance
     *
     * @param widgetClass
     * @return
     */
    public WidgetConfiguration transform(Class<?> widgetClass) {

        Widget annotation = query.findWidgetAnnotation(widgetClass)
        if (!annotation) {
            throw new IllegalArgumentException("The class is not a widget annotated class")
        }

        WidgetConfiguration config = new WidgetConfiguration();
        config.setWidget(metadataBuilder.build(annotation))
        config.setConfiguration(configBuilder.build(annotation))
        return config
    }


    void setMetadataBuilder(WidgetMetadataBuilder metadataBuilder) {
        this.metadataBuilder = metadataBuilder
    }

    void setItemBuilder(WidgetConfigurationBuilder itemBuilder) {
        this.configBuilder = itemBuilder
    }

    void setQuery(ConfigurationQuery query) {
        this.query = query;
    }
}
