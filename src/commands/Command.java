package commands;

public abstract class Command {
    int wordsCount;

    public Command(int wordsCount) {
        this.wordsCount = wordsCount;
    }

    public Command() {
    }

    public int getWordsCount() {
        return wordsCount;
    }

}
