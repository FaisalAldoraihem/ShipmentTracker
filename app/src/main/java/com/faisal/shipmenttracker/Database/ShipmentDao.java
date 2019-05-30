package com.faisal.shipmenttracker.Database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ShipmentDao {

    @Query("SELECT * FROM  Shipment")
    LiveData<List<ShipmentEntry>> laodAllShipments();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertShipment(ShipmentEntry shipmentEntry);

    @Delete
    void deleteShipment(ShipmentEntry shipmentEntry);
}
