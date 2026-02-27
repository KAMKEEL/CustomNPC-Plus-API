package noppes.npcs.api.event;

import noppes.npcs.api.IDamageSource;
import noppes.npcs.api.ability.IChainedAbility;
import noppes.npcs.api.entity.ICustomNpc;
import noppes.npcs.api.entity.IEntityLivingBase;
import noppes.npcs.api.entity.IPlayer;

/**
 * Events related to chained ability execution lifecycle.
 * These fire at chain-level transitions, not per-ability.
 * Unified for both NPCs and Players.
 */
public interface IChainEvent extends ICustomNPCsEvent {

    /**
     * Get the entity executing the chain (NPC or Player).
     */
    IEntityLivingBase getEntity();

    /**
     * Get the player executing the chain, or null if the caster is an NPC.
     */
    IPlayer getPlayer();

    /**
     * Get the NPC executing the chain, or null if the caster is a player.
     */
    ICustomNpc<?> getNpc();

    /**
     * Whether the entity executing the chain is an NPC.
     */
    boolean isNPC();

    /**
     * Get the chained ability being executed.
     */
    IChainedAbility getChain();

    /**
     * Get the target of the chain, or null if no target.
     */
    IEntityLivingBase getTarget();

    /**
     * Get the current entry index within the chain (0-based).
     */
    int getEntryIndex();

    /**
     * Fired when a chained ability sequence starts executing.
     */
    interface StartEvent extends IChainEvent {}

    /**
     * Fired when the chain advances to the next entry in the sequence.
     */
    interface NextEvent extends IChainEvent {}

    /**
     * Fired when a chained ability sequence completes all entries.
     */
    interface CompleteEvent extends IChainEvent {}

    /**
     * Fired when a chained ability is interrupted by damage.
     */
    interface InterruptEvent extends IChainEvent {
        /**
         * Get the damage source that caused the interruption.
         */
        IDamageSource getDamageSource();

        /**
         * Get the amount of damage that caused the interruption.
         */
        float getDamage();
    }
}
