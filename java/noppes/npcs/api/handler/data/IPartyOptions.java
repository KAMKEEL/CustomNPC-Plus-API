package noppes.npcs.api.handler.data;

public interface IPartyOptions {


    public boolean isAllowParty();

    public void setAllowParty(boolean allowParty);


    /**
     * @return  0:Leader, 1:All, 2:Valid
     */
    public int getPartyRequirements();


    /**
     * @param partyRequirements 0:Leader, 1:All, 2:Valid
     */
    public void setPartyRequirements(int partyRequirements);

    /**
     * @return  0:Leader, 1:All, 2:Enrolled, 3:Completer
     */
    public int getRewardControl();

    /**
     * @param rewardControl 0:Leader, 1:All, 2:Enrolled, 3:Completer
     */
    public void setRewardControl(int rewardControl);

    /**
     * @return  0:Leader, 1:All, 2:Enrolled, 3:Completer
     */
    public int getCompleteFor();

    /**
     * @param completeFor 0:Leader, 1:All, 2:Enrolled, 3:Completer
     */
    public void setCompleteFor(int completeFor);

    public int getMaxPartySize();

    public void setMaxPartySize(int newSize);
}
