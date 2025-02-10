package noppes.npcs.api.handler;

import net.minecraft.item.ItemStack;
import noppes.npcs.api.handler.data.IAnvilRecipe;
import noppes.npcs.api.handler.data.IRecipe;

import java.util.List;

public interface IRecipeHandler {
    List<IRecipe> getGlobalList();

    List<IRecipe> getCarpentryList();

    List<IAnvilRecipe> getAnvilList();

    void addRecipe(String var1, boolean var2, ItemStack var3, Object... var4);

    void addRecipe(String var1, boolean var2, ItemStack var3, int var4, int var5, ItemStack... var6);

    IRecipe delete(int var1);

    IAnvilRecipe deleteAnvil(int var1);

    void addAnvilRecipe(String name, boolean global, ItemStack itemToRepair, ItemStack repairMaterial, int xpCost, float repairPercentage);
}
