package commands;

import models.Ticket;
import managers.CollectionManager;

public class Show extends Command implements Executable{


    @Override
    public void execute(String[] splitedConsoleRead) {

        if (CollectionManager.getCOLLECTION().isEmpty()){
            System.out.println("Коллекция пуста!");
            return;
        }

        for (Ticket ticket :CollectionManager.getCOLLECTION().values()){
            System.out.println(ticket.toString());
        }


    }

    @Override
    public String toString() {
        return "show";
    }
}
