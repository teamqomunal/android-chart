package com.qomunal.opensource.androidresearch.common.ext

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