package noppes.npcs.api.jobs;

public interface IJobPuppet extends IJob {

    void setAnimated(boolean animated);

    boolean isAnimated();

    void setInterpolated(boolean interpolate);

    boolean isInterpolated();

    void setFullAngles(boolean limit);

    boolean fullAngles();

    void setAnimRate(float animRate);

    float getAnimRate();

    void doWhileStanding(boolean whileStanding);

    boolean doWhileStanding();

    void doWhileAttacking(boolean whileAttacking);

    boolean doWhileAttacking();

    void doWhileMoving(boolean whileMoving);

    boolean doWhileMoving();

    void setRotation(int part, float rotationX, float rotationY, float rotationZ);

    void setRotationX(int part, float rotation);

    void setRotationY(int part, float rotation);

    void setRotationZ(int part, float rotation);

    float getRotationX(int part);

    float getRotationY(int part);

    float getRotationZ(int part);

    void setOffset(int part, float offsetX, float offsetY, float offsetZ);

    void setOffsetX(int part, float offset);

    void setOffsetY(int part, float offset);

    void setOffsetZ(int part, float offset);

    float getOffsetX(int part);

    float getOffsetY(int part);

    float getOffsetZ(int part);

    boolean isEnabled(int part);

    void setEnabled(int part, boolean bo);
}
