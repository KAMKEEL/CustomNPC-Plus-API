package noppes.npcs.api;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.eventhandler.EventBus;
import net.minecraft.entity.Entity;
import net.minecraft.entity.INpc;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import noppes.npcs.api.entity.ICustomNpc;
import noppes.npcs.api.entity.IEntity;
import noppes.npcs.api.entity.IPlayer;
import noppes.npcs.api.gui.ICustomGui;
import noppes.npcs.api.handler.IAbilityHandler;
import noppes.npcs.api.handler.IActionManager;
import noppes.npcs.api.handler.IAnimationHandler;
import noppes.npcs.api.handler.ICloneHandler;
import noppes.npcs.api.handler.ICustomEffectHandler;
import noppes.npcs.api.handler.IDialogHandler;
import noppes.npcs.api.handler.IFactionHandler;
import noppes.npcs.api.handler.IMagicHandler;
import noppes.npcs.api.handler.INaturalSpawnsHandler;
import noppes.npcs.api.handler.IPartyHandler;
import noppes.npcs.api.handler.IProfileHandler;
import noppes.npcs.api.handler.IQuestHandler;
import noppes.npcs.api.handler.IRecipeHandler;
import noppes.npcs.api.handler.IScriptHookHandler;
import noppes.npcs.api.handler.ITransportHandler;
import noppes.npcs.api.handler.data.IAnimation;
import noppes.npcs.api.handler.data.IFrame;
import noppes.npcs.api.handler.data.IFramePart;
import noppes.npcs.api.handler.data.ISound;
import noppes.npcs.api.item.IItemStack;
import noppes.npcs.api.overlay.ICustomOverlay;

import java.io.File;
import java.util.HashMap;

/**
 * This object stores functions available to all scripting handlers through the "API" keyword.
 *
 */
public abstract class AbstractNpcAPI {
    private static AbstractNpcAPI instance = null;

    public AbstractNpcAPI() {
    }

    /**
     * @param key Get temp data for this key
     * @return Returns the stored temp data
     */
    public abstract Object getTempData(String key);

    /**
     * Tempdata gets cleared when the server restarts. All worlds share the same temp data.
     *
     * @param key   The key for the data stored
     * @param value The data stored
     */
    public abstract void setTempData(String key, Object value);

    /**
     * @param key The key thats going to be tested against the temp data
     * @return Whether or not temp data containes the key
     */
    public abstract boolean hasTempData(String key);

    /**
     * @param key The key for the temp data to be removed
     */
    public abstract void removeTempData(String key);

    /**
     * Removes all tempdata
     */
    public abstract void clearTempData();

    public abstract String[] getTempDataKeys();

    /**
     * @param key The key of the data to be returned
     * @return Returns the stored data
     */
    public abstract Object getStoredData(String key);

    /**
     * Stored data persists through world restart. Unlike tempdata only Strings and Numbers can be saved
     *
     * @param key   The key for the data stored
     * @param value The data stored. This data can be either a Number or a String. Other data is not stored
     */
    public abstract void setStoredData(String key, Object value);

    /**
     * @param key The key of the data to be checked
     * @return Returns whether or not the stored data contains the key
     */
    public abstract boolean hasStoredData(String key);

    /**
     * @param key The key of the data to be removed
     */
    public abstract void removeStoredData(String key);

    /**
     * Remove all stored data
     */
    public abstract void clearStoredData();

    public abstract String[] getStoredDataKeys();

    public abstract void registerICommand(ICommand command);

    public abstract ICommand getICommand(String commandName, int priorityLevel);

    public abstract void addGlobalObject(String key, Object obj);

    public abstract void removeGlobalObject(String key);

    public abstract boolean hasGlobalObject(String key);

    public abstract HashMap<String, Object> getEngineObjects();

    public abstract long sizeOfObject(Object obj);

    public abstract void stopServer();

    public abstract int getCurrentPlayerCount();

    public abstract int getMaxPlayers();

    public abstract void kickAllPlayers();

    public abstract boolean isHardcore();

    public abstract File getFile(String path);

    public abstract String getServerOwner();

    public abstract IFactionHandler getFactions();

