package noppes.npcs.api.entity;

import net.minecraft.entity.EntityCreature;
import noppes.npcs.api.IPos;
import noppes.npcs.api.ITimers;
import noppes.npcs.api.entity.data.IModelData;
import noppes.npcs.api.handler.IActionManager;
import noppes.npcs.api.handler.IOverlayHandler;
import noppes.npcs.api.handler.data.*;
import noppes.npcs.api.item.IItemStack;
import noppes.npcs.api.jobs.IJob;
import noppes.npcs.api.roles.IRole;

/**
 * Represents a customizable NPC with a wide variety of properties such as appearance,
 * behavior, combat, loot, and more. This interface extends living entity and animation
 * capabilities and defines methods for adjusting almost every aspect of an NPC.
 *
 * @param <T> the underlying EntityCreature type.
 */
public interface ICustomNpc<T extends EntityCreature> extends IEntityLiving<T>, IAnimatable {

    /**
     * Returns the current NPC's size (scale factor) within the range 1–30.
     *
     * @return the NPC's size.
     */
    int getSize();

    /**
     * Sets the NPC's size (scale factor).
     *
     * @param size the size of the NPC (range 1–30, default is 5).
     */
    void setSize(int size);

    /**
     * Returns the NPC's model type.
     *
     * @return the model type.
     */
    int getModelType();

    /**
     * Sets the NPC's model type.
     *
     * @param modelType the model type (0: Steve, 1: Steve64, 2: Alex).
     */
    void setModelType(int modelType);

    /**
     * Returns the NPC's name.
     *
     * @return the NPC's name.
     */
    String getName();

    /**
     * Sets the NPC's rotation (yaw).
     *
     * @param rotation the new rotation angle in degrees.
     */
    void setRotation(float rotation);

    /**
     * Sets the NPC's rotation type.
     *
     * @param rotationType the rotation type (implementation-specific).
     */
    void setRotationType(int rotationType);

    /**
     * Returns the NPC's rotation type.
     *
     * @return the rotation type.
     */
    int getRotationType();

    /**
     * Sets the moving type of the NPC.
     *
     * @param movingType the moving type (0: standing, 1: wandering, 2: moving path).
     */
    void setMovingType(int movingType);

    /**
     * Returns the moving type of the NPC.
     *
     * @return the moving type (0: standing, 1: wandering, 2: moving path).
     */
    int getMovingType();

    /**
     * Sets the NPC's name.
     *
     * @param name the new name.
     */
    void setName(String name);

    /**
     * Returns the NPC's title.
     *
     * @return the NPC's title.
     */
    String getTitle();

    /**
     * Sets the NPC's title.
     *
     * @param title the new title.
     */
    void setTitle(String title);

    /**
     * Returns the NPC's texture path.
     *
     * @return the texture path.
     */
    String getTexture();

    /**
     * Sets the NPC's texture.
     *
     * @param texture the new texture path.
     */
    void setTexture(String texture);

    /**
     * Returns the NPC's home position.
     *
     * @return the home position as an IPos.
     */
    IPos getHome();

    /**
     * Returns the home position X coordinate.
     *
     * @return the home X coordinate.
     */
    int getHomeX();

    /**
     * Sets the home position X coordinate.
     *
     * @param x the new home X coordinate.
     */
    void setHomeX(int x);

    /**
     * Returns the home position Y coordinate.
     *
     * @return the home Y coordinate.
     */
    int getHomeY();

    /**
     * Sets the home position Y coordinate.
     *
     * @param y the new home Y coordinate.
     */
    void setHomeY(int y);

    /**
     * Returns the home position Z coordinate.
     *
     * @return the home Z coordinate.
     */
    int getHomeZ();

    /**
     * Sets the home position Z coordinate.
     *
     * @param z the new home Z coordinate.
     */
    void setHomeZ(int z);

    /**
     * Sets the home position using individual coordinates.
     *
     * @param x the home X coordinate.
     * @param y the home Y coordinate.
     * @param z the home Z coordinate.
     */
    void setHome(int x, int y, int z);

    /**
     * Sets the home position using an IPos instance.
     *
     * @param pos the new home position.
     */
    void setHome(IPos pos);

