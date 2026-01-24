package noppes.npcs.api;

import noppes.npcs.api.entity.IEntity;

/**
 * A runtime instance of an active telegraph in the world.
 * Represents a spawned telegraph with position, timing, and control methods.
 * <p>
 * Instances are created when you call spawn() on an ITelegraph:
 * <pre>
 * var telegraph = API.getTelegraphs().createCircle(5.0);
 * var instance = telegraph.spawn(world, x, y, z);
 *
 * // Later...
 * instance.remove(); // Remove the telegraph early
 * </pre>
 */
public interface ITelegraphInstance {

    /**
     * Get the unique instance ID.
     */
    String getInstanceId();

    // ═══════════════════════════════════════════════════════════════════════════
    // POSITION
    // ═══════════════════════════════════════════════════════════════════════════

    /**
     * Get the current X position.
     */
    double getX();

    /**
     * Get the current Y position.
     */
    double getY();

    /**
     * Get the current Z position.
     */
    double getZ();

    /**
     * Get the rotation yaw.
     */
    float getYaw();

    /**
     * Set the position.
     * Note: Only works for static telegraphs (not following an entity).
     */
    void setPosition(double x, double y, double z);

    // ═══════════════════════════════════════════════════════════════════════════
    // ENTITY FOLLOWING
    // ═══════════════════════════════════════════════════════════════════════════

    /**
     * Make this telegraph follow an entity.
     * The telegraph position will update each tick to match the entity.
     */
    void followEntity(IEntity entity);

    /**
     * Stop following any entity and fix the current position.
     */
    void stopFollowing();

    /**
     * Check if this telegraph is following an entity.
     */
    boolean isFollowing();

    // ═══════════════════════════════════════════════════════════════════════════
    // TIMING
    // ═══════════════════════════════════════════════════════════════════════════

    /**
     * Get the remaining ticks before the telegraph expires.
     */
    int getRemainingTicks();

    /**
     * Get the total duration ticks.
     */
    int getTotalTicks();

    /**
     * Get the progress from 0.0 (just started) to 1.0 (finished).
     */
    float getProgress();

    /**
     * Check if the telegraph is in the warning phase.
     */
    boolean isWarning();

    // ═══════════════════════════════════════════════════════════════════════════
    // CONTROL
    // ═══════════════════════════════════════════════════════════════════════════

    /**
     * Remove this telegraph immediately.
     * Sends a removal packet to all clients tracking it.
     */
    void remove();

    /**
     * Lock the telegraph at its current position.
     * Equivalent to calling stopFollowing().
     */
    void lockPosition();
}
