package noppes.npcs.api.handler.data;

public interface IAnimationData {

    void updateClient();

    boolean isActive();

    void setEnabled(boolean enabled);

    boolean enabled();

    void setAnimation(IAnimation animation);

    IAnimation getAnimation();
}
