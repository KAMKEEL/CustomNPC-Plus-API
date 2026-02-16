package noppes.npcs.api.entity;

import net.minecraft.entity.Entity;

/**
 * Represents an energy projectile entity (Orb, Beam, Disc, Laser).
 * Extends IEntity so scripts have full access to both entity and energy-specific methods.
 */
public interface IEnergyProjectile<T extends Entity> extends IEntity<T> {

    // ==================== OWNER & TARGET ====================

    int getOwnerEntityId();

    IEntity getOwner();

    void setOwner(IEntity owner);

    int getTargetEntityId();

    IEntity getTarget();

    void setTarget(IEntity target);

    // ==================== SIZE ====================

    float getSize();

    void setSize(float size);

    // ==================== DISPLAY ====================

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

    float getRotationSpeed();

    void setRotationSpeed(float speed);

    // ==================== INTERPOLATION (READ-ONLY) ====================

    float getInterpolatedRotationX(float partialTicks);

    float getInterpolatedRotationY(float partialTicks);

    float getInterpolatedRotationZ(float partialTicks);

    float getInterpolatedSize(float partialTicks);

    // ==================== LIGHTNING ====================

    boolean hasLightningEffect();

    void setLightningEffect(boolean enabled);

    float getLightningDensity();

    void setLightningDensity(float density);

    float getLightningRadius();

    void setLightningRadius(float radius);

    int getLightningFadeTime();

    void setLightningFadeTime(int ticks);

    // ==================== LIFESPAN ====================

    float getMaxDistance();

    void setMaxDistance(float distance);

    int getMaxLifetime();

    void setMaxLifetime(int ticks);

    // ==================== COMBAT ====================

    float getDamage();

    void setDamage(float damage);

    float getKnockback();

    void setKnockback(float knockback);

    float getKnockbackUp();

    void setKnockbackUp(float knockbackUp);

    boolean isExplosive();

    void setExplosive(boolean explosive);

    float getExplosionRadius();

    void setExplosionRadius(float radius);

    float getExplosionDamageFalloff();

    void setExplosionDamageFalloff(float falloff);

    // ==================== MOVEMENT ====================

    float getSpeed();

    void setSpeed(float speed);

    boolean isHoming();

    void setHoming(boolean homing);

    float getHomingStrength();

    void setHomingStrength(float strength);

    float getHomingRange();

    void setHomingRange(float range);

    // ==================== ANCHOR ====================

    int getAnchor();

    float getAnchorOffsetX();

    float getAnchorOffsetY();

    float getAnchorOffsetZ();

    // ==================== POSITION ====================

    double getStartX();

    double getStartY();

    double getStartZ();

    // ==================== STATE ====================

    boolean hasHit();

    boolean isCharging();

    float getChargeProgress();

    /**
     * Returns the energy projectile sub-type.
     * 0=Orb, 1=Beam, 2=Disc, 3=Laser
     */
    int getEnergyType();

    // ==================== FIRE / LAUNCH ====================

    /**
     * Spawns the projectile in the world (if not yet spawned) and starts it moving toward the target entity.
     */
    void fire(IEntity target);

    /**
     * Spawns the projectile in the world (if not yet spawned) and starts it moving toward the specified coordinates.
     */
    void fire(double x, double y, double z);

    /**
     * Spawns the projectile in the world (if not yet spawned) and starts it moving in the specified direction.
     */
    void fire(float yaw, float pitch);

    /**
     * Sets the owner, positions the projectile at the caster's eye level, and fires in the caster's look direction.
     * Convenience method similar to how fireKiAttack works.
     */
    void fire(IEntityLivingBase caster);

    /**
     * Sets the owner, positions the projectile at the caster's eye level, and fires toward the target entity.
     */
    void fire(IEntityLivingBase caster, IEntity target);

}
