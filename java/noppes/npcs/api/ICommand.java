package noppes.npcs.api;

public interface ICommand {
    String getCommandName();

    String getCommandUsage();

    int getPermissionLevel();

    void setCommandName(String commandName);

    void setCommandUsage(String commandUsage);

    void setPermissionLevel(int permissionLevel);

    String[] getAliases();

    void addAliases(String... aliases);

    boolean hasAlias(String alias);

    void removeAlias(String alias);
}
