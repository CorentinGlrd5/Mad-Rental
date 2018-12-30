package com.corentin.mad_rental;

import android.provider.BaseColumns;

public class ReservedVehicleContract {
    private ReservedVehicleContract() {}

    public static class ReservedVehiclesEntry implements BaseColumns {
        public static final String TABLE_NAME = "ReservedVehicles";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_PRICE = "price";
        public static final String COLUMN_IMAGE = "image";
        public static final String COLUMN_BEGIN_DATE = "beginDate";
        public static final String COLUMN_END_DATE = "endDate";
    }
}
