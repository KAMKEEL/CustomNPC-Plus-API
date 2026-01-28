package noppes.npcs.api.ability.type;

import noppes.npcs.api.ability.IAbility;

/**
 * API interface for Dash abilities.
 * Quick evasive sidestep movement.
 */
public interface IAbilityDash extends IAbility {

    /**
     * Get the dash mode (0 = AGGRESSIVE, 1 = DEFENSIVE).
     */
    int getDashMode();
    void setDashMode(int mode);

    float getDashDistance();
    void setDashDistance(float distance);

    float getDashSpeed();
    void setDashSpeed(float speed);
}
