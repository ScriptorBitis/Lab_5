package commands;

import managers.CollectionManager;

public class Info extends Command implements Executable{

    @Override
    public void execute(String[] splitedConsoleRead) {
        System.out.println("Информация о коллекции:\n"+
                "Количество элементов : "+ CollectionManager.getCOLLECTION().size()+"\n"+
                "Тип : " + CollectionManager.getCOLLECTION().getClass().getSimpleName()+"\n"+
                "Время инициализации : "+ CollectionManager.getInitializationDate()+"\n"+
                "Набор доступных ключей : "+ CollectionManager.getCOLLECTION().keySet()+"\n"






        );
    }

    @Override
    public String toString() {
        return "info";
    }
}
