package noppes.npcs.api.event;

import cpw.mods.fml.common.eventhandler.Cancelable;
import noppes.npcs.api.IPos;
import noppes.npcs.api.IWorld;
import noppes.npcs.api.entity.IEntityLivingBase;
import noppes.npcs.api.handler.data.INaturalSpawn;

public interface ICustomNPCsEvent {

    String getHookName();

    @Cancelable
    interface CNPCNaturalSpawnEvent extends ICustomNPCsEvent {

        IEntityLivingBase<?> getEntity();

        INaturalSpawn getNaturalSpawn();

        void setAttemptPosition(IPos attemptPosition);

        IPos getAttemptPosition();

        boolean animalSpawnPassed();

        boolean monsterSpawnPassed();

        boolean liquidSpawnPassed();

        boolean airSpawnPassed();
    }

    interface ScriptedCommandEvent extends ICustomNPCsEvent {
        IWorld getSenderWorld();

        IPos getSenderPosition();

        String getSenderName();

        void setReplyMessage(String message);

        String getId();

        String[] getArgs();
    }
}
