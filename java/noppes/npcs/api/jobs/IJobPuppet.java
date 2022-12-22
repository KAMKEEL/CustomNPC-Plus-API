package noppes.npcs.api.jobs;

public interface IJobPuppet extends IJob {

    void setAnimated(boolean animated);

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

    void setRotationX(int part, int rotation);

    void setRotationY(int part, int rotation);

    void setRotationZ(int part, int rotation);

    boolean isEnabled(int part);

    void setEnabled(int part, boolean bo);
}
