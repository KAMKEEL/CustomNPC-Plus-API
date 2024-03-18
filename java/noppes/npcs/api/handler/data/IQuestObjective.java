package noppes.npcs.api.handler.data;

public interface IQuestObjective {
    int getProgress();

    void setProgress(int var1);

    int getMaxProgress();

    boolean isCompleted();

    String getText();

    String getAdditionalText();
}
