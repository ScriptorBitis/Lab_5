package commands;

public abstract class Command {
    int wordsCount;
    String necessaryToken;

    public Command(int wordsCount, String necessaryToken) {
        this.wordsCount = wordsCount;
        this.necessaryToken = necessaryToken;
    }

    public Command() {
    }

    public int getWordsCount() {
        return wordsCount;
    }

    public String getNecessaryToken() {
        return necessaryToken;
    }
}
