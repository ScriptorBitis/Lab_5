package commands;

import commands.creators.TicketCreator;
import entity.Ticket;
import exeptions.WrongTypeInput;
import managers.CollectionManager;
import utility.Engine;

public class Insert extends Command implements Executable {

    @Override
    public void execute(String[] splitedRequest) {
        if (splitedRequest.length!=3){
            System.out.println("Команде Insert передано больше нужных аргументов.\nВозвращение на домашнюю страницу.");
            Engine.runProgramm();
        }
        try {


            Ticket ticket = TicketCreator.createTicket();

            if (ticket.validate()) {
                CollectionManager.addTicket(splitedRequest[1], ticket);
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
