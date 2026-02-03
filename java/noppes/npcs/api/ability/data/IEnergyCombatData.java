package noppes.npcs.api.ability.data;

public interface IEnergyCombatData {
    float getDamage();

    void setDamage(float damage);

    float getKnockback();

    void setKnockback(float knockback);

    float getKnockbackUp();

    void setKnockbackUp(float knockbackUp);

    boolean isExplosive();

    void setExplosive(boolean explosive);

    float getExplosionRadius();

    void setExplosionRadius(float explosionRadius);

    float getExplosionDamageFalloff();

    void setExplosionDamageFalloff(float explosionDamageFalloff);
}
