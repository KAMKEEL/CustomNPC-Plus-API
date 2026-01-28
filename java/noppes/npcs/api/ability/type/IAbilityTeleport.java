package noppes.npcs.api.ability.type;

import noppes.npcs.api.ability.IAbility;

/**
 * API interface for Teleport abilities.
 * Instant repositioning with various modes.
 */
public interface IAbilityTeleport extends IAbility {

    /**
     * Get the teleport mode (0 = BLINK, 1 = BEHIND, 2 = SINGLE).
     */
    int getMode();
    void setMode(int mode);

    int getBlinkCount();
    void setBlinkCount(int count);

    int getBlinkDelayTicks();
    void setBlinkDelayTicks(int ticks);

    float getBlinkRadius();
    void setBlinkRadius(float radius);

    float getBehindDistance();
    void setBehindDistance(float distance);

    boolean isRequireLineOfSight();
    void setRequireLineOfSight(boolean require);

    boolean isDamageAtStart();
    void setDamageAtStart(boolean damage);

    boolean isDamageAtEnd();
    void setDamageAtEnd(boolean damage);

    float getDamage();
    void setDamage(float damage);

    float getDamageRadius();
    void setDamageRadius(float radius);
}
