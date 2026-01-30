package noppes.npcs.api.handler;

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
     * Get all custom ability preset UUIDs.
     */
    String[] getCustomAbilityIdArray();

    /**
     * Check if a custom ability preset exists by UUID.
     */
    boolean hasCustomAbilityId(String uuid);

    /**
     * Delete a custom ability preset by UUID.
     *
     * @return true if deleted successfully
     */
    boolean deleteCustomAbilityById(String uuid);
}
