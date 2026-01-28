package noppes.npcs.api.ability.type;

import noppes.npcs.api.ability.IAbility;

/**
 * API interface for Projectile abilities.
 * Ranged projectile attacks.
 */
public interface IAbilityProjectile extends IAbility {

    float getDamage();
    void setDamage(float damage);

    float getSpeed();
    void setSpeed(float speed);

    float getKnockback();
    void setKnockback(float knockback);

    String getProjectileType();
    void setProjectileType(String type);

    boolean isExplosive();
    void setExplosive(boolean explosive);

    float getExplosionRadius();
    void setExplosionRadius(float radius);

    boolean isHoming();
    void setHoming(boolean homing);

    float getHomingStrength();
    void setHomingStrength(float strength);
}
