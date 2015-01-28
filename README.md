# Widget generator

This artifact is used in conjunction with the `widget-configuration-model` artifact. 

The generator contains a number of annotations that can be used to decorate fields on a POJO. Then, the parser class is able to parse the POJOs and generate a configuration model with them. 

The annotations that are exposed are as follows:

||Annotation||Description||
|`@Widget`| \
This annotation is expected to be used on a class that implements the `WidgetStencil` interface. It contains information about the name of the widget, and which POJO is used to convey its configuration information. For an example on how to use the `WidgetStencil` class, please refer to the lmzwidget artifact.|
|`@ExposeAs`| \
This annotation is used on fields in the POJO. It contains information about its type, any regexp validation, whether it's required or not etc. |
| `@Option` | \
The option annotation contains key/value pairs for types that are exposed as lists. |


Below you can find an example of a configuration POJO:

	class PrototypeWidgetConfiguration {

		@ExposeAs(
			label = "Title",
			description = "This is title that is being displayed",
			required = true
		)
		String title;

		@ExposeAs(
			label = "Teaser description",
			description = "The teaser text shown in the widget",
			type = VariableConstants.Type.TEXTAREA
		)
		String teaser;

		@ExposeAs(
			label = "Links to",
			pattern = VariableConstants.Pattern.URL
		)
		String moreLink;

		@ExposeAs(
			label = "Count up to",
			required = true,
			group = "Counter"
		)
		Long countTo;

		@ExposeAs(
			label = "Text to count with",
			required = true,
			group = "Counter"
		)
		String countToText;

	}

