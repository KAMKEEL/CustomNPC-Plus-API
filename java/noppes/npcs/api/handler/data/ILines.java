package noppes.npcs.api.handler.data;

public interface ILines {

    ILine createLine(String text);

    ILine getLine(boolean isRandom);

    ILine getLine(int lineIndex);

    void setLine(int lineIndex, ILine line);

    void removeLine(int lineIndex);

    void clear();

    boolean isEmpty();

    Integer[] getKeys();
}
