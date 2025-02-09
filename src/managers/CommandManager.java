package managers;

import commands.*;


import java.util.HashMap;
import java.util.Map;


public class CommandManager {
    private static final Map<String, Executable> COMMAND_MAP = new HashMap<>();

    public static void setUpCommand(Executable command){
        addCommand(command.toString(),command);

    }


    private static final void addCommand(String name, Executable command) {
        COMMAND_MAP.put(name, command);
    }

    public static final Map<String, Executable> getCommands() {
        return COMMAND_MAP;
    }

    public static void setUserRequest(String[] splitedRequest){
        String request= splitedRequest[0];
        if (CommandManager.getCommands().containsKey(request)){
            CommandManager.getCommands().get(request).execute(splitedRequest);
        }else {
            System.out.println("Команда не распознана! Попробуйте ознакомиться с перечнем команд, введя '\\help'.");
        }
    }



}
