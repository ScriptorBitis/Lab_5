package managers;

import entity.Ticket;

import java.util.HashMap;
import java.util.Map;

public class CollectionManager {
    private static final Map<String,Ticket> COLLECTION = new HashMap<>();

    public static Map<String, Ticket> getCOLLECTION() {
        return COLLECTION;
    }

    public static void addTicket(String key,Ticket ticket){
        COLLECTION.put(key,ticket);
    }


}