    /**
     * Sets the NPC's maximum health.
     *
     * @param health the new maximum health.
     */
    void setMaxHealth(double health);

    /**
     * Sets whether the NPC should return to its home position.
     *
     * @param bo true to enable returning home, false otherwise.
     */
    void setReturnToHome(boolean bo);

    /**
     * Returns whether the NPC is set to return home.
     *
     * @return true if the NPC returns home, false otherwise.
     */
    boolean getReturnToHome();

    /**
     * Returns the faction associated with the NPC.
     *
     * @return the NPC's faction.
     */
    IFaction getFaction();

    /**
     * Sets the NPC's faction by its ID.
     *
     * @param id the faction ID.
     */
    void setFaction(int id);

    /**
     * Sets whether the NPC will attack members of other factions.
     *
     * @param attackOtherFactions true to attack, false otherwise.
     */
    void setAttackFactions(boolean attackOtherFactions);

    /**
     * Returns whether the NPC attacks other factions.
     *
     * @return true if it attacks, false otherwise.
     */
    boolean getAttackFactions();

    /**
     * Sets whether the NPC should defend members of its faction.
     *
     * @param defendFaction true to defend, false otherwise.
     */
    void setDefendFaction(boolean defendFaction);

    /**
     * Returns whether the NPC defends its faction.
     *
     * @return true if it defends, false otherwise.
     */
    boolean getDefendFaction();

    /**
     * Returns the entity type of the NPC.
     *
     * @return the NPC's type.
     */
    int getType();

    /**
     * Checks if the NPC is of the given type.
     *
     * @param type the type to check.
     * @return true if the NPC matches the specified type; otherwise, defers to the parent.
     */
    boolean typeOf(int type);

    /**
     * Instructs the NPC to shoot an item at a target.
     *
     * @param target   the target entity.
     * @param item     the item to shoot.
     * @param accuracy the accuracy of the shot (0–100).
     */
    void shootItem(IEntityLivingBase target, IItemStack item, int accuracy);

    /**
     * Sets whether projectiles fired by the NPC should ignore terrain collisions.
     *
     * @param b true if projectiles keep terrain, false otherwise.
     */
    void setProjectilesKeepTerrain(boolean b);

    /**
     * Returns whether projectiles fired by the NPC ignore terrain collisions.
     *
     * @return true if they ignore terrain, false otherwise.
     */
    boolean getProjectilesKeepTerrain();

    /**
     * Makes the NPC broadcast a message.
     *
     * @param message the message to say.
     */
    void say(String message);

    /**
     * Makes the NPC send a message to a specific player.
     *
     * @param player  the target player.
     * @param message the message to say.
     */
    void say(IPlayer player, String message);

    /**
     * Retrieves the dialog from the specified slot.
     *
     * @param slot the dialog slot.
     * @return the dialog instance.
     */
    IDialog getDialog(int slot);

    /**
     * Returns the dialog ID in the specified slot.
     *
     * @param slot the dialog slot.
     * @return the dialog ID, or -1 if none exists.
     */
    int getDialogId(int slot);

    /**
     * Sets the dialog for the specified slot.
     *
     * @param slot   the dialog slot.
     * @param dialog the dialog instance.
     */
    void setDialog(int slot, IDialog dialog);

    /**
     * Sets the dialog for the specified slot by its ID.
     *
     * @param slot     the dialog slot.
     * @param dialogId the dialog ID.
     */
    void setDialog(int slot, int dialogId);

    /**
     * Returns the lines used for NPC interaction.
     *
     * @return the interact lines.
     */
    ILines getInteractLines();

    /**
     * Returns the lines displayed in the world.
     *
     * @return the world lines.
     */
    ILines getWorldLines();

    /**
     * Returns the lines spoken when the NPC attacks.
     *
     * @return the attack lines.
     */
    ILines getAttackLines();

    /**
     * Returns the lines spoken when the NPC is killed.
     *
     * @return the killed lines.
     */
    ILines getKilledLines();

    /**
     * Returns the lines spoken when the NPC kills another entity.
     *
     * @return the kill lines.
     */
    ILines getKillLines();

    /**
     * Kills the NPC without despawning it.
     */
    void kill();

