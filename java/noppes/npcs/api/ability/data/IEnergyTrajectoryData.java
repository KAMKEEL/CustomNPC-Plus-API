package noppes.npcs.api.ability.data;

public interface IEnergyTrajectoryData {
    float getSpeed();

    void setSpeed(float speed);

    boolean isHoming();

    void setHoming(boolean homing);

    float getHomingStrength();

    void setHomingStrength(float homingStrength);

    float getHomingRange();

    void setHomingRange(float homingRange);
}
