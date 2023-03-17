package noppes.npcs.api.entity.data;

public interface IModelData {

    void headWear(byte config);

    byte headWear();

    void bodyWear(byte config);

    byte bodyWear();

    void rightArmWear(byte config);

    byte rightArmWear();

    void leftArmWear(byte config);

    byte leftArmWear();

    void rightLegWear(byte config);

    byte rightLegWear();

    void leftLegWear(byte config);

    byte leftLegWear();

    /**
     * Hide Body Parts
     * part: [0: Head, 1: Body, 2: Arms, 3: Legs]
     * hide: [0: None, 1: Both, 2: Right, 3: Left], only values 0 and 1 used for head & body.
     */
    void hidePart(int part, byte hide);

    int hidden(int part);

    void enableRotation(boolean enableRotation);

    boolean enableRotation();

    IModelRotate getRotation();

    IModelScale getScale();

    void setEntity(String string);

    String getEntity();
}
