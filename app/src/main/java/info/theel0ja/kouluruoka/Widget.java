package info.theel0ja.kouluruoka;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.widget.ImageView;
import android.widget.RemoteViews;

import com.squareup.picasso.Picasso;


/**
 * Implementation of App Widget functionality.
 * App Widget Configuration implemented in {@link WidgetConfigureActivity WidgetConfigureActivity}
 */
public class Widget extends AppWidgetProvider {


    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager, int appWidgetId) {
        //RemoteViews updateViews = new RemoteViews(context.getPackageName(), R.layout.widget);


        //String URL = "http://i0.wp.com/s-ssl.wordpress.com/mshots/v1/https%3A%2F%2Falpha.viikon-kouluruoka.theel0ja.info%2Fwidget%2Fturku-alakoulu.php%3Ffrom%3Dti%26to%3Dke%26time%3D1481406855?ssl=1&crop=0,0,30,60";


        //updateViews.setImageViewBitmap(imageView, IMG);

        //ImageView imageView = (ImageView) findViewById(R.id.imageView); //TODO <--

        //Picasso.with(context).load(URL).into(imageView);



        //CharSequence widgetText = WidgetConfigureActivity.loadTitlePref(context, appWidgetId);
        // Construct the RemoteViews object
        //RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget);
        //views.setTextViewText(R.id.appwidget_text, widgetText);

        // Instruct the widget manager to update the widget
        //appWidgetManager.updateAppWidget(appWidgetId, views);

    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        // When the user deletes the widget, delete the preference associated with it.
        for (int appWidgetId : appWidgetIds) {
            WidgetConfigureActivity.deleteTitlePref(context, appWidgetId);
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

