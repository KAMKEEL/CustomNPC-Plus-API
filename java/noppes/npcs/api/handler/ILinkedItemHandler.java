package noppes.npcs.api.handler;

import noppes.npcs.api.handler.data.ILinkedItem;
import noppes.npcs.api.item.IItemStack;

public interface ILinkedItemHandler {
    ILinkedItem createItem(String name);

    IItemStack createItemStack(int id);

    void add(ILinkedItem linkedItem);

    ILinkedItem remove(int id);

    ILinkedItem get(int id);

    boolean contains(int id);

    boolean contains(ILinkedItem linkedItem);
}
