package nz.ac.auckland.lmzwidget.generator.builders

import nz.ac.auckland.lmzwidget.configuration.model.WidgetMetadata
import nz.ac.auckland.lmzwidget.generator.annotations.Widget

/**
 * @author Marnix Cook
 *
 * Builds the metadata instance based on the Widget annotation it is passed
 */
class WidgetMetadataBuilder {

    /**
     * @return the widget metadata instance for the information in the widget annotation instance
     */
    public WidgetMetadata build(Widget widgetAnnotation) {
        if (!widgetAnnotation) {
            throw new IllegalArgumentException("Widget annotation not provided")
        }

        return [
            name : widgetAnnotation.name(),
            description : widgetAnnotation.description(),
            version : "Unknown"
        ] as WidgetMetadata
    }

}
