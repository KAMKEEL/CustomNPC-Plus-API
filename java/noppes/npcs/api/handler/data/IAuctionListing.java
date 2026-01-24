package noppes.npcs.api.handler.data;

import noppes.npcs.api.item.IItemStack;

/**
 * Represents an auction listing.
 */
public interface IAuctionListing {

    /**
     * Get the unique listing ID.
     */
    String getId();

    /**
     * Get the seller's UUID as a string.
     */
    String getSellerUUID();

    /**
     * Get the seller's display name.
     */
    String getSellerName();

    /**
     * Get the item being sold.
     */
    IItemStack getItem();

    /**
     * Get the starting price.
     */
    long getStartingPrice();

    /**
     * Get the buyout price (0 if no buyout).
     */
    long getBuyoutPrice();

    /**
     * Check if this listing has a buyout option.
     */
    boolean hasBuyout();

    /**
     * Get the current highest bid.
     */
    long getCurrentBid();

    /**
     * Get the high bidder's UUID as a string (null if no bids).
     */
    String getHighBidderUUID();

    /**
     * Get the high bidder's display name (null if no bids).
     */
    String getHighBidderName();

    /**
     * Check if there are any bids on this listing.
     */
    boolean hasBids();

    /**
     * Get the total number of bids placed.
     */
    int getBidCount();

    /**
     * Get when the listing was created (Unix timestamp in ms).
     */
    long getCreatedTime();

    /**
     * Get when the auction ends (Unix timestamp in ms).
     */
    long getEndTime();

    /**
     * Get the remaining time in milliseconds.
     */
    long getRemainingTime();

    /**
     * Check if the auction has expired.
     */
    boolean isExpired();

    /**
     * Check if the auction is still active (can be bid on).
     */
    boolean isActive();

    /**
     * Get the auction status.
     * @return 0 = Active, 1 = Ended, 2 = Cancelled, 3 = Claimed
     */
    int getStatus();

    /**
     * Get the minimum bid amount (current bid + increment).
     */
    long getMinimumBid();

    /**
     * Check if a player UUID is the seller.
     */
    boolean isSeller(String playerUUID);

    /**
     * Check if a player UUID is the current high bidder.
     */
    boolean isHighBidder(String playerUUID);

    /**
     * Get the remaining time formatted as a string (e.g., "2h 30m").
     */
    String getRemainingTimeFormatted();
}
