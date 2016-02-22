/**
 * Created by simonhamermesh on 2/22/16.
 */

import java.util.ArrayList;
import java.util.HashMap;


public class ItemManager {

    private ArrayList<Item> allItemArrayList = new ArrayList<Item>();

    private int errors = 0;

    /***********************************************/
    public ArrayList<Item> getItemArrayList() throws Exception {fillItemsArrayList();return allItemArrayList;}

    private void fillItemsArrayList() throws Exception{
        for(String object : Splitters.splitRawData(Main.readRawDataToString())){
            StringBuilder stringBuilder = new StringBuilder();
            for(String record : Splitters.splitRecordsToItems(object)){
                for(String item : Splitters.splitItemsByKV(record)){
                    stringBuilder.append(item).append(",");
                }
            }
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
            try{createItem(stringBuilder.toString().split(","));}catch(IndexOutOfBoundsException e){errors++;}
        }
        totalNames();
    }

    private void createItem(String [] item) throws IndexOutOfBoundsException{
        if (item[1] == null || item[3]==null||item[5]==null|item[7]==null) {throw new IndexOutOfBoundsException();}
        allItemArrayList.add(new Item(item[1],item[3],item[5],item[7]));
    }

    /*************************************************/
    public HashMap<Integer, String> getItemNames() {
        return itemNames;
    }
    private HashMap<Integer,String> itemNames = new HashMap<Integer,String>(){{
        put(4,"Milk");put(5,"Bread");put(6,"Apples");put(7,"Cookies");}};
    /*************************************************/

    public HashMap<Integer,Integer> getNameCount (){
        return nameCount;
    }
    private HashMap<Integer,Integer> nameCount = new HashMap<Integer, Integer>(){{
        put(4,0);put(5,0);put(6,0);put(7,0);}};

    private ArrayList<Item> itemByNameList;

    private void totalNames(){
        for (int i = 4; i<8;i++) {
            itemByNameList = new ArrayList<Item>();
            for (Item x : allItemArrayList) {
                if (x.getName().toCharArray().length == i) {
                    nameCount.put(i, nameCount.get(i) + 1);
                    itemByNameList.add(x);
                }
            }
            totalPrices(i);
        }
    }
    /*****************************************************/

    private void totalPrices(int i){
        itemPriceCount.put((itemNames.get(i)),setItemsPriceList(i));
    }

    /*****************************************************/
    private HashMap<String,ArrayList<String>> itemPriceList = new HashMap<String,ArrayList<String>>(){{
        put("Milk",new ArrayList<String>());put("Bread",new ArrayList<String>());put("Apples",new ArrayList<String>());put("Cookies",new ArrayList<String>());}};

    public HashMap<String, ArrayList<String>> getItemPriceList() {
        return itemPriceList;
    }

    private ArrayList<String> setItemsPriceList(int i){
        ArrayList<String> allItemPrices = new ArrayList<String>();
        for(Item x : itemByNameList) {
            allItemPrices.add(x.getPrice());}
        itemPriceList.put(itemNames.get(i),allItemPrices);
        return setItemPriceCount(allItemPrices);
    }

    /******************************************************/
    private HashMap<String,ArrayList<String>> itemPriceCount = new HashMap<String,ArrayList<String>>(){{
        put("Milk",new ArrayList<String>());put("Bread",new ArrayList<String>());put("Apples",new ArrayList<String>());put("Cookies",new ArrayList<String>());}};

    public HashMap<String, ArrayList<String>> getItemPriceCount() {
        return itemPriceCount;
    }

    private ArrayList<String> setItemPriceCount(ArrayList<String> allItemPrices){
        ArrayList<String> cleanedItemPrices = new ArrayList<String>();
        for(String price : allItemPrices){
            if(!(cleanedItemPrices.contains(price))){
                cleanedItemPrices.add(price);}
        }
        return cleanedItemPrices;
    }

    /*****************************************************/

    public int countPriceOccurances(String price, ArrayList<String> priceList){
        int count = 0;
        for(String sPrice : priceList){
            if(Float.parseFloat(price) == Float.parseFloat(sPrice)){
                count++;
            }
        }
        return count;
    }

    private HashMap<String, Integer> priceOccurences = new HashMap<String, Integer>(){{

    }};

    public int getErrors() {
        return errors;
    }


}
