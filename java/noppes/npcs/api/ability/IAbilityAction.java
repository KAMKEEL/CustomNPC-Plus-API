package noppes.npcs.api.ability;

/**
 * Common API interface for all combat actions (abilities and chained abilities).
 * Both {@link IAbility} and {@link IChainedAbility} extend this interface.
 */
public interface IAbilityAction {

    String getName();

    boolean isEnabled();

    int getWeight();

    int getCooldownTicks();

    float getMinRange();

    float getMaxRange();

    /**
     * Whether this action is a chained ability (sequence) vs an individual ability.
     */
    boolean isChain();
}
