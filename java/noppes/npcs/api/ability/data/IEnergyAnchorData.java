package noppes.npcs.api.ability.data;

import kamkeel.npcs.controllers.data.ability.AnchorPoint;

public interface IEnergyAnchorData {
    AnchorPoint getAnchorPoint();

    void setAnchorPoint(AnchorPoint anchorPoint);

    float getAnchorOffsetX();

    void setAnchorOffsetX(float anchorOffsetX);

    float getAnchorOffsetY();

    void setAnchorOffsetY(float anchorOffsetY);

    float getAnchorOffsetZ();

    void setAnchorOffsetZ(float anchorOffsetZ);
}
