package utility;

import managers.CommandManager;

import java.util.Scanner;


public class Engine {
    private static boolean flag = true;

    public static void finishProgramm (){
        flag=false;
    }

    public static void runProgramm() {
        do {
            Scanner consoleRead = new Scanner(System.in);

            CommandManager.setUserRequest(consoleRead.nextLine().trim().split(" "));
        } while (flag);
    }
}
