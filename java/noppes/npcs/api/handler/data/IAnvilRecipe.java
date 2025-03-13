package noppes.npcs.api.handler.data;

import net.minecraft.item.ItemStack;

public interface IAnvilRecipe {
    /**
     * Returns the unique name of this anvil recipe.
     */
    String getName();

    /**
     * The XP cost per repair tick (e.g., 10 levels per tick).
     */
    int getXpCost();

    /**
     * The repair percentage (e.g., 0.1f repairs 10% of max damage per tick).
     */
    float getRepairPercentage();

    /**
     * Checks whether the provided item and repair material match this recipe.
     *
     * @param itemToRepair   the damaged item
     * @param repairMaterial the material used to repair
     * @return true if the items match the recipe requirements
     */
    boolean matches(ItemStack itemToRepair, ItemStack repairMaterial);

    /**
     * Returns the repaired item based on the input damaged item.
     *
     * @param itemToRepair the input damaged item
     * @return a copy with reduced damage
     */
    ItemStack getResult(ItemStack itemToRepair);

    int getID();
}
