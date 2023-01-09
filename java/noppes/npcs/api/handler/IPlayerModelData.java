package noppes.npcs.api.handler;

import noppes.npcs.api.handler.data.IModelPart;

public interface IPlayerModelData {

    void updateClient();

    IModelPart getPart(int part);

    void setEnabled(boolean enabled);

    boolean enabled();

    void setAnimated(boolean animated);

    boolean isAnimated();

    void setInterpolated(boolean interpolate);

    boolean isInterpolated();

    void setFullAngles(boolean fullAngles);

    boolean fullAngles();

    void setAnimRate(float animRate);

    float getAnimRate();

    void setRotation(float rotationX, float rotationY, float rotationZ);

    void setRotationX(float rotationX);

    void setRotationY(float rotationY);

    void setRotationZ(float rotationZ);

    float getRotationX();

    float getRotationY();

    float getRotationZ();

    void setRotationEnabled(boolean enabledX, boolean enabledY, boolean enabledZ);

    void setRotationEnabledX(boolean enabled);

    void setRotationEnabledY(boolean enabled);

    void setRotationEnabledZ(boolean enabled);

    boolean rotationEnabledX();

    boolean rotationEnabledY();

    boolean rotationEnabledZ();

    void allEnabled(boolean enabled);

    void allAnimated(boolean animated);

    void allInterpolated(boolean interpolate);

    void allFullAngles(boolean fullAngles);

    void allAnimRate(float animRate);
}
