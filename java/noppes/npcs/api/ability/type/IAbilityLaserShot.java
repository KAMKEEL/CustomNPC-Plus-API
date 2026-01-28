package noppes.npcs.api.ability.type;

import noppes.npcs.api.ability.IAbility;

/**
 * API interface for Laser Shot abilities.
 * Fast expanding thin line that pierces through targets.
 */
public interface IAbilityLaserShot extends IAbility {

    float getLaserWidth();
    void setLaserWidth(float width);

    float getExpansionSpeed();
    void setExpansionSpeed(float speed);

    int getLingerTicks();
    void setLingerTicks(int ticks);

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

    boolean hasLightningEffect();
    void setLightningEffect(boolean enabled);
}
