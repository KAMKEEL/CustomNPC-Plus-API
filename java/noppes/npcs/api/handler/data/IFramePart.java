package noppes.npcs.api.handler.data;

public interface IFramePart{

    String getName();

    int getPartId();

    IFramePart setPart(String name);

    IFramePart setPart(int partId);

    float[] getRotations();

    IFramePart setRotations(float[] rotation);

    float[] getPivots();

    IFramePart setPivots(float[] pivot);

    boolean isCustomized();

    IFramePart setCustomized(boolean customized);

    float getSpeed();

    IFramePart setSpeed(float speed);

    byte isSmooth();

    IFramePart setSmooth(byte smooth);
}
