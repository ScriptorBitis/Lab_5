package creators;

import entity.Ticket;
import entity.TicketType;

import java.util.Scanner;

public class TicketCreator extends Creator {

    public static Ticket createTicket() {
        System.out.println("Инициализировано создание объекта для добавление в коллекцию");

        Ticket.Builder builder = new Ticket.Builder();
        Scanner consoleRead = new Scanner(System.in);

        System.out.println("Введите значение для параметра 'name'");
        builder.name(consoleRead.next());

        System.out.println("Введите значение для параметра 'price'");
        builder.price(consoleRead.nextInt());

        System.out.println("Введите значение для параметра 'discount'");
        builder.discount(consoleRead.nextFloat());

        System.out.println("Введите значение для параметра 'refundable'");
        builder.refundable(consoleRead.nextBoolean());

        System.out.println("Выберите значение для параметра 'type':\n1 : VIP\n2 : BUDGETARY\n3 : CHEAP\n(необходимо ввести цифру)");

        switch (Integer.valueOf(consoleRead.next())) {
            case (1):
                builder.type(TicketType.VIP);
            case (2):
                builder.type(TicketType.BUDGETARY);
            case (3):
                builder.type(TicketType.CHEAP);
        }

        builder.coordinates(CoordinatesCreator.createCoordinates());
        builder.event(EventCreator.createEvent());



        Ticket element = builder.build();
        return element;
    }
}
