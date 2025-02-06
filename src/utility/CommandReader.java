package utility;

import managers.CommandManager;
import java.util.Scanner;


public class CommandReader {
    private static String userRequest;

    public static void setUserRequest(String request){
        if (CommandManager.getCommands().containsKey(request)){
            CommandManager.getCommands().get(request).execute();
        }else {
            System.out.println("Комманда не распознана! Поробуйте ознакомиться с перечнем команд, введя '\\help', или перестаньте быть дуракомэ!");
        }


    }
}
