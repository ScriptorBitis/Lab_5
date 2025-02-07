package commands;

import creators.TicketCreator;
import entity.Ticket;
import managers.CollectionManager;

public class Insert extends Command implements Executable{

    @Override
    public void execute(String[] splitedRequest) {
        Ticket ticket =TicketCreator.createTicket();
        if (ticket.validate()){
            CollectionManager.addTicket(splitedRequest[1],ticket);
        }else {
            System.out.println("Какой-то параметр введен неверно!Элемент не будет добавлен в коллекцию");
        }

    }

    @Override
    public String toString() {
        return "insert";
    }
}
