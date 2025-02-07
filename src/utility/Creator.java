package utility;

import entity.Ticket;

import java.util.Scanner;

public class Creator {
    public static Ticket createElement() {
        System.out.println("Инициализировано создание объекта для добавление в коллекцию");

        Ticket.Builder builder = new Ticket.Builder();
        Scanner consoleRead = new Scanner(System.in);

        System.out.println("Введите значение для параметра 'name'");
        builder.name(consoleRead.next());

        System.out.println("Введите значение для параметра 'price'");
        builder.price(consoleRead.nextInt());

        Ticket element = builder.build();
        return element;
    }
}
