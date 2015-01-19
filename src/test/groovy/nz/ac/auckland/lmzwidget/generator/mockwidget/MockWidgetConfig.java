package nz.ac.auckland.lmzwidget.generator.mockwidget;

import nz.ac.auckland.lmzwidget.generator.annotations.Option;
import nz.ac.auckland.lmzwidget.generator.annotations.ExposeAs;
import nz.ac.auckland.lmzwidget.generator.annotations.VariableConstants;

/**
 * @author Marnix Cook
 */
public class MockWidgetConfig {

    @ExposeAs(
        label = "Number of items to show",
        description = "More specific title text that helps explain things better"
    )
    private Long numberOfItems = 10l;

    @ExposeAs(
        required = true,
        label = "Heading title"
    )
    private String title;

    @ExposeAs(
        label = "The teaser text",
        type = VariableConstants.Type.TEXTAREA
    )
    private String teaser;

    @ExposeAs(
            label = "Where to link to when 'more >' is pressed",
            pattern = VariableConstants.Pattern.URL
    )
    private String allItemsLink;

    @ExposeAs(
            label = "Who do we send an email?",
            pattern = "email"
    )
    private String recipientEmail;

    @ExposeAs(
            label = "Select one of these options",
            type = VariableConstants.Type.DROPDOWN,
            options = {
                @Option(key = "key", value = "value"),
                @Option(key = "key2", value = "value2")
            }
    )
    private String dropDown;

    @ExposeAs(
            label = "Are we supposed to be fancy?"
    )
    private Boolean fancyMode;


    public Long getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(Long numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTeaser() {
        return teaser;
    }

    public void setTeaser(String teaser) {
        this.teaser = teaser;
    }

    public String getAllItemsLink() {
        return allItemsLink;
    }

    public void setAllItemsLink(String allItemsLink) {
        this.allItemsLink = allItemsLink;
    }

    public String getRecipientEmail() {
        return recipientEmail;
    }

    public void setRecipientEmail(String recipientEmail) {
        this.recipientEmail = recipientEmail;
    }

    public String getDropdown() {
        return dropDown;
    }

    public void setDropdown(String dropDown) {
        this.dropDown = dropDown;
    }

    public Boolean getFancyMode() {
        return fancyMode;
    }

    public void setFancyMode(Boolean fancyMode) {
        this.fancyMode = fancyMode;
    }
}
