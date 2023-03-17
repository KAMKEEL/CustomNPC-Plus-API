package noppes.npcs.api.entity.data;

public interface IModelRotatePart {

    void setRotation(float x, float y, float z);

    float getRotateX();

    float getRotateY();

    float getRotateZ();

    void disabled(boolean enabled);

    boolean disabled();
}
