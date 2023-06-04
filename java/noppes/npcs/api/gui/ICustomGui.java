//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package noppes.npcs.api.gui;

import net.minecraft.nbt.NBTTagCompound;
import noppes.npcs.api.item.IItemStack;
import noppes.npcs.api.entity.IPlayer;

import java.util.List;

public interface ICustomGui {
    int getID();

    int getWidth();

    int getHeight();

    List<ICustomGuiComponent> getComponents();

    void clear();

    List<IItemSlot> getSlots();

    void setSize(int width, int height);

    void setDoesPauseGame(boolean pauseGame);

    boolean doesPauseGame();

    void setBackgroundTexture(String resourceLocation);

    String getBackgroundTexture();

    IButton addButton(int id, String text, int x, int y);

    IButton addButton(int id, String text, int x, int y, int width, int height);

    IButton addTexturedButton(int id, String text, int x, int y, int width, int height, String texture);

    IButton addTexturedButton(int id, String text, int x, int y, int width, int height, String texture, int textureX, int textureY);

    ILabel addLabel(int id, String text, int x, int y, int width, int height);

    ILabel addLabel(int id, String text, int x, int y, int width, int height, int color);

    ITextField addTextField(int id, int x, int y, int width, int height);

    ITexturedRect addTexturedRect(int id, String texture, int x, int y, int width, int height);

    ITexturedRect addTexturedRect(int id, String texture, int x, int y, int width, int height, int textureX, int textureY);

    IScroll addScroll(int id, int x, int y, int width, int height, String[] list);

    ILine addLine(int id, int x1, int y1, int x2, int y2, int color, int thickness);

    ILine addLine(int id, int x1, int y1, int x2, int y2);

    IItemSlot addItemSlot(int id, int x, int y);

    IItemSlot addItemSlot(int id, int x, int y, IItemStack itemStack);

    @Deprecated
    IItemSlot addItemSlot(int x, int y);

    @Deprecated
    IItemSlot addItemSlot(int x, int y, IItemStack itemStack);

    void showPlayerInventory(int x, int y);

    ICustomGuiComponent getComponent(int id);

    void removeComponent(int id);

    void updateComponent(ICustomGuiComponent component);

    void update(IPlayer player);

    boolean getShowPlayerInv();

    int getPlayerInvX();

    int getPlayerInvY();

    ICustomGui fromNBT(NBTTagCompound tag);

    NBTTagCompound toNBT();
}
