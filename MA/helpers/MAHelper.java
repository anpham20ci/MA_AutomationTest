package helpers;

import helper_base.Helper;

import java.util.Dictionary;

/**
 * Common things used for the project
 */
public class MAHelper {
    public static Dictionary<String, String> Config;
    public static String getConfig(String key){
        if(Config == null){
            Config = Helper.loadProfileFromConfigFile("config\\default.profile.json");
        }
        return Config.get(key);
    }

    public static String BackendPath = MAHelper.getConfig("BackendPath");
    public static String BackendUser = MAHelper.getConfig("BackendUser");
    public static String BackendPassword = MAHelper.getConfig("BackendPassword");
}
