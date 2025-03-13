package noppes.npcs.api.handler.data;

public interface IMagic {
    int getId();

    String getName();

    void setName(String name);

    void setColor(int c);

    int getColor();

    void save();
}
