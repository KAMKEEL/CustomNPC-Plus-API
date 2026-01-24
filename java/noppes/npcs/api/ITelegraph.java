package noppes.npcs.api;

import noppes.npcs.api.entity.IEntity;

/**
 * A telegraph is a visual warning indicator that displays on the ground.
 * Telegraphs are commonly used to warn players of incoming attacks or mark areas of effect.
 * <p>
 * To create a telegraph:
 * <pre>
 * var telegraph = API.getTelegraphs().createCircle(5.0);
 * telegraph.setDuration(60); // 3 seconds
 * telegraph.setColor(0x80FF0000); // Semi-transparent red
 * var instance = telegraph.spawn(world, x, y, z);
 * </pre>
 * <p>
 * Telegraph types:
 * <ul>
 *     <li>CIRCLE - A filled circle with a radius</li>
 *     <li>RING - A ring with inner and outer radius</li>
 *     <li>LINE - A rectangular line in a direction</li>
 *     <li>CONE - A cone/arc shape</li>
 *     <li>POINT - A small point marker</li>
 * </ul>
 */
public interface ITelegraph {

    // ═══════════════════════════════════════════════════════════════════════════
    // TYPE
    // ═══════════════════════════════════════════════════════════════════════════

    /**
     * Get the telegraph type.
     *
     * @return Type name: "CIRCLE", "RING", "LINE", "CONE", or "POINT"
     */
    String getType();

    /**
     * Set the telegraph type.
     *
     * @param type Type name: "circle", "ring", "line", "cone", or "point" (case insensitive)
     */
    void setType(String type);

    // ═══════════════════════════════════════════════════════════════════════════
    // SHAPE PARAMETERS
    // ═══════════════════════════════════════════════════════════════════════════

    /**
     * Get the radius (for CIRCLE and RING types).
     */
    float getRadius();

    /**
     * Set the radius (for CIRCLE and RING types).
     */
    void setRadius(float radius);

    /**
     * Get the inner radius (for RING type).
     */
    float getInnerRadius();

    /**
     * Set the inner radius (for RING type).
     */
    void setInnerRadius(float innerRadius);

    /**
     * Get the length (for LINE and CONE types).
     */
    float getLength();

    /**
     * Set the length (for LINE and CONE types).
     */
    void setLength(float length);

    /**
     * Get the width (for LINE type).
     */
    float getWidth();

    /**
     * Set the width (for LINE type).
     */
    void setWidth(float width);

    /**
     * Get the angle in degrees (for CONE type).
     */
    float getAngle();

    /**
     * Set the angle in degrees (for CONE type).
     */
    void setAngle(float angle);

    // ═══════════════════════════════════════════════════════════════════════════
    // TIMING
    // ═══════════════════════════════════════════════════════════════════════════

    /**
     * Get the duration in ticks.
     */
    int getDuration();

    /**
     * Set the duration in ticks (20 ticks = 1 second).
     */
    void setDuration(int ticks);

    // ═══════════════════════════════════════════════════════════════════════════
    // COLORS
    // ═══════════════════════════════════════════════════════════════════════════

    /**
     * Get the primary color in ARGB format.
     */
    int getColor();

    /**
     * Set the primary color in ARGB format.
     * Example: 0x80FF0000 for semi-transparent red
     */
    void setColor(int argb);

    /**
     * Get the warning phase color in ARGB format.
     */
    int getWarningColor();

    /**
     * Set the warning phase color in ARGB format.
     * This color is used during the final warning phase.
     */
    void setWarningColor(int argb);

    /**
     * Get the tick at which warning phase begins.
     */
    int getWarningStartTick();

    /**
     * Set the tick at which warning phase begins.
     * When remaining ticks falls below this value, the telegraph uses the warning color.
     */
    void setWarningStartTick(int tick);

    // ═══════════════════════════════════════════════════════════════════════════
    // ANIMATION
    // ═══════════════════════════════════════════════════════════════════════════

    /**
     * Check if pulsing animation is enabled.
     */
    boolean isAnimated();

    /**
     * Enable or disable pulsing animation.
     */
    void setAnimated(boolean animated);

    // ═══════════════════════════════════════════════════════════════════════════
    // POSITIONING
    // ═══════════════════════════════════════════════════════════════════════════

    /**
     * Get the height offset from ground level.
     */
    float getHeightOffset();

    /**
     * Set the height offset from ground level.
     * Default is 0.1 to prevent z-fighting with ground blocks.
     */
    void setHeightOffset(float offset);

    // ═══════════════════════════════════════════════════════════════════════════
    // SPAWN METHODS
    // ═══════════════════════════════════════════════════════════════════════════

    /**
     * Spawn this telegraph at a position.
     *
     * @param world The world to spawn in
     * @param x     X position
     * @param y     Y position
     * @param z     Z position
     * @return The spawned telegraph instance
     */
    ITelegraphInstance spawn(IWorld world, double x, double y, double z);

    /**
     * Spawn this telegraph at a position with rotation.
     *
     * @param world The world to spawn in
     * @param x     X position
     * @param y     Y position
     * @param z     Z position
     * @param yaw   Rotation yaw (for directional telegraphs like LINE/CONE)
     * @return The spawned telegraph instance
     */
    ITelegraphInstance spawn(IWorld world, double x, double y, double z, float yaw);

    /**
     * Spawn this telegraph following an entity.
     * The telegraph will update its position to follow the entity.
     *
     * @param entity The entity to follow
     * @return The spawned telegraph instance
     */
    ITelegraphInstance spawn(IEntity entity);

    /**
     * Spawn this telegraph following an entity with rotation.
     *
     * @param entity The entity to follow
     * @param yaw    Rotation yaw
     * @return The spawned telegraph instance
     */
    ITelegraphInstance spawn(IEntity entity, float yaw);
}
