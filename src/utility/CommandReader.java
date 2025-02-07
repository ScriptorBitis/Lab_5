package utility;

import managers.CommandManager;



public class CommandReader {
    //private static String userRequest;

    public static void setUserRequest(String request,String[] splitedRequest){
        if (CommandManager.getCommands().containsKey(request)){
            CommandManager.getCommands().get(request).execute(splitedRequest);
        }else {
            System.out.println("Команда не распознана! Попробуйте ознакомиться с перечнем команд, введя '\\help', или перестаньте быть дураком!");
        }


    }
}
