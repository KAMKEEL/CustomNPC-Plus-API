package noppes.npcs.api.handler;

import noppes.npcs.api.IPos;
import noppes.npcs.api.IWorld;
import noppes.npcs.api.entity.IEntity;

public interface ICloneHandler {

    IEntity spawn(double x, double y, double z, int tab, String name, IWorld world, boolean ignoreProtection);

    IEntity spawn(IPos pos, int tab, String name, IWorld world, boolean ignoreProtection);

    IEntity spawn(double x, double y, double z, int tab, String name, IWorld world);

    IEntity spawn(IPos pos, int tab, String name, IWorld world);

    IEntity[] getTab(int tab, IWorld world);

    IEntity get(int tab, String name, IWorld world);

    boolean has(int tab, String name);

    void set(int tab, String name, IEntity entity);

    void remove(int tab, String name);

    // --- Custom Folder Methods ---

    String[] getFolders();

    boolean hasFolder(String folderName);

    IEntity spawn(double x, double y, double z, String folderName, String name, IWorld world, boolean ignoreProtection);

    IEntity spawn(IPos pos, String folderName, String name, IWorld world, boolean ignoreProtection);

    IEntity spawn(double x, double y, double z, String folderName, String name, IWorld world);

    IEntity spawn(IPos pos, String folderName, String name, IWorld world);

    IEntity[] getFolder(String folderName, IWorld world);

    IEntity get(String folderName, String name, IWorld world);

    boolean has(String folderName, String name);

    void set(String folderName, String name, IEntity entity);

    void remove(String folderName, String name);
}
