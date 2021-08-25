package co.com.foodbank.packaged.sdk.util;

/**
 * @author mauricio.londono@gmail.com
 * co.com.foodbank.packaged.sdk.util
 * 25/08/2021
 */
public final class SDKPackageParameters {

    
    public static final String _PREFIX = "/packaged";
    public static final String _SUFIX_FIND_PACKACKED_ID = "/findById/";
    public static final String _SUFIX_FIND_PACKACKED_DATE= "/findByDate/";
    public static final String _SUFIX_UPDATE_PACKAED= "/updateState";
    
    public static final String PATH_FIND_PACKAGED_ID= _PREFIX + _SUFIX_FIND_PACKACKED_ID;
    public static final String PATH_FIND_PACKAGED_DATE= _PREFIX + _SUFIX_FIND_PACKACKED_DATE;
    public static final String PATH_UPDATE_PACKAGED= _PREFIX + _SUFIX_UPDATE_PACKAED;
     
    public final static String ID = "/id/";
    public final static String OPTION = "/option/";

    public SDKPackageParameters() {}
}
