import com.sun.tools.classfile.Code_attribute;

import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.Files.readAllBytes;
import static java.nio.file.Paths.get;

import java.util.ArrayList;

public class Main {



    public static String readRawDataToString() throws Exception{
        Path path = Paths.get(ClassLoader.getSystemResource("RawData.txt").toURI());
        return new String(readAllBytes(get(path.toUri())));
    }

    public static void main(String[] args) throws Exception{

        ItemManager itemManager = new ItemManager();
        itemManager.getItemArrayList();

        for(int nameKey : itemManager.getItemNames().keySet()){
            System.out.println(itemManager.getItemNames().get(nameKey));
            System.out.println(itemManager.getNameCount().get(nameKey));
            System.out.println(itemManager.getItemPriceCount().get(itemManager.getItemNames().get(nameKey)));
            System.out.println(itemManager.getItemPriceList().get(itemManager.getItemNames().get(nameKey)));

            for(String price : itemManager.getItemPriceCount().get(itemManager.getItemNames().get(nameKey))){
                System.out.println(price + ":" + itemManager.countPriceOccurances(price,itemManager.getItemPriceList().get(itemManager.getItemNames().get(nameKey))));
            }


            System.out.println();
        }


        System.out.println("Errors : " + itemManager.getErrors());

    }

}
