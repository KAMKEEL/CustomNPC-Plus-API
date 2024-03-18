package noppes.npcs.api.handler;

import noppes.npcs.api.handler.data.ITag;

import java.util.List;

public interface ITagHandler {
    List<ITag> list();

    ITag delete(int var1);

    ITag create(String var1, int var2);

    ITag get(int var1);
}
