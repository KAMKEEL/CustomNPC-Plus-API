package noppes.npcs.api.handler.data;

import noppes.npcs.api.entity.IAnimatable;

public interface IAnimationData {

    IAnimatable getEntity();

    void updateClient();

    boolean isActive();

    void setEnabled(boolean enabled);

    boolean enabled();

    void setAnimation(IAnimation animation);

    IAnimation getAnimation();
}
