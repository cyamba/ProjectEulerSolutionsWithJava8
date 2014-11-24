package com.yambacode.solutions.euler2

import groovy.transform.TailRecursive

/**
 * Created by christopher.yamba on 24/11/14.
 */
class GroovyFibbo {


    @TailRecursive
    static def fibbo(def a = 1, def b = 1, def max) {
        if (a + b > max) {
            return b
        }
        return fibbo(b, a + b, max)
    }

}
