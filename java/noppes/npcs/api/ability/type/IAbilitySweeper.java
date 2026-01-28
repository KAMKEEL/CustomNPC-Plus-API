package noppes.npcs.api.ability.type;

import noppes.npcs.api.ability.IAbility;

/**
 * API interface for Sweeper abilities.
 * Low sweeping beam that rotates around the NPC.
 */
public interface IAbilitySweeper extends IAbility {

    float getBeamLength();
    void setBeamLength(float length);

    float getBeamWidth();
    void setBeamWidth(float width);

    float getBeamHeight();
    void setBeamHeight(float height);

    float getDamage();
    void setDamage(float damage);

    int getDamageInterval();
    void setDamageInterval(int interval);

    boolean isPiercing();
    void setPiercing(boolean piercing);

    float getSweepSpeed();
    void setSweepSpeed(float speed);

    int getNumberOfRotations();
    void setNumberOfRotations(int rotations);

    boolean isLockOnTarget();
    void setLockOnTarget(boolean lock);

    int getInnerColor();
    void setInnerColor(int color);

    int getOuterColor();
    void setOuterColor(int color);

    float getOuterColorWidth();
    void setOuterColorWidth(float width);

    boolean isOuterColorEnabled();
    void setOuterColorEnabled(boolean enabled);
}
