package noppes.npcs.api.ability.type;

import noppes.npcs.api.ability.IAbility;

/**
 * API interface for Guard abilities.
 * Defensive stance with optional counter-attack.
 */
public interface IAbilityGuard extends IAbility {

    int getDurationTicks();
    void setDurationTicks(int ticks);

    int getCounterWindow();
    void setCounterWindow(int ticks);

    float getDamageReduction();
    void setDamageReduction(float reduction);

    boolean canCounter();
    void setCanCounter(boolean canCounter);

    int getCounterType();
    void setCounterType(int type);

    float getCounterValue();
    void setCounterValue(float value);

    String getCounterSound();
    void setCounterSound(String sound);

    int getCounterAnimationId();
    void setCounterAnimationId(int animationId);
}
