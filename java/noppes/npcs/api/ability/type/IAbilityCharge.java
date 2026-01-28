package noppes.npcs.api.ability.type;

import noppes.npcs.api.ability.IAbility;

/**
 * API interface for Charge abilities.
 * Rush forward attack.
 */
public interface IAbilityCharge extends IAbility {

    float getChargeSpeed();
    void setChargeSpeed(float speed);

    float getDamage();
    void setDamage(float damage);

    float getKnockback();
    void setKnockback(float knockback);

    float getHitWidth();
    void setHitWidth(float width);
}
