package noppes.npcs.api.ability.type;

/**
 * API interface for Energy Beam abilities.
 * Homing beam head with trailing path attached to origin.
 */
public interface IAbilityEnergyBeam extends IAbilityEnergyProjectile {

    float getSpeed();

    void setSpeed(float speed);

    float getBeamWidth();

    void setBeamWidth(float width);

    float getHeadSize();

    void setHeadSize(float size);

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

    // Indexed accessors
    int getInnerColor(int projectileIndex);

    void setInnerColor(int projectileIndex, int color);

    int getOuterColor(int projectileIndex);

    void setOuterColor(int projectileIndex, int color);

    int getAnchorPoint(int projectileIndex);

    void setAnchorPoint(int projectileIndex, int point);
}
