package models.views.backend.users;

import models.views.backend.BackendPageModelBase;
import org.openqa.selenium.WebElement;

/**
 * Users -> Create new user -> Payment details tab view
 */
public class PaymentDetailsTabView extends BackendPageModelBase {
    public WebElement getInvoiceDescription(){
        return find("#user_invoice_description");
    }

    //<editor-fold desc="Allow future invoice">
    public WebElement getAllowFutureInvoiceCheckbox(){
        return find("//input[@id='profile_allow_future_invoice']/following-sibling::label");
    }

    //<editor-fold desc="For self-serving orders">
    public WebElement getForSelservingOrderCheckbox(){
        return find("//input[@id='profile_ss_price_cap']/following-sibling::label");
    }

    public WebElement getSelfServingPriceCaps(){
        return find("#profile_ss_price_cap_money");
    }

    public WebElement getSelfServingCapUsed(){
        return find("#profile_cap_used");
    }

    public WebElement getSelfServingPriceCapsRemain(){
        return find("#profile_cap_remain");
    }
    //</editor-fold>

    //<editor-fold desc="For missed leads orders">
    public WebElement getForMissedLeadsOrdersCheckbox(){
        return find("//input[@id='profile_missed_leads_price_cap']/following-sibling::label");
    }

    public WebElement getMissedLeadsPriceCaps(){
        return find("#profile_missed_leads_money");
    }

    public WebElement getMissedLeadsCapUsed(){
        return find("#profile_missed_cap_used");
    }

    public WebElement getMissedLeadsPriceCapsRemain(){
        return find("#profile_missed_cap_remain");
    }
    //</editor-fold>

    //<editor-fold desc="For self-serving and missed leads">
    public WebElement getForSelfServingAndMissedLeadsCheckbox(){
        return find("//input[@id='profile_for_both']/following-sibling::label");
    }

    public WebElement getForSelfServingAndMissedLeadsPriceCaps(){
        return find("#profile_for_both_money");
    }

    public WebElement getForSelfServingAndMissedLeadsCapUsed(){
        return find("#profile_for_both_cap_used");
    }

    public WebElement getForSelfServingAndMissedLeadsPriceCapsRemain(){
        return find("#profile_for_both_cap_remain");
    }
    //</editor-fold>
    //</editor-fold>

    //<editor-fold desc="Billing address">
    public WebElement getBillingFirstName(){
        return find("#billing_address_first_name");
    }

    public WebElement getBillingLastName(){
        return find("#billing_address_last_name");
    }

    public WebElement getBillingPostcode(){
        return find("#billing_postcode");
    }

    public WebElement getBillingAddressLine1(){
        return find("#billing_address_line_1");
    }

    public WebElement getBillingAddressLine2(){
        return find("#billing_address_line_2");
    }

    public WebElement getBillingTown(){
        return find("#billing_town");
    }

    public WebElement getBillingCountry(){
        return find("#billing_country");
    }

    public WebElement getBillingPONumber(){
        return find("#billing_po_number");
    }

    public WebElement getBillingTelephone(){
        return find("#billing_telephone");
    }

    public WebElement getBillingMobile(){
        return find("#billing_mobi_phone");
    }
    //</editor-fold>

    //<editor-fold desc="Mailing address">
    public WebElement getUserBillingAddressCheckbox(){
        return find("//input[@id='use_billing_data']/following-sibling::label");
    }

    public WebElement getMailingFirstName(){
        return find("#mailing_first_name");
    }

    public WebElement getMailingLastName(){
        return find("#mailing_last_name");
    }

    public WebElement getMailingPostcode(){
        return find("#mailing_postcode");
    }

    public WebElement getMailingAddressLine1(){
        return find("#mailing_address_line_1");
    }

    public WebElement getMailingAddressLine2(){
        return find("#mailing_address_line_2");
    }

    public WebElement getMailingTown(){
        return find("#mailing_town");
    }

    public WebElement getMailingCountry(){
        return find("#mailing_country");
    }

    public WebElement getMailingPONumber(){
        return find("#mailing_po_number");
    }

    public WebElement getMailingTelephone(){
        return find("#mailing_telephone");
    }

    public WebElement getMailingMobile(){
        return find("#mailing_mobi_phone");
    }
    //</editor-fold>
}
