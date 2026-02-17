package noppes.npcs.api.entity;

import net.minecraft.entity.Entity;

/**
 * Base interface for all energy ability entities (Projectiles, Barriers).
 * Contains shared display, lightning, owner, and charging properties.
 */
public interface IEnergyAbility<T extends Entity> extends IEntity<T> {

    // ==================== OWNER ====================

    int getOwnerEntityId();

    IEntity getOwner();

    // ==================== DISPLAY ====================

    int getInnerColor();

    void setInnerColor(int color);

    float getInnerAlpha();

    void setInnerAlpha(float alpha);

    int getOuterColor();

    void setOuterColor(int color);

    boolean isOuterColorEnabled();

    void setOuterColorEnabled(boolean enabled);

    float getOuterColorWidth();

    void setOuterColorWidth(float width);

    float getOuterColorAlpha();

    void setOuterColorAlpha(float alpha);

    // ==================== LIGHTNING ====================

    boolean hasLightningEffect();

    void setLightningEffect(boolean enabled);

    float getLightningDensity();

    void setLightningDensity(float density);

    float getLightningRadius();

    void setLightningRadius(float radius);

    int getLightningFadeTime();

    void setLightningFadeTime(int ticks);

    // ==================== STATE ====================

    boolean isCharging();

    float getChargeProgress();
}
