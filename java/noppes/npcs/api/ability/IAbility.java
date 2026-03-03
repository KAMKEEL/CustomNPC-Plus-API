package noppes.npcs.api.ability;

import noppes.npcs.api.INbt;
import noppes.npcs.api.handler.data.IMagicData;

/**
 * Interface for NPC abilities.
 * Abilities are special attacks or actions that NPCs can perform during combat.
 */
public interface IAbility extends IAbilityAction {

    /**
     * Get the unique ID (UUID for custom abilities, registry key for built-in).
     * This is the stable reference that never changes after creation.
     */
    String getId();

    /**
     * Set the unique ID of this ability instance.
     * @param id Unique ability ID.
     */
    void setId(String id);

    /**
     * Get the unique identifier/name of this ability (used for file naming, commands, search).
     */
    String getName();

    /**
     * Set the unique identifier/name of this ability.
     * @param name Unique identifier.
     */
    void setName(String name);

    /**
     * Get the display name (cosmetic). Falls back to getName() if not set.
     */
    String getDisplayName();

    /**
     * Set the display name (cosmetic). Pass empty string to use getName() as display.
     * @param displayName Display name, or empty string for default.
     */
    void setDisplayName(String displayName);

    /**
     * Get the type ID of this ability (e.g., "cnpc:slam", "cnpc:beam").
     */
    String getTypeId();

    /**
     * Check if this ability is enabled.
     */
    boolean isEnabled();

    /**
     * Enable or disable this ability.
     * @param enabled Whether the ability is enabled.
     */
    void setEnabled(boolean enabled);

    /**
     * Get the selection weight for random ability selection.
     * Higher weight = more likely to be selected.
     */
    int getWeight();

    /**
     * Set the selection weight.
     * @param weight Selection weight (higher = more likely).
     */
    void setWeight(int weight);

    /**
     * Get the minimum range at which this ability can be used.
     */
    float getMinRange();

    /**
     * Set the minimum range.
     * @param range Minimum range in blocks.
     */
    void setMinRange(float range);

    /**
     * Get the maximum range at which this ability can be used.
     */
    float getMaxRange();

    /**
     * Set the maximum range.
     * @param range Maximum range in blocks.
     */
    void setMaxRange(float range);

    /**
     * Get the cooldown time in ticks.
     */
    int getCooldownTicks();

    /**
     * Set the cooldown time in ticks.
     * @param ticks Cooldown duration in ticks.
     */
    void setCooldownTicks(int ticks);

    /**
     * Get the wind-up time in ticks (telegraph phase).
     */
    int getWindUpTicks();

    /**
     * Set the wind-up time in ticks.
     * @param ticks Wind-up duration in ticks.
     */
    void setWindUpTicks(int ticks);

    /**
     * Get the dazed time in ticks (stun after interrupt during WINDUP).
     */
    int getDazedTicks();

    /**
     * Set the dazed time in ticks.
     * @param ticks Dazed duration in ticks.
     */
    void setDazedTicks(int ticks);

    /**
     * Check if this ability can be interrupted by damage.
     */
    boolean isInterruptible();

    /**
     * Set whether this ability can be interrupted.
     * @param interruptible Whether the ability is interruptible.
     */
    void setInterruptible(boolean interruptible);

    /**
     * Check if this ability ignores target invulnerability frames (hurt resistance).
     */
    boolean isIgnoreIFrames();

    /**
     * Set whether this ability ignores target invulnerability frames (hurt resistance).
     * @param ignore Whether to ignore invulnerability frames.
     */
    void setIgnoreIFrames(boolean ignore);

    /**
     * Get the lock movement type for this ability.
     *
     * @return 0=NO, 1=WINDUP, 2=ACTIVE, 3=WINDUP_AND_ACTIVE
     */
    int getLockMovementType();

    /**
     * Set the lock movement type for this ability.
     *
     * @param type 0=NO, 1=WINDUP, 2=ACTIVE, 3=WINDUP_AND_ACTIVE
     */
    void setLockMovementType(int type);

    /**
     * Get the rotation mode for this ability.
     *
     * @return 0=FREE, 1=LOCKED, 2=TRACK
     */
    int getRotationModeType();

    /**
     * Set the rotation mode for this ability.
     *
     * @param type 0=FREE, 1=LOCKED, 2=TRACK
     */
    void setRotationModeType(int type);

    /**
     * Get the rotation phase for this ability (when rotation mode applies).
     *
     * @return 0=NO, 1=WINDUP, 2=ACTIVE, 3=WINDUP_AND_ACTIVE
     */
    int getRotationPhaseType();

