package commands.creators;

import entity.Coordinates;
import exeptions.WrongTypeInput;
import utility.Engine;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CoordinatesCreator extends Creator  {
    public static Coordinates createCoordinates() throws WrongTypeInput {

        Coordinates.Builder builder = new Coordinates.Builder();
        Scanner consoleRead = new Scanner(System.in);

        System.out.println("Инициализировано задание координат");

        System.out.println("Введите значение x");
        try {
            builder.x(consoleRead.nextInt());
        }catch (InputMismatchException exception){
            System.out.println("Ошибка ввода\nВы будете выброшены на 'главную страницу'");
            throw new WrongTypeInput("Ошибка ввода");
        }

        try {


            System.out.println("Введите значение y, учтите, что оно не должно превышать 484.");
            builder.y(consoleRead.nextDouble());
            if (builder.getY()>484){
                throw new InputMismatchException();
            }
        }catch (InputMismatchException exception){
            System.out.println("Ошибка ввода\nВы будете выброшены на 'главную страницу'");
            throw new WrongTypeInput("Ошибка ввода");
        }


        Coordinates coordinates = builder.build();
        return coordinates;
    }
}
