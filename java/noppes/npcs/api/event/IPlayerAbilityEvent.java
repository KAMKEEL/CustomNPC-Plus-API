package noppes.npcs.api.event;

import cpw.mods.fml.common.eventhandler.Cancelable;
import noppes.npcs.api.IDamageSource;
import noppes.npcs.api.ability.IAbility;
import noppes.npcs.api.entity.IEntityLivingBase;

/**
 * Events related to player ability execution.
 * These events are fired during the ability lifecycle when a player uses an ability.
 */
public interface IPlayerAbilityEvent extends IPlayerEvent {

    /**
     * Get the ability involved in this event.
     */
    IAbility getAbility();

    /**
     * Get the target of the ability, or null if no target.
     */
    IEntityLivingBase getTarget();

    /**
     * Fired when a player's ability starts executing (enters WINDUP phase).
     * Canceling prevents the ability from starting.
     *
     * @hookName abilityStart
     */
    @Cancelable
    interface StartEvent extends IPlayerAbilityEvent {
    }

    /**
     * Fired when a player's ability enters the ACTIVE phase and performs its effect.
     * Canceling prevents the ability effect from occurring.
     *
     * @hookName abilityExecute
     */
    @Cancelable
    interface ExecuteEvent extends IPlayerAbilityEvent {
    }

    /**
     * Fired when a player's ability is interrupted by damage.
     *
     * @hookName abilityInterrupt
     */
    interface InterruptEvent extends IPlayerAbilityEvent {
        /**
         * Get the damage source that caused the interruption, or null if not damage-triggered.
         */
        IDamageSource getDamageSource();

        /**
         * Get the amount of damage that caused the interruption.
         */
        float getDamage();
    }

    /**
     * Fired when a player's ability completes its full execution cycle.
     *
     * @hookName abilityComplete
     */
    interface CompleteEvent extends IPlayerAbilityEvent {
    }

    /**
     * Fired every tick while a player's ability is executing.
     * Provides the current phase and tick count.
     *
     * @hookName abilityTick
     */
    interface TickEvent extends IPlayerAbilityEvent {
        /**
         * Get the current phase of the ability.
         * 0 = IDLE, 1 = WINDUP, 2 = ACTIVE, 3 = RECOVERY
         */
        int getAbilityPhase();

        /**
         * Get the current tick count within the phase.
         */
        int getTick();
    }

    /**
     * Fired when a player's ability hits an entity with damage.
     * Canceling this event prevents the damage from being applied.
     *
     * @hookName abilityHit
     */
    @Cancelable
    interface HitEvent extends IPlayerAbilityEvent {
        /**
         * Get the entity that was hit by the ability.
         */
        IEntityLivingBase getHitEntity();

        /**
         * Get the damage amount.
         */
        float getDamage();

        /**
         * Set the damage amount. Allows scripts to modify damage.
         */
        void setDamage(float damage);

        /**
         * Get the horizontal knockback amount.
         */
        float getKnockback();

        /**
         * Set the horizontal knockback amount.
         */
        void setKnockback(float knockback);

        /**
         * Get the vertical knockback (upward force) amount.
         */
        float getKnockbackUp();

        /**
         * Set the vertical knockback (upward force) amount.
         */
        void setKnockbackUp(float knockbackUp);
    }
}
