package commands;

import entity.creators.TicketCreator;
import entity.Ticket;
import exeptions.WrongTypeInput;
import managers.CollectionManager;
import utility.Engine;

public class Insert extends Command implements Executable {


    public Insert(int wordsCount, String necessaryToken) {
        super(wordsCount,necessaryToken);
    }

    @Override
    public void execute(String[] splitedRequest) {

        if (splitedRequest.length==this.getWordsCount()){
            if (!splitedRequest[2].equals("{element}")) {
                System.out.println("3-й аргумент должен быть токеном {element}");
                return;
            }
        }else {
            System.out.println("Команда insert состоит из команды, ключа и токена {element}.\nВозвращение на домашнюю страницу.");
            return;
        }


        try {
            Ticket ticket = TicketCreator.createTicket();

            if (ticket.validate()) {
                CollectionManager.addTicket(splitedRequest[1], ticket);
                System.out.println("Элемент успешно добавлен в коллекцию!");
            } else {
                System.out.println("Какой-то параметр введен неверно!Элемент не будет добавлен в коллекцию");
            }
        }catch (WrongTypeInput exception){
            //System.out.println("Ошибка ввода.Вы будете возвращены на 'домашнюю страницу'");
            return;
        }
    }



    @Override
    public String toString() {
        return "insert";
    }
}
