package test_resource;

public class TextResource {
    //region Create new user
    //region User type
    public static String UserType_DirectDebit = "Direct Debit";
    public static String UserType_SelfServe = "Self serve";
    //endregion

    //region Member type
    public static String MembeType_BARMember = "BAR member";
    public static String MembeType_FORMember = "FOR member";
    public static String MembeType_RegularMember = "Regular member";
    //endregion

    //region Data format type
    public static String DataFormatType_AveryLabels = "Avery Labels";
    public static String DataFormatType_HermaLabels = "Herma Labels";
    public static String DataFormatType_Twenty10Labels = "Twenty10 Labels";
    public static String DataFormatType_Twenty10Postcards = "Twenty10 Postcards";
    public static String DataFormatType_UKMailPostcards = "UK Mail Postcards";
    public static String DataFormatType_Twenty10_Labels = "Twenty10";
    //endregion

    //<editor-fold desc="Order type">
    public static String OrderType_Subscription = "subscription";
    public static String OrderType_SelfServe = "self_serve";
    public static String OrderType_DDAdhoc = "dd_adhoc";
    public static String OrderType_Any = "any";
    //</editor-fold>

    //<editor-fold desc="Transaction type">
    public static String TransactionType_OneClickAdhoc = "1 Click Adhoc";
    public static String TransactionType_All = "all";
    //</editor-fold>

    //<editor-fold desc="Download status">
    public static String DownloadedStatus_Yes = "yes";
    public static String DownloadedStatus_No = "no";
    public static String DownloadedStatus_Any = "any";
    //</editor-fold>


    //endregion
}
