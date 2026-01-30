package noppes.npcs.api.ability;

/**
 * Interface for managing player abilities.
 * Players reference abilities by key (built-in names or custom UUIDs).
 * <p>
 * Access via IPlayerData.getAbilityData()
 */
public interface IPlayerAbilityData {

    /**
     * Get all unlocked ability keys.
     */
    String[] getUnlockedAbilities();

    /**
     * Unlock an ability for this player.
     *
     * @param key The ability key (built-in name or custom UUID)
     */
    void unlockAbility(String key);

    /**
     * Lock (remove) an ability from this player.
     */
    void lockAbility(String key);

    /**
     * Check if the player has unlocked a specific ability.
     */
    boolean hasUnlockedAbility(String key);

    /**
     * Get the currently selected ability index.
     */
    int getSelectedIndex();

    /**
     * Set the selected ability index.
     */
    void setSelectedIndex(int index);

    /**
     * Get the key of the currently selected ability.
     */
    String getSelectedAbilityKey();

    /**
     * Select the next ability in the list.
     */
    void selectNext();

    /**
     * Select the previous ability in the list.
     */
    void selectPrevious();

    /**
     * Check if the player is currently executing an ability.
     */
    boolean isExecutingAbility();

    /**
     * Get the currently executing ability.
     */
    IAbility getCurrentAbility();

    /**
     * Interrupt the currently executing ability.
     */
    void interruptCurrentAbility();

    /**
     * Check if the player is on universal cooldown.
     */
    boolean isOnCooldown();

    /**
     * Check if a specific ability is on cooldown.
     *
     * @param key The ability key
     * @return true if on cooldown
     */
    boolean isOnCooldown(String key);

    /**
     * Reset the universal cooldown.
     */
    void resetCooldown();

    /**
     * Reset cooldown for a specific ability key.
     *
     * @param key The ability key
     */
    void resetCooldown(String key);

    /**
     * Reset all cooldowns.
     */
    void resetAllCooldowns();

    /**
     * Activate the currently selected ability.
     */
    boolean activateAbility();

    /**
     * Activate a specific ability by key.
     */
    boolean activateAbility(String key);
}
