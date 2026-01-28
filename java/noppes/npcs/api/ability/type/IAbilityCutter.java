package noppes.npcs.api.ability.type;

import noppes.npcs.api.ability.IAbility;

/**
 * API interface for Cutter abilities.
 * Sweeping fan attack in an arc.
 */
public interface IAbilityCutter extends IAbility {

    float getArcAngle();
    void setArcAngle(float angle);

    float getRange();
    void setRange(float range);

    float getDamage();
    void setDamage(float damage);

    float getKnockback();
    void setKnockback(float knockback);

    /**
     * Get the sweep mode (0 = SWIPE, 1 = SPIN).
     */
    int getSweepMode();
    void setSweepMode(int mode);

    float getSweepSpeed();
    void setSweepSpeed(float speed);

    int getSpinDurationTicks();
    void setSpinDurationTicks(int ticks);

    boolean isPiercing();
    void setPiercing(boolean piercing);

    float getInnerRadius();
    void setInnerRadius(float radius);
}
