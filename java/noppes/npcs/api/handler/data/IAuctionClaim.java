package noppes.npcs.api.handler.data;

import noppes.npcs.api.item.IItemStack;

/**
 * Represents an auction claim (item or currency to be collected).
 */
public interface IAuctionClaim {

    /**
     * Get the unique claim ID.
     */
    String getId();

    /**
     * Get the player's UUID who can claim this.
     */
    String getPlayerUUID();

    /**
     * Get the player's display name.
     */
    String getPlayerName();

    /**
     * Get the related listing ID.
     */
    String getListingId();

    /**
     * Get the claim type.
     * @return 0 = Item, 1 = Currency (sale proceeds), 2 = Refund (outbid)
     */
    int getType();

    /**
     * Check if this is an item claim.
     */
    boolean isItemClaim();

    /**
     * Check if this is a currency claim (sale proceeds or refund).
     */
    boolean isCurrencyClaim();

    /**
     * Check if this is a refund claim (outbid).
     */
    boolean isRefundClaim();

    /**
     * Get the item to claim (for item claims only).
     * @return The item, or null for currency claims
     */
    IItemStack getItem();

    /**
     * Get the item display name (for currency/refund claims tooltip).
     */
    String getItemName();

    /**
     * Get the currency amount (for currency/refund claims).
     */
    long getCurrency();

    /**
     * Get the other player's name involved.
     * For currency claims: the buyer's name.
     * For refund claims: the player who outbid.
     */
    String getOtherPlayerName();

    /**
     * Get when this claim was created (Unix timestamp in ms).
     */
    long getCreatedTime();

    /**
     * Check if this claim has been claimed.
     */
    boolean isClaimed();

    /**
     * Check if this is a returned item (expired/cancelled listing) vs won item.
     * Only relevant for item claims.
     */
    boolean isReturnedItem();

    /**
     * Get days until this claim expires.
     */
    long getDaysUntilExpiration();

    /**
     * Check if this claim has expired.
     */
    boolean isExpired();
}
