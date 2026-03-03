package noppes.npcs.api;

import noppes.npcs.api.entity.*;

/**
 * Central controller for creating energy entities and routing energy damage.
 * Access via API.getEnergyController().
 *
 * All factory methods create entities that are NOT spawned in the world.
 * Configure the entity, then call fire() (projectiles) or spawn() (zones/sweepers/panels)
 * to place it in the world.
 */
public interface IEnergyController {

    // ==================== PROJECTILE CREATION ====================

    /**
     * Create an energy orb projectile. Not spawned until fire() is called.
     */
    IEnergyOrb createOrb(IWorld world, IEntity owner, double x, double y, double z, float size);

    /**
     * Create an energy beam projectile. Not spawned until fire() is called.
     */
    IEnergyBeam createBeam(IWorld world, IEntity owner, double x, double y, double z, float beamWidth, float headSize);

    /**
     * Create an energy disc projectile. Not spawned until fire() is called.
     */
    IEnergyDisc createDisc(IWorld world, IEntity owner, double x, double y, double z, float radius, float thickness);

    /**
     * Create an energy laser projectile. Not spawned until fire() is called.
     */
    IEnergyLaser createLaser(IWorld world, IEntity owner, double x, double y, double z, float laserWidth);

    // ==================== ZONE CREATION ====================

    /**
     * Create a hazard zone entity with defaults. Not spawned until spawn() is called.
     * Hazards deal continuous damage to entities within the zone.
     */
    IEnergyZone createHazard(IWorld world, IEntity owner, double x, double y, double z);

    /**
     * Create a trap zone entity with defaults. Not spawned until spawn() is called.
     * Traps trigger when entities enter and deal burst damage.
     */
    IEnergyZone createTrap(IWorld world, IEntity owner, double x, double y, double z);

    // ==================== SWEEPER CREATION ====================

    /**
     * Create a sweeper entity with defaults. Not spawned until spawn() is called.
     * Sweepers rotate a beam that damages entities in its path.
     */
    IEnergySweeper createSweeper(IWorld world, IEntity owner, double x, double y, double z);

    // ==================== PANEL CREATION ====================

    /**
     * Create a panel entity with defaults. Not spawned until spawn() is called.
     * Panels are flat energy barriers that can deal damage on contact.
     */
    IEnergyPanel createPanel(IWorld world, IEntity owner, double x, double y, double z);
}
