package noppes.npcs.api.event;

import cpw.mods.fml.common.eventhandler.Cancelable;
import noppes.npcs.api.entity.IAnimatable;
import noppes.npcs.api.handler.data.IAnimation;
import noppes.npcs.api.handler.data.IAnimationData;
import noppes.npcs.api.handler.data.IFrame;

public interface IAnimationEvent extends ICustomNPCsEvent {

    IAnimation getAnimation();

    IAnimationData getAnimationData();

    IAnimatable getEntity();

    /**
     * @hookName animationStart
     */
    @Cancelable
    interface Started extends IAnimationEvent {

    }

    /**
     * @hookName animationEnd
     */
    interface Ended extends IAnimationEvent {

    }

    interface IFrameEvent extends IAnimationEvent {

        int getIndex();

        IFrame getFrame();

        /**
         * @hookName frameEnter
         */
        interface Entered extends IFrameEvent {

        }

        /**
         * @hookName frameExit
         */
        interface Exited extends IFrameEvent {

        }
    }
}
