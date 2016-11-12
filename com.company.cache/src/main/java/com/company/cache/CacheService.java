package com.company.cache;

/**
 * Service to interact with the cache
 */
public interface CacheService {

    /**
     * Puts a value to the cache
     *
     * @param id      the id of the value
     * @param toCache the value to cache
     */
    public void putCache(String id, String toCache);

    /**
     * Gets the value from the cache based on the id
     *
     * @param id the id of the value
     * @return the value
     */
    public String getCache(String id);

}
