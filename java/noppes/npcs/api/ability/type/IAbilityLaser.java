package noppes.npcs.api.ability.type;

/**
 * API interface for Laser abilities.
 * Sweeping beam that follows the caster's look vector.
 */
public interface IAbilityLaser extends IAbilityEnergyProjectile {

    float getLaserWidth();

    void setLaserWidth(float width);

    float getExpansionSpeed();

    void setExpansionSpeed(float speed);

    float getMaxLength();

    void setMaxLength(float maxLength);
}
