package managers;

import entity.Ticket;

import java.time.LocalDateTime;
import java.util.*;

public class CollectionManager {
    private static final Map<String, Ticket> COLLECTION = new HashMap<>();
    private static final LocalDateTime initializationDate = LocalDateTime.now().withNano(0);

    public static Map<String, Ticket> getCOLLECTION() {
        return COLLECTION;
    }

    public static void addTicket(String key, Ticket ticket) {
        COLLECTION.put(key, ticket);
    }

    public static LocalDateTime getInitializationDate() {
        return initializationDate;
    }

    public static Map<String, Ticket> sortByPrice(Map COLLECTION) {
        List<Ticket> ticketByPrice = new ArrayList<>(COLLECTION.values());
        Collections.sort(ticketByPrice, Comparator.comparing(Ticket::getPrice));

        for (Ticket ticket : ticketByPrice) {
            System.out.println(ticket.toString());
        }


        return Map.of();
    }
            /*
            Map<String, Person> people = new HashMap<>();
        Person jim = new Person("Jim", 25);
        Person scott = new Person("Scott", 28);
        Person anna = new Person("Anna", 23);

        people.put(jim.getName(), jim);
        people.put(scott.getName(), scott);
        people.put(anna.getName(), anna);

        // not yet sorted
        List<Person> peopleByAge = new ArrayList<>(people.values());

        Collections.sort(peopleByAge, Comparator.comparing(Person::getAge));

        for (Person p : peopleByAge) {
            System.out.println(p.getName() + "\t" + p.getAge());
        }
             */
}
