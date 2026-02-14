package noppes.npcs.api.ability.type;

/**
 * API interface for Disc abilities.
 * Flat spinning disc projectile with optional boomerang.
 */
public interface IAbilityDisc extends IAbilityEnergyProjectile {

    float getSpeed();
    void setSpeed(float speed);

    float getDiscRadius();
    void setDiscRadius(float radius);

    float getDiscThickness();
    void setDiscThickness(float thickness);

    boolean isVertical();
    void setVertical(boolean vertical);

    boolean isBoomerang();
    void setBoomerang(boolean boomerang);

    int getBoomerangDelay();
    void setBoomerangDelay(int ticks);

    boolean isHoming();
    void setHoming(boolean homing);

    float getHomingStrength();
    void setHomingStrength(float strength);

    float getHomingRange();
    void setHomingRange(float range);

    float getRotationSpeed();
    void setRotationSpeed(float speed);

    int getProjectileCount();
    void setProjectileCount(int count);

    int getFireDelay();
    void setFireDelay(int delay);

    /** @deprecated Use {@link #getFireDelay()} */
    int getDualFireDelay();
    /** @deprecated Use {@link #setFireDelay(int)} */
    void setDualFireDelay(int delay);

    // Indexed accessors
    int getInnerColor(int projectileIndex);
    void setInnerColor(int projectileIndex, int color);

    int getOuterColor(int projectileIndex);
    void setOuterColor(int projectileIndex, int color);

    int getAnchorPoint(int projectileIndex);
    void setAnchorPoint(int projectileIndex, int point);
}
