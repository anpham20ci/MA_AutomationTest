package models.views.backend;

import models.components.backend.lists.ProfileList;
import org.openqa.selenium.WebElement;
import page_model_base.PageModelBase;

import java.util.List;

import static helper_base.Helper.selectElement;

/**
 *Share common things between backend page views
 */
public class BackendPageModelBase extends PageModelBase {
    /**
     * Form title for each page
     *
     * @return
     */
    public WebElement getTitle() {
        return find("//div[@class='breadcrumb-dn mr-auto']/p");
    }

    /**
     * Profile list at the right top
     * @return
     */
    public static ProfileList getProfileList(){
        return new ProfileList();
    }

    /**
     * Submit/Create button
     *
     * @return
     */
    public WebElement getSubmitBtn() {
        return find("//button[@type='submit']");
    }

    /**
     * Cancel button
     *
     * @return
     */
    public WebElement getCancelBtn() {
        return find("//a[text()='Cancel']");
    }

    //<editor-fold desc="Search area">

    /**
     * Search button
     *
     * @return
     */
    public WebElement getSearchBtn() {
        return find("//i[@class='fas fa-search']//parent::button");
    }

    /**
     * Clear search button
     *
     * @return
     */
    public WebElement getClearBtn() {
        return find("//i[@class='fas fa-eraser']//parent::a");
    }
    //</editor-fold>

    //<editor-fold desc="Table view">

    /**
     * Get displaying item label
     * For example: "Displaying accounts 1 - 12 of 12 in total" in View Admins page
     *
     * @return
     */
    public WebElement getDisplayingItem() {
        return find("//div[@class='table-responsive']/div");
    }

    /**
     * Get all elements of a column in table view by column order
     * For example: To get all the Name elements (the second column), call getColumn(2)
     * @param order Column order. Starts from 1
     * @return
     */
    public List<WebElement> getColumn(int order) {
        return findMany(String.format("//div[@class='table-responsive']//tr/td[%d]", order));
    }

    /**
     * Get all elements of a column in table view by column header name
     * @param header Column header name
     * @return
     */
    public List<WebElement> getColumn(String header){
        return findMany(String.format("//tbody/tr/td[count(//tr/th[.='%s']/preceding-sibling::th)+1]", header));
    }

    /**
     * Get element at a cell in table view
     *
     * @param row    Row order. Starts from 1, ignoring header row
     * @param column Column order. Starts from 1
     * @return
     */
    public WebElement getCell(int row, int column) {
        return find(String.format("(//div[@class='table-responsive']//tr)[%d]/td[%d]", row + 1, column));
    }
    //</editor-fold>

    //<editor-fold desc="Public methods">

    /**
     * Select Submit button
     */
    public void submit() {
        selectElement(getSubmitBtn());
    }

    /**
     * Select Cancel button
     */
    public void cancel() {
        selectElement(getCancelBtn());
    }

    /**
     * Select Search button
     */
    public void search(){
        selectElement(getSearchBtn());
    }

    /**
     * Get pageNumber navigation button by pageNumber number
     * @param pageNumber Page number (for example: "5") or First, Last for the first/last pageNumber
     * @return
     */
    public WebElement getPageBtn(String pageNumber){
        return find(String.format("//a[text()='%s']//parent::li[contains(@class,'pageNumber-item')]", pageNumber));
    }

    /**
     * Go to page by click on pageNumber navigation button
     * @param pageNumber Page number (for example: "5") or First, Last for the first/last pageNumber
     */
    public void openPageNumber(String pageNumber){
        selectElement(getPageBtn(pageNumber));
    }

    public void logout(){
        getProfileList().selectItem("Logout");
    }
    //</editor-fold>

}
