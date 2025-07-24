package noppes.npcs.api.event;

import cpw.mods.fml.common.eventhandler.Cancelable;
import noppes.npcs.api.item.IItemStack;

public interface IRecipeEvent extends IPlayerEvent {

    /**
     * Returns the recipe object associated with this event.
     * This can be a custom recipe or an anvil recipe.
     *
     * @return the recipe object - IRecipe or IAnvilRecipe
     */
    Object getRecipe();

    IItemStack[] getItems();

    boolean isAnvil();

    @Cancelable
    interface Pre extends IRecipeEvent {
        void setMessage(String message);

        String getMessage();

        /**
         * Only for IAnvilRecipe
         *
         * @return the XP Cost of Anvil Recipe
         */
        int getXpCost();

        /**
         * Sets the XP Cost of Anvil Recipe
         *
         * @param xpCost the XP Cost to set
         */
        void setXpCost(int xpCost);

        /**
         * Only for IAnvilRecipe
         *
         * @return the material usage of Anvil Recipe
         */
        int getMaterialUsage();

        /**
         * Sets the material usage of Anvil Recipe
         *
         * @param materialUsage the material usage to set
         */
        void setMaterialUsage(int materialUsage);
    }

    interface Post extends IRecipeEvent {
        IItemStack getCraft();

        void setResult(IItemStack stack);
    }
}
