package commands;

import entity.creators.TicketCreator;
import entity.Ticket;
import managers.CollectionManager;

public class Insert extends Command implements Executable {


    public Insert(int wordsCount) {
        super(wordsCount);
    }

    @Override
    public void execute(String[] splitedRequest) {

        if (splitedRequest.length != this.getWordsCount()) {
            System.out.println("Команда execute состоит из 2 слов : команда и ключ");
                return;
        }


        Ticket ticket = TicketCreator.createTicket("Инициализировано создание билета");

        if (ticket.validate()) {
            CollectionManager.addTicket(splitedRequest[1], ticket);
            System.out.println("Элемент успешно добавлен в коллекцию!");
        } else {
            System.out.println("Какой-то параметр введен неверно!Элемент не будет добавлен в коллекцию");
        }

    }


    @Override
    public String toString() {
        return "insert";
    }
}
