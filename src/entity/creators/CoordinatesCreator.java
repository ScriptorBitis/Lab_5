package entity.creators;

import entity.Coordinates;
import exeptions.ExitWhileBuilding;
import exeptions.WrongInput;

import java.util.Scanner;

public class CoordinatesCreator extends Creator {

    private static Scanner consoleRead = new Scanner(System.in);

    public static Coordinates createCoordinates() throws WrongInput {

        Coordinates.Builder builder = new Coordinates.Builder();


        System.out.println("Инициализировано задание координат");

        builder.x(askX());
        builder.y(askY());
        Coordinates coordinates = builder.build();
        return coordinates;
    }

    private static int askX() {
        System.out.println("Введите координату x");
        int x = 0;
        boolean pass = true;
        do {
            try {
                String userRequest = consoleRead.nextLine().trim();
                if (userRequest.equals("exit")) {
                    throw new ExitWhileBuilding("Введена команда exit во время ввода координаты x");
                }
                x = Integer.valueOf(userRequest);


                pass = false;
            } catch (NumberFormatException exception) {
                System.out.println("Ошибка ввода.Попробуйте снова");
            }
        } while (pass);
        return x;
    }


    private static Double askY() {
        System.out.println("Введите координату y. Учтите, что y не может быть больше 484");
        Double y = 0.0;
        boolean pass = true;
        do {
            try {
                String userRequest = consoleRead.nextLine().trim();
                if (userRequest.equals("exit")) {
                    throw new ExitWhileBuilding("Создание объекта прервано:\nВведена команда exit во время ввода координаты x");
                }
                y = Double.valueOf(userRequest);
                if (y > 484) {
                    throw new WrongInput("y превышает максимальное значение");
                }
                pass = false;
            } catch (NumberFormatException | WrongInput exception) {
                System.out.println("Ошибка ввода.Попробуйте снова");

            }

        } while (pass);

        return y;
    }


}
