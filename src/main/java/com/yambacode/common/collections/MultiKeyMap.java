package com.yambacode.common.collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by cbyamba on 2014-04-08.
 */
public class MultiKeyMap<K, V> implements Map<Set<K>, V> {

    private Map<Set<K>, V> map;

    private MultiKeyMap(Map<Set<K>, V> map) {
        this.map = map;
    }

    public static <K, V> MultiKeyMap<K, V> of(Map<Set<K>, V> map) {
        return new MultiKeyMap<>(map);
    }

    public static <K, V> MultiKeyMap<K, V> of() {
        return new MultiKeyMap<>(new HashMap<>());
    }


    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return map.containsValue(value);
    }

    @Override
    public V get(Object key) {
        return map.get(key);
    }

    @Override
    public V put(Set<K> key, V value) {
        return map.put(key, value);
    }

    @Override
    public V remove(Object key) {
        return map.remove(key);
    }

    @Override
    public void putAll(Map<? extends Set<K>, ? extends V> m) {
        map.putAll(m);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Set<Set<K>> keySet() {
        return map.keySet();
    }

    @Override
    public Collection<V> values() {
        return map.values();
    }

    @Override
    public Set<Entry<Set<K>, V>> entrySet() {
        return map.entrySet();
    }

    @Override
    public boolean equals(Object o) {
        return map.equals(o);
    }

    @Override
    public int hashCode() {
        return map.hashCode();
    }
}
