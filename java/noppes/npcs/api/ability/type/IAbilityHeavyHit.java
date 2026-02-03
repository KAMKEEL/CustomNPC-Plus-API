package noppes.npcs.api.ability.type;

import noppes.npcs.api.ability.IAbility;

/**
 * API interface for Heavy Hit abilities.
 * AOE rectangle melee attack in front of the caster.
 */
public interface IAbilityHeavyHit extends IAbility {

    float getDamage();
    void setDamage(float damage);

    float getKnockback();
    void setKnockback(float knockback);

    float getHitLength();
    void setHitLength(float hitLength);

    float getHitWidth();
    void setHitWidth(float hitWidth);
}
