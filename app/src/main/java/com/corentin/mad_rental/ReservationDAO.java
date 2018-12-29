package com.corentin.mad_rental;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import java.util.ArrayList;
import java.util.List;

public class ReservationDAO {
    public static List<ReservedVehicle> getReservecVehicles(Context context){

        ReservedVehicleDbHelper dbHelper = new ReservedVehicleDbHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] projection = {
                ReservedVehicleContract.ReservedVehiclesEntry._ID,
                ReservedVehicleContract.ReservedVehiclesEntry.COLUMN_NAME,
                ReservedVehicleContract.ReservedVehiclesEntry.COLUMN_PRICE,
                ReservedVehicleContract.ReservedVehiclesEntry.COLUMN_IMAGE,
                ReservedVehicleContract.ReservedVehiclesEntry.COLUMN_BEGIN_DATE,
                ReservedVehicleContract.ReservedVehiclesEntry.COLUMN_END_DATE
        };

        String sortOrder = ReservedVehicleContract.ReservedVehiclesEntry._ID + " ASC";

        Cursor cursor = db.query(
                ReservedVehicleContract.ReservedVehiclesEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                sortOrder
        );

        List<ReservedVehicle> reservedVehicles = new ArrayList<ReservedVehicle>();
        while (cursor.moveToNext())
        {
            reservedVehicles.add(
                    new ReservedVehicle(
                            cursor.getInt(cursor.getColumnIndex(ReservedVehicleContract.ReservedVehiclesEntry._ID)),
                            cursor.getString(cursor.getColumnIndex(ReservedVehicleContract.ReservedVehiclesEntry.COLUMN_NAME)),
                            cursor.getString(cursor.getColumnIndex(ReservedVehicleContract.ReservedVehiclesEntry.COLUMN_IMAGE)),
                            cursor.getInt(cursor.getColumnIndex(ReservedVehicleContract.ReservedVehiclesEntry.COLUMN_PRICE)),
                            cursor.getString(cursor.getColumnIndex(ReservedVehicleContract.ReservedVehiclesEntry.COLUMN_BEGIN_DATE)),
                            cursor.getString(cursor.getColumnIndex(ReservedVehicleContract.ReservedVehiclesEntry.COLUMN_END_DATE))
                            ));
        }
        cursor.close();
        db.close();
        dbHelper.close();
        return reservedVehicles;
    }
}

