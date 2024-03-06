package noppes.npcs.api.event;

import cpw.mods.fml.common.eventhandler.Cancelable;
import noppes.npcs.api.entity.IPlayer;
import noppes.npcs.api.handler.data.IParty;
import noppes.npcs.api.handler.data.IQuest;
import noppes.npcs.api.item.IItemStack;

public interface IPartyEvent {

    IParty getParty();

    IQuest getQuest();

    interface PartyQuestCompletedEvent extends IPartyEvent {
    }

    @Cancelable
    interface PartyQuestSetEvent extends IPartyEvent {
    }

    @Cancelable
    interface PartyQuestTurnedInEvent extends IPartyEvent { }

    @Cancelable
    interface PartyInviteEvent extends IPartyEvent {

        IPlayer getPlayer();

        String getPlayerName();

    }

    @Cancelable
    interface PartyKickEvent extends IPartyEvent {
        IPlayer getPlayer();

        String getPlayerName();
    }

    interface PartyLeaveEvent extends IPartyEvent {
        IPlayer getPlayer();

        String getPlayerName();
    }

    interface PartyDisbandEvent extends IPartyEvent {
    }
}
