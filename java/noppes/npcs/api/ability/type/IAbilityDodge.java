package noppes.npcs.api.ability.type;

/**
 * API interface for Dodge abilities.
 * Cancels the incoming attack event entirely and plays a random dodge animation.
 */
public interface IAbilityDodge extends IAbilityDefend {

    int getDodgeAnimation1Id();

    void setDodgeAnimation1Id(int animationId);

    int getDodgeAnimation2Id();

    void setDodgeAnimation2Id(int animationId);

    int getDodgeAnimation3Id();

    void setDodgeAnimation3Id(int animationId);
}
