package noppes.npcs.api.item;

public interface IItemCustom extends IItemStack {

    /**
     * @return true if scripted item script is enabled
     */
    boolean getEnabled();

    /**
     * @param enable Enable or Disable scripted item script
     */
    void setEnabled(boolean enable);

    /**
     * Gets the texture path for the scripted item.
     * @return The texture path
     */
    String getTexture();

    /**
     * Sets the texture path for the scripted item. Can be a URL
     * @param texture The texture path
     */
    void setTexture(String texture);

    /**
     * Sets the armor type for the scripted item.
     * @param armorType The armor type
     */
    void setArmorType(int armorType);

    /**
     * Gets the armor type for the scripted item.
     * @return The armor type
     */
    int getArmorType();

    /**
     * Sets whether the scripted item is a tool.
     * @param isTool True if the item is a tool, false otherwise
     */
    void setIsTool(boolean isTool);

    /**
     * Checks if the scripted item is a tool. Allows for enchanting
     * @return True if the item is a tool, false otherwise
     */
    boolean isTool();

    /**
     * Sets whether the scripted item is a normal item. Will disable
     * all forms of Rotation, Translation, Scale Rendering in hand and on ground
     * @param normalItem True if the item is a normal item, false otherwise
     */
    void setIsNormalItem(boolean normalItem);

    /**
     * Checks if the scripted item is a normal item.
     * @return True if the item is a normal item, false otherwise
     */
    boolean isNormalItem();

    /**
     * Sets the dig speed for the scripted item.
     * @param digSpeed The dig speed
     */
    void setDigSpeed(int digSpeed);

    /**
     * Gets the dig speed for the scripted item.
     * @return The dig speed
     */
    int getDigSpeed();

    /**
     * Sets the maximum stack size for the scripted item.
     * @param maxStackSize The maximum stack size
     */
    void setMaxStackSize(int maxStackSize);

    /**
     * Gets the current durability value for the scripted item.
     * @return The durability value
     */
    double getDurabilityValue();

    /**
     * Sets the current durability value for the scripted item.
     * @param durabilityValue The durability value
     */
    void setDurabilityValue(float durabilityValue);

    /**
     * Checks if the durability bar should be shown for the scripted item.
     * @return True if the durability bar should be shown, false otherwise
     */
    Boolean getDurabilityShow();

    /**
     * Sets whether the durability bar should be shown for the scripted item.
     * @param durabilityShow True if the durability bar should be shown, false otherwise
     */
    void setDurabilityShow(Boolean durabilityShow);

    /**
     * Gets the color of the durability bar for the scripted item.
     * @return The durability bar color
     */
    Integer getDurabilityColor();

    /**
     * Sets the color of the durability bar for the scripted item.
     * @param durabilityColor The durability bar color
     */
    void setDurabilityColor(Integer durabilityColor);

    /**
     * Gets the color of the scripted item.
     * @return The item color
     */
    Integer getColor();

    /**
     * Sets the color of the scripted item.
     * @param color The item color
     */
    void setColor(Integer color);

    /**
     * Gets the maximum item use duration for the scripted item.
     * @return The maximum item use duration
     */
    int getMaxItemUseDuration();

    /**
     * Sets the maximum item use duration for the scripted item.
     * @param duration The maximum item use duration
     */
    void setMaxItemUseDuration(int duration);

    /**
     * Sets the item use action for the scripted item.
     * @param action The item use action
     */
    void setItemUseAction(int action);

    /**
     * Gets the item use action for the scripted item.
     * @return The item use action
     */
    int getItemUseAction();

    /**
     * Gets the enchantability for the scripted item.
     * @return The enchantability
     */
    int getEnchantability();

    /**
     * Sets the enchantability for the scripted item.
     * @param enchantability The enchantability
     */
    void setEnchantability(int enchantability);

    /**
     * Sets the rotation values for the scripted item.
     * @param rotationX The X-axis rotation
     * @param rotationY The Y-axis rotation
     * @param rotationZ The Z-axis rotation
     */
    void setRotation(Float rotationX, Float rotationY, Float rotationZ);

    /**
     * Sets the rotation rate values for the scripted item. Spinning Speed
     * @param rotationXRate The X-axis rotation rate
     * @param rotationYRate The Y-axis rotation rate
     * @param rotationZRate The Z-axis rotation rate
     */
    void setRotationRate(Float rotationXRate, Float rotationYRate, Float rotationZRate);

    /**
     * Sets the scale values for the scripted item.
     * @param scaleX The X-axis scale
     * @param scaleY The Y-axis scale
     * @param scaleZ The Z-axis scale
     */
    void setScale(Float scaleX, Float scaleY, Float scaleZ);

    /**
     * Sets the translation values for the scripted item.
     * @param translateX The X-axis translation
     * @param translateY The Y-axis translation
     * @param translateZ The Z-axis translation
     */
    void setTranslate(Float translateX, Float translateY, Float translateZ);

    /**
     * Gets the X-axis rotation for the scripted item.
     * @return The X-axis rotation
     */
    Float getRotationX();

    /**
     * Gets the Y-axis rotation for the scripted item.
     * @return The Y-axis rotation
     */
    Float getRotationY();

    /**
     * Gets the Z-axis rotation for the scripted item.
     * @return The Z-axis rotation
     */
    Float getRotationZ();

    /**
     * Gets the X-axis rotation rate for the scripted item.
     * @return The X-axis rotation rate
     */
    Float getRotationXRate();

    /**
     * Gets the Y-axis rotation rate for the scripted item.
     * @return The Y-axis rotation rate
     */
    Float getRotationYRate();

    /**
     * Gets the Z-axis rotation rate for the scripted item.
     * @return The Z-axis rotation rate
     */
    Float getRotationZRate();

    /**
     * Gets the X-axis scale for the scripted item.
     * @return The X-axis scale
     */
    Float getScaleX();

    /**
     * Gets the Y-axis scale for the scripted item.
     * @return The Y-axis scale
     */
    Float getScaleY();

    /**
     * Gets the Z-axis scale for the scripted item.
     * @return The Z-axis scale
     */
    Float getScaleZ();

    /**
     * Gets the X-axis translation for the scripted item.
     * @return The X-axis translation
     */
    Float getTranslateX();

    /**
     * Gets the Y-axis translation for the scripted item.
     * @return The Y-axis translation
     */
    Float getTranslateY();

    /**
     * Gets the Z-axis translation for the scripted item.
     * @return The Z-axis translation
     */
    Float getTranslateZ();
}
