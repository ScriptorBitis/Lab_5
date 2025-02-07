package commands.creators;

import entity.Ticket;
import entity.TicketType;
import exeptions.WrongTypeInput;
import utility.Engine;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TicketCreator extends Creator {

    public static Ticket createTicket() throws WrongTypeInput {
        boolean pass = true;
        System.out.println("Инициализировано создание объекта для добавление в коллекцию");

        Ticket.Builder builder = new Ticket.Builder();
        Scanner consoleRead = new Scanner(System.in);

        do {
            System.out.println("Введите значение для параметра 'name'");
            String name = consoleRead.nextLine();
            if (name.isEmpty()) {
                System.out.println("Имя не может быть пустым!");

            } else {
                System.out.println("Гойда");
                builder.name(name);
                pass = false;
            }

        } while (pass);

        pass=false;

        System.out.println("Введите значение для параметра 'price'");
        try {
            builder.price(consoleRead.nextInt());
        }catch (InputMismatchException exception){
            System.out.println("Ошибка: введено неправильное значение.\nPrice соответствует число без букв. Вы будете выброшены на 'главную страницу'");
            throw new WrongTypeInput("Ошибка ввода");
        }

        System.out.println("Введите значение для параметра 'discount'\nЭтому параметру соответствует число с плавающей точкой 0<число<=100.\nВводите значения через запятую. Пример: 15,4");
        try {
            builder.discount(consoleRead.nextFloat());
            if (builder.getDiscount()>100 || builder.getDiscount()<=0){
                throw new InputMismatchException();
            }
        }catch (InputMismatchException exception){
            System.out.println("Ошибка: введено неправильное значение.\nВы будете выброшены на 'главную страницу'");
            throw new WrongTypeInput("Ошибка ввода");
        }

        System.out.println("Введите значение для параметра 'refundable'\nВыберите соответствующее значение\n1 : да, билет вернуть можно\n2 : нет, вернуть билет нельзя");
        try {
            switch ((consoleRead.nextInt())) {
                case (1):
                    builder.refundable(true);
                    break;
                case (2):
                    builder.refundable(false);
                    break;
            }
        }catch (InputMismatchException exception){
            System.out.println("Ошибка ввода\nВы будете выброшены на 'главную страницу'");
            throw new WrongTypeInput("Ошибка ввода");
        }


        System.out.println("Выберите значение для параметра 'type':\n1 : VIP\n2 : BUDGETARY\n3 : CHEAP\n(необходимо ввести цифру)");
        try {


            switch (consoleRead.nextInt()) {
                case (1):
                    builder.type(TicketType.VIP);
                    break;
                case (2):
                    builder.type(TicketType.BUDGETARY);
                    break;
                case (3):
                    builder.type(TicketType.CHEAP);
                    break;
            }
        }catch (InputMismatchException exception){
            System.out.println("Ошибка ввода\nВы будете выброшены на 'главную страницу'");
            throw new WrongTypeInput("Ошибка ввода");
        }
        builder.coordinates(CoordinatesCreator.createCoordinates());
        builder.event(EventCreator.createEvent());


        Ticket element = builder.build();
        return element;
    }
}
