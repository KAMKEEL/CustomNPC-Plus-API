package noppes.npcs.api.event;

import cpw.mods.fml.common.eventhandler.Cancelable;
import noppes.npcs.api.IBlock;
import noppes.npcs.api.IPos;
import noppes.npcs.api.entity.IEntity;
import noppes.npcs.api.entity.IPlayer;

public interface IBlockEvent extends ICustomNPCsEvent {
    IBlock getBlock();
    @Cancelable
    interface EntityFallenUponEvent extends IBlockEvent{
        IEntity getEntity();
        float getDistanceFallen();
    }

    @Cancelable
    interface InteractEvent extends IBlockEvent {
        IPlayer getPlayer();

        float getHitX();

        float getHitY();

        float getHitZ();

        int getSide();
    }

    interface RedstoneEvent extends IBlockEvent{
        int getPrevPower();
        int getPower();
    }
    interface BreakEvent extends IBlockEvent{

    }
    @Cancelable
    interface ExplodedEvent extends IBlockEvent{

    }
    interface RainFillEvent extends IBlockEvent{

    }

    interface NeighborChangedEvent extends IBlockEvent {
        IPos getChangedPos();
    }

    interface InitEvent extends IBlockEvent{

    }
    interface UpdateEvent extends IBlockEvent{

    }

    interface ClickedEvent extends IBlockEvent {
        IPlayer getPlayer();
    }

    @Cancelable
    interface HarvestedEvent extends IBlockEvent {
        IPlayer getPlayer();
    }

    interface CollidedEvent extends IBlockEvent {
        IEntity getEntity();
    }

    interface TimerEvent extends IBlockEvent {
        int getId();
    }
}
