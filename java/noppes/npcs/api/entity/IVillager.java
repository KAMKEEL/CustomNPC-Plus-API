package noppes.npcs.api.entity;

import net.minecraft.entity.passive.EntityVillager;
import noppes.npcs.api.entity.IEntityLivingBase;

/**
 * Represents a villager entity with additional trading-related methods.
 *
 * @param <T> The underlying Minecraft EntityVillager type.
 */
public interface IVillager<T extends EntityVillager> extends IEntityLiving<T> {

    /**
     * @return The profession of the villager.
     */
    int getProfession();

    /**
     * @return true if the villager is currently trading.
     */
    boolean getIsTrading();

    /**
     * Returns the customer (player) who is currently trading with the villager.
     *
     * @return the customer as an IEntityLivingBase.
     */
    IEntityLivingBase getCustomer();
}
