package creators;

import entity.Event;

import java.util.Scanner;

public class EventCreator extends Creator {

    public static Event createEvent (){
        Event.Builder builder=new Event.Builder();
        Scanner consoleRead = new Scanner(System.in);
        System.out.println("Инициализировано создание ивента");

        System.out.println("Введите название мероприятия");
        builder.name(consoleRead.nextLine());

        System.out.println("Введите количество билетов");
        builder.ticketsCount(consoleRead.nextInt());

        System.out.println("Введите описание мероприятия");

        builder.description(consoleRead.nextLine());
        builder.description(consoleRead.nextLine());
        //я не понимаю....



        Event event=builder.build();
        return  event;
    }
}
