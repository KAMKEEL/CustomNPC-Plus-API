package noppes.npcs.api.handler;

import noppes.npcs.api.ability.IChainedAbility;

/**
 * Handler for ability management. Allows scripts to query ability types,
 * built-in abilities, and custom ability presets.
 * <p>
 * Access via API.getAbilities()
 */
public interface IAbilityHandler {

    /**
     * Get all registered ability type IDs.
     */
    String[] getTypes();

    /**
     * Check if an ability type is registered.
     */
    boolean hasType(String typeId);

    /**
     * Get all built-in ability names.
     */
    String[] getAbilityNameArray();

    /**
     * Check if a built-in ability exists by name.
     */
    boolean hasAbilityName(String name);

    /**
     * Get all custom ability preset names.
     */
    String[] getCustomAbilityNameArray();

    /**
     * Check if a custom ability preset exists by name.
     */
    boolean hasCustomAbilityName(String name);

    /**
     * Delete a custom ability preset by name.
     *
     * @return true if deleted successfully
     */
    boolean deleteCustomAbilityByName(String name);

    /**
     * Get all chained ability names.
     */
    String[] getChainedAbilityNames();

    /**
     * Check if a chained ability exists by name.
     */
    boolean hasChainedAbilityName(String name);

    /**
     * Delete a chained ability by name.
     *
     * @return true if deleted successfully
     */
    boolean deleteChainedAbilityByName(String name);

    /**
     * Get a chained ability by name.
     *
     * @return the chained ability, or null if not found
     */
    IChainedAbility getChainedAbility(String name);

    /**
     * Save a chained ability. If a chain with the same name exists, it is overwritten.
     *
     * @return true if saved successfully
     */
    boolean saveChainedAbility(IChainedAbility chain);
}
