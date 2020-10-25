package com.example.kitapp.widget

import android.app.Application
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.widget.RemoteViews
import androidx.lifecycle.ViewModelProvider
import com.example.kitapp.R
import com.example.kitapp.database.ScheduleDatabase
import com.example.kitapp.database.ScheduleDatabaseDao
import com.example.kitapp.database.ScheduleItem
import com.example.kitapp.startingpage.StartFragment
import com.example.kitapp.startingpage.StartViewModel
import com.example.kitapp.startingpage.StartViewModelFactory
import java.time.DayOfWeek
import java.util.*

/**
 * Implementation of App Widget functionality.
 */
class ScheduleWidget : AppWidgetProvider() {

    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
//        val fragment = StartFragment(false)
//        val daysList = fragment.startViewModel.days.value
        // There may be multiple widgets active, so update all of them
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created
    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

internal fun updateAppWidget(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetId: Int,
) {

    var chth = "Ч/З"
    when(Calendar.getInstance().get(Calendar.DAY_OF_WEEK_IN_MONTH)){
        1 -> chth = "Знаменник"
        2 -> chth = "Чисельник"
        3 -> chth ="Знаменник"
        4 -> chth = "Чисельник"
        5 -> chth = "Знаменник"
        else -> "ітвоітвло"
    }

    var dayOfWeek = "День тижня"
    when(Calendar.getInstance().get(Calendar.DAY_OF_WEEK)){
        1 -> dayOfWeek = "Неділя"
        2 -> dayOfWeek = "Понеділок"
        3 -> dayOfWeek = "Вівторок"
        4 -> dayOfWeek = "Середа"
        5 -> dayOfWeek = "Четвер"
        6 -> dayOfWeek = "П'ятниця"
        7 -> dayOfWeek = "Субота"
    }


    // Construct the RemoteViews object
    val views = RemoteViews(context.packageName, R.layout.schedule_widget)
    views.setTextViewText(R.id.name_of_day, dayOfWeek + " / " + chth)
    if (dayOfWeek == "Неділя"){
        views.setTextViewText(R.id.name_of_day, dayOfWeek + " / Вихідний")
        views.setTextViewText(R.id.first_lessonw,"-")
        views.setTextViewText(R.id.second_lesson,"-")
        views.setTextViewText(R.id.third_lesson,"-")
        views.setTextViewText(R.id.fourth_lesson,"-")
        views.setTextViewText(R.id.fifth_lesson,"-")
    }

    if (dayOfWeek == "Понеділок" && chth == "Чисельник"){
        views.setTextViewText(R.id.first_lessonw,"ТІМС 2309 лек.")
        views.setTextViewText(R.id.second_lesson,"ТІМС 2309 пр.")
        views.setTextViewText(R.id.third_lesson,"Англійська 2208 пр.")
        views.setTextViewText(R.id.fourth_lesson,"-")
        views.setTextViewText(R.id.fifth_lesson,"-")
    }

    // Instruct the widget manager to update the widget
    appWidgetManager.updateAppWidget(appWidgetId, views)
}