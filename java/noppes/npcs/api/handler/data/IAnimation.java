package noppes.npcs.api.handler.data;

public interface IAnimation {

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

    IAnimation useRenderTicks(boolean renderTicks);

    boolean useRenderTicks();

    IAnimation doWhileStanding(boolean whileStanding);

    boolean doWhileStanding();

    IAnimation doWhileMoving(boolean whileMoving);

    boolean doWhileMoving();

    IAnimation doWhileAttacking(boolean whileAttacking);

    boolean doWhileAttacking();

    IAnimation setLoop(int loopAtFrame);

    int loop();

    IAnimation save();
}
