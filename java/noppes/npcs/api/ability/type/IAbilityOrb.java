package noppes.npcs.api.ability.type;

/**
 * API interface for Orb abilities.
 * Homing projectile sphere.
 */
public interface IAbilityOrb extends IAbilityEnergyProjectile {

    float getOrbSpeed();

    void setOrbSpeed(float speed);

    float getOrbSize();

    void setOrbSize(float size);

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

    /**
     * @deprecated Use {@link #getFireDelay()}
     */
    int getDualFireDelay();

    /**
     * @deprecated Use {@link #setFireDelay(int)}
     */
    void setDualFireDelay(int delay);

    // Indexed accessors
    int getInnerColor(int projectileIndex);

    void setInnerColor(int projectileIndex, int color);

    int getOuterColor(int projectileIndex);

    void setOuterColor(int projectileIndex, int color);

    int getAnchorPoint(int projectileIndex);

    void setAnchorPoint(int projectileIndex, int point);
}
