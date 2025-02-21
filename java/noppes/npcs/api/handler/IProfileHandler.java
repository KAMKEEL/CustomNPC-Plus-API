package noppes.npcs.api.handler;

import noppes.npcs.api.entity.IPlayer;
import noppes.npcs.api.handler.data.IProfile;

public interface IProfileHandler {

    IProfile getProfile(IPlayer player);

    boolean changeSlot(IPlayer player, int slotID);

    boolean hasSlot(IPlayer player, int slotID);

    boolean removeSlot(IPlayer player, int slotID);

    IPlayerData getSlotPlayerData(IPlayer player, int slotID);

    void saveSlotData(IPlayer player);
}
