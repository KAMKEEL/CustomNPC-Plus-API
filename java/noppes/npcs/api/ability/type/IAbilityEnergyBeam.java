package noppes.npcs.api.ability.type;

import noppes.npcs.api.ability.IAbility;

/**
 * API interface for Energy Beam abilities.
 * Homing beam head with trailing path attached to origin.
 */
public interface IAbilityEnergyBeam extends IAbility {

    float getSpeed();
    void setSpeed(float speed);

    float getMaxDistance();
    void setMaxDistance(float distance);

    int getMaxLifetime();
    void setMaxLifetime(int ticks);

    float getBeamWidth();
    void setBeamWidth(float width);

    float getHeadSize();
    void setHeadSize(float size);

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

    boolean isExplosive();
    void setExplosive(boolean explosive);

    float getExplosionRadius();
    void setExplosionRadius(float radius);

    int getStunDuration();
    void setStunDuration(int duration);

    int getSlowDuration();
    void setSlowDuration(int duration);

    int getSlowLevel();
    void setSlowLevel(int level);

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