    /**
     * Resets the NPC to its initial state and triggers the initialization script.
     */
    void reset();

    /**
     * Returns the NPC's animation data.
     *
     * @return the animation data.
     */
    IAnimationData getAnimationData();

    /**
     * Returns the NPC's current role.
     *
     * @return the role instance.
     */
    IRole getRole();

    /**
     * Sets the NPC's role by its ID.
     *
     * @param role the role ID.
     */
    void setRole(int role);

    /**
     * Returns the NPC's current job.
     *
     * @return the job instance.
     */
    IJob getJob();

    /**
     * Sets the NPC's job by its ID.
     *
     * @param job the job ID.
     */
    void setJob(int job);

    /**
     * Returns the item held in the NPC's right hand.
     *
     * @return the right-hand item.
     */
    IItemStack getRightItem();

    /**
     * Sets the item held in the NPC's right hand.
     *
     * @param item the new item.
     */
    void setRightItem(IItemStack item);

    /**
     * (Deprecated) Returns the item held in the NPC's left hand.
     *
     * @return the left-hand item.
     */
    @Deprecated
    IItemStack getLefttItem();

    /**
     * Returns the item held in the NPC's left hand.
     *
     * @return the left-hand item.
     */
    IItemStack getLeftItem();

    /**
     * Sets the item held in the NPC's left hand.
     *
     * @param item the new item.
     */
    void setLeftItem(IItemStack item);

    /**
     * Returns the projectile item used by the NPC.
     *
     * @return the projectile item.
     */
    IItemStack getProjectileItem();

    /**
     * Sets the projectile item for the NPC.
     *
     * @param item the new projectile item.
     */
    void setProjectileItem(IItemStack item);

    /**
     * Checks if the NPC can aim while shooting.
     *
     * @return true if aiming while shooting is enabled, false otherwise.
     */
    @Deprecated
    boolean canAimWhileShooting();

    /**
     * Sets whether the NPC can aim while shooting.
     *
     * @param aimWhileShooting true to enable aiming, false to disable.
     */
    @Deprecated
    void aimWhileShooting(boolean aimWhileShooting);

    /**
     * Sets the Aim Type for an NPC
     *
     * @param aimWhileShooting 0: No, 1: Yes, 2: On Shot
     */
    void setAimType(byte aimWhileShooting);

    /**
     * Gets the Aim Type for an NPC
     *
     * @return  0: No, 1: Yes, 2: On Shot
     */
    byte getAimType();

    /**
     * Sets the minimum delay (in ticks) between projectiles.
     *
     * @param minDelay the minimum delay.
     */
    void setMinProjectileDelay(int minDelay);

    /**
     * Returns the minimum projectile delay.
     *
     * @return the minimum delay in ticks.
     */
    int getMinProjectileDelay();

    /**
     * Sets the maximum delay (in ticks) between projectiles.
     *
     * @param maxDelay the maximum delay.
     */
    void setMaxProjectileDelay(int maxDelay);

    /**
     * Returns the maximum projectile delay.
     *
     * @return the maximum delay in ticks.
     */
    int getMaxProjectileDelay();

    /**
     * Sets the range for ranged attacks.
     *
     * @param rangedRange the ranged attack range.
     */
    void setRangedRange(int rangedRange);

    /**
     * Returns the range for ranged attacks.
     *
     * @return the ranged attack range.
     */
    int getRangedRange();

    /**
     * Sets the fire rate for ranged attacks.
     *
     * @param rate the fire rate in ticks.
     */
    void setFireRate(int rate);

    /**
     * Returns the fire rate for ranged attacks.
     *
     * @return the fire rate.
     */
    int getFireRate();

    /**
     * Sets the number of shots in a burst.
     *
     * @param burstCount the burst count.
     */
    void setBurstCount(int burstCount);

    /**
     * Returns the number of shots in a burst.
     *
     * @return the burst count.
     */
    int getBurstCount();

    /**
     * Sets the number of shots fired.
     *
     * @param shotCount the shot count.
     */
    void setShotCount(int shotCount);

    /**
     * Returns the number of shots fired.
     *
     * @return the shot count.
     */
    int getShotCount();

