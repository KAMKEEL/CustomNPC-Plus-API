package noppes.npcs.api.entity;

import net.minecraft.entity.projectile.EntityThrowable;

/**
 * Represents a throwable entity with additional methods.
 *
 * @param <T> The underlying Minecraft EntityThrowable type.
 */
public interface IThrowable<T extends EntityThrowable> extends IEntity<T> {

    IEntityLivingBase getThrower();

    void kill();
}
