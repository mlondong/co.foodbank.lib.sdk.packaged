package co.com.foodbank.packaged.sdk.service;

import java.util.Collection;
import java.util.Date;
import co.com.foodbank.packaged.sdk.exception.SDKPackagedNotFoundException;
import co.com.foodbank.packaged.sdk.exception.SDKPackagedServiceException;
import co.com.foodbank.packaged.sdk.exception.SDKPackagedServiceIllegalArgumentException;
import co.com.foodbank.packaged.sdk.model.ResponsePackagedData;

/**
 * @author mauricio.londono@gmail.com co.com.foodbank.contribution.sdk.service
 *         15/06/2021
 */
public interface ISDKPackaged {


    /**
     * Method to find packaged by id.
     * 
     * @param idPackage
     * @return {@code ResponsePackagedData}
     * @throws SDKPackagedServiceIllegalArgumentException
     * @throws SDKPackagedNotFoundException
     * @throws SDKPackagedServiceException
     */
    ResponsePackagedData findPackageById(String idPackage)
            throws SDKPackagedServiceIllegalArgumentException,
            SDKPackagedNotFoundException, SDKPackagedServiceException;



    /**
     * Method to find a Packages less by date.
     * 
     * @param date
     * @return {@code Collection<ResponsePackagedData>}
     * @throws SDKPackagedServiceIllegalArgumentException
     * @throws SDKPackagedNotFoundException
     * @throws SDKPackagedServiceException
     */
    Collection<ResponsePackagedData> findPackageByDate(Date date)
            throws SDKPackagedServiceIllegalArgumentException,
            SDKPackagedNotFoundException, SDKPackagedServiceException;


    /**
     * Method to update state in Packaged. Option 1: Open OPtion 2: Close;
     * 
     * @param date
     * @return {@code Collection<ResponsePackagedData>}
     * @throws SDKPackagedServiceIllegalArgumentException
     * @throws SDKPackagedNotFoundException
     * @throws SDKPackagedServiceException
     */
    ResponsePackagedData updateStatepackaged(String idpackage, String option)
            throws SDKPackagedServiceIllegalArgumentException,
            SDKPackagedNotFoundException, SDKPackagedServiceException;



}
