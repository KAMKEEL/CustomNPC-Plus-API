package noppes.npcs.api.ability.type;

/**
 * API interface for Guard abilities.
 * Defensive stance that reduces incoming damage.
 */
public interface IAbilityGuard extends IAbilityDefend {

    float getDamageReduction();

    void setDamageReduction(float reduction);
}
