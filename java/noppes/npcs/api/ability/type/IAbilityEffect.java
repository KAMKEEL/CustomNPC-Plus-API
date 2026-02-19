package noppes.npcs.api.ability.type;

import noppes.npcs.api.ability.IAbility;

/**
 * API interface for Effect abilities.
 * Applies healing, potion effects, custom effects, and mod-registered effect actions
 * to self or nearby entities.
 */
public interface IAbilityEffect extends IAbility {

    int getDurationTicks();
    void setDurationTicks(int ticks);

    float getHealAmount();
    void setHealAmount(float amount);

    float getHealPercent();
    void setHealPercent(float percent);

    boolean isIncludeSelf();
    void setIncludeSelf(boolean includeSelf);

    float getRadius();
    void setRadius(float radius);

    boolean isInstantHeal();
    void setInstantHeal(boolean instant);

    /**
     * @return Target filter type ordinal: 0=ALLIES, 1=ENEMIES, 2=ALL
     */
    int getTargetFilterType();

    /**
     * @param filter Target filter type ordinal: 0=ALLIES, 1=ENEMIES, 2=ALL
     */
    void setTargetFilterType(int filter);

    /**
     * @return Number of configured custom effects (from CustomEffectController)
     */
    int getCustomEffectCount();

    /**
     * @return Number of configured mod-registered effect actions
     */
    int getEffectActionCount();
}
