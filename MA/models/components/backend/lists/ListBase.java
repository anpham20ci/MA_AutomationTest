package models.components.backend.lists;

import org.openqa.selenium.WebElement;
import page_model_base.PageModelBase;

import static helper_base.Helper.selectElement;

/**
 * Base class for list element
 */
public class ListBase extends PageModelBase {
    private   String _id;

    /**
     * Initialize a list by id of the list
     * @param id id of List. For example: "#user_type"
     */
    public ListBase(String id){
        this._id = id;
    }

    /**
     * Get current selected item
     * @return
     */
    public WebElement getSelectedItem(){
        return find(_id);
    }

    /**
     *Get displayed name of current selected item
     * @return
     */
    public String getSelected(){
        return getSelectedItem().getText();
    }

    /**
     * Get an item by displayed item name
     * @param name Displayed name
     * @return
     */
    public WebElement getItem(String name){
        return find(String.format("//select/option[text()='%s']", name));
    }

    /**
     * Get an item by xpath value
     * @param value Xpath value
     * @return
     */
    public WebElement getItemByValue(String value){
        return find(String.format("//select/option[@value='%s']", value));
    }

    /**
     * Select current list
     */
    public void selectList(){
        selectElement(getSelectedItem());
    }

    /**
     * Select an item by displayed item name
     * @param name Displayed name
     */
    public void selectItem(String name){
        selectList();
        selectElement(getItem(name));
    }

    /**
     * Select an item by Xpath value
     * @param value Xpath value
     */
    public void selectItemByValue(String value){
        selectList();
        selectElement(getItem(value));
    }
}
