package noppes.npcs.api.entity;

import net.minecraft.entity.projectile.EntityFishHook;

/**
 * Represents a fish hook entity with additional methods.
 *
 * @param <T> The underlying Minecraft EntityFishHook type.
 */
public interface IFishHook<T extends EntityFishHook> extends IEntity<T> {

    IPlayer getCaster();

    void kill();
}
