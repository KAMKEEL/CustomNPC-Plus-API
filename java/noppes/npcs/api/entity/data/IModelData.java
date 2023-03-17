package noppes.npcs.api.entity.data;

public interface IModelData {

    void enableRotation(boolean enableRotation);

    boolean enableRotation();

    IModelRotate getRotation();

    IModelScale getScale();

    void setEntity(String string);

    String getEntity();
}
