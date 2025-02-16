package noppes.npcs.api.handler.data;

public interface ILinkedItem {

    int getId();

    void setId(int id);

    int getVersion();

    void setVersion(int version);

    String getName();

    void setName(String name);

    double getDurabilityValue();

    void setDurabilityValue(double durabilityValue);

    int getStackSize();

    void setStackSize(int stackSize);

    int getMaxItemUseDuration();

    void setMaxItemUseDuration(int maxItemUseDuration);

    int getItemUseAction();

    void setItemUseAction(int itemUseAction);

    boolean isNormalItem();

    void setNormalItem(boolean normalItem);

    boolean isTool();

    void setTool(boolean tool);

    int getDigSpeed();

    void setDigSpeed(int digSpeed);

    int getArmorType();

    void setArmorType(int armorType);

    int getEnchantability();

    void setEnchantability(int enchantability);
}
