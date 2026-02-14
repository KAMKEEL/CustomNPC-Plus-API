package noppes.npcs.api.ability.type;

/**
 * API interface for Laser Shot abilities.
 * Fast expanding thin line that pierces through targets.
 */
public interface IAbilityLaserShot extends IAbilityEnergyProjectile {

    float getLaserWidth();
    void setLaserWidth(float width);

    float getExpansionSpeed();
    void setExpansionSpeed(float speed);

    int getLingerTicks();
    void setLingerTicks(int ticks);
}
