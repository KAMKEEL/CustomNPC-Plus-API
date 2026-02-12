package noppes.npcs.api.ability.type;

import noppes.npcs.api.ability.IAbility;

/**
 * API interface for zone-based abilities (Trap, Hazard).
 * Shared zone properties: duration, shape, spawn, visual layers, colors.
 */
public interface IAbilityZone extends IAbility {

    int getDurationTicks();
    void setDurationTicks(int ticks);

    /**
     * Get the zone shape (0 = CIRCLE, 1 = SQUARE).
     */
    int getZoneShapeOrdinal();
    void setZoneShapeOrdinal(int shape);

    float getSpawnRadius();
    void setSpawnRadius(float radius);

    int getZoneCount();
    void setZoneCount(int count);

    float getZoneHeight();
    void setZoneHeight(float height);

    float getParticleDensity();
    void setParticleDensity(float density);

    float getParticleScale();
    void setParticleScale(float scale);

    float getAnimSpeed();
    void setAnimSpeed(float speed);

    float getLightningDensity();
    void setLightningDensity(float density);

    // Color controls
    int getInnerColor();
    void setInnerColor(int color);

    int getOuterColor();
    void setOuterColor(int color);

    boolean isOuterColorEnabled();
    void setOuterColorEnabled(boolean enabled);

    // Visual layer controls

    boolean isGroundFill();
    void setGroundFill(boolean enabled);

    float getGroundAlpha();
    void setGroundAlpha(float alpha);

    boolean isRings();
    void setRings(boolean enabled);

    int getRingCount();
    void setRingCount(int count);

    boolean isBorder();
    void setBorder(boolean enabled);

    float getBorderSpeed();
    void setBorderSpeed(float speed);

    boolean isAccents();
    void setAccents(boolean enabled);

    /**
     * Get the accent style (0=STATIC, 1=SWAYING, 2=FLICKERING).
     */
    int getAccentStyle();
    void setAccentStyle(int style);

    boolean isLightning();
    void setLightning(boolean enabled);

    boolean isParticles();
    void setParticles(boolean enabled);

    /**
     * Get the particle motion style (0=RISING, 1=DRIFTING, 2=SPARKS).
     */
    int getParticleMotion();
    void setParticleMotion(int motion);

    String getParticleDir();
    void setParticleDir(String directory);

    int getParticleSize();
    void setParticleSize(int size);

    boolean isParticleGlow();
    void setParticleGlow(boolean glow);
}
