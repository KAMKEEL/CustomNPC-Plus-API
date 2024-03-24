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

    @Cancelable
    interface Started extends IAnimationEvent {

    }

    interface Ended extends IAnimationEvent {

    }

    interface IFrameEvent extends IAnimationEvent {

        int getIndex();

        IFrame getFrame();

        interface Entered extends IFrameEvent {

        }

        interface Exited extends IFrameEvent {

        }
    }
}
