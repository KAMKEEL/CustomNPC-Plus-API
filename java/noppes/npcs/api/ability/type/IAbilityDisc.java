package noppes.npcs.api.ability.type;

import noppes.npcs.api.ability.IAbility;

/**
 * API interface for Disc abilities.
 * Flat spinning disc projectile with optional boomerang.
 */
public interface IAbilityDisc extends IAbility {

    float getSpeed();
    void setSpeed(float speed);

    float getDiscRadius();
    void setDiscRadius(float radius);

    float getDiscThickness();
    void setDiscThickness(float thickness);

    float getMaxDistance();
    void setMaxDistance(float distance);

    int getMaxLifetime();
    void setMaxLifetime(int ticks);

    float getDamage();
    void setDamage(float damage);

    float getKnockback();
    void setKnockback(float knockback);

    float getKnockbackUp();
    void setKnockbackUp(float knockback);

    boolean isHoming();
    void setHoming(boolean homing);

    float getHomingStrength();
    void setHomingStrength(float strength);

    float getHomingRange();
    void setHomingRange(float range);

    boolean isBoomerang();
    void setBoomerang(boolean boomerang);

    int getBoomerangDelay();
    void setBoomerangDelay(int ticks);

    boolean isExplosive();
    void setExplosive(boolean explosive);

    float getExplosionRadius();
    void setExplosionRadius(float radius);

    int getInnerColor();
    void setInnerColor(int color);

    int getOuterColor();
    void setOuterColor(int color);

    boolean isOuterColorEnabled();
    void setOuterColorEnabled(boolean enabled);

    float getRotationSpeed();
    void setRotationSpeed(float speed);

    boolean hasLightningEffect();
    void setLightningEffect(boolean enabled);

    /**
     * Get the anchor point for charging (0-7, see AnchorPoint enum).
     */
    int getAnchorPoint();
    void setAnchorPoint(int point);
}
