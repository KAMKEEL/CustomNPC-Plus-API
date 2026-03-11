package noppes.npcs.api.entity;

import net.minecraft.entity.projectile.EntityFishHook;

/**
 * Represents a fish hook entity with additional methods.
 *
 * @param <T> The underlying Minecraft EntityFishHook type.
 */
public interface IFishHook<T extends EntityFishHook> extends IEntity<T> {

    /**
     * Returns the player who cast this fish hook.
     *
     * @return the casting player, or null if none.
     */
    IPlayer getCaster();

    /**
     * Removes this fish hook entity from the world.
     */
    void kill();
}
