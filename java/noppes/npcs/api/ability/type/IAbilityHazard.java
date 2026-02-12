package noppes.npcs.api.ability.type;

/**
 * API interface for Hazard abilities.
 * Persistent ground effect zones placed around the caster.
 */
public interface IAbilityHazard extends IAbilityZone {

    float getRadius();
    void setRadius(float radius);

    float getDamagePerSecond();
    void setDamagePerSecond(float damage);

    int getDamageInterval();
    void setDamageInterval(int interval);

    boolean isIgnoreInvulnFrames();
    void setIgnoreInvulnFrames(boolean ignore);

    boolean isAffectsCaster();
    void setAffectsCaster(boolean affects);
}
