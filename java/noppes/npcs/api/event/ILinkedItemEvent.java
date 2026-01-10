package noppes.npcs.api.event;

public interface ILinkedItemEvent extends IItemEvent {

    /**
     * @hookName versionChanged
     */
    interface VersionChangeEvent extends IItemEvent {

        int getVersion();

        int getPreviousVersion();
    }

    /**
     * @hookName buildingItem
     */
    interface BuildEvent extends IItemEvent {
    }
}
