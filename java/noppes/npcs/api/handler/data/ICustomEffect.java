package noppes.npcs.api.handler.data;

public interface ICustomEffect {

    int getID();

    String getName();

    boolean isCustom();

    void setMenuName(String name);

    String getMenuName();

    void setName(String name);

    String getIcon();

    void setIcon(String icon);

    int getEveryXTick();

    void setEveryXTick(int everyXTick);

    int getIconX();

    void setIconX(int iconX);

    int getIconY();

    void setIconY(int iconY);

    int getWidth();

    void setWidth(int width);

    int getHeight();

    void setHeight(int height);

    boolean isLossOnDeath();

    void setLossOnDeath(boolean lossOnDeath);

    ICustomEffect save();

    void setID(int id);

    /**
     * Utilized by DBC Addon or other Addons to tell
     * which map of Effects to Match to.
     * Index: 0 - CNPC+
     * Index: 1 - DBC Addon
     */
    int getIndex();
}


