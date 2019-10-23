package models.components.backend.lists;

/**
 * Owner type list that appears in Create new client -> Client info tab
 */
public class OwnerList extends ListBase{

    /**
     * Initialize a list by id of the list
     *
     */
    public OwnerList() {
        super("//select[@name='admin_id']");
    }
}
