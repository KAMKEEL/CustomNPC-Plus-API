package noppes.npcs.api.ability.type;

/**
 * API interface for Counter abilities.
 * Absorbs incoming damage and counter-attacks the attacker.
 */
public interface IAbilityCounter extends IAbilityDefend {

    int getCounterType();

    void setCounterType(int type);

    float getCounterValue();

    void setCounterValue(float value);

    int getCounterAnimationId();

    void setCounterAnimationId(int animationId);
}