    /**
     * Sets the shooting accuracy.
     *
     * @param accuracy the accuracy (0–100).
     */
    void setAccuracy(int accuracy);

    /**
     * Returns the shooting accuracy.
     *
     * @return the accuracy value.
     */
    int getAccuracy();

    /**
     * Returns the sound directory played when a projectile is fired.
     *
     * @return the fire sound directory.
     */
    String getFireSound();

    /**
     * Sets the sound directory for projectile firing.
     *
     * @param fireSound the new fire sound directory.
     */
    void setFireSound(String fireSound);

    /**
     * Returns the armor item in the specified slot.
     *
     * @param slot the armor slot (0: head, 1: body, 2: legs, 3: boots).
     * @return the armor item.
     */
    IItemStack getArmor(int slot);

    /**
     * Sets the armor item in the specified slot.
     *
     * @param slot the armor slot (0: head, 1: body, 2: legs, 3: boots).
     * @param item the armor item.
     */
    void setArmor(int slot, IItemStack item);

    /**
     * Returns the loot item from the NPC's drop list for the given slot.
     *
     * @param slot the loot slot (0–8).
     * @return the loot item.
     */
    IItemStack getLootItem(int slot);

    /**
     * Sets the loot item in the NPC's drop list for the given slot.
     *
     * @param slot the loot slot (0–8).
     * @param item the new loot item.
     */
    void setLootItem(int slot, IItemStack item);

    /**
     * Returns the chance for the loot item in the specified slot to drop.
     *
     * @param slot the loot slot (0–8).
     * @return the drop chance (default 100 if not set).
     */
    double getLootChance(int slot);

    /**
     * Sets the drop chance for the loot item in the specified slot.
     *
     * @param slot   the loot slot (0–8).
     * @param chance the new drop chance.
     */
    void setLootChance(int slot, double chance);

    /**
     * Returns the NPC's loot mode.
     *
     * @return the loot mode (0: Normal, 1: Auto Pickup).
     */
    int getLootMode();

    /**
     * Sets the NPC's loot mode.
     *
     * @param lootMode the loot mode (0: Normal, 1: Auto Pickup).
     */
    void setLootMode(int lootMode);

    /**
     * Sets the minimum XP dropped by the NPC.
     *
     * @param lootXP the minimum loot XP.
     */
    void setMinLootXP(int lootXP);

    /**
     * Sets the maximum XP dropped by the NPC.
     *
     * @param lootXP the maximum loot XP.
     */
    void setMaxLootXP(int lootXP);

    /**
     * Returns the minimum XP dropped by the NPC.
     *
     * @return the minimum loot XP.
     */
    int getMinLootXP();

    /**
     * Returns the maximum XP dropped by the NPC.
     *
     * @return the maximum loot XP.
     */
    int getMaxLootXP();

    /**
     * Returns whether the NPC can drown.
     *
     * @return true if the NPC can drown, false otherwise.
     */
    boolean getCanDrown();

    /**
     * Sets the drowning behavior of the NPC.
     *
     * @param type 0: Never drowns, 1: Drowns in water, 2: Drowns in air (without water).
     */
    void setDrowningType(int type);

    /**
     * Returns whether the NPC can breathe.
     *
     * @return true if the NPC can breathe, false otherwise.
     */
    boolean canBreathe();

    /**
     * Sets the NPC's animation type.
     *
     * @param type the animation type.
     */
    void setAnimation(int type);

    /**
     * Sets the NPC's tactical variant.
     *
     * @param variant the tactical variant (0: Rush, 1: Dodge, 2: Surround, 3: Hit N Run, 4: Ambush, 5: Stalk, 6: None).
     */
    void setTacticalVariant(int variant);

    /**
     * Returns the NPC's tactical variant.
     *
     * @return the tactical variant as an integer.
     */
    int getTacticalVariant();

    /**
     * Sets the NPC's tactical variant by its name.
     *
     * @param variant the name of the tactical variant.
     */
    void setTacticalVariant(String variant);

    /**
     * Returns the name of the NPC's tactical variant.
     *
     * @return the tactical variant name.
     */
    String getTacticalVariantName();

    /**
     * Returns the name of the NPC's combat policy.
     *
     * @return the combat policy name.
     */
    String getCombatPolicyName();

