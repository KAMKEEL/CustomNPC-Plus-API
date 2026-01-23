package noppes.npcs.api.handler;

/**
 * Handler for ability presets. Allows scripts to save, load, and manage
 * reusable ability templates.
 * <p>
 * Access via API.getAbilities()
 */
public interface IAbilityHandler {

    /**
     * Get all registered ability type IDs.
     * These are the types that can be used to create new abilities.
     *
     * @return Array of type IDs (e.g., "cnpc:slam", "cnpc:charge")
     */
    String[] getTypes();

    /**
     * Check if an ability type is registered.
     *
     * @param typeId The type ID to check
     * @return true if the type exists
     */
    boolean hasType(String typeId);

    /**
     * Get all saved ability preset names.
     *
     * @return Array of saved ability names
     */
    String[] getSavedNames();

    /**
     * Check if a saved ability preset exists.
     *
     * @param name The name of the ability
     * @return true if the preset exists
     */
    boolean has(String name);

    /**
     * Delete a saved ability preset.
     *
     * @param name The name of the ability to delete
     * @return true if deleted successfully
     */
    boolean delete(String name);
}
