package noppes.npcs.api.handler.data;

public interface IModelPart {

    void setEnabled(boolean bo);

    boolean isEnabled();

    void setAnimated(boolean animated);

    boolean isAnimated();

    void setInterpolated(boolean interpolate);

    boolean isInterpolated();

    void setFullAngles(boolean limit);

    boolean fullAngles();

    void setAnimRate(float animRate);

    float getAnimRate();

    void setRotation(float rotationX, float rotationY, float rotationZ);

    void setRotationX(float rotation);

    void setRotationY(float rotation);

    void setRotationZ(float rotation);

    float getRotationX();

    float getRotationY();

    float getRotationZ();

    void setOffset(float offsetX, float offsetY, float offsetZ);

    void setOffsetX(float offset);

    void setOffsetY(float offset);

    void setOffsetZ(float offset);

    float getOffsetX();

    float getOffsetY();

    float getOffsetZ();
}
