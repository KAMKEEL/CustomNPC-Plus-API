package noppes.npcs.api;

/**
 * MC shadow of the INbtList interface.
 * Shadows the platform-api version at compile time for mc1710.
 */
public interface INbtList {

    int size();

    INbt getCompound(int index);

    String getString(int index);

    int getInt(int index);

    double getDouble(int index);

    float getFloat(int index);

    int[] getIntArray(int index);

    int getElementType();

    // --- Mutators ---

    void addCompound(INbt compound);

    void addString(String value);

    void addInt(int value);

    void addDouble(double value);

    void remove(int index);

    Object getMCTagList();
}
