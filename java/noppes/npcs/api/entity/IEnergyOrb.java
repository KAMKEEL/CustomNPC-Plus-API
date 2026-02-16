package noppes.npcs.api.entity;

import net.minecraft.entity.Entity;

/**
 * Represents an energy orb projectile - a spherical homing energy ball.
 * Orbs use the base IEnergyProjectile properties with no additional methods.
 */
public interface IEnergyOrb<T extends Entity> extends IEnergyProjectile<T> {
}
