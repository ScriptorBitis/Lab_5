package entity.creators;

import entity.Event;
import exeptions.WrongTypeInput;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EventCreator extends Creator {
    private static Scanner consoleRead = new Scanner(System.in);

    public static Event createEvent() throws WrongTypeInput {
        Event event=null;
        Event.Builder builder = new Event.Builder();


        System.out.println("Инициализировано создание ивента");

        System.out.println("Вы хотите создать описание мероприятия?\n1 : да\n2 : нет");

        boolean pass= true;
        do {

            try {


                switch (Integer.valueOf(consoleRead.nextLine())) {
                    case (1):
                        builder.name(askName());
                        builder.ticketsCount(askTicketCount());
                        builder.description(askDescription());
                        System.out.println("Контроль"+ builder.toString());
                        event = builder.build();
                        pass = false;
                        break;
                    case (2):
                        event = null;
                        pass = false;
                        break;
                    default:
                        pass = true;
                        System.out.println("Ошибка ввода.\nВыберите одно из двухъ значений");
                        break;


                }
            }catch (NumberFormatException exception){
                System.out.println("Ошибка ввода: выберите одно из двух значений");
            }

        }while (pass);


        return event;

    }
    private static String askName(){
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
    private  static int askTicketCount(){
        System.out.println("Введите количество билетов");
        int ticketCount=0;
        boolean pass=true;
        do{
        try {
            ticketCount=Integer.valueOf(consoleRead.nextLine().trim());

            if (ticketCount <= 0) {
                throw new WrongTypeInput("Количество билетов отрицательное");
            }
            pass=false;
        } catch (NumberFormatException | WrongTypeInput exception) {
            System.out.println("Ошибка: введено неправильное значение.\nЗначение должно быть больше 0");

        }
        }while (pass);
        return ticketCount;
    }
    private static String askDescription(){
        String description;
        boolean pass=true;
        System.out.println("Введите описание мероприятия.Ввод пустой строки будет засчитан как отсутствие описания");
        description=consoleRead.nextLine().trim();
        if (description.isEmpty()){
            return null;
        }
        else {
            return description;
        }

    }


}
