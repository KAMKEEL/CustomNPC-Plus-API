package noppes.npcs.api.ability.type;

import noppes.npcs.api.ability.IAbility;

/**
 * API interface for defensive abilities (Guard, Counter, Dodge).
 */
public interface IAbilityDefend extends IAbility {

    int getDurationTicks();

    void setDurationTicks(int ticks);

    int getMaxHitAmount();

    void setMaxHitAmount(int amount);

    boolean isDefending();
}
