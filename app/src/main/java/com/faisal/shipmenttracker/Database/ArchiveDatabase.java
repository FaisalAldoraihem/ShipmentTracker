package com.faisal.shipmenttracker.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {ShipmentEntry.class}, version = 1, exportSchema = false)

@TypeConverters({ShipmentConverters.class})
public abstract class ArchiveDatabase extends RoomDatabase {

    private static final Object LOCK = new Object();
    private static final String DATABASE_NAME = "Shipment_Archive";
    private static ArchiveDatabase sInstance;

    public static ArchiveDatabase getInstance(Context context) {
        if (sInstance == null) {
            synchronized (LOCK) {
                sInstance = Room.databaseBuilder(context.getApplicationContext(),
                        ArchiveDatabase.class, ArchiveDatabase.DATABASE_NAME)
                        .build();
            }
        }
        return sInstance;
    }

    public abstract ShipmentDao shipmentDao();

}
