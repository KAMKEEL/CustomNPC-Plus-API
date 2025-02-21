package noppes.npcs.api.handler.data;

import noppes.npcs.api.IContainer;
import noppes.npcs.api.entity.IPlayer;

public interface IQuest {
    int getId();

    String getName();

    void setName(String var1);

    int getType();

    void setType(int var1);

    String getLogText();

    void setLogText(String var1);

    String getCompleteText();

    void setCompleteText(String var1);

    IQuest getNextQuest();

    void setNextQuest(IQuest var1);

    IQuestObjective[] getObjectives(IPlayer var1);

    IQuestCategory getCategory();

    IContainer getRewards();

    String getNpcName();

    void setNpcName(String var1);

    void save();

    boolean getIsRepeatable();

    long getTimeUntilRepeat(IPlayer player);

    void setRepeatType(int type);

    int getRepeatType();

    IQuestInterface getQuestInterface();

    IPartyOptions getPartyOptions();

    boolean isProfileShared();

    void setProfileShared(boolean value);

    long getCustomCooldown();

    void setCustomCooldown(long newCooldown);
}
