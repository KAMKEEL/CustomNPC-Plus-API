package noppes.npcs.api.ability;

/**
 * Interface for an NPC's ability data manager.
 * Provides access to the NPC's abilities and execution state.
 */
public interface IDataAbilities {

    /**
     * Check if the ability system is enabled for this NPC.
     */
    boolean isEnabled();

    /**
     * Enable or disable the ability system for this NPC.
     */
    void setEnabled(boolean enabled);

    /**
     * Get all abilities assigned to this NPC (resolved from slots).
     */
    IAbility[] getAbilities();

    /**
     * Add an inline ability to this NPC.
     */
    void addAbility(IAbility ability);

    /**
     * Add a reference ability by key (built-in name or custom UUID).
     */
    void addAbilityReference(String key);

    /**
     * Remove an ability by ID.
     */
    void removeAbility(String abilityId);

    /**
     * Get an ability by ID.
     */
    IAbility getAbility(String abilityId);

    /**
     * Check if the NPC has an ability with the given ID.
     */
    boolean hasAbility(String abilityId);

    /**
     * Check if a slot is a reference (by ability ID).
     */
    boolean isAbilityReference(String abilityId);

    /**
     * Convert a reference slot to inline (by ability ID).
     * Returns false if the reference cannot be resolved.
     */
    boolean convertToInline(String abilityId);

    /**
     * Clear all abilities from this NPC.
     */
    void clearAbilities();

    /**
     * Get the currently executing ability, or null if none.
     */
    IAbility getCurrentAbility();

    /**
     * Check if any ability is currently executing.
     */
    boolean isExecutingAbility();

    /**
     * Interrupt the current ability if one is executing.
     */
    void interruptCurrentAbility();

    /**
     * Get the global cooldown timer in ticks.
     */
    int getGlobalCooldown();

    /**
     * Set the global cooldown timer in ticks.
     */
    void setGlobalCooldown(int ticks);

    /**
     * Reset all ability cooldowns.
     */
    void resetCooldowns();

    /**
     * Force start an ability on this NPC.
     * If an ability is currently executing, it will be cancelled.
     *
     * @param abilityId The ID of the ability to start
     * @return true if the ability was started successfully
     */
    boolean forceStartAbility(String abilityId);

    /**
     * Force start an ability on this NPC with a specific target.
     * If an ability is currently executing, it will be cancelled.
     *
     * @param abilityId The ID of the ability to start
     * @param target The target entity (can be null for self-targeted abilities)
     * @return true if the ability was started successfully
     */
    boolean forceStartAbility(String abilityId, Object target);

    /**
     * Execute an ability on this NPC by key (built-in name or custom UUID).
     * The NPC does NOT need to have this ability assigned.
     * If an ability is currently executing, it will be cancelled.
     *
     * @param key The ability key (built-in name or custom UUID)
     * @return true if the ability was started successfully
     */
    boolean executeAbility(String key);

    /**
     * Execute an ability on this NPC with a specific target.
     * The NPC does NOT need to have this ability assigned.
     * If an ability is currently executing, it will be cancelled.
     *
     * @param key The ability key (built-in name or custom UUID)
     * @param target The target entity (can be null for self-targeted abilities)
     * @return true if the ability was started successfully
     */
    boolean executeAbility(String key, Object target);

    /**
     * Create a new ability instance by type ID.
     * The ability is not assigned to this NPC - use addAbility() to assign it.
     *
     * @param typeId The type ID (e.g., "cnpc:slam", "cnpc:projectile")
     * @return The new ability, or null if the type is unknown
     */
    IAbility createAbility(String typeId);
}
