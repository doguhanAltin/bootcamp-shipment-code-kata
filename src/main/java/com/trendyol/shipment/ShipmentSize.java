package com.trendyol.shipment;

import java.util.List;

public enum ShipmentSize {

    SMALL,
    MEDIUM,
    LARGE,
    X_LARGE;
    private static final ShipmentSize[] values = ShipmentSize.values();
    public ShipmentSize nextSize() {
        int ordinal = this.ordinal();
        if (ordinal < values.length - 1) {
            return values[ordinal + 1];
        } else {
            return this;
        }
    }

}
