package noppes.npcs.api.entity.data;

public interface IModelRotate {

    boolean whileStanding();

    void whileStanding(boolean whileStanding);

    boolean whileAttacking();

    void whileAttacking(boolean whileAttacking);

    boolean whileMoving();

    void whileMoving(boolean whileMoving);

    IModelRotatePart getPart(int part);
}
