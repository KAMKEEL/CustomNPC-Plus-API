package noppes.npcs.api.ability.type;

import noppes.npcs.api.ability.IAbility;

/**
 * Shared API interface for energy projectile abilities (Orb, Disc, Beam, LaserShot).
 * Contains methods common to all energy projectile types.
 */
public interface IAbilityEnergyProjectile extends IAbility {

    // Combat
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

    float getExplosionDamageFalloff();

    void setExplosionDamageFalloff(float falloff);

    // Lifespan
    float getMaxDistance();

    void setMaxDistance(float distance);

    int getMaxLifetime();

    void setMaxLifetime(int ticks);

    // Colors
    int getInnerColor();

    void setInnerColor(int color);

    int getOuterColor();

    void setOuterColor(int color);

    boolean isOuterColorEnabled();

    void setOuterColorEnabled(boolean enabled);

    float getOuterColorWidth();

    void setOuterColorWidth(float width);

    float getOuterColorAlpha();

    void setOuterColorAlpha(float alpha);

    // Lightning
    boolean hasLightningEffect();

    void setLightningEffect(boolean enabled);

    float getLightningDensity();

    void setLightningDensity(float density);

    float getLightningRadius();

    void setLightningRadius(float radius);

    // Anchor
    int getAnchorPoint();

    void setAnchorPoint(int point);
}
