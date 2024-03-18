package noppes.npcs.api.gui;

public interface ILabel extends ICustomGuiComponent {
    String getText();

    ILabel setText(String text);

    int getWidth();

    int getHeight();

    ILabel setSize(int width, int height);

    float getScale();

    ILabel setScale(float scale);

    boolean getShadow();

    void setShadow(boolean shadow);
}