    /**
     * Sets the NPC's combat policy.
     *
     * @param policy the combat policy (0: Flip, 1: Brute, 2: Stubborn, 4: Tactical).
     */
    void setCombatPolicy(int policy);

    /**
     * Returns the NPC's combat policy.
     *
     * @return the combat policy as an integer.
     */
    int getCombatPolicy();

    /**
     * Sets the NPC's combat policy by name.
     *
     * @param policy the combat policy name.
     */
    void setCombatPolicy(String policy);

    /**
     * Sets the tactical radius affecting NPC behavior.
     *
     * @param tacticalRadius the tactical radius.
     */
    void setTacticalRadius(int tacticalRadius);

    /**
     * Returns the tactical radius affecting NPC behavior.
     *
     * @return the tactical radius.
     */
    int getTacticalRadius();

    /**
     * Sets whether the NPC ignores cobwebs.
     *
     * @param ignore true to ignore cobwebs, false otherwise.
     */
    void setIgnoreCobweb(boolean ignore);

    /**
     * Returns whether the NPC ignores cobwebs.
     *
     * @return true if cobwebs are ignored, false otherwise.
     */
    boolean getIgnoreCobweb();

    /**
     * Sets the NPC's behavior when encountering an enemy.
     *
     * @param onAttack 0: Retaliate, 1: Panic, 2: Retreat, 3: Nothing.
     */
    void setOnFoundEnemy(int onAttack);

    /**
     * Returns the NPC's behavior when encountering an enemy.
     *
     * @return an integer representing the behavior (0: Retaliate, 1: Panic, 2: Retreat, 3: Nothing).
     */
    int onFoundEnemy();

    /**
     * Sets the condition under which the NPC seeks shelter.
     *
     * @param shelterFrom 0: Darkness, 1: Sunlight, 2: Disabled.
     */
    void setShelterFrom(int shelterFrom);

    /**
     * Returns the condition under which the NPC seeks shelter.
     *
     * @return an integer representing the shelter condition (0: Darkness, 1: Sunlight, 2: Disabled).
     */
    int getShelterFrom();

    /**
     * Returns whether the NPC has a living animation.
     *
     * @return true if living animation is enabled, false otherwise.
     */
    boolean hasLivingAnimation();

    /**
     * Sets whether the NPC has a living animation.
     *
     * @param livingAnimation true to enable living animation, false to disable.
     */
    void setLivingAnimation(boolean livingAnimation);

    /**
     * Sets the visibility type of the NPC.
     *
     * @param type the visibility type (0: visible, 1: invisible, 2: semi-visible).
     */
    void setVisibleType(int type);

    /**
     * Returns the visibility type of the NPC.
     *
     * @return the visibility type.
     */
    int getVisibleType();

    /**
     * Sets whether the NPC is visible to a specific player.
     *
     * @param player  the player.
     * @param visible true if the NPC should be visible, false if invisible.
     */
    void setVisibleTo(IPlayer player, boolean visible);

    /**
     * Checks if the NPC is visible to a specific player.
     *
     * @param player the player.
     * @return true if the NPC is visible, false otherwise.
     */
    boolean isVisibleTo(IPlayer player);

    /**
     * Sets the visibility type of the NPC's name.
     *
     * @param type the visibility type (0: visible, 1: invisible, 2: when attacking).
     */
    void setShowName(int type);

    /**
     * Returns the visibility type of the NPC's name.
     *
     * @return the name visibility type.
     */
    int getShowName();

    /**
     * Returns the visibility type of the NPC's boss bar.
     *
     * @return the boss bar visibility (0: invisible, 1: visible, 2: when attacking).
     */
    int getShowBossBar();

    /**
     * Sets the visibility type of the NPC's boss bar.
     *
     * @param type the boss bar visibility (0: invisible, 1: visible, 2: when attacking).
     */
    void setShowBossBar(int type);

    /**
     * Returns the melee strength of the NPC.
     *
     * @return the melee strength.
     */
    double getMeleeStrength();

    /**
     * Sets the melee strength of the NPC.
     *
     * @param strength the new melee strength.
     */
    void setMeleeStrength(double strength);

    /**
     * Returns the melee speed of the NPC.
     *
     * @return the melee speed.
     */
    int getMeleeSpeed();