    public abstract IRecipeHandler getRecipes();

    public abstract IQuestHandler getQuests();

    public abstract IDialogHandler getDialogs();

    public abstract ICloneHandler getClones();

    public abstract INaturalSpawnsHandler getNaturalSpawns();

    public abstract IProfileHandler getProfileHandler();

    public abstract ICustomEffectHandler getCustomEffectHandler();

    public abstract IMagicHandler getMagicHandler();

    public abstract IPartyHandler getPartyHandler();

    public abstract ITransportHandler getLocations();

    public abstract IAnimationHandler getAnimations();

    /**
     * Get the script hook handler for registering custom hooks.
     * Addon mods can use this to register hooks that will appear in script editor GUIs.
     *
     * @return The script hook handler
     */
    public abstract IScriptHookHandler getScriptHooks();

    public abstract IAbilityHandler getAbilities();

    public abstract String[] getAllBiomeNames();

    public abstract ICustomNpc<?> createNPC(IWorld var1);

    /**
     *
     * Spawns a new NPC in the world at the given coordinates and returns an ICustomNpc object of it.
     */
    public abstract ICustomNpc<?> spawnNPC(IWorld var1, int var2, int var3, int var4);

    public abstract ICustomNpc<?> spawnNPC(IWorld world, IPos pos);

    public abstract IEntity<?> getIEntity(Entity var1);

    public abstract IPlayer<?> getPlayer(String username);

    public abstract INpc[] getChunkLoadingNPCs();

    public abstract IEntity<?>[] getLoadedEntities();

    public abstract IBlock getIBlock(IWorld world, int x, int y, int z);

    public abstract IBlock getIBlock(IWorld world, IPos pos);

    public abstract ITileEntity getITileEntity(IWorld world, IPos pos);

    public abstract ITileEntity getITileEntity(IWorld world, int x, int y, int z);

    public abstract ITileEntity getITileEntity(TileEntity tileEntity);

    public abstract IPos getIPos(BlockPos pos);

    public abstract IPos getIPos(int x, int y, int z);

    public abstract IPos getIPos(double x, double y, double z);

    public abstract IPos getIPos(float x, float y, float z);

    public abstract IPos getIPos(long serializedPos);

    /**
     * Forms a box with corners as the input IPos parameters, and returns all
     * points inside the box as a list of IPos vectors.
     *
     * @param from           The starting IPos vector, first corner of the box.
     * @param to             The ending IPos vector, opposite corner of the box.
     * @param sortByDistance Sorts the list by distance from the "from" IPos parameter.
     * @return The list of all IPos vectors inside the box.
     */
    public abstract IPos[] getAllInBox(IPos from, IPos to, boolean sortByDistance);

    public abstract IPos[] getAllInBox(IPos from, IPos to);

    public abstract IContainer getIContainer(IInventory var1);

    public abstract IContainer getIContainer(Container var1);

    public abstract IItemStack getIItemStack(ItemStack var1);

    /**
     * @return A single IWorld from Loaded IWorlds
     */
    public abstract IWorld getIWorld(World var1);

    /**
     * @return A single IWorld from Loaded IWorlds
     */
    public abstract IWorld getIWorld(int var1);

    /**
     * This will forcefully load the dimension if it is not loaded
     * Forge sometimes automatically, unloads the End when all players
     * are no longer present.
     *
     * @return A single IWorld from Loaded/Unloaded IWorlds
     */
    public abstract IWorld getIWorldLoad(int var1);

    /**
     *
     * @return The global IActionManager for the server
     */
    public abstract IActionManager getActionManager();

    /**
     * @return The list of all LOADED IWorlds
     */
    public abstract IWorld[] getIWorlds();

    public abstract IDamageSource getIDamageSource(DamageSource var1);

    public abstract IDamageSource getIDamageSource(IEntity<?> entity);

    public abstract EventBus events();

    public abstract File getGlobalDir();

    public abstract File getWorldDir();

    public static boolean IsAvailable() {
        return Loader.isModLoaded("customnpcs");
    }

