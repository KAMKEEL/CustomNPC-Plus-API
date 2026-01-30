package noppes.npcs.api.event;

import cpw.mods.fml.common.eventhandler.Cancelable;
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
     * Fired when a player's ability hits an entity with damage.
     * Canceling this event prevents the damage from being applied.
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
