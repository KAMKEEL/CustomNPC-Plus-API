//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package noppes.npcs.api.gui;

import net.minecraft.nbt.NBTTagCompound;

public interface ICustomGuiComponent {
    int getID();

    ICustomGuiComponent setID(int id);

    int getPosX();

    int getPosY();

    ICustomGuiComponent setPos(int x, int y);

    boolean hasHoverText();

    String[] getHoverText();

    ICustomGuiComponent setHoverText(String hoverText);

    ICustomGuiComponent setHoverText(String[] hoverTextLines);

    int getColor();

    ICustomGuiComponent setColor(int color);

     float getAlpha();

    void setAlpha(float alpha);

    float getRotation();

    void setRotation(float rotation);

    NBTTagCompound toNBT(NBTTagCompound nbt);

    ICustomGuiComponent fromNBT(NBTTagCompound nbt);
}
