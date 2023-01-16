package noppes.npcs.api.handler.data;

public interface IFramePart{

    String getName();

    int getPartId();

    IFramePart setPart(String name);

    IFramePart setPart(int partId);

    int[] getRotations();

    IFramePart setRotations(int[] rotation);

    int[] getPivots();

    IFramePart setPivots(int[] pivot);

    boolean isCustomized();

    IFramePart setCustomized(boolean customized);

    float getSpeed();

    IFramePart setSpeed(float speed);

    byte isSmooth();

    IFramePart setSmooth(byte smooth);
}
