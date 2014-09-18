package com.yambacode.math;

import com.yambacode.common.pattern.Builder;

/**
 * Created by cbyamba on 2011-12-09
 */
public class ResultBuilder implements Builder<Result> {

    private Result result;

    private ResultBuilder(Result result) {
        this.result = result;
    }

    public static ResultBuilder create() {
        return new ResultBuilder(new Result());
    }

    public ResultBuilder count(int count) {
        result.setCount(count);
        return this;
    }

    public ResultBuilder first(int first) {
        result.setFirst(first);
        return this;
    }

    @Override
    public Result build() {
        return result;
    }
}
