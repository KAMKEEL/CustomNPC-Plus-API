package noppes.npcs.api.entity;

import net.minecraft.entity.Entity;

/**
 * Base interface for energy barrier entities (Dome, Panel).
 * Barriers are defensive structures that block incoming energy projectiles.
 * Extends IEnergyAbility for shared display/lightning/owner/charging methods.
 */
public interface IEnergyBarrier<T extends Entity> extends IEnergyAbility<T> {

    // ==================== HEALTH ====================

    float getCurrentHealth();

    void setCurrentHealth(float health);

    float getHealthPercent();

    float getMaxHealth();

    void setMaxHealth(float maxHealth);

    boolean isUseHealth();

    void setUseHealth(boolean useHealth);

    // ==================== DURATION ====================

    int getDuration();

    void setDuration(int ticks);

    boolean isUseDuration();

    void setUseDuration(boolean useDuration);

    // ==================== STATE (BARRIER-SPECIFIC) ====================

    int getTicksAlive();

    // ==================== BARRIER ====================

    float getDefaultMultiplier();

    void setDefaultMultiplier(float multiplier);

    boolean isSolid();

    void setSolid(boolean solid);

    boolean isKnockbackEnabled();

    void setKnockbackEnabled(boolean enabled);

    float getKnockbackStrength();

    void setKnockbackStrength(float strength);

    boolean isAbsorbing();

    void setAbsorbing(boolean absorbing);

    /**
     * Returns the barrier type: 0=Dome, 1=Panel
     */
    int getBarrierType();

    // ==================== SYNC ====================

    /**
     * Sends all current visual and barrier-specific data to tracking clients.
     * <p>
     * Call this <b>after</b> making batch changes to properties like colors, alpha,
     * lightning, dome radius, panel dimensions, etc. This sends a single packet
     * instead of one per setter call.
     * <p>
     * Example:
     * <pre>
     * dome.setInnerColor(0xFF0000);
     * dome.setDomeRadius(5.0);
     * dome.syncClient(); // one packet for all changes
     * </pre>
     */
    void syncClient();
}
