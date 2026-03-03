package noppes.npcs.api.entity;

import net.minecraft.entity.Entity;

/**
 * Entity-level interface for zone entities (Hazard and Trap).
 * Created via IEnergyController.createHazard() or createTrap().
 * Configure properties, then call spawn() to place in the world.
 */
public interface IEnergyZone<T extends Entity> extends IEntity<T> {

    // ==================== ZONE TYPE ====================

    /** @return Zone type: 0=Trap, 1=Hazard */
    int getZoneType();

    // ==================== COMMON ZONE PROPERTIES ====================

    /** @return Zone shape: 0=Circle, 1=Square */
    int getZoneShape();
    void setZoneShape(int shape);

    float getRadius();
    void setRadius(float radius);

    float getZoneHeight();
    void setZoneHeight(float height);

    int getDuration();
    void setDuration(int ticks);

    // ==================== COLORS ====================

    int getInnerColor();
    void setInnerColor(int color);

    int getOuterColor();
    void setOuterColor(int color);

    boolean isOuterColorEnabled();
    void setOuterColorEnabled(boolean enabled);

    // ==================== VISUALS ====================

    float getParticleDensity();
    void setParticleDensity(float density);

    float getParticleScale();
    void setParticleScale(float scale);

    float getAnimSpeed();
    void setAnimSpeed(float speed);

    boolean isIgnoreIFrames();
    void setIgnoreIFrames(boolean ignore);

    // ==================== HAZARD-SPECIFIC ====================

    float getDamagePerSecond();
    void setDamagePerSecond(float dps);

    int getDamageInterval();
    void setDamageInterval(int ticks);

    boolean isAffectsCaster();
    void setAffectsCaster(boolean affects);

    // ==================== TRAP-SPECIFIC ====================

    float getTriggerRadius();
    void setTriggerRadius(float radius);

    int getArmTime();
    void setArmTime(int ticks);

    int getMaxTriggers();
    void setMaxTriggers(int max);

    int getTriggerCooldown();
    void setTriggerCooldown(int ticks);

    float getDamage();
    void setDamage(float damage);

    float getKnockback();
    void setKnockback(float knockback);

    boolean isVisible();
    void setVisible(boolean visible);

    // ==================== CUSTOM DAMAGE DATA ====================

    /** Get custom damage data for addon handler routing (e.g. DBC damage stats). */
    noppes.npcs.api.INbt getDamageData();

    /** Set custom damage data for addon handler routing. */
    void setDamageData(noppes.npcs.api.INbt data);

    // ==================== SPAWNING ====================

    /** Spawn this zone entity into the world. */
    void spawn();
}
