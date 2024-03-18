package noppes.npcs.api.handler.data;

public interface ITag {
    String getUuid();

    String getName();

    void setName(String name);

    void setColor(int c);

    int getId();

    int getColor();

    boolean getIsHidden();

    void setIsHidden(boolean hidden);

    void save();
}
