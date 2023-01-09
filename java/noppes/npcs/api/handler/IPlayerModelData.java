package noppes.npcs.api.handler;

import noppes.npcs.api.handler.data.IModelPart;

public interface IPlayerModelData {

    void updateClient();

    IModelPart getPart(int part);

    void setAnimated(boolean animated);

    void setInterpolated(boolean interpolate);

    void setFullAngles(boolean fullAngles);

    void setAnimRate(float animRate);

    void allAnimated(boolean animated);

    void allInterpolated(boolean interpolate);

    void allFullAngles(boolean fullAngles);

    void allAnimRate(float animRate);
}
