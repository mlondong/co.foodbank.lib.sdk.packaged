package co.com.foodbank.packaged.sdk.model;

import java.util.Collection;
import java.util.Date;
import co.com.foodbank.packaged.dto.item.Item;
import co.com.foodbank.packaged.dto.state.IStatePackaged;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author mauricio.londono@gmail.com co.com.foodbank.packaged.sdk.model
 *         13/08/2021
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponsePackagedData {

    private String id;
    private Collection<Item> item;
    private Long units;
    private Date datePackage;
    private IStatePackaged state;

}
