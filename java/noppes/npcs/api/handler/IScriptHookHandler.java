package noppes.npcs.api.handler;

import java.util.List;

/**
 * Handler for registering and retrieving script hooks.
 * Addon mods can register custom hooks that will appear in the script editor GUIs.
 *
 * Available contexts:
 * - "npc" - NPC script editor
 * - "player" - Player scripts editor
 * - "block" - Scripted block editor
 * - "item" - Scripted item editor
 * - "linked_item" - Linked item editor
 * - "forge" - Forge scripts editor
 * - "global_npc" - Global NPC scripts editor
 * - "recipe" - Recipe scripts editor
 * - "effect" - Custom effect scripts editor
 */
public interface IScriptHookHandler {

    /**
     * Register a hook for a single context.
     *
     * @param context The context identifier (e.g., "npc", "player", "block")
     * @param functionName The script function name (e.g., "onMyCustomEvent")
     */
    void registerHook(String context, String functionName);

    /**
     * Register a hook for multiple contexts at once.
     *
     * @param functionName The script function name
     * @param contexts The contexts where this hook should appear
     */
    void registerHooks(String functionName, String... contexts);

    /**
     * Unregister a hook from a specific context.
     *
     * @param context The context to remove the hook from
     * @param functionName The function name to remove
     */
    void unregisterHook(String context, String functionName);

    /**
     * Unregister a hook from all contexts.
     *
     * @param functionName The function name to remove
     */
    void unregisterHookFromAll(String functionName);

    /**
     * Get all registered addon hooks for a context.
     * This does not include built-in hooks.
     *
     * @param context The context identifier
     * @return List of hook function names for that context
     */
    List<String> getAddonHooks(String context);

    /**
     * Get all hooks (built-in + addon) for a context.
     *
     * @param context The context identifier
     * @return List of all hook function names for that context
     */
    List<String> getAllHooks(String context);

    /**
     * Check if a hook is registered in a specific context.
     *
     * @param context The context to check
     * @param functionName The function name to look for
     * @return true if the hook is registered
     */
    boolean hasHook(String context, String functionName);

    /**
     * Get all available context identifiers.
     *
     * @return Array of context strings
     */
    String[] getContexts();
}
