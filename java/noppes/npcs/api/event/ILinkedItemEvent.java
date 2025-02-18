package noppes.npcs.api.event;

public interface ILinkedItemEvent extends IItemEvent {

    // Version Change Event
    interface VersionChangeEvent extends IItemEvent {

        int getVersion();

        int getPreviousVersion();
    }

    interface BuildEvent extends IItemEvent {
    }
}
