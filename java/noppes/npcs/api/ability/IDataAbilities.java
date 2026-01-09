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
     * Get all abilities assigned to this NPC.
     */
    IAbility[] getAbilities();

    /**
     * Add an ability to this NPC.
     */
    void addAbility(IAbility ability);

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
}
