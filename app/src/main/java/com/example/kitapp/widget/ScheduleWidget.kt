package com.example.kitapp.widget

import android.app.Application
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.util.Log
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

    override fun onReceive(context: Context?, intent: Intent?) {
        super.onReceive(context, intent)
        if (Intent.ACTION_DATE_CHANGED.equals(intent!!.getAction())) {

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

    var chth : String = "_"
    val wichDay = Calendar.getInstance(Locale.GERMANY).get(Calendar.WEEK_OF_MONTH)
    val month = Calendar.getInstance().get(Calendar.MONTH)
    when(month){
        9 -> when(wichDay){
            1 -> chth = "Чисельник"
            2 -> chth = "Знаменник"
            3 -> chth = "Чисельник"
            4 -> chth = "Знаменник"
            5 -> chth = "Чисельник"
        }
        10 -> when(wichDay){
            0 -> chth = "Чисельник"
            1 -> chth = "Знаменник"
            2 -> chth = "Чисельник"
            3 -> chth = "Знаменник"
            4 -> chth = "Чисельник"
            5 -> chth = "Знаменник"
        }
        11-> when(wichDay){
            1 -> chth = "Знаменник"
            2 -> chth = "Чисельник"
            3 -> chth = "Знаменник"
            4 -> chth = "Чисельник"
            5 -> chth = "Знаменник"
        }
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

    when(chth){
        "Чисельник" -> {
            if (dayOfWeek == "Понеділок") {
                views.setTextViewText(R.id.first_lessonw, "ТІМС 2309 лек.")
                views.setTextViewText(R.id.second_lesson, "ТІМС 2309 пр.")
                views.setTextViewText(R.id.third_lesson, "Англійська 2208 пр.")
                views.setTextViewText(R.id.fourth_lesson, "-")
                views.setTextViewText(R.id.fifth_lesson, "-")
            } else if (dayOfWeek == "Вівторок") {
                views.setTextViewText(R.id.first_lessonw, "-")
                views.setTextViewText(R.id.second_lesson, "Алгоритми 2209 пр.")
                views.setTextViewText(R.id.third_lesson, "Програмування 2209 пр.")
                views.setTextViewText(R.id.fourth_lesson, "Програмування 2113 лек.")
                views.setTextViewText(R.id.fifth_lesson, "-")
            } else if (dayOfWeek == "Середа") {
                views.setTextViewText(R.id.first_lessonw, "-")
                views.setTextViewText(R.id.second_lesson, "-")
                views.setTextViewText(R.id.third_lesson, "Електорадіо. 2309 лек.")
                views.setTextViewText(R.id.fourth_lesson, "Електорадіо. 2309 лек.")
                views.setTextViewText(R.id.fifth_lesson, "Фізкультура")
            } else if (dayOfWeek == "Четвер") {
                views.setTextViewText(R.id.first_lessonw, "-")
                views.setTextViewText(R.id.second_lesson, "-")
                views.setTextViewText(R.id.third_lesson, "Мат. Аналіз 2308 лек.")
                views.setTextViewText(R.id.fourth_lesson, "ОБД 2112 лек.")
                views.setTextViewText(R.id.fifth_lesson, "-")
            } else if (dayOfWeek == "П'ятниця") {
                views.setTextViewText(R.id.first_lessonw, "ТІМС 2309 лек.")
                views.setTextViewText(R.id.second_lesson, "ТІМС 2309 пр.")
                views.setTextViewText(R.id.third_lesson, "Англійська 2208 пр.")
                views.setTextViewText(R.id.fourth_lesson, "-")
                views.setTextViewText(R.id.fifth_lesson, "-")
            } else if (dayOfWeek == "Субота") {
                views.setTextViewText(R.id.first_lessonw, "-")
                views.setTextViewText(R.id.second_lesson, "Алгоритми 2209 пр.")
                views.setTextViewText(R.id.third_lesson, "Програмування 2209 пр.")
                views.setTextViewText(R.id.fourth_lesson, "Програмування 2113 лек.")
                views.setTextViewText(R.id.fifth_lesson, "-")
            }
        }
        "Знаменник" ->{
            if (dayOfWeek == "Понеділок") {
                views.setTextViewText(R.id.first_lessonw, "ТІМС 2309 лек.")
                views.setTextViewText(R.id.second_lesson, "Мат. Аналіз 2310 пр.")
                views.setTextViewText(R.id.third_lesson, "Англійська 2208 пр.")
                views.setTextViewText(R.id.fourth_lesson, "-")
                views.setTextViewText(R.id.fifth_lesson, "-")
            } else if (dayOfWeek == "Вівторок") {
                views.setTextViewText(R.id.first_lessonw, "-")
                views.setTextViewText(R.id.second_lesson, "Алгоритми 2209 пр.")
                views.setTextViewText(R.id.third_lesson, "ОБД 2113 пр.")
                views.setTextViewText(R.id.fourth_lesson, "Системне ПЗ 2113 лек.")
                views.setTextViewText(R.id.fifth_lesson, "Системне ПЗ 2113 пр.")
            } else if (dayOfWeek == "Середа") {
                views.setTextViewText(R.id.first_lessonw, "-")
                views.setTextViewText(R.id.second_lesson, "-")
                views.setTextViewText(R.id.third_lesson, "Електорадіо. 2309 лек.")
                views.setTextViewText(R.id.fourth_lesson, "Електорадіо. 2311 пр.")
                views.setTextViewText(R.id.fifth_lesson, "Фізкультура")
            } else if (dayOfWeek == "Четвер") {
                views.setTextViewText(R.id.first_lessonw, "-")
                views.setTextViewText(R.id.second_lesson, "-")
                views.setTextViewText(R.id.third_lesson, "Мат. Аналіз 2308 лек.")
                views.setTextViewText(R.id.fourth_lesson, "Алгоритми 2112 лек.")
                views.setTextViewText(R.id.fifth_lesson, "-")
            } else if (dayOfWeek == "П'ятниця") {
                views.setTextViewText(R.id.first_lessonw, "-")
                views.setTextViewText(R.id.second_lesson, "-")
                views.setTextViewText(R.id.third_lesson, "Електорадіо. 2309 лек.")
                views.setTextViewText(R.id.fourth_lesson, "Електорадіо. 2311 пр.")
                views.setTextViewText(R.id.fifth_lesson, "Фізкультура")
            } else if (dayOfWeek == "Субота") {
                views.setTextViewText(R.id.first_lessonw, "-")
                views.setTextViewText(R.id.second_lesson, "-")
                views.setTextViewText(R.id.third_lesson, "Мат. Аналіз 2308 лек.")
                views.setTextViewText(R.id.fourth_lesson, "Алгоритми 2112 лек.")
                views.setTextViewText(R.id.fifth_lesson, "-")
            }
        }
    }



    if (dayOfWeek == "Неділя"){
        views.setTextViewText(R.id.name_of_day, dayOfWeek + " / Вихідний")
        views.setTextViewText(R.id.first_lessonw,"-")
        views.setTextViewText(R.id.second_lesson,"-")
        views.setTextViewText(R.id.third_lesson,"-")
        views.setTextViewText(R.id.fourth_lesson,"-")
        views.setTextViewText(R.id.fifth_lesson,"-")
    }


    // Instruct the widget manager to update the widget
    appWidgetManager.updateAppWidget(appWidgetId, views)
}