package noppes.npcs.api.ability.data;

import kamkeel.npcs.controllers.data.ability.data.EnergyTrajectoryData;
import noppes.npcs.api.IPos;

public interface IEnergyTrajectoryData {
    int getCurrentPath();

    void setCurrentPath(int currentPath);

    int getDelay(int path);

    void setDelay(int path, int ticks);

    IPos getPos(int path);

    void setPos(int path, IPos coords);

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

    interface IPath {

    }
}
