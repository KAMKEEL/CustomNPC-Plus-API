package noppes.npcs.api.ability.type;

import noppes.npcs.api.ability.IAbility;

/**
 * API interface for Heavy Hit abilities.
 * Single-target high damage melee attack.
 */
public interface IAbilityHeavyHit extends IAbility {

    float getDamage();
    void setDamage(float damage);

    float getKnockback();
    void setKnockback(float knockback);
}
