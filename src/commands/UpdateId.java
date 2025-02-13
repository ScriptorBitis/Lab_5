package commands;

import entity.Ticket;
import entity.creators.TicketCreator;
import managers.CollectionManager;

import java.util.Map;

public class UpdateId extends Command implements Executable{

    public UpdateId(int wordsCount) {
        super(wordsCount);
    }

    @Override
    public void execute(String[] splitedConsoleRead) {

        if (splitedConsoleRead.length != this.getWordsCount()) {
            System.out.println("Команда update состоит из команды и ключа .\nВозвращение на домашнюю страницу.");
            return;
        }



        int id;
        Map<String,Ticket> COLLECTION = CollectionManager.getCOLLECTION();
        try { id=Integer.valueOf(splitedConsoleRead[1]);
            for (Ticket ticket: COLLECTION.values()){
                if (ticket.getId()==id){
                   for (String key: COLLECTION.keySet()){
                       if (ticket.equals(COLLECTION.get(key))){
                           CollectionManager.addTicket(key, TicketCreator.createTicket("Для обновление элемента коллеции надо ввести параметры."));
                           System.out.println("Элемент с id "+id+" обновлен");
                       }
                   }
                    return;
                }
                System.out.println("Элемента с id "+id+" не существует!");
            }
        }catch (NumberFormatException exception){
            System.out.println("id должен быть числом\nВозвращение на главное страницу");
        }
    }



    @Override
    public String toString() {
        return "update";
    }
}
