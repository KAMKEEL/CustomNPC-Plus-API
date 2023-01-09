package noppes.npcs.api.jobs;

import noppes.npcs.api.handler.data.IModelPart;

public interface IJobPuppet extends IJob {

    IModelPart getPart(int part);

    void setAnimated(boolean animated);

    void setInterpolated(boolean interpolate);

    void setFullAngles(boolean fullAngles);

    void setAnimRate(float animRate);

    void doWhileStanding(boolean whileStanding);

    boolean doWhileStanding();

    void doWhileAttacking(boolean whileAttacking);

    boolean doWhileAttacking();

    void doWhileMoving(boolean whileMoving);

    boolean doWhileMoving();

    @Deprecated
    void setRotationX(int part, float rotation);

    @Deprecated
    void setRotationY(int part, float rotation);

    @Deprecated
    void setRotationZ(int part, float rotation);

    @Deprecated
    float getRotationX(int part);

    @Deprecated
    float getRotationY(int part);

    @Deprecated
    float getRotationZ(int part);

    @Deprecated
    boolean isEnabled(int part);

    @Deprecated
    void setEnabled(int part, boolean bo);
}
