package noppes.npcs.api.handler.data;

public interface IFrame {

    IFramePart[] getParts();

    IFrame addPart(IFramePart partConfig);

    IFrame removePart(String partName);

    IFrame removePart(int partId);

    IFrame clearParts();

    int getDuration();

    IFrame setDuration(int duration);

    boolean isCustomized();

    IFrame setCustomized(boolean customized);

    float getSpeed();

    IFrame setSpeed(float speed);

    byte smoothType();

    IFrame setSmooth(byte smooth);
}
