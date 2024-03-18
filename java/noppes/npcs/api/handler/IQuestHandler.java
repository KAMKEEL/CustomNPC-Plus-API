package noppes.npcs.api.handler;

import noppes.npcs.api.handler.data.IQuest;
import noppes.npcs.api.handler.data.IQuestCategory;

import java.util.List;

public interface IQuestHandler {
    List<IQuestCategory> categories();

    IQuest get(int var1);
}
