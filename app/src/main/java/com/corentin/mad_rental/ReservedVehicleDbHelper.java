package com.corentin.mad_rental;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ReservedVehicleDbHelper extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "ReservedVehicles.db";
    private static final String SQL_CREATE_TABLE =
            "CREATE TABLE " + ReservedVehicleContract.ReservedVehiclesEntry.TABLE_NAME + " (" +
                              ReservedVehicleContract.ReservedVehiclesEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                              ReservedVehicleContract.ReservedVehiclesEntry.COLUMN_NAME + " TEXT," +
                              ReservedVehicleContract.ReservedVehiclesEntry.COLUMN_PRICE + " TEXT," +
                              ReservedVehicleContract.ReservedVehiclesEntry.COLUMN_IMAGE + " TEXT," +
                              ReservedVehicleContract.ReservedVehiclesEntry.COLUMN_BEGIN_DATE + " TEXT," +
                              ReservedVehicleContract.ReservedVehiclesEntry.COLUMN_END_DATE + " TEXT)";

    private static final String SQL_DELETE_TABLE =
            "DROP TABLE IF EXISTS " + ReservedVehicleContract.ReservedVehiclesEntry.TABLE_NAME;

    public ReservedVehicleDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_TABLE);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
