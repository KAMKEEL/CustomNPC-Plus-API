package noppes.npcs.api.ability.data;

public interface IEnergyLightningData {
    boolean isLightningEffect();

    void setLightningEffect(boolean lightningEffect);

    float getLightningDensity();

    void setLightningDensity(float lightningDensity);

    float getLightningRadius();

    void setLightningRadius(float lightningRadius);

    int getLightningFadeTime();

    void setLightningFadeTime(int lightningFadeTime);
}
