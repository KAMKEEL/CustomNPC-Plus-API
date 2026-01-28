package noppes.npcs.api.ability.type;

import noppes.npcs.api.ability.IAbility;

/**
 * API interface for Hazard abilities.
 * Persistent ground effect zones.
 */
public interface IAbilityHazard extends IAbility {

    int getDurationTicks();
    void setDurationTicks(int ticks);

    float getRadius();
    void setRadius(float radius);

    float getInnerRadius();
    void setInnerRadius(float radius);

    float getConeAngle();
    void setConeAngle(float angle);

    /**
     * Get the hazard shape (0 = CIRCLE, 1 = RING, 2 = CONE).
     */
    int getShape();
    void setShape(int shape);

    /**
     * Get the placement mode (0 = AT_CASTER, 1 = AT_TARGET, 2 = FOLLOW_CASTER, 3 = FOLLOW_TARGET).
     */
    int getPlacement();
    void setPlacement(int placement);

    float getDamagePerSecond();
    void setDamagePerSecond(float damage);

    int getDamageInterval();
    void setDamageInterval(int interval);

    boolean isIgnoreInvulnFrames();
    void setIgnoreInvulnFrames(boolean ignore);

    int getSlownessLevel();
    void setSlownessLevel(int level);

    int getWeaknessLevel();
    void setWeaknessLevel(int level);

    int getPoisonLevel();
    void setPoisonLevel(int level);

    int getWitherLevel();
    void setWitherLevel(int level);

    int getBlindnessLevel();
    void setBlindnessLevel(int level);

    int getDebuffDuration();
    void setDebuffDuration(int duration);

    boolean isAffectsCaster();
    void setAffectsCaster(boolean affects);
}
