package com.seewhy.solutions.euler51;

import java.util.List;

/**
 * Created by cbyamba on 2014-02-20.
 */
public class PdrObject {

    private Integer originalNumber;

    private List<Integer> originalSet;


    public PdrObject(Integer originalNumber, List<Integer> originalSet) {
        this.originalNumber = originalNumber;
        this.originalSet = originalSet;
    }

    public Integer getOriginalNumber() {
        return originalNumber;
    }

    public List<Integer> getOriginalSet() {
        return originalSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PdrObject pdrObject = (PdrObject) o;

        if (!originalSet.equals(pdrObject.originalSet)) return false;
        if (!originalNumber.equals(pdrObject.originalNumber)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = originalNumber.hashCode();
        result = 31 * result + originalSet.hashCode();
        return result;
    }
}
