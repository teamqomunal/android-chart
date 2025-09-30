package com.qomunal.opensource.androidresearch.common.ext

import android.graphics.DashPathEffect
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.utils.ColorTemplate

/**
 * Created by faisalamircs on 30/09/2025
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 */


fun getTemplateColorChart() : ArrayList<Int?> {

    // add a lot of colors
    val colors = ArrayList<Int?>()

    for (c in ColorTemplate.VORDIPLOM_COLORS) colors.add(c)

    for (c in ColorTemplate.JOYFUL_COLORS) colors.add(c)

    for (c in ColorTemplate.COLORFUL_COLORS) colors.add(c)

    for (c in ColorTemplate.LIBERTY_COLORS) colors.add(c)

    for (c in ColorTemplate.PASTEL_COLORS) colors.add(c)

    colors.add(ColorTemplate.getHoloBlue())

    return colors
}


fun initLineDataSet(label: String, color: Int, values: ArrayList<Entry?>): LineDataSet {
    // create a dataset and give it a type
    return LineDataSet(values, label).apply {
        setDrawIcons(false)

        // draw dashed line
        enableDashedLine(10f, 5f, 0f)

        // black lines and points
        setColor(color)
        setCircleColor(color)

        // line thickness and point size
        setLineWidth(3f)
        circleRadius = 4f

        // draw points as solid circles
        setDrawCircleHole(false)
        setDrawValues(false)
        setDrawFilled(false)

        // customize legend entry
        formLineWidth = 1f
        formLineDashEffect = DashPathEffect(floatArrayOf(10f, 5f), 0f)
        formSize = 15f

        // text size of values
        valueTextSize = 9f
        mode = LineDataSet.Mode.CUBIC_BEZIER

        // draw selection line as dashed
        enableDashedHighlightLine(10f, 5f, 0f)
    }

}