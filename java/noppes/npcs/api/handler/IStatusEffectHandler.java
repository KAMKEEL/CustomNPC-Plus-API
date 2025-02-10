package noppes.npcs.api.handler;

import noppes.npcs.api.entity.IPlayer;
import noppes.npcs.api.handler.data.ICustomEffect;

public interface IStatusEffectHandler {

    ICustomEffect createEffect(String name);

    ICustomEffect getEffect(String name);

    void deleteEffect(String name);

    /**
     *
     * @param player Player
     * @param id ID of Status Effect -- Only DBC Addon
     * @return True if Player has Effect
     */
    boolean hasEffect(IPlayer player, int id);

    boolean hasEffect(IPlayer player, ICustomEffect effect);

    /**
     *
     * -1 : Does not have effect
     * -100 : Has infinite effect
     *
     * @param player Player
     * @param id ID of Status Effect -- Only DBC Addon
     * @return Effect Time
     */
    int getEffectDuration(IPlayer player, int id);

    int getEffectDuration(IPlayer player, ICustomEffect effect);

    /**
     * @param player Player
     * @param id ID of Status Effect
     * @param duration Duration of Effect in Seconds | -100 : Has infinite effect
     * @param level Level of Effect [Some effects not affected by level]
     */
    void applyEffect(IPlayer player, int id, int duration, byte level);

    void applyEffect(IPlayer player, ICustomEffect effect, int duration, byte level);

    /**
     * @param player Player
     * @param id ID of Status Effect
     */
    void removeEffect(IPlayer player, int id);

    void removeEffect(IPlayer player, ICustomEffect effect);

    void clearEffects(IPlayer player);

    ICustomEffect saveEffect(ICustomEffect customEffect);
}