    public static AbstractNpcAPI Instance() {
        if (instance != null) {
            return instance;
        } else if (!IsAvailable()) {
            return null;
        } else {
            try {
                Class<?> c = Class.forName("noppes.npcs.scripted.NpcAPI");
                instance = (AbstractNpcAPI) c.getMethod("Instance").invoke((Object) null);
            } catch (Exception var1) {
                var1.printStackTrace();
            }

            return instance;
        }
    }

    public abstract void executeCommand(IWorld var1, String var2);

    /**
     * Generates a new name as a String using the Markov name generator.
     *
     * @param dictionary An integer representing which dictionary to use:
     *                   0: Roman
     *                   1: Japanese
     *                   2: Slavic
     *                   3: Welsh
     *                   4: Saami
     *                   5: Old Norse
     *                   6: Ancient Greek
     *                   7: Aztec
     *                   8: CustomNPCs Classic
     *                   9: Spanish
     * @param gender     The gender of the name:
     *                   0: Random
     *                   1: Male
     *                   2: Female
     */
    public abstract String getRandomName(int dictionary, int gender);

    public abstract INbt getINbt(NBTTagCompound nbtTagCompound);

    public abstract INbt stringToNbt(String str);

    public abstract IPlayer<?>[] getAllServerPlayers();

    public abstract String[] getPlayerNames();

    public abstract IItemStack createItemFromNBT(INbt nbt);

    public abstract IItemStack createItem(String id, int damage, int size);

    public abstract void playSoundAtEntity(IEntity<?> entity, String sound, float volume, float pitch);

    public abstract void playSoundToNearExcept(IPlayer<?> player, String sound, float volume, float pitch);

    /**
     *
     * @return Returns the server's Message of The Day.
     */
    public abstract String getMOTD();

    /**
     * @param motd The server's new Message of The Day.
     */
    public abstract void setMOTD(String motd);

    /**
     *
     * @return A new IParticle object initialized with the given texture.
     */
    public abstract IParticle createParticle(String directory);

    @Deprecated
    public abstract IParticle createEntityParticle(String directory);

    public abstract ISound createSound(String directory);

    public abstract void playSound(int id, ISound sound);

    public abstract void playSound(ISound sound);

    public abstract void stopSound(int id);

    public abstract void pauseSounds();

    public abstract void continueSounds();

    public abstract void stopSounds();

    /**
     *
     * @return The uptime of the server in MC ticks.
     */
    public abstract int getServerTime();

    public abstract boolean arePlayerScriptsEnabled();

    public abstract boolean areForgeScriptsEnabled();

    public abstract boolean areGlobalNPCScriptsEnabled();

    public abstract void enablePlayerScripts(boolean enable);

    public abstract void enableForgeScripts(boolean enable);

    public abstract void enableGlobalNPCScripts(boolean enable);

    /**
     *
     * @param id        The id of the custom GUI.
     * @param width     The width of the GUI in pixels.
     * @param height    The height of the GUI in pixels.
     * @param pauseGame Whether the GUI pauses the game or not.
     * @return A new ICustomGui object with the given attributes.
     */
    public abstract ICustomGui createCustomGui(int id, int width, int height, boolean pauseGame);

    /**
     *
     * @return A new ICustomOverlay overlay object with the given ID.
     */
    public abstract ICustomOverlay createCustomOverlay(int id);

    /**
     *
     * @return A new ISkinOverlay object initialized with the given texture.
     */
    public abstract ISkinOverlay createSkinOverlay(String texture);

    public abstract String millisToTime(long millis);

    public abstract String ticksToTime(long ticks);

    public abstract IAnimation createAnimation(String name);

    public abstract IAnimation createAnimation(String name, float speed, byte smooth);

    public abstract IFrame createFrame(int duration);

    public abstract IFrame createFrame(int duration, float speed, byte smooth);

    public abstract IFramePart createPart(String name);

    public abstract IFramePart createPart(String name, float[] rotation, float[] pivot);

    public abstract IFramePart createPart(String name, float[] rotation, float[] pivot, float speed, byte smooth);

    public abstract IFramePart createPart(int partId);

    public abstract IFramePart createPart(int partId, float[] rotation, float[] pivot);

    public abstract IFramePart createPart(int partId, float[] rotation, float[] pivot, float speed, byte smooth);
}
