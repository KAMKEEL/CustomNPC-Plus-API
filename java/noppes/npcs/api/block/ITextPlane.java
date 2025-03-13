package noppes.npcs.api.block;

public interface ITextPlane {

    String getText();

    void setText(String text);

    int getRotationX();

    int getRotationY();

    int getRotationZ();

    void setRotationX(int x);

    void setRotationY(int y);

    /**
     * @param z Default: 0.5
     */
    void setRotationZ(int z);

    float getOffsetX();

    float getOffsetY();

    float getOffsetZ();

    void setOffsetX(float x);

    void setOffsetY(float y);

    void setOffsetZ(float z);

    float getScale();

    /**
     * @param scale Default: 1
     */
    void setScale(float scale);
}
