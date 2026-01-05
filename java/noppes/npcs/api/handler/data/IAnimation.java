package noppes.npcs.api.handler.data;

import noppes.npcs.controllers.data.Animation;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public interface IAnimation {

    IAnimationData getParent();

    IFrame currentFrame();

    IFrame[] getFrames();

    IAnimation setFrames(IFrame[] frames);

    IAnimation clearFrames();

    IAnimation addFrame(IFrame frame);

    IAnimation addFrame(int index, IFrame frame);

    IAnimation removeFrame(IFrame frame);

    IAnimation setName(String name);

    String getName();

    IAnimation setSpeed(float speed);

    float getSpeed();

    IAnimation setSmooth(byte smooth);

    byte isSmooth();

    IAnimation doWhileStanding(boolean whileStanding);

    boolean doWhileStanding();

    IAnimation doWhileMoving(boolean whileMoving);

    boolean doWhileMoving();

    IAnimation doWhileAttacking(boolean whileAttacking);

    boolean doWhileAttacking();

    IAnimation setLoop(int loopAtFrame);

    int loop();

    IAnimation save();

    int getID();

    /**
     * Do not use this unless you know what you are changing. Dangerous to change.
     */
    void setID(int id);

    long getTotalTime();

    boolean hasData(String key);

    Object getData(String key);

    IAnimation setData(String key, Object v);

    IAnimation removeData(String key);

    IAnimation onStart(Consumer<Animation> task);

    IAnimation onFrame(BiConsumer<Integer, Animation> task);

    IAnimation onEnd(Consumer<Animation> task);
}
