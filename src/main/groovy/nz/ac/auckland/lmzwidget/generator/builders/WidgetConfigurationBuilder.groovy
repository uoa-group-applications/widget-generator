package nz.ac.auckland.lmzwidget.generator.builders

import nz.ac.auckland.lmzwidget.configuration.model.WidgetItem
import nz.ac.auckland.lmzwidget.configuration.model.WidgetTab
import nz.ac.auckland.lmzwidget.generator.ConfigurationQuery
import nz.ac.auckland.lmzwidget.generator.annotations.Option
import nz.ac.auckland.lmzwidget.generator.annotations.ExposeAs
import nz.ac.auckland.lmzwidget.generator.annotations.Widget

import java.lang.reflect.Field
import java.lang.reflect.Method

/**
 * @author Marnix Cook
 *
 * This class constructs the widget configuration instances for a specific widget definition
 */
class WidgetConfigurationBuilder {

    /**
     * Query functionality
     */
    private ConfigurationQuery query = new ConfigurationQuery();

    /**
     * Build a map of widget tabs based on the configuration class that was specified in the
     *
     * @param widget
     * @return
     */
    public Map<String, WidgetTab> build(Widget widget) {
        Class<?> configClass = widget.configuration();

        // get suitable configuration methods
        List<Field> configurationFields = query.getConfigurationFields(configClass)

        // map items into a list of widget items
        List<WidgetItem> items = mapFieldsToWidgetItems(configurationFields, widget)

        // separate items out into
        return separateIntoTabs(widget, items);
    }

    /**
     * @param widgetAnnotation
     */
    protected List<Method> mapFieldsToWidgetItems(List<Field> configurationFields, Widget widgetAnnotation) {
        return configurationFields.collect { Field configField ->
            return buildWidgetItem(widgetAnnotation, configField)
        }
    }

    /**
     * This method grabs a list of items and turns it into a map of widget tabs based
     * on the group the widget items are part of.
     *
     * @param widget is the annotated widget we're interacting with
     * @param items is the list of widget items
     *
     * @return a map
     */
    protected Map<String, WidgetTab> separateIntoTabs(Widget widget, List<WidgetItem> items) {
        // find all groups
        Set<String> groupNames =
                items.collect { WidgetItem item ->
                    return item.group
                }.unique()

        Map<String, WidgetTab> tabs = [:]
        groupNames.eachWithIndex { String name, int index ->

            Map<String, WidgetTab> mappedItems = [:]

            List<WidgetItem> itemsInGroup = items.findAll { WidgetItem item -> return item.group == name}
            itemsInGroup.each { WidgetItem item -> mappedItems[item.name] = item}

            // assign to tab
            tabs["tab" + index] = new WidgetTab(label: name, items: mappedItems)

        }

        return tabs
    }

    /**
     * @return the model class for the configuration method'svairable annotation
     */
    protected WidgetItem buildWidgetItem(Widget widget, Field configField) {
        ExposeAs var = query.getVariableAnnotationFor(configField)

        // can't find an annotation?
        if (!var) {
            return null
        }

        // instantiate a new configuration instance to get default values
        def configInstance = widget.configuration().newInstance()

        WidgetItem item = new WidgetItem();

        item.name = configField.name;
        item.type = getTypeFor(configField.getType(), var.type())
        item.label = var.label()
        item.description = var.description()
        item.required = var.required()
        item.group = var.group()

        if (configField.getType() != String && var.type()) {
            throw new IllegalStateException("@Variables cannot define the 'type' parameter when they are not String type")
        }

        if (item.type == "dropdown") {
            item.options = extractOptions(var)
        }

        // has pattern?
        if (var.pattern()) {
            if (configField.getType() != String) {
                throw new IllegalStateException("@Variable cannot define pattern if type is not String")
            }
            item.pattern = var.pattern()
        }

        // get the default value
        item.defaultValue = configInstance[configField.getName()]

        return item
    }

    /**
     * @return a mapified version of the option annotations list
     */
    protected Map<String, String> extractOptions(ExposeAs var) {
        Map<String, String> mappedOptions = [:]
        var.options().each { Option option ->
            mappedOptions[option.key()] = option.value()
        }
        return mappedOptions
    }

    /**
     * This method determines the type for the variable that is being processed. The String
     * type has the ability to override something.
     *
     * @param classType
     * @param overrideType
     * @return
     */
    protected String getTypeFor(Class<?> classType, String overrideType) {
        if (classType == Long) {
            return "number"
        } else if (classType == Boolean) {
            return "bool";
        } else if (overrideType in ['textarea', 'dropdown'] && classType == String) {
            return overrideType
        } else {
            return "string"
        }
    }

    void setQuery(ConfigurationQuery query) {
        this.query = query
    }
}
