package noppes.npcs.api.ability;

import noppes.npcs.api.INbt;

/**
 * Interface for NPC abilities.
 * Abilities are special attacks or actions that NPCs can perform during combat.
 */
public interface IAbility {

    /**
     * Get the unique ID of this ability instance.
     */
    String getId();

    /**
     * Set the unique ID of this ability instance.
     */
    void setId(String id);

    /**
     * Get the display name of this ability.
     */
    String getName();

    /**
     * Set the display name of this ability.
     */
    void setName(String name);

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
     */
    void setEnabled(boolean enabled);

    /**
     * Get the selection weight for random ability selection.
     * Higher weight = more likely to be selected.
     */
    int getWeight();

    /**
     * Set the selection weight.
     */
    void setWeight(int weight);

    /**
     * Get the minimum range at which this ability can be used.
     */
    float getMinRange();

    /**
     * Set the minimum range.
     */
    void setMinRange(float range);

    /**
     * Get the maximum range at which this ability can be used.
     */
    float getMaxRange();

    /**
     * Set the maximum range.
     */
    void setMaxRange(float range);

    /**
     * Get the cooldown time in ticks.
     */
    int getCooldownTicks();

    /**
     * Set the cooldown time in ticks.
     */
    void setCooldownTicks(int ticks);

    /**
     * Get the wind-up time in ticks (telegraph phase).
     */
    int getWindUpTicks();

    /**
     * Set the wind-up time in ticks.
     */
    void setWindUpTicks(int ticks);

    /**
     * Get the dazed time in ticks (stun after interrupt during WINDUP).
     */
    int getDazedTicks();

    /**
     * Set the dazed time in ticks.
     */
    void setDazedTicks(int ticks);

    /**
     * Check if this ability can be interrupted by damage.
     */
    boolean isInterruptible();

    /**
     * Set whether this ability can be interrupted.
     */
    void setInterruptible(boolean interruptible);

    /**
     * Get the lock movement type for this ability.
     * @return 0=NO, 1=WINDUP, 2=ACTIVE, 3=WINDUP_AND_ACTIVE
     */
    int getLockMovementType();

    /**
     * Set the lock movement type for this ability.
     * @param type 0=NO, 1=WINDUP, 2=ACTIVE, 3=WINDUP_AND_ACTIVE
     */
    void setLockMovementType(int type);

    /**
     * Check if movement is locked during the WINDUP phase.
     */
    boolean isMovementLockedDuringWindup();

    /**
     * Check if movement is locked during the ACTIVE phase.
     */
    boolean isMovementLockedDuringActive();

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
     * Get this ability's data as NBT.
     */
    INbt getNbt();

    /**
     * Set this ability's data from NBT.
     */
    void setNbt(INbt nbt);
}
