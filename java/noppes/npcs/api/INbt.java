package noppes.npcs.api;

import net.minecraft.nbt.NBTTagCompound;

import java.util.Set;

/**
 * MC shadow of the unified INbt interface.
 * This version shadows the platform-api INbt at compile time for mc1710,
 * adding the typed {@code getMCNBT()} method and scripting convenience methods.
 *
 * <p>Compound tags contain uniquely-keyed tags of various types:
 * <pre>
 * 1: Byte    2: Short   3: Int      4: Long
 * 5: Float   6: Double  7: Byte[]   8: String
 * 9: List   10: Compound 11: Int[]
 * </pre>
 */
public interface INbt {

    // ======================== Setters ========================

    void setString(String key, String value);

    void setInteger(String key, int value);

    void setBoolean(String key, boolean value);

    void setDouble(String key, double value);

    void setFloat(String key, float value);

    void setLong(String key, long value);

    void setShort(String key, short value);

    void setByte(String key, byte value);

    void setByteArray(String key, byte[] value);

    void setIntArray(String key, int[] value);

    default void setIntegerArray(String key, int[] value) {
        setIntArray(key, value);
    }

    void setCompound(String key, INbt compound);

    default void setTag(String key, INbt compound) {
        setCompound(key, compound);
    }

    /**
     * Sets a list from an Object array. Elements can be: INbt, String, Double, Float, Integer, int[].
     */
    void setList(String key, Object[] value);

    /**
     * Sets a typed tag list on this compound.
     */
    void setTagList(String key, INbtList list);

    // ======================== Getters ========================

    String getString(String key);

    int getInteger(String key);

    boolean getBoolean(String key);

    double getDouble(String key);

    float getFloat(String key);

    long getLong(String key);

    short getShort(String key);

    byte getByte(String key);

    byte[] getByteArray(String key);

    int[] getIntArray(String key);

    default int[] getIntegerArray(String key) {
        return getIntArray(key);
    }

    INbt getCompound(String key);

    /**
     * Returns a tag list as an Object array. Elements are typed based on list type:
     * INbt (compounds), String, Double, Float, Integer, int[].
     */
    Object[] getList(String key, int type);

    /**
     * Gets a typed tag list from this compound.
     *
     * @param key  the key
     * @param type the element type ID (e.g. 10 for compounds, 8 for strings)
     * @return the list, or an empty list if the key doesn't exist
     */
    INbtList getTagList(String key, int type);

    /**
     * Returns the type of the tag list with this key.
     */
    int getListType(String key);

    // ======================== Query ========================

    boolean hasKey(String key);

    default boolean has(String key) {
        return hasKey(key);
    }

    boolean hasKey(String key, int type);

    Set<String> getKeySet();

    default String[] getKeys() {
        return getKeySet().toArray(new String[0]);
    }

    void removeTag(String key);

    default void remove(String key) {
        removeTag(key);
    }

    int getTagType(String key);

    default int getType(String key) {
        return getTagType(key);
    }

    boolean isEmpty();

    // ======================== Interop ========================

    void merge(INbt other);

    INbt copy();

    /**
     * Returns the underlying MC NBTTagCompound.
     * Expert use only.
     */
    NBTTagCompound getMCNBT();

    // ======================== Convenience ========================

    String toJsonString();

    boolean isEqual(INbt nbt);

    void clear();
}