    /**
     * Sets the melee speed of the NPC.
     *
     * @param speed the new melee speed.
     */
    void setMeleeSpeed(int speed);

    /**
     * Returns the melee range of the NPC.
     *
     * @return the melee range.
     */
    int getMeleeRange();

    /**
     * Sets the melee range of the NPC.
     *
     * @param range the new melee range.
     */
    void setMeleeRange(int range);

    /**
     * Returns the swing warmup time (in ticks) before melee damage is applied.
     *
     * @return the swing warmup time.
     */
    int getSwingWarmup();

    /**
     * Sets the swing warmup time (in ticks) before melee damage is applied.
     *
     * @param ticks the warmup time.
     */
    void setSwingWarmup(int ticks);

    /**
     * Returns the knockback strength of the NPC.
     *
     * @return the knockback strength.
     */
    int getKnockback();

    /**
     * Sets the knockback strength of the NPC.
     *
     * @param knockback the new knockback strength.
     */
    void setKnockback(int knockback);

    /**
     * Returns the aggro range of the NPC.
     *
     * @return the aggro range.
     */
    int getAggroRange();

    /**
     * Sets the aggro range of the NPC.
     *
     * @param aggroRange the new aggro range.
     */
    void setAggroRange(int aggroRange);

    /**
     * Returns the ranged attack strength of the NPC.
     *
     * @return the ranged strength.
     */
    float getRangedStrength();

    /**
     * Sets the ranged attack strength of the NPC.
     *
     * @param strength the new ranged strength.
     */
    void setRangedStrength(float strength);

    /**
     * Returns the ranged attack speed of the NPC.
     *
     * @return the ranged speed.
     */
    int getRangedSpeed();

    /**
     * Sets the ranged attack speed of the NPC.
     *
     * @param speed the new ranged speed.
     */
    void setRangedSpeed(int speed);

    /**
     * Returns the number of projectiles in a ranged burst attack.
     *
     * @return the burst count.
     */
    int getRangedBurst();

    /**
     * Sets the number of projectiles in a ranged burst attack.
     *
     * @param count the new burst count.
     */
    void setRangedBurst(int count);

    /**
     * Returns the number of ticks before the NPC respawns.
     *
     * @return the respawn time.
     */
    int getRespawnTime();

    /**
     * Sets the number of ticks before the NPC respawns.
     *
     * @param time the respawn time.
     */
    void setRespawnTime(int time);

    /**
     * Returns the NPC's respawn cycle.
     *
     * @return the respawn cycle (0: Always, 1: Day, 2: Night, 3: No respawn).
     */
    int getRespawnCycle();

    /**
     * Sets the NPC's respawn cycle.
     *
     * @param cycle the respawn cycle (0: Always, 1: Day, 2: Night, 3: No respawn).
     */
    void setRespawnCycle(int cycle);

    /**
     * Returns whether the NPC's body is hidden upon death.
     *
     * @return true if the body is hidden, false otherwise.
     */
    boolean getHideKilledBody();

    /**
     * Sets whether the NPC's body should be hidden upon death.
     *
     * @param hide true to hide the body, false otherwise.
     */
    void hideKilledBody(boolean hide);

    /**
     * Returns whether the NPC naturally despawns.
     *
     * @return true if it naturally despawns, false otherwise.
     */
    boolean naturallyDespawns();

    /**
     * Sets whether the NPC should naturally despawn.
     *
     * @param canDespawn true to allow natural despawning, false otherwise.
     */
    void setNaturallyDespawns(boolean canDespawn);

    /**
     * Returns whether the NPC was spawned using a soul stone.
     *
     * @return true if spawned from a soul stone, false otherwise.
     */
    boolean spawnedFromSoulStone();

    /**
     * Returns the name of the player who spawned this NPC using a soul stone.
     *
     * @return the player's name, or null if not spawned by soul stone.
     */
    String getSoulStonePlayerName();

    /**
     * Returns whether the NPC has been initialized after a soul stone spawn.
     *
     * @return true if initialized, false otherwise.
     */
    boolean isSoulStoneInit();

