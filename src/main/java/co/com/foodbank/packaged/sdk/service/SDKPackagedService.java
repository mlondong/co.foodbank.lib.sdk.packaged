package co.com.foodbank.packaged.sdk.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import co.com.foodbank.packaged.sdk.exception.SDKPackagedNotFoundException;
import co.com.foodbank.packaged.sdk.exception.SDKPackagedServiceException;
import co.com.foodbank.packaged.sdk.exception.SDKPackagedServiceIllegalArgumentException;
import co.com.foodbank.packaged.sdk.exception.SDKPackagedServiceNotAvailableException;
import co.com.foodbank.packaged.sdk.model.ResponsePackagedData;
import co.com.foodbank.packaged.sdk.util.SDKPackageParameters;

@Service
@Validated
public class SDKPackagedService implements ISDKPackaged {


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private HttpHeaders httpHeaders;

    @Value("${urlSdlSelectPackagedById}")
    private String urlSdlSelectPackagedById;

    @Value("${urlSdlSelectPackageByDate}")
    private String urlSdlSelectPackageByDate;

    @Value("${urlSdlUpdateStatePackaged}")
    private String urlSdlUpdateStatePackaged;



    @Override
    public Collection<ResponsePackagedData> findPackageByDate(Date date)
            throws SDKPackagedServiceIllegalArgumentException,
            SDKPackagedNotFoundException, SDKPackagedServiceException {

        try {
            httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            HttpEntity<String> entity = new HttpEntity<String>(httpHeaders);

            String response =
                    restTemplate
                            .exchange(urlSdlSelectPackageByDate + date,
                                    HttpMethod.GET, entity, String.class)
                            .getBody();

            return objectMapper.readValue(response,
                    new TypeReference<Collection<ResponsePackagedData>>() {});

        } catch (HttpClientErrorException i) {

            if (i.getStatusCode() == HttpStatus.BAD_REQUEST) {
                throw new SDKPackagedServiceIllegalArgumentException(i);
            }
            if (i.getStatusCode() == HttpStatus.NOT_FOUND) {
                throw new SDKPackagedNotFoundException(date.toString(),
                        i.getResponseBodyAsString());
            }
            throw new SDKPackagedServiceException(i);
        } catch (ResourceAccessException i) {
            throw new SDKPackagedServiceNotAvailableException(i);
        } catch (Exception i) {
            throw new SDKPackagedServiceException(i);
        }
    }



    @Override
    public ResponsePackagedData updateStatepackaged(String idpackage,
            String option) throws SDKPackagedServiceIllegalArgumentException,
            SDKPackagedNotFoundException, SDKPackagedServiceException {


        try {
            httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            HttpEntity<String> entity = new HttpEntity<String>(httpHeaders);

            String response =
                    restTemplate
                            .exchange(
                                    urlSdlUpdateStatePackaged
                                            + urlBuild(idpackage, option),
                                    HttpMethod.GET, entity, String.class)
                            .getBody();

            return objectMapper.readValue(response,
                    new TypeReference<ResponsePackagedData>() {});

        } catch (HttpClientErrorException i) {

            if (i.getStatusCode() == HttpStatus.BAD_REQUEST) {
                throw new SDKPackagedServiceIllegalArgumentException(i);
            }
            if (i.getStatusCode() == HttpStatus.NOT_FOUND) {
                throw new SDKPackagedNotFoundException(idpackage,
                        i.getResponseBodyAsString());
            }
            throw new SDKPackagedServiceException(i);
        } catch (ResourceAccessException i) {
            throw new SDKPackagedServiceNotAvailableException(i);
        } catch (Exception i) {
            throw new SDKPackagedServiceException(i);
        }


    }



    private String urlBuild(String idpackage, String option) {
        return new String(SDKPackageParameters.ID + idpackage
                + SDKPackageParameters.OPTION + option);
    }



    @Override
    public ResponsePackagedData findPackageById(String idPackage)
            throws SDKPackagedServiceIllegalArgumentException,
            SDKPackagedNotFoundException, SDKPackagedServiceException {


        try {
            httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            HttpEntity<String> entity = new HttpEntity<String>(httpHeaders);

            String response =
                    restTemplate
                            .exchange(urlSdlSelectPackagedById + idPackage,
                                    HttpMethod.GET, entity, String.class)
                            .getBody();

            return objectMapper.readValue(response,
                    new TypeReference<ResponsePackagedData>() {});



        } catch (HttpClientErrorException i) {

            if (i.getStatusCode() == HttpStatus.BAD_REQUEST) {
                throw new SDKPackagedServiceIllegalArgumentException(i);
            }
            if (i.getStatusCode() == HttpStatus.NOT_FOUND) {
                throw new SDKPackagedNotFoundException(idPackage,
                        i.getResponseBodyAsString());
            }
            throw new SDKPackagedServiceException(i);
        } catch (ResourceAccessException i) {
            throw new SDKPackagedServiceNotAvailableException(i);
        } catch (Exception i) {
            throw new SDKPackagedServiceException(i);
        }
    }



}
