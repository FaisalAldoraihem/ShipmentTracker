package com.faisal.shipmenttracker.Shipment;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class TrackingDeserializer implements JsonDeserializer<Tracking> {


    private ShipmentInfo parseShipmentInfo(JsonElement element) {
        if (element.isJsonObject()) {
            JsonObject obj = element.getAsJsonObject();
            return new Gson().fromJson(obj, ShipmentInfo.class);

        } else
            return null;
    }


    @Override
    public Tracking deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {

        ShipmentInfo info = parseShipmentInfo(json);
        return new Tracking(info);
    }
}

