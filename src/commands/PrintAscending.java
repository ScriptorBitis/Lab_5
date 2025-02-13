package commands;

import entity.Ticket;
import managers.CollectionManager;

import java.util.*;

public class PrintAscending  extends Command implements Executable{

    @Override
    public void execute(String[] splitedConsoleRead) {
        Map<String,Ticket> COLLECTION = CollectionManager.getCOLLECTION();
        List<Ticket> ticketByPrice = new ArrayList<>(COLLECTION.values());
        Collections.sort(ticketByPrice, Comparator.comparing(Ticket::getPrice));

        for (Ticket ticket : ticketByPrice) {
            System.out.println(ticket.toString());
        }
    }

    @Override
    public String toString() {
        return "print_ascending";
    }
}
