package commands.creators;

import entity.Event;
import exeptions.WrongTypeInput;
import utility.Engine;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EventCreator extends Creator {

    public static Event createEvent() throws WrongTypeInput {
        Event.Builder builder = new Event.Builder();
        Scanner consoleRead = new Scanner(System.in);
        boolean pass = true;
        System.out.println("Инициализировано создание ивента");

        System.out.println("Вы хотите создать описание мероприятия?\n1 : да\n2 : нет");
        try {

            switch (consoleRead.nextInt()) {
                case (1):
                    do {
                        System.out.println("Введите название мероприятия");
                        String name = consoleRead.nextLine();
                        if (name.isEmpty()) {
                            System.out.println("Название не может быть пустым!");

                        } else {
                            System.out.println("Гойда");
                            builder.name(name);
                            pass = false;
                        }

                    } while (pass);

                    System.out.println("Введите количество билетов");
                    builder.ticketsCount(consoleRead.nextInt());
                    try {

                        if (builder.getTicketsCount() <= 0) {
                            throw new InputMismatchException();
                        }
                    } catch (InputMismatchException exception) {
                        System.out.println("Ошибка: введено неправильное значение.\nВы будете выброшены на 'главную страницу'");
                        throw new WrongTypeInput("Ошибка ввода");
                    }
                    System.out.println("Введите описание мероприятия");

                    builder.description(consoleRead.nextLine());
                    builder.description(consoleRead.nextLine());
                    //я не понимаю.... ПОЧЕМУ БЛЯЯЯДЬ ЕБ ТВОЮ МАТЬ ОНО ИНАЧЕ НЕ РАБОТАЕТ


                    Event event = builder.build();
                    System.out.println(event.toString());
                    System.out.println("Контроль");
                    return event;


                case (2):
                    Event event2 = null;
                    return event2;
                default:
                    return null;
                // без этой строчки не работает почему-то бляяяяядь
            }
        } catch (InputMismatchException exception) {
            System.out.println("Ошибка ввода\nВы будете выброшены на 'главную страницу'");
            throw new WrongTypeInput("Ошибка ввода");
        }


    }
}
