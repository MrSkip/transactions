package com.gl.transactioncalculator.constant;

import java.math.RoundingMode;

public final class CommonConstants {

    private CommonConstants() {
        throw new IllegalStateException();
    }

    // use the internal scale to be more precise
    public static final int INTERNAL_SCALE = 5;
    // apply this scale only to end calculations
    public static final int EXTERNAL_SCALE = 2;

    public static final RoundingMode DEFAULT_ROUNDING = RoundingMode.HALF_UP;

}
