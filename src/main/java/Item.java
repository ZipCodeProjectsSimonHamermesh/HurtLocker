import java.util.ArrayList;

/**
 * Created by simonhamermesh on 2/22/16.
 */
public class Item {

    private String name;
    private String price;
    private String type;
    private String expiration;

    Item(String iName, String iPrice, String iType, String iExpiration){
        this.name = iName;
        this.price = iPrice;
        this.type = iType;
        this.expiration = iExpiration;
       }

    public String getName(){
        return name;
    }
    public String getPrice(){
        return price;
    }
    public String getType(){
        return type;
    }
    public String getExpiration(){
        return expiration;
    }

}
