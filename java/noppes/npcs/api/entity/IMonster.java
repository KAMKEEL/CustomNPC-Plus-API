package noppes.npcs.api.entity;

import net.minecraft.entity.monster.EntityMob;

/**
 * Represents a monster entity.
 * This interface does not add new methods, but allows type checking
 * against the EntityType.MONSTER.
 *
 * @param <T> The underlying Minecraft EntityMob type.
 */
public interface IMonster<T extends EntityMob> extends IEntityLiving<T> {
}
