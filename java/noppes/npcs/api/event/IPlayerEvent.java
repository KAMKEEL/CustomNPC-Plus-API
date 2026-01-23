package noppes.npcs.api.event;

import cpw.mods.fml.common.eventhandler.Cancelable;
import noppes.npcs.api.IBlock;
import noppes.npcs.api.IContainer;
import noppes.npcs.api.IDamageSource;
import noppes.npcs.api.entity.IEntity;
import noppes.npcs.api.entity.IEntityLivingBase;
import noppes.npcs.api.entity.IPlayer;
import noppes.npcs.api.handler.data.IPlayerEffect;
import noppes.npcs.api.handler.data.IProfile;
import noppes.npcs.api.item.IItemStack;

public interface IPlayerEvent extends ICustomNPCsEvent {

    IPlayer getPlayer();

    @Cancelable
    interface ChatEvent extends IPlayerEvent {
        void setMessage(String message);

        String getMessage();
    }

    interface KeyPressedEvent extends IPlayerEvent {
        int getKey();

        boolean isCtrlPressed();

        boolean isAltPressed();

        boolean isShiftPressed();

        boolean isMetaPressed();

        boolean keyDown();

        int[] getKeysDown();
    }

    interface MouseClickedEvent extends IPlayerEvent {
        int getButton();

        int getMouseWheel();

        boolean buttonDown();

        boolean isCtrlPressed();

        boolean isAltPressed();

        boolean isShiftPressed();

        boolean isMetaPressed();

        int[] getKeysDown();
    }

    interface PickupXPEvent extends IPlayerEvent {
        int getAmount();
    }

    interface LevelUpEvent extends IPlayerEvent {
        int getChange();
    }

    interface LogoutEvent extends IPlayerEvent {
    }

    interface LoginEvent extends IPlayerEvent {
    }

    interface RespawnEvent extends IPlayerEvent {
    }

    /**
     * @hookName changedDim
     */
    interface ChangedDimension extends IPlayerEvent {
        int getFromDim();

        int getToDim();
    }

    interface TimerEvent extends IPlayerEvent {
        int getId();
    }

    @Cancelable
    interface AttackedEvent extends IPlayerEvent {
        IDamageSource getDamageSource();

        IEntity getSource();

        float getDamage();
    }

    @Cancelable
    interface DamagedEvent extends IPlayerEvent {
        IDamageSource getDamageSource();

        IEntity getSource();

        float getDamage();
    }

    @Cancelable
    interface LightningEvent extends IPlayerEvent {
    }

    /**
     * @hookName playSound
     */
    @Cancelable
    interface SoundEvent extends IPlayerEvent {
        String getName();

        float getPitch();

        float getVolume();
    }

    @Cancelable
    interface FallEvent extends IPlayerEvent {
        float getDistance();
    }

    interface JumpEvent extends IPlayerEvent {
    }

    /**
     * @hookName kills
     */
    interface KilledEntityEvent extends IPlayerEvent {
        IEntityLivingBase getEntity();
    }

    /**
     * @hookName killed
     */
    interface DiedEvent extends IPlayerEvent {
        IDamageSource getDamageSource();

        String getType();

        IEntity getSource();
    }

    @Cancelable
    interface RangedLaunchedEvent extends IPlayerEvent {
        IItemStack getBow();

        int getCharge();
    }

    @Cancelable
    interface AttackEvent extends IPlayerEvent {
        IDamageSource getDamageSource();

        IEntity getTarget();

        float getDamage();
    }

    @Cancelable
    interface DamagedEntityEvent extends IPlayerEvent {
        IDamageSource getDamageSource();

        IEntity getTarget();

        float getDamage();
    }

    interface ContainerClosed extends IPlayerEvent {
        IContainer getContainer();
    }

    interface ContainerOpen extends IPlayerEvent {
        IContainer getContainer();
    }

    @Cancelable
    interface PickUpEvent extends IPlayerEvent {
        IItemStack getItem();
    }

    @Cancelable
    interface DropEvent extends IPlayerEvent {
        IItemStack[] getItems();
    }

    @Cancelable
    interface TossEvent extends IPlayerEvent {
        IItemStack getItem();
    }

    @Cancelable
    interface InteractEvent extends IPlayerEvent {
        int getType();

        IEntity getTarget();
    }

    @Cancelable
    interface RightClickEvent extends IPlayerEvent {
        int getType();

        Object getTarget();

        IPlayer getPlayer();
    }

    /**
     * @hookName tick
     */
    interface UpdateEvent extends IPlayerEvent {
    }

    interface InitEvent extends IPlayerEvent {
    }

    /**
     * @hookName startItem
     */
    interface StartUsingItem extends IPlayerEvent {
        IItemStack getItem();

        int getDuration();
    }

    interface UsingItem extends IPlayerEvent {
        IItemStack getItem();

        int getDuration();
    }

    /**
     * @hookName stopItem
     */
    interface StopUsingItem extends IPlayerEvent {
        IItemStack getItem();

        int getDuration();
    }

    /**
     * @hookName finishItem
     */
    interface FinishUsingItem extends IPlayerEvent {
        IItemStack getItem();

        int getDuration();
    }

    /**
     * @hookName breakBlock
     */
    @Cancelable
    interface BreakEvent extends IPlayerEvent {
        IBlock getBlock();

        int getExp();
    }

    interface UseHoeEvent extends IPlayerEvent {
        IItemStack getHoe();

        int getX();

        int getY();

        int getZ();
    }

    interface WakeUpEvent extends IPlayerEvent {
        boolean setSpawn();
    }

    interface SleepEvent extends IPlayerEvent {
        int getX();

        int getY();

        int getZ();
    }

    interface AchievementEvent extends IPlayerEvent {
        String getDescription();
    }

    interface FillBucketEvent extends IPlayerEvent {
        IItemStack getCurrent();

        IItemStack getFilled();
    }

    interface BonemealEvent extends IPlayerEvent {
        IBlock getBlock();

        int getX();

        int getY();

        int getZ();
    }

    interface RangedChargeEvent extends IPlayerEvent {
    }

    interface EffectEvent extends IPlayerEvent {

        IPlayerEffect getEffect();

        /**
         * @hookName onEffectAdd
         */
        interface Added extends EffectEvent {

        }

        /**
         * @hookName onEffectTick
         */
        interface Ticked extends EffectEvent {

        }

        /**
         * @hookName onEffectRemove
         */
        interface Removed extends EffectEvent {

            /**
             * @return If the effect timer has ticked down to 0.
             */
            boolean hasTimerRunOut();

            /**
             * @return If the effect was removed on death.
             */
            boolean causedByDeath();
        }

    }

    @Cancelable
    interface ProfileEvent extends IPlayerEvent {

        /**
         * @return IProfile Object of the Operation
         */
        IProfile getProfile();

        /**
         * @return Slot ID in question
         */
        int getSlot();

        /**
         * @return returns true if it occurs after the operation (not cancellable)
         */
        boolean isPost();

        /**
         * @hookName profileChange
         */
        @Cancelable
        interface Changed extends ProfileEvent {
            /**
             * @return The previous slot before the switch
             */
            int getPrevSlot();
        }

        /**
         * @hookName profileCreate
         */
        @Cancelable
        interface Create extends ProfileEvent {
        }

        /**
         * @hookName profileRemove
         */
        @Cancelable
        interface Removed extends ProfileEvent {
        }
    }
}
