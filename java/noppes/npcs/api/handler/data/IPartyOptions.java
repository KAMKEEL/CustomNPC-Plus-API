package noppes.npcs.api.handler.data;

public interface IPartyOptions {


    public boolean isAllowParty();

    public void setAllowParty(boolean allowParty);

    public boolean isOnlyParty();

    public void setOnlyParty(boolean onlyParty);

    /**
     * @return  0:Leader, 1:All, 2:Valid
     */
    public int getPartyRequirements();

    /**
     * @param partyRequirements 0:Leader, 1:All, 2:Valid
     */
    public void setPartyRequirements(int partyRequirements);

    /**
     * @return  0:Leader, 1:All, 2:Enrolled, 3:Valid
     */
    public int getRewardControl();

    /**
     * @param rewardControl 0:Leader, 1:All, 2:Enrolled, 3:Valid
     */
    public void setRewardControl(int rewardControl);

    /**
     * @return  0:Leader, 1:All, 2:Enrolled, 3:Valid
     */
    public int getCompleteFor();

    /**
     * @param completeFor 0:Leader, 1:All, 2:Enrolled, 3:Valid
     */
    public void setCompleteFor(int completeFor);

    /**
     * @return  0:Leader, 1:All, 2:Enrolled, 3:Valid
     */
    int getExecuteCommandFor();

    /**
     * @param commandFor 0:Leader, 1:All, 2:Enrolled, 3:Valid
     */
    void setExecuteCommandFor(int commandFor);

    /**
     * @return 0:Shard, 1:All, 2:Leader
     */
    public int getObjectiveRequirement();

    /**
     * @param requirement 0:Shard, 1:All, 2:Leader
     */
    public void setObjectiveRequirement(int requirement);

    public int getMinPartySize();

    public void setMinPartySize(int newSize);


    public int getMaxPartySize();

    public void setMaxPartySize(int newSize);
}
