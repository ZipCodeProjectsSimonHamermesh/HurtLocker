/**
 * Created by simonhamermesh on 2/22/16.
 */
public class Splitters {

    public static String[] splitRawData(String rawData) {
        return rawData.split("##");
    }

    public static String[] splitRecordsToItems (String record){
        return record.split(";|\\^|@|%|\\*|!");
    }

    public static String[] splitItemsByKV(String item){
        return item.split(":");
    }

}
