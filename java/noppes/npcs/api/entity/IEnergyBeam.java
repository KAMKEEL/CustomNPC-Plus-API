package noppes.npcs.api.entity;

import net.minecraft.entity.Entity;

/**
 * Represents an energy beam projectile - a directional beam with a trailing path.
 */
public interface IEnergyBeam<T extends Entity> extends IEnergyProjectile<T> {

    float getBeamWidth();

    void setBeamWidth(float width);

    float getHeadSize();

    void setHeadSize(float size);

    boolean isAttachedToOwner();

    void setAttachedToOwner(boolean attached);

    boolean shouldRenderTailOrb();
}
