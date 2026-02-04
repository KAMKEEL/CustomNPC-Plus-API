package noppes.npcs.api.ability.data;

import noppes.npcs.api.IPos;

import java.util.function.BiConsumer;

public interface IEnergyTrajectoryData {
    int getCurrentPath();

    void setCurrentPath(int currentPath);

    int getDelay(int path);

    void setDelay(int path, int ticks);

    IPos getPos(int path);

    void setPos(int path, IPos coords);

    boolean isConcluded(int path);

    void setConcluded(int path, boolean concluded);

    double getX(int path);

    void setX(int path, double x);

    double getY(int path);

    void setY(int path, double y);

    double getZ(int path);

    void setZ(int path, double z);

    void setPath(int path, IPos pos);

    void setPath(int path, IPos pos, int delay);

    void setPath(int path, double x, double y, double z);

    void setPath(int path, double x, double y, double z, int delay);

    IPath createPath(IPos coords);

    IPath createPath(IPos coords, int delay);

    IPath createPath(double x, double y, double z);

    IPath createPath(double x, double y, double z, int delay);

    void forEach(BiConsumer<Integer, IPath> lambda);

    interface IPath {

        IPos getPos();

        void setPos(IPos pos);

        int getDelay();

        void setDelay(int delayTicks);

        boolean isConcluded();

        void setConcluded(boolean concluded);

        double getX();

        void setX(double x);

        double getY();

        void setY(double y);

        double getZ();

        void setZ(double z);
    }
}
