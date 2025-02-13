package commands;

import managers.CollectionManager;

public class RemoveKey extends Command implements Executable {

    public RemoveKey(int wordsCount) {
        super(wordsCount);
    }

    @Override
    public void execute(String[] splitedConsoleRead) {


        if (splitedConsoleRead.length!=this.getWordsCount()){
            System.out.println("Команда remove_key состоит из команды и ключа\nВозвращение на домашнюю страницу.");
            return;
        }


        if (CollectionManager.getCOLLECTION().containsKey(splitedConsoleRead[1])){
            CollectionManager.getCOLLECTION().remove(splitedConsoleRead[1]);
            System.out.println("Элемент удален!");

        }else {
            System.out.println("Такого ключа нет! Можете ознакомиться с доступными ключами, введя info");
        }
    }

    @Override
    public String toString() {
        return "remove_key";
    }
}
