package noppes.npcs.api.ability.type;

import noppes.npcs.api.ability.IAbility;

/**
 * API interface for Shockwave abilities.
 * Pushes targets away from the caster.
 */
public interface IAbilityShockwave extends IAbility {

    float getPushRadius();
    void setPushRadius(float radius);

    float getPushStrength();
    void setPushStrength(float strength);

    float getDamage();
    void setDamage(float damage);

    int getMaxTargets();
    void setMaxTargets(int max);
}
