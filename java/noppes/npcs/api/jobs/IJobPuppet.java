package noppes.npcs.api.jobs;

public interface IJobPuppet extends IJob {

    void setAnimated(boolean animated);

    boolean fullAngles();

    void setFullAngles(boolean limit);

    boolean isAnimated();

    void setAnimRate(float animRate);

    float getAnimRate();

    void doWhileStanding(boolean whileStanding);

    boolean doWhileStanding();

    void doWhileAttacking(boolean whileAttacking);

    boolean doWhileAttacking();

    void doWhileMoving(boolean whileMoving);

    boolean doWhileMoving();

    int getRotationX(int part);

    int getRotationY(int part);

    int getRotationZ(int part);

    void setRotation(int part, int rotationX, int rotationY, int rotationZ);

    void setRotationX(int part, int rotation);

    void setRotationY(int part, int rotation);

    void setRotationZ(int part, int rotation);

    int getOffsetX(int part);

    int getOffsetY(int part);

    int getOffsetZ(int part);

    void setOffset(int part, int offsetX, int offsetY, int offsetZ);

    void setOffsetX(int part, int offset);

    void setOffsetY(int part, int offset);

    void setOffsetZ(int part, int offset);

    boolean isEnabled(int part);

    void setEnabled(int part, boolean bo);
}
