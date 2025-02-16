package commands;

import models.Ticket;
import managers.CollectionManager;

public class Show extends Command implements Executable{

    public Show(int wordsCount, CollectionManager collectionManager) {
        super(wordsCount, collectionManager);
    }

    public Show(CollectionManager collectionManager) {
        super(collectionManager);
    }

    public Show(int wordsCount) {
        super(wordsCount);
    }

    public Show() {
    }

    @Override
    public void execute(String[] splitedConsoleRead) {

        if (this.collectionManager.getCOLLECTION().isEmpty()){
            System.out.println("Коллекция пуста!");
            return;
        }

        for (Ticket ticket :this.collectionManager.getCOLLECTION().values()){
            System.out.println(ticket.toString());
        }


    }

    @Override
    public String toString() {
        return "show";
    }
}
