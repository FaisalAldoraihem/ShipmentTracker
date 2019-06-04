package com.faisal.shipmenttracker;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import com.faisal.shipmenttracker.POJO.Tracking;
import com.faisal.shipmenttracker.UI.MainActivity;
import com.faisal.shipmenttracker.Utils.ShipmentsUtils;

/**
 * Implementation of App Widget functionality.
 */
public class ShipmentWidget extends AppWidgetProvider {

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId, Tracking entry) {
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.shipment_widget);

        Intent intent = new Intent(context, ShipmentsUtils.class);
        intent.setAction(ShipmentsUtils.ACTION_GET_TRACKING);

        PendingIntent pendingIntent = PendingIntent.getService(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);


        Intent mainIntent = new Intent(context, MainActivity.class);

        PendingIntent pendingIntentMain = PendingIntent.getActivity(context,0,mainIntent,0);

        views.setOnClickPendingIntent(R.id.update,pendingIntent);
        views.setOnClickPendingIntent(R.id.Shipment_title,pendingIntentMain);

        if(entry != null){
            int size = entry.getCheckpoints().size();
            String title = entry.getTitle();
            String update = entry.getCheckpoints().get(size-1).getMessage();
            views.setTextViewText(R.id.Shipment_title,title);
            views.setTextViewText(R.id.update,update);
        }
        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        ShipmentsUtils.startActionGetTracking(context);
    }

    public static void updateTrackingWidgets(Context context, AppWidgetManager
            appWidgetManager, int[] appWidgetIds,Tracking entry) {

        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId,entry);
        }

    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

