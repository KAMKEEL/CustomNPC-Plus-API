package noppes.npcs.api.event;

import cpw.mods.fml.common.eventhandler.Cancelable;
import noppes.npcs.api.IDamageSource;
import noppes.npcs.api.ability.IAbility;
import noppes.npcs.api.entity.ICustomNpc;
import noppes.npcs.api.entity.IEntityLivingBase;

/**
 * Events related to NPC ability execution.
 * These events are fired during the ability lifecycle.
 */
public interface IAbilityEvent extends INpcEvent {

    /**
     * Get the ability involved in this event.
     */
    IAbility getAbility();

    /**
     * Get the target of the ability, or null if no target.
     */
    IEntityLivingBase getTarget();

    /**
     * Fired when an ability starts executing (enters WINDUP phase).
     * Canceling prevents the ability from starting.
     */
    @Cancelable
    interface StartEvent extends IAbilityEvent {
    }

    /**
     * Fired when an ability enters the ACTIVE phase and performs its effect.
     * Canceling prevents the ability effect from occurring.
     */
    @Cancelable
    interface ExecuteEvent extends IAbilityEvent {
    }

    /**
     * Fired when an ability is interrupted by damage.
     */
    interface InterruptEvent extends IAbilityEvent {
        /**
         * Get the damage source that caused the interruption.
         */
        IDamageSource getDamageSource();

        /**
         * Get the amount of damage that caused the interruption.
         */
        float getDamage();
    }

    /**
     * Fired when an ability completes its full execution cycle.
     */
    interface CompleteEvent extends IAbilityEvent {
    }

    /**
     * Fired when an ability hits an entity with damage.
     * Canceling this event prevents the damage from being applied.
     */
    @Cancelable
    interface HitEvent extends IAbilityEvent {
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

    /**
     * Fired every tick while an ability is executing.
     * Provides the current phase and tick count.
     */
    interface TickEvent extends IAbilityEvent {
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
}
