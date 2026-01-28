package noppes.npcs.api.ability.type;

import noppes.npcs.api.ability.IAbility;

/**
 * API interface for Vortex abilities.
 * Pulls targets toward the caster.
 */
public interface IAbilityVortex extends IAbility {

    float getPullRadius();
    void setPullRadius(float radius);

    float getPullStrength();
    void setPullStrength(float strength);

    float getDamage();
    void setDamage(float damage);

    float getKnockback();
    void setKnockback(float knockback);

    boolean isAoe();
    void setAoe(boolean aoe);

    int getMaxTargets();
    void setMaxTargets(int max);

    boolean isDamageOnPull();
    void setDamageOnPull(boolean damage);

    float getPullDamage();
    void setPullDamage(float damage);
}
