package noppes.npcs.api.handler;

import java.util.List;

/**
 * Handler for registering and retrieving script hooks.
 * Addon mods can register custom hooks that will appear in the script editor GUIs.
 *
 * <h3>Available contexts:</h3>
 * <ul>
 *   <li>"npc" - NPC script editor</li>
 *   <li>"player" - Player scripts editor</li>
 *   <li>"block" - Scripted block editor</li>
 *   <li>"item" - Scripted item editor</li>
 *   <li>"linked_item" - Linked item editor</li>
 *   <li>"forge" - Forge scripts editor</li>
 *   <li>"global_npc" - Global NPC scripts editor</li>
 *   <li>"recipe" - Recipe scripts editor</li>
 *   <li>"effect" - Custom effect scripts editor</li>
 * </ul>
 *
 * <h3>Rich Hook Registration (Recommended)</h3>
 * Use {@link #registerHookDefinition(String, IHookDefinition)} for full metadata support:
 * <pre>{@code
 * hooks.registerHookDefinition("player", HookDefinition.builder("onDBCTransform")
 *     .eventClass(IDBCEvent.TransformEvent.class)
 *     .requiredImports("com.dbc.api.event.IDBCEvent")
 *     .cancelable(true)
 *     .build());
 * }</pre>
 */
public interface IScriptHookHandler {

    // ==================== RICH HOOK REGISTRATION (NEW) ====================

    /**
     * Register a hook with full metadata including event type, imports, and cancelability.
     * This is the recommended way to register addon hooks.
     *
     * @param context The context identifier (e.g., "npc", "player", "block")
     * @param definition The hook definition containing all metadata
     */
    void registerHookDefinition(String context, IHookDefinition definition);

    /**
     * Get the hook definition for a specific hook.
     *
     * @param context The context identifier
     * @param hookName The hook function name
     * @return The hook definition, or null if not found or no metadata available
     */
    IHookDefinition getHookDefinition(String context, String hookName);

    /**
     * Get all hook definitions for a context.
     *
     * @param context The context identifier
     * @return List of all hook definitions (may be empty, never null)
     */
    List<IHookDefinition> getAllHookDefinitions(String context);

    /**
     * Get the current hook revision number.
     * This increments each time a hook is registered, allowing caches to invalidate.
     *
     * @return The current revision number
     */
    int getHookRevision();

    // ==================== LEGACY HOOK REGISTRATION ====================

    /**
     * Register a hook for a single context (legacy method).
     * Creates a minimal definition without event type metadata.
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
