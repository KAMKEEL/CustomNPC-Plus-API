package noppes.npcs.api.ability.data;

public interface IEnergyDisplayData {
    int getInnerColor();

    void setInnerColor(int innerColor);

    int getOuterColor();

    void setOuterColor(int outerColor);

    boolean isOuterColorEnabled();

    void setOuterColorEnabled(boolean outerColorEnabled);

    float getOuterColorWidth();

    void setOuterColorWidth(float outerColorWidth);

    float getOuterColorAlpha();

    void setOuterColorAlpha(float outerColorAlpha);

    float getInnerAlpha();

    void setInnerAlpha(float innerAlpha);

    float getRotationSpeed();

    void setRotationSpeed(float rotationSpeed);
}
