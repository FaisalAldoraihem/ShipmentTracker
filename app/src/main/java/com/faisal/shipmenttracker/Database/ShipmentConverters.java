package com.faisal.shipmenttracker.Database;

import androidx.room.TypeConverter;

import com.faisal.shipmenttracker.POJO.Checkpoint;
import com.faisal.shipmenttracker.POJO.Tracking;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class ShipmentConverters {
    @TypeConverter
    public static Tracking trackingFromString(String value){
        Type trackingtype = new TypeToken<Tracking>(){}.getType();

        return new Gson().fromJson(value,trackingtype);
    }

    @TypeConverter
    public static String fromTracking(Tracking tracking){
        Gson gson = new Gson();

        return gson.toJson(tracking);
    }

    @TypeConverter
    public static List<Checkpoint> checkpointFromString(String value){
        Type trackingtype = new TypeToken<List<Checkpoint>>(){}.getType();

        return new Gson().fromJson(value,trackingtype);
    }

    @TypeConverter
    public static String checkpointFromCheckpoint(List<Checkpoint> tracking){
        Gson gson = new Gson();

        return  gson.toJson(tracking);
    }
}
