import commands.*;
import entity.Coordinates;
import entity.Event;
import entity.Ticket;
import entity.TicketType;
import managers.CollectionManager;
import managers.CommandManager;
import utility.Engine;

public class Main {


    public static void main(String[] args) {

        //TODO : РЕПЛЕЙС ИФ ЛОВЕ ДОДЕЛАТЬ????????????





        CommandManager.setUpCommand(new Help());
        CommandManager.setUpCommand(new Exit());
        CommandManager.setUpCommand(new Insert(2));
        CommandManager.setUpCommand(new Show());
        CommandManager.setUpCommand(new Clear());
        CommandManager.setUpCommand(new Info());
        CommandManager.setUpCommand(new RemoveKey(2));
        CommandManager.setUpCommand(new UpdateId(2));
        CommandManager.setUpCommand(new PrintAscending());
        CommandManager.setUpCommand(new MaxByCoordinates());
        CommandManager.setUpCommand(new ReplaceIfLowe());

        System.out.println(CommandManager.getCommands().toString());

        Ticket.Builder builder=new Ticket.Builder();
        Coordinates.Builder builder1 = new Coordinates.Builder();
        Coordinates coordinates=builder1.x(15).y(Double.valueOf(24)).build();
        Ticket ticket=builder.price(1500).name("Билетик 1").coordinates(coordinates).discount(15).refundable(true).type(TicketType.CHEAP).build();
        CollectionManager.addTicket("aboba1",ticket);

        coordinates=builder1.x(125).y(Double.valueOf(324)).build();
        ticket=builder.price(3500).name("Билетик 2").coordinates(coordinates).discount(25).refundable(false).type(TicketType.VIP).build();
        CollectionManager.addTicket("aboba2",ticket);

        int i = 0;
        do {
            i++;
        }while (i<4);


        Engine.runProgramm();


        /*
        save : сохранить коллекцию в файл
        execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.

        remove_greater {element} : удалить из коллекции все элементы, превышающие заданный
        remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный


        remove_any_by_type type : удалить из коллекции один элемент, значение поля type которого эквивалентно заданному
        \\TODO вроде готова replace_if_lowe null {element} : заменить значение по ключу, если новое значение меньше старого
         */


    }

}