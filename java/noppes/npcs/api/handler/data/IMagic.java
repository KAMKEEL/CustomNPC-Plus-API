package noppes.npcs.api.handler.data;

import noppes.npcs.api.entity.ICustomNpc;
import noppes.npcs.api.entity.IPlayer;

public interface IMagic {
    int getId();

    String getName();

    void setName(String name);

    void setColor(int c);

    int getColor();

    void save();
}
