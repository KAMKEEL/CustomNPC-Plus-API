package noppes.npcs.api.ability.type;

import noppes.npcs.api.ability.IAbility;

/**
 * API interface for Trap abilities.
 * Proximity-triggered traps.
 */
public interface IAbilityTrap extends IAbility {

    int getDurationTicks();
    void setDurationTicks(int ticks);

    /**
     * Get the placement mode (0 = AT_CASTER, 1 = AT_TARGET, 2 = AHEAD_OF_CASTER).
     */
    int getPlacement();
    void setPlacement(int placement);

    float getPlacementDistance();
    void setPlacementDistance(float distance);

    float getTriggerRadius();
    void setTriggerRadius(float radius);

    int getArmTime();
    void setArmTime(int ticks);

    int getMaxTriggers();
    void setMaxTriggers(int max);

    int getTriggerCooldown();
    void setTriggerCooldown(int cooldown);

    float getDamage();
    void setDamage(float damage);

    float getDamageRadius();
    void setDamageRadius(float radius);

    float getKnockback();
    void setKnockback(float knockback);

    boolean isVisible();
    void setVisible(boolean visible);
}
