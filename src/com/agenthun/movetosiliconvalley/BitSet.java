package com.agenthun.movetosiliconvalley;

/**
 * Created by agenthun on 15/10/14.
 */
public class BitSet {
    long[] bits;

    BitSet(int numBits) {
        int numLongs = numBits >>> 6;
        if ((numBits & 0x3f) != 0) {
            numLongs++;
        }
        bits = new long[numLongs];
    }

    private BitSet(long[] bits) {
        this.bits = bits;
    }

    boolean get(int index) {
        return (bits[index >>> 6] & 1L << (index & 0x3f)) != 0L;
    }

    void set(int index) {
        bits[index >>> 6] |= 1L << (index & 0x3f);
    }

    void clear(int index) {
        bits[index >>> 6] &= ~(1L << (index & 0x3f));
    }
}
