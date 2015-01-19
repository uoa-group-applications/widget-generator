package nz.ac.auckland.lmzwidget.generator.builders

import nz.ac.auckland.lmzwidget.configuration.model.WidgetConfiguration
import nz.ac.auckland.lmzwidget.generator.annotations.Widget

/**
 * @author Marnix Cook
 *
 * This builder is able to build the complete widget configuration from a widget annotated class
 */
class WidgetBuilder {

    private WidgetConfigurationBuilder configBuilder = new WidgetConfigurationBuilder();
    private WidgetMetadataBuilder metadataBuilder = new WidgetMetadataBuilder();

    /**
     * Build the complete widget configuration
     *
     * @param clazz is the class
     * @return
     */
    public WidgetConfiguration build(Class<?> clazz) {
        if (!clazz) {
            throw new IllegalArgumentException("`clazz` cannot be null")
        }

        if (!widget) {
            throw new IllegalArgumentException("Class must have @Widget annotation");
        }

    }

    void setConfigBuilder(WidgetConfigurationBuilder configBuilder) {
        this.configBuilder = configBuilder
    }

    void setMetadataBuilder(WidgetMetadataBuilder metadataBuilder) {
        this.metadataBuilder = metadataBuilder
    }
}
