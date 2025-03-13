package noppes.npcs.api.roles;

import noppes.npcs.api.entity.IPlayer;

public interface IRoleFollower extends IRole {

    /**
     * @param player Player who is set as the owner. If null given everything resets
     * @since 1.7.10c
     */
    void setOwner(IPlayer player);

    /**
     * @return Returns the followers owner. Returns null if he has no owner or the owner is offline
     * @since 1.7.10c
     */
    IPlayer getOwner();

    /**
     * @return Returns whether or not the follower has an owner
     * @since 1.7.10c
     */
    boolean hasOwner();

    boolean isFollowing();

    void setIsFollowing(boolean following);

    /**
     * @return Returns days left
     * @since 1.7.10c
     */
    int getDaysLeft();

    /**
     * @param days The days you want to add to the days remaining
     * @since 1.7.10c
     */
    void addDaysLeft(int days);

    /**
     * @return Returns whether or not the follower is set to infinite days
     * @since 1.7.10c
     */
    boolean getInfiniteDays();

    /**
     * @param infinite Sets whether the days hired are infinite
     * @since 1.7.10c
     */
    void setInfiniteDays(boolean infinite);

    /**
     * @return Return whether the gui is disabled
     * @since 1.7.10c
     */
    boolean getGuiDisabled();

    /**
     * @param disabled Set the gui to be disabled or not
     * @since 1.7.10c
     */
    void setGuiDisabled(boolean disabled);


    /**
     * @param index  Index of Rate [0 - 2]
     * @param amount Amount hired for
     */
    void setRate(int index, int amount);

    /**
     * @param index Index of Rate [0 - 2]
     * @return amount fired for
     */
    int getRate(int index);

    /**
     * @param dialogHire New dialog hire string
     */
    void setDialogHire(String dialogHire);

    /**
     * @return dialog hire string
     */
    String getDialogHire();

    /**
     * @param dialogFarewell New dialog farewell string
     */
    void setDialogFarewell(String dialogFarewell);

    /**
     * @return dialog farewell string
     */
    String getDialogFarewell();
}
