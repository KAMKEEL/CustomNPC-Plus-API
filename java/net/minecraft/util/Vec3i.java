package net.minecraft.util;

import com.google.common.base.Objects;

/** This code is owned by Minecraft */

public class Vec3i implements Comparable<Vec3i>
{
    /** X coordinate */
    private final int x;
    /** Y coordinate */
    private final int y;
    /** Z coordinate */
    private final int z;

    /** Double X coordinate */
    private final double xd;
    /** Double Y coordinate */
    private final double yd;
    /** Double Z coordinate */
    private final double zd;

    public Vec3i(int xIn, int yIn, int zIn)
    {
        this((double) xIn, (double) yIn, (double) zIn);
    }

    public Vec3i(double xIn, double yIn, double zIn)
    {
        this.x = MathHelper.floor_double(xIn);
        this.y = MathHelper.floor_double(yIn);
        this.z = MathHelper.floor_double(zIn);
        this.xd = xIn;
        this.yd = yIn;
        this.zd = zIn;
    }

    public boolean equals(Object p_equals_1_)
    {
        if (this == p_equals_1_)
        {
            return true;
        }
        else if (!(p_equals_1_ instanceof Vec3i))
        {
            return false;
        }
        else
        {
            Vec3i vec3I = (Vec3i)p_equals_1_;
            return this.getX() != vec3I.getX() ? false : (this.getY() != vec3I.getY() ? false : this.getZ() == vec3I.getZ());
        }
    }

    public int hashCode()
    {
        return (this.getY() + this.getZ() * 31) * 31 + this.getX();
    }

    public int compareTo(Vec3i p_compareTo_1_)
    {
        return this.getY() == p_compareTo_1_.getY() ? (this.getZ() == p_compareTo_1_.getZ() ? this.getX() - p_compareTo_1_.getX() : this.getZ() - p_compareTo_1_.getZ()) : this.getY() - p_compareTo_1_.getY();
    }

    /**
     * Get the X coordinate
     */
    public int getX()
    {
        return this.x;
    }

    /**
     * Get the Y coordinate
     */
    public int getY()
    {
        return this.y;
    }

    /**
     * Get the Z coordinate
     */
    public int getZ()
    {
        return this.z;
    }


    /**
     * Get the X coordinate as a double
     */
    public double getXD()
    {
        return this.xd;
    }

    /**
     * Get the Y coordinate as a double
     */
    public double getYD()
    {
        return this.yd;
    }

    /**
     * Get the Z coordinate as a double
     */
    public double getZD()
    {
        return this.zd;
    }

    /**
     * Calculate the cross product of this and the given Vector
     */
    public Vec3i crossProduct(Vec3i vec)
    {
        return new Vec3i(this.getYD() * vec.getZD() - this.getZD() * vec.getYD(), this.getZD() * vec.getXD() - this.getXD() * vec.getZD(), this.getXD() * vec.getYD() - this.getYD() * vec.getXD());
    }

    public String toString()
    {
        return Objects.toStringHelper(this).add("x", this.getX()).add("y", this.getY()).add("z", this.getZ()).toString();
    }
}