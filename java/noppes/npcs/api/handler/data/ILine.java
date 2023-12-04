package noppes.npcs.api.handler.data;

import noppes.npcs.api.entity.IEntityLivingBase;

public interface ILine {

    ILine formatTarget(IEntityLivingBase entityLivingBase);

    String getText();

    void setText(String text);

    String getSound();

    void setSound(String sound);

    void hideText(boolean hide);

    boolean hideText();
}