    /**
     * Set the rotation phase for this ability.
     *
     * @param type 0=NO, 1=WINDUP, 2=ACTIVE, 3=WINDUP_AND_ACTIVE
     */
    void setRotationPhaseType(int type);

    /**
     * Get track delay for TRACK rotation mode.
     * 0 = instant tracking (legacy). Higher values = slower lerp toward target.
     */
    float getTrackDelayValue();

    /**
     * Set track delay for TRACK rotation mode.
     *
     * @param delay 0 = instant tracking. Higher values = slower lerp toward target.
     */
    void setTrackDelayValue(float delay);

    /**
     * Check if movement (pathfinding/motion) is locked during the WINDUP phase.
     */
    boolean isMovementLockedDuringWindup();

    /**
     * Check if movement (pathfinding/motion) is locked during the ACTIVE phase.
     */
    boolean isMovementLockedDuringActive();

    /**
     * Check if rotation (yaw/pitch) is locked during the WINDUP phase.
     */
    boolean isRotationLockedDuringWindup();

    /**
     * Check if rotation (yaw/pitch) is locked during the ACTIVE phase.
     */
    boolean isRotationLockedDuringActive();

    /**
     * Check if this ability is currently being executed.
     */
    boolean isExecuting();

    /**
     * Get the current execution phase (0=IDLE, 1=WINDUP, 2=ACTIVE, 3=DAZED).
     */
    int getPhaseInt();

    /**
     * Get the current tick within the current phase.
     */
    int getCurrentTick();

    /**
     * Get the allowed user type for this ability.
     *
     * @return 0=NPC_ONLY, 1=PLAYER_ONLY, 2=BOTH
     */
    int getAllowedByType();

    /**
     * Set the allowed user type for this ability.
     *
     * @param type 0=NPC_ONLY, 1=PLAYER_ONLY, 2=BOTH
     */
    void setAllowedByType(int type);

    /**
     * Check if this ability ignores cooldowns.
     */
    boolean isIgnoreCooldown();

    /**
     * Set whether this ability ignores cooldowns.
     * @param ignore Whether to ignore cooldowns.
     */
    void setIgnoreCooldown(boolean ignore);

    /**
     * Check if this ability uses per-ability cooldown instead of global cooldown.
     * When true, using this ability only puts THIS ability on cooldown, not all abilities.
     */
    boolean isPerAbilityCooldown();

    /**
     * Set whether this ability uses per-ability cooldown.
     * @param perAbility Whether to use per-ability cooldown.
     */
    void setPerAbilityCooldown(boolean perAbility);

    /**
     * Get this ability's data as NBT.
     */
    INbt getNbt();

    /**
     * Set this ability's data from NBT.
     * @param nbt NBT data to load.
     */
    void setNbt(INbt nbt);

    // Burst system

    /** @return Whether burst firing is enabled (fires multiple instances in rapid succession). */
    boolean isBurstEnabled();

    /** @param enabled Whether burst firing is enabled. */
    void setBurstEnabled(boolean enabled);

    /** @return Number of times the ability fires per burst. */
    int getBurstAmount();

    /** @param amount Number of shots per burst. */
    void setBurstAmount(int amount);

    /** @return Delay in ticks between each burst shot. */
    int getBurstDelay();

    /** @param delay Delay in ticks between burst shots. */
    void setBurstDelay(int delay);

    /** @return Whether animations replay for each burst shot. */
    boolean isBurstReplayAnimations();

    /** @param replay Whether to replay animations per burst shot. */
    void setBurstReplayAnimations(boolean replay);

    /** @return Whether burst shots can overlap (fire before previous shot ends). */
    boolean isBurstOverlap();

    /** @param overlap Whether burst shots can overlap. */
    void setBurstOverlap(boolean overlap);

    // Toggle system

    /**
     * Check if this ability is toggleable (has at least 1 toggle state).
     */
    boolean isToggleable();

    /**
     * Get the number of toggle states.
     * 0 = not toggleable, 1 = binary on/off, 2+ = multi-state cycling.
     */
    int getToggleStates();

    /**
     * Set the number of toggle states.
     * 0 = not toggleable, 1 = binary on/off, 2+ = multi-state cycling.
     * @param states Number of toggle states.
     */
    void setToggleStates(int states);

    /**
     * Get the display label for a specific toggle state (1-indexed).
     * @param state Toggle state number (1-indexed).
     * @return the label, or null if none set.
     */
    String getToggleStateLabel(int state);

    /**
     * Get this ability's magic data. Defines magic types, damage splits,
     * and flat magic damage for this ability. Inherited by spawned energy entities.
     * @return the ability's magic data
     */
    IMagicData getMagicData();
}
