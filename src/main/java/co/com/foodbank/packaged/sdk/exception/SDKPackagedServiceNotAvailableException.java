package co.com.foodbank.packaged.sdk.exception;

/**
 * @author mauricio.londono@gmail.com co.com.foodbank.contribution.sdk.exception
 *         15/06/2021
 */
public class SDKPackagedServiceNotAvailableException
        extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public SDKPackagedServiceNotAvailableException(Exception e) {
        super(e);
    }

}
