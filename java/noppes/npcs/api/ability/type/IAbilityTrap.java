package noppes.npcs.api.ability.type;

/**
 * API interface for Trap abilities.
 * Proximity-triggered traps placed around the caster.
 */
public interface IAbilityTrap extends IAbilityZone {

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
