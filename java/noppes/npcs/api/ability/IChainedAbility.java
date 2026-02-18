package noppes.npcs.api.ability;

/**
 * API interface for chained abilities - ordered sequences of ability references
 * that execute one after another with configurable delays.
 */
public interface IChainedAbility extends IAbilityAction {

    boolean isWindUpAll();

    int getEntryCount();

    String getEntryReference(int index);

    int getEntryDelay(int index);

    boolean isEntryInline(int index);
}
