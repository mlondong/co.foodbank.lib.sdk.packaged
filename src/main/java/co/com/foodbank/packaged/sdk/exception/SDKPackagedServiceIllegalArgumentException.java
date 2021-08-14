package co.com.foodbank.packaged.sdk.exception;

/**
 * @author mauricio.londono@gmail.com co.com.foodbank.contribution.sdk.exception
 *         15/06/2021
 */
public class SDKPackagedServiceIllegalArgumentException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public SDKPackagedServiceIllegalArgumentException(Exception e) {
        super(e);
    }
}
