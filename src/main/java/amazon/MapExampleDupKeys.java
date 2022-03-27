package amazon;


import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;

public class MapExampleDupKeys {

  public static HashMap<String, ArrayList> hashMap = new HashMap<String, ArrayList>();

    public static void main(String... arg) {
        // Add data with duplicate keys

        MapExampleDupKeys obj = new MapExampleDupKeys();
        obj.addValues("A", "a1");
        obj.addValues("A", "a2");
        obj.addValues("B", "b");
        // View data.
        Iterator it = hashMap.keySet().iterator();
        ArrayList tempList = null;

        while (it.hasNext()) {
            String key = it.next().toString();
            tempList = hashMap.get(key);
            if (tempList != null) {
                for (Object value: tempList) {
                    System.out.println("Key : "+key+ " , Value : "+value);
                }
            }
        }
    }

    private void addValues(String key, String value) {
        ArrayList tempList = null;
        if (hashMap.containsKey(key)) {
            tempList = hashMap.get(key);
            if(tempList == null)
                tempList = new ArrayList();
            tempList.add(value);
        } else {
            tempList = new ArrayList();
            tempList.add(value);
        }
        hashMap.put(key,tempList);
    }
}
