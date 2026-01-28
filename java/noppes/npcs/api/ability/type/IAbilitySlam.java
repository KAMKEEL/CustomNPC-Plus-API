package noppes.npcs.api.ability.type;

import noppes.npcs.api.ability.IAbility;

/**
 * API interface for Slam abilities.
 * Ground-pound AOE attack with leap.
 */
public interface IAbilitySlam extends IAbility {

    float getDamage();
    void setDamage(float damage);

    float getRadius();
    void setRadius(float radius);

    float getKnockbackStrength();
    void setKnockbackStrength(float knockback);

    float getLeapSpeed();
    void setLeapSpeed(float speed);

    float getLeapHeight();
    void setLeapHeight(float height);
}
