package noppes.npcs.api.handler.data;

import noppes.npcs.api.IWorld;
import noppes.npcs.api.entity.IEntity;

public interface INaturalSpawn {
    int DESPAWN_FORCE_NATURAL = 0;
    int DESPAWN_PRESERVE_TEMPLATE = 1;
    int DESPAWN_FORCE_PERSISTENT = 2;

    void setName(String name);

    String getName();

    void setEntity(IEntity entity, int slot);

    IEntity getEntity(IWorld world, int slot);

    Integer[] getSlots();

    void setWeight(int weight);

    int getWeight();

    void setMinHeight(int height);

    int getMinHeight();

    void setMaxHeight(int height);

    int getMaxHeight();

    void spawnsLikeAnimal(boolean spawns);

    boolean spawnsLikeAnimal();

    void spawnsLikeMonster(boolean spawns);

    boolean spawnsLikeMonster();

    void spawnsInLiquid(boolean spawns);

    boolean spawnsInLiquid();

    void spawnsInAir(boolean spawns);

    boolean spawnsInAir();

    String[] getBiomes();

    void setBiomes(String[] biomes);

    void setMaxAlive(int maxAlive);

    int getMaxAlive();

    void setCooldownTicks(int ticks);

    int getCooldownTicks();

    void setAttemptsPerCycle(int attempts);

    int getAttemptsPerCycle();

    void setPlayerMinDistance(int distance);

    int getPlayerMinDistance();

    void setDespawnMode(int mode);

    int getDespawnMode();
}
