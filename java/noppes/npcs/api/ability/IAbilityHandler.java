package noppes.npcs.api.ability;

/**
 * Handler for ability registration and creation.
 * Use this to register custom ability types from external mods.
 */
public interface IAbilityHandler {

    /**
     * Register a custom ability type.
     * Call during FMLInitializationEvent.
     *
     * @param typeId       The unique type ID (e.g., "mymod:custom_ability")
     * @param abilityClass The class that implements the ability
     */
    void registerType(String typeId, Class<? extends IAbility> abilityClass);

    /**
     * Check if an ability type is registered.
     */
    boolean hasType(String typeId);

    /**
     * Get all registered ability type IDs.
     */
    String[] getTypes();

    /**
     * Create a new ability of the given type.
     * Returns null if the type is not registered.
     */
    IAbility create(String typeId);
}
