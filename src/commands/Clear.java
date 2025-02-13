package commands;

import managers.CollectionManager;
import managers.CommandManager;

public class Clear extends Command implements Executable{


    @Override
    public void execute(String[] splitedConsoleRead) {
       CollectionManager.getCOLLECTION().clear();
       if (CollectionManager.getCOLLECTION().isEmpty()){
           System.out.println("Коллекция успешно очищена!");
       }

    }

    @Override
    public String toString() {
        return "clear";
    }
}
