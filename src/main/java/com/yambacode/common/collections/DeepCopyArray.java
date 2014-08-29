package com.yambacode.common.collections;

/**
 * Created by cbyamba on 2014-03-12.
 */
public interface DeepCopyArray<T extends DeepCopiable> {
    T[] deepCopyArray(int length);
}
