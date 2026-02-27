package noppes.npcs.api.ability;

/**
 * A custom (script-driven) ability whose behavior is entirely defined by script event hooks.
 * Supports both instant execution mode and toggle mode.
 */
public interface ICustomAbility extends IAbility {

    /**
     * Get the duration in ticks for instant mode (non-toggle).
     */
    int getDurationTicks();

    /**
     * Set the duration in ticks for instant mode.
     */
    void setDurationTicks(int ticks);

    /**
     * Get the telegraph shape type ordinal.
     * @return ordinal of TelegraphType: 0=CIRCLE, 1=RING, 2=LINE, 3=CONE, 4=POINT, 5=SQUARE, 6=NONE
     */
    int getTelegraphShapeType();

    /**
     * Set the telegraph shape type by ordinal.
     * @param type ordinal of TelegraphType
     */
    void setTelegraphShapeType(int type);

    /**
     * Get the targeting mode ordinal.
     * @return ordinal of TargetingMode: 0=AGGRO_TARGET, 1=SELF, 2=AOE_SELF, 3=AOE_TARGET
     */
    int getTargetingModeType();

    /**
     * Set the targeting mode by ordinal.
     * @param type ordinal of TargetingMode
     */
    void setTargetingModeType(int type);
}
