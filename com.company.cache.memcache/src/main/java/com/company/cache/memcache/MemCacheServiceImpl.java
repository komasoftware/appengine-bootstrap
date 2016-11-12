package com.company.cache.memcache;

import com.company.cache.CacheService;

import javax.cache.*;
import java.util.Collections;

/**
 * Implementation of the {@link CacheService} specific for
 * Google MemCache
 */
public class MemCacheServiceImpl implements CacheService {
    private Cache cache;

    /**
     * Constructs this object
     *
     * @throws CacheException
     */
    public MemCacheServiceImpl() throws CacheException {
        CacheFactory cacheFactory = CacheManager.getInstance().getCacheFactory();
        cache = cacheFactory.createCache(Collections.emptyMap());
    }

    @Override
    public void putCache(String key, String toCache) {
        cache.put(key, toCache);
    }

    @Override
    public String getCache(String key) {
        String value = null;
        CacheEntry cacheEntry = cache.getCacheEntry(key);
        if (cacheEntry != null)
            value = cacheEntry.getValue().toString();
        return value;
    }
}