    /**
     * Returns whether the NPC refuses to be captured by a soul stone.
     *
     * @return true if it refuses, false otherwise.
     */
    boolean getRefuseSoulStone();

    /**
     * Sets whether the NPC refuses to be captured by a soul stone.
     *
     * @param refuse true to refuse, false to allow.
     */
    void setRefuseSoulStone(boolean refuse);

    /**
     * Returns the minimum faction points required to capture the NPC with a soul stone.
     *
     * @return the minimum points (default -1 means use the faction's friendly points).
     */
    int getMinPointsToSoulStone();

    /**
     * Sets the minimum faction points required to capture the NPC with a soul stone.
     *
     * @param points the minimum faction points.
     */
    void setMinPointsToSoulStone(int points);

    /**
     * Gives an item to the specified player.
     *
     * @param player the recipient.
     * @param item   the item to give.
     */
    void giveItem(IPlayer player, IItemStack item);

    /**
     * Executes a command as the NPC.
     * <p>
     * Note: On servers the enable-command-block option must be set to true.
     * </p>
     *
     * @param command the command to execute.
     */
    void executeCommand(String command);

    /**
     * Returns the model data associated with the NPC.
     *
     * @return the model data, or null if not available.
     */
    IModelData getModelData();

    /**
     * (Deprecated) Sets the head scale of the NPC.
     *
     * @param x scale factor along the X-axis.
     * @param y scale factor along the Y-axis.
     * @param z scale factor along the Z-axis.
     */
    @Deprecated
    void setHeadScale(float x, float y, float z);

    /**
     * (Deprecated) Sets the body scale of the NPC.
     *
     * @param x scale factor along the X-axis.
     * @param y scale factor along the Y-axis.
     * @param z scale factor along the Z-axis.
     */
    @Deprecated
    void setBodyScale(float x, float y, float z);

    /**
     * (Deprecated) Sets the arms scale of the NPC.
     *
     * @param x scale factor along the X-axis.
     * @param y scale factor along the Y-axis.
     * @param z scale factor along the Z-axis.
     */
    @Deprecated
    void setArmsScale(float x, float y, float z);

    /**
     * (Deprecated) Sets the legs scale of the NPC.
     *
     * @param x scale factor along the X-axis.
     * @param y scale factor along the Y-axis.
     * @param z scale factor along the Z-axis.
     */
    @Deprecated
    void setLegsScale(float x, float y, float z);

    /**
     * Sets the NPC's explosion resistance.
     *
     * @param resistance the resistance (0–2, default is 1).
     */
    void setExplosionResistance(float resistance);

    /**
     * Returns the NPC's explosion resistance.
     *
     * @return the explosion resistance.
     */
    float getExplosionResistance();

    /**
     * Sets the NPC's melee resistance.
     *
     * @param resistance the resistance (0–2, default is 1).
     */
    void setMeleeResistance(float resistance);

    /**
     * Returns the NPC's melee resistance.
     *
     * @return the melee resistance.
     */
    float getMeleeResistance();

    /**
     * Sets the NPC's arrow resistance.
     *
     * @param resistance the resistance (0–2, default is 1).
     */
    void setArrowResistance(float resistance);

    /**
     * Returns the NPC's arrow resistance.
     *
     * @return the arrow resistance.
     */
    float getArrowResistance();

    /**
     * Sets the NPC's knockback resistance.
     *
     * @param resistance the resistance (0–2, default is 1).
     */
    void setKnockbackResistance(double resistance);

    /**
     * Returns the NPC's knockback resistance.
     *
     * @return the knockback resistance.
     */
    double getKnockbackResistance();

    /**
     * Sets the NPC's retaliation type.
     *
     * @param type the retaliation type (0: normal, 1: panic, 2: retreat, 3: nothing).
     */
    void setRetaliateType(int type);

    /**
     * Returns the NPC's combat health regeneration per second.
     *
     * @return the combat regen rate.
     */
    float getCombatRegen();

    /**
     * Sets the NPC's combat health regeneration per second.
     *
     * @param regen the combat regen rate.
     */
    void setCombatRegen(float regen);

    /**
     * Returns the NPC's health regeneration per second when not in combat.
     *
     * @return the health regen rate.
     */
    float getHealthRegen();

