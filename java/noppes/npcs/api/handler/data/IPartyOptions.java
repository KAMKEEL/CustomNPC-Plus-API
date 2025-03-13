package noppes.npcs.api.handler.data;

public interface IPartyOptions {


    boolean isAllowParty();

    void setAllowParty(boolean allowParty);

    boolean isOnlyParty();

    void setOnlyParty(boolean onlyParty);

    /**
     * @return 0:Leader, 1:All, 2:Valid
     */
    int getPartyRequirements();

    /**
     * @param partyRequirements 0:Leader, 1:All, 2:Valid
     */
    void setPartyRequirements(int partyRequirements);

    /**
     * @return 0:Leader, 1:All, 2:Enrolled, 3:Valid
     */
    int getRewardControl();

    /**
     * @param rewardControl 0:Leader, 1:All, 2:Enrolled, 3:Valid
     */
    void setRewardControl(int rewardControl);

    /**
     * @return 0:Leader, 1:All, 2:Enrolled, 3:Valid
     */
    int getCompleteFor();

    /**
     * @param completeFor 0:Leader, 1:All, 2:Enrolled, 3:Valid
     */
    void setCompleteFor(int completeFor);

    /**
     * @return 0:Leader, 1:All, 2:Enrolled, 3:Valid
     */
    int getExecuteCommandFor();

    /**
     * @param commandFor 0:Leader, 1:All, 2:Enrolled, 3:Valid
     */
    void setExecuteCommandFor(int commandFor);

    /**
     * @return 0:Shard, 1:All, 2:Leader
     */
    int getObjectiveRequirement();

    /**
     * @param requirement 0:Shard, 1:All, 2:Leader
     */
    void setObjectiveRequirement(int requirement);

    int getMinPartySize();

    void setMinPartySize(int newSize);


    int getMaxPartySize();

    void setMaxPartySize(int newSize);
}
