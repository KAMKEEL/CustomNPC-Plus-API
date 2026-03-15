# Scripting API — `src/api/java/noppes/npcs/api`

## Purpose
Public Java interfaces that define the scripting API surface. Scripts (JS/Java) interact
with the game exclusively through these interfaces — implementations live in `noppes.npcs.scripted`
and `noppes.npcs.controllers.data`. This separation means API changes affect every scripter.

## Package Layout
| Package | Contents |
|---------|----------|
| `entity/` | Core entity types: `IEntity`, `IEntityLivingBase`, `IPlayer`, `ICustomNpc`, `IAnimatable`, plus energy projectile variants |
| `entity/data/` | NPC visual data: `IModelData`, `IHitboxData`, `ITintData`, model scale/rotation |
| `event/` | 20 event interfaces (`INpcEvent`, `IPlayerEvent`, `IBlockEvent`, `IQuestEvent`, etc.) containing nested hook event types |
| `handler/` | Singletons and data managers: `ICloneHandler`, `IFactionHandler`, `IQuestHandler`, `IScriptHookHandler`, `IPlayerData`, etc. |
| `handler/data/` | Data objects: `IQuest`, `IDialog`, `IFaction`, `IAnimation`, `IFrame`, `ILinkedItem`, `ICustomEffect`, `IParty`, etc. |
| `item/` | Item wrappers: `IItemStack`, `IItemArmor`, `IItemLinked`, `IItemCustom` |
| `ability/` | Ability system: `IAbility`, `IAbilityAction`, `IChainedAbility`, `IDataAbilities`, `IPlayerAbilityData` |
| `gui/` | Custom GUI components: `ICustomGui`, `IButton`, `ILabel`, `ITextField`, `IScroll`, `IItemSlot` |
| `overlay/` | Screen overlays: `ICustomOverlay`, `IOverlayLabel`, `IOverlayLine`, `IOverlayTexturedRect` |
| `block/` | Scripted blocks: `IBlockScripted`, `ITextPlane` |
| `roles/`, `jobs/` | NPC role/job interfaces: `IRoleTrader`, `IJobGuard`, etc. |
| Root | Primitives: `IWorld`, `IPos`, `INbt`, `IBlock`, `ITimers`, `IDamageSource`, `IContainer`, `IParticle` |

## Entity Hierarchy
`IEntity<T>` → `IEntityLivingBase<T>` → `IEntityLiving<T>` → `ICustomNpc<T>`
`IEntity<T>` → `IEntityLivingBase<T>` → `IPlayer<T>`
Both `IPlayer` and `ICustomNpc` implement `IAnimatable`.

## Event/Hook Pattern
Every scriptable context has an event interface (e.g., `INpcEvent`) with nested inner interfaces
for each hook. Each inner interface has a `@hookName` Javadoc tag naming the script function:
```java
/** @hookName damaged */
@Cancelable
interface DamagedEvent extends INpcEvent {
    float getDamage();
    void setDamage(float damage);
    IEntity getSource();
}
```
Scripts receive the event as a parameter: `function damaged(event) { event.setDamage(0); }`.
Cancelable events can call `event.setCanceled(true)` to prevent default behavior.

## Hook Registration (Addon API)
`IScriptHookHandler` allows addons to register custom hooks with full metadata via
`IHookDefinition` (hook name, event class FQN, param names, required imports, cancelable flag).
Registered hooks appear in the script editor's hook list and get proper stub generation.

## API Entry Point
`AbstractNpcAPI` (accessed as `API` in scripts) provides global utilities: world access,
item/entity creation, handler lookups, temp/stored data, NBT construction, overlay/GUI creation.

## Design Rules
- **Interface-only API**: No implementation classes. Scripters see only `I*` interfaces.
- **Method overloads**: Provide both object-based (`IPos`) and primitive-based (`double x, y, z`) signatures.
- **Generic type params**: Entity interfaces use `<T extends EntityXxx>` to expose `getMCEntity()` for advanced users.
- **`@Deprecated` methods**: Keep for backward compatibility, add replacement alongside.
- **`@hookName` tag**: Required on every event inner interface — drives editor hook list and stub generation.
- **No runtime dependencies on editor**: API interfaces must never reference client/GUI classes.
