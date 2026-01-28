package noppes.npcs.api.ability.type;

import noppes.npcs.api.ability.IAbility;

/**
 * API interface for Heal abilities.
 * Healing self and/or allies.
 */
public interface IAbilityHeal extends IAbility {

    int getDurationTicks();
    void setDurationTicks(int ticks);

    float getHealAmount();
    void setHealAmount(float amount);

    float getHealPercent();
    void setHealPercent(float percent);

    boolean isHealSelf();
    void setHealSelf(boolean healSelf);

    boolean isHealAllies();
    void setHealAllies(boolean healAllies);

    float getHealRadius();
    void setHealRadius(float radius);

    boolean isInstantHeal();
    void setInstantHeal(boolean instant);
}
