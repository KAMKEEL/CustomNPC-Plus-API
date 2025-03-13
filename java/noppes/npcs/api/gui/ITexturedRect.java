package noppes.npcs.api.gui;

/**
 * Represents a textured rectangle component in a custom GUI.
 * Allows configuration of texture resource, size, scale, and texture offset.
 */
public interface ITexturedRect extends ICustomGuiComponent {

    /**
     * Returns the texture resource location.
     *
     * @return the texture as a string.
     */
    String getTexture();

    /**
     * Sets the texture resource location.
     *
     * @param texture the texture resource location.
     * @return this textured rectangle instance.
     */
    ITexturedRect setTexture(String texture);

    /**
     * Returns the width of the rectangle.
     *
     * @return the width in pixels.
     */
    int getWidth();

    /**
     * Returns the height of the rectangle.
     *
     * @return the height in pixels.
     */
    int getHeight();

    /**
     * Sets the size of the rectangle.
     *
     * @param width  the new width.
     * @param height the new height.
     * @return this textured rectangle instance.
     */
    ITexturedRect setSize(int width, int height);

    /**
     * Returns the scale factor of the rectangle.
     *
     * @return the scale.
     */
    float getScale();

    /**
     * Sets the scale factor of the rectangle.
     *
     * @param scale the new scale.
     * @return this textured rectangle instance.
     */
    ITexturedRect setScale(float scale);

    /**
     * Returns the texture's x offset.
     *
     * @return the x offset.
     */
    int getTextureX();

    /**
     * Returns the texture's y offset.
     *
     * @return the y offset.
     */
    int getTextureY();

    /**
     * Sets the texture offset.
     *
     * @param textureX the new x offset.
     * @param textureY the new y offset.
     * @return this textured rectangle instance.
     */
    ITexturedRect setTextureOffset(int textureX, int textureY);
}
