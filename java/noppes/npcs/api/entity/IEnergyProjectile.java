package noppes.npcs.api.entity;


public interface IEnergyProjectile {
    int getOwnerEntityId();

    IEntity getOwner();

    int getTargetEntityId();

    IEntity getTarget();

    int getSiblingEntityId();

    void setSiblingEntityId(int siblingEntityId);

    IEnergyProjectile getSibling();

    float getSize();

    double getMotionX();

    double getMotionY();

    double getMotionZ();

    int getInnerColor();

    int getOuterColor();

    boolean isOuterColorEnabled();

    float getOuterColorWidth();

    float getOuterColorAlpha();

    float getRotationSpeed();

    float getInterpolatedRotationX(float partialTicks);

    float getInterpolatedRotationY(float partialTicks);

    float getInterpolatedRotationZ(float partialTicks);

    float getInterpolatedSize(float partialTicks);

    boolean hasLightningEffect();

    float getLightningDensity();

    float getLightningRadius();

    int getLightningFadeTime();

    float getMaxDistance();

    int getMaxLifetime();

    float getDamage();

    float getKnockback();

    float getKnockbackUp();

    boolean isExplosive();

    float getExplosionRadius();

    float getExplosionDamageFalloff();

    float getSpeed();

    boolean isHoming();

    float getHomingStrength();

    float getHomingRange();

    int getAnchor();

    float getAnchorOffsetX();

    float getAnchorOffsetY();

    float getAnchorOffsetZ();

    double getStartX();

    double getStartY();

    double getStartZ();
}