    /**
     * Sets the NPC's health regeneration per second when not in combat.
     *
     * @param regen the health regen rate.
     */
    void setHealthRegen(float regen);

    /**
     * Returns the age of the NPC in ticks.
     *
     * @return the age.
     */
    long getAge();

    /**
     * Returns the timers associated with the NPC.
     *
     * @return the timers.
     */
    ITimers getTimers();

    /**
     * Sets the NPC's flying ability.
     *
     * @param fly 1 to enable flying, 0 to disable.
     */
    void setFly(int fly);

    /**
     * Returns whether the NPC can fly.
     *
     * @return true if flying is enabled, false otherwise.
     */
    boolean canFly();

    /**
     * Sets the NPC's flying speed.
     *
     * @param flySpeed the fly speed.
     */
    void setFlySpeed(double flySpeed);

    /**
     * Returns the NPC's flying speed.
     *
     * @param unused unused parameter.
     * @return the fly speed.
     */
    double getFlySpeed(double unused);

    /**
     * Sets the gravity effect on the NPC while flying.
     *
     * @param flyGravity the fly gravity (0.0–1.0).
     */
    void setFlyGravity(double flyGravity);

    /**
     * Returns the gravity effect on the NPC while flying.
     *
     * @param unused unused parameter.
     * @return the fly gravity.
     */
    double getFlyGravity(double unused);

    /**
     * Sets the maximum flying height for the NPC.
     *
     * @param flyHeightLimit the height limit.
     */
    void setFlyHeightLimit(int flyHeightLimit);

    /**
     * Returns the maximum flying height for the NPC.
     *
     * @param unused unused parameter.
     * @return the fly height limit.
     */
    int getFlyHeightLimit(int unused);

    /**
     * Enables or disables flying height limitation.
     *
     * @param limit true to enable limitation, false to disable.
     */
    void limitFlyHeight(boolean limit);

    /**
     * Checks if flying height is limited.
     *
     * @param unused unused parameter.
     * @return true if limited, false otherwise.
     */
    boolean isFlyHeightLimited(boolean unused);

    /**
     * Sets the NPC's walking speed.
     *
     * @param speed the walking speed.
     */
    void setSpeed(double speed);

    /**
     * Returns the NPC's walking speed.
     *
     * @return the walking speed.
     */
    double getSpeed();

    /**
     * Sets the NPC's skin type.
     *
     * @param type the skin type.
     */
    void setSkinType(byte type);

    /**
     * Returns the NPC's skin type.
     *
     * @return the skin type.
     */
    byte getSkinType();

    /**
     * Sets the NPC's skin URL.
     *
     * @param url the skin URL.
     */
    void setSkinUrl(String url);

    /**
     * Returns the NPC's skin URL.
     *
     * @return the skin URL.
     */
    String getSkinUrl();

    /**
     * Sets the NPC's cloak texture.
     *
     * @param cloakTexture the cloak texture.
     */
    void setCloakTexture(String cloakTexture);

    /**
     * Returns the NPC's cloak texture.
     *
     * @return the cloak texture.
     */
    String getCloakTexture();

    /**
     * Adds an overlay texture to the NPC.
     *
     * @param overlayTexture the overlay texture.
     */
    void setOverlayTexture(String overlayTexture);

    /**
     * Returns the first overlay texture of the NPC.
     *
     * @return the overlay texture, or an empty string if none.
     */
    String getOverlayTexture();

    /**
     * Returns the NPC's overlay handler.
     *
     * @return the overlay handler.
     */
    IOverlayHandler getOverlays();

    /**
     * Sets the NPC's collision type.
     *
     * @param type the collision type.
     */
    void setCollisionType(int type);

    /**
     * Returns the NPC's collision type.
     *
     * @return the collision type.
     */
    int getCollisionType();

    /**
     * Updates the client with the latest NPC state.
     */
    void updateClient();

    /**
     * Updates the NPC's AI tasks.
     */
    void updateAI();

    /**
     * Returns the action manager used for scheduling NPC actions.
     *
     * @return the action manager.
     */
    IActionManager getActionManager();

    /**
     * Returns the Magic Data of an NPC
     *
     * @return Magic data
     */
    IMagicData getMagicData();
}
