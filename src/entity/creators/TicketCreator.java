package entity.creators;
//insert aboba {element}

import entity.Coordinates;
import entity.Event;
import entity.Ticket;
import entity.TicketType;
import exeptions.WrongTypeInput;
import utility.console.Console;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TicketCreator extends Creator {
    private static Scanner consoleRead = new Scanner(System.in);

    public static Ticket createTicket() throws WrongTypeInput {


        System.out.println("Инициализировано создание объекта для добавление в коллекцию");
        Ticket.Builder builder = new Ticket.Builder();
        builder.name(askName());
        builder.price(askPrice());
        builder.discount(askDiscount());
        builder.refundable(askRefundable());
        builder.type(askTicketType());
        builder.coordinates(CoordinatesCreator.createCoordinates());
        builder.event(EventCreator.createEvent());
        Ticket element = builder.build();
        return element;
    }

    private static String askName() {

        boolean pass = true;
        String name;
        do {
            System.out.println("Введите значение для параметра 'name'");
            name = consoleRead.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("Имя не может быть пустым!");

            } else {
                pass = false;

            }

        } while (pass);
        return name;
    }

    private static Integer askPrice() {

        System.out.println("Введите значение для параметра 'price'.Ввод пустой строки будет засчитан за отсутствие параметра.\nВас предупредили");
        Integer integer = 0;
        Boolean pass = true;
        do {

            try {
                String userRequest = consoleRead.nextLine().trim();
                if (userRequest.isEmpty()) {
                    integer = null;
                } else {
                    integer = Integer.valueOf(userRequest);
                    if (integer <= 0) {
                        throw new WrongTypeInput("Значение цены не натуральное, а отрицательное");
                    }
                }
                //integer=consoleRead.nextInt(); //  в этом случае критическая ошибка

                pass = false;
            } catch (NumberFormatException | WrongTypeInput exception) {
                System.out.println(exception.toString());
                System.out.println("Ошибка: введено неправильное значение.\nPrice соответствует число без букв и пробелов >0. Повторите ввод");
                //throw new WrongTypeInput("Ошибка ввода");
                //TODO сделать exit =)
            }

        } while (pass);
        System.out.println("Гойда");
        return integer;
    }

    private static float askDiscount() {

        System.out.println("Введите значение для параметра 'скидка' > 0 и <= 100\nПример ввода: 15.5");
        float discount = 0;
        Boolean pass = true;
        do {

            try {
                discount = Float.valueOf(consoleRead.nextLine().trim());
                if (discount <= 0 || discount > 100) {
                    throw new WrongTypeInput("Введено неправильное значения параметра 'скидка");
                }
                pass = false;
            } catch (NumberFormatException | WrongTypeInput exception) {
                System.out.println("Ошибка: введено неправильное значение.\nСкидке соответствует число без букв и пробелов. Повторите ввод");
                //throw new WrongTypeInput("Ошибка ввода");
            }
        } while (pass);

        return discount;

    }

    private static Boolean askRefundable() {

        Boolean refundable=null;
        Boolean pass = true;
        System.out.println("Введите значение для параметра 'refundable'\nВыберите соответствующее значение\n1 : да, билет вернуть можно\n2 : нет, вернуть билет нельзя\n3 : не вводить параметр");
        do {
            try {


                switch (Integer.valueOf(consoleRead.nextLine().trim())) {
                    case (1):
                        refundable = true;
                        pass = false;
                        break;
                    case (2):
                        refundable = false;
                        pass = false;
                        break;
                    case (3):
                        refundable = null;
                        pass = false;
                        break;
                    default:
                        System.out.println("Ошибка ввода\nВыберите одно из двух значений.Введите '1' ,или '2', или '3'");
                        break;
                }
            } catch (NumberFormatException exception) {
                System.out.println("Ошибка ввода\nВыберите одно из двух значений.Введите '1' ,или '2', или '3'");
            }
        } while (pass);
        return refundable;

    }

    private static TicketType askTicketType() {
        System.out.println("Выберите значение для параметра 'type':\n1 : VIP\n2 : BUDGETARY\n3 : CHEAP\n4 : не вводить параметр\n(необходимо ввести цифру)");
        TicketType ticketType = null;
        Boolean pass = true;
        do {
            try {
                switch (Integer.valueOf(consoleRead.nextLine().trim())) {
                    case (1):
                        ticketType = TicketType.VIP;
                        pass = false;
                        break;
                    case (2):
                        ticketType = TicketType.BUDGETARY;
                        pass = false;
                        break;
                    case (3):
                        ticketType = TicketType.CHEAP;
                        pass = false;
                        break;
                    case (4):
                        ticketType = null;
                        pass = false;
                        break;
                    default:
                        System.out.println("Ошибка ввода\nВыберите одно из предоставленных значений");
                }
            } catch (NumberFormatException exception) {
                System.out.println("Ошибка ввода\nВыберите одно из предоставленных значений");

            }
        } while (pass);
        return ticketType;

    }

}
