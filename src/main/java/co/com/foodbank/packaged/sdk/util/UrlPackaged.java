package co.com.foodbank.packaged.sdk.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Class to handle Url for sdk Packaged.
 * 
 * @author mauricio.londono@gmail.com co.com.foodbank.vault.sdk.util 25/08/2021
 */
@Component
@Validated
public class UrlPackaged {

    @Value("${sdk.service.packaged.scheme}")
    private String urlScheme;

    @Value("${sdk.service.packaged.url}")
    private String urlBase;


    public String tofindPackagedId(String idPackaged) {
        return UriComponentsBuilder.newInstance().scheme(urlScheme)
                .host(urlBase)
                .path(SDKPackageParameters.PATH_FIND_PACKAGED_ID + idPackaged)
                .buildAndExpand(encode(idPackaged)).toString();
    }

    public String tofindPackagedDate(Date date) {
        return UriComponentsBuilder.newInstance().scheme(urlScheme)
                .host(urlBase)
                .path(SDKPackageParameters.PATH_FIND_PACKAGED_DATE + date)
                .build().toString();
    }

    public String toUpdatePackaged(String idpackage, String option) {
        return UriComponentsBuilder.newInstance().scheme(urlScheme)
                .host(urlBase)
                .path(SDKPackageParameters.PATH_UPDATE_PACKAGED
                        + urlBuild(idpackage, option))
                .buildAndExpand(encode(idpackage)).toString();

    }


    private String urlBuild(String idpackage, String option) {
        return new String(SDKPackageParameters.ID + idpackage
                + SDKPackageParameters.OPTION + option);
    }

    /**
     * Method for encode
     * 
     * @param value url
     * @return utf8 encoded url
     */
    private String encode(String value) {
        try {
            return URLEncoder.encode(value, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

}
