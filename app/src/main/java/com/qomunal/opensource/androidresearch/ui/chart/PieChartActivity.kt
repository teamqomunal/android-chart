package com.qomunal.opensource.androidresearch.ui.chart

import android.graphics.Color
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.listener.OnChartValueSelectedListener
import com.github.mikephil.charting.utils.MPPointF
import com.qomunal.opensource.androidresearch.common.base.BaseActivity
import com.qomunal.opensource.androidresearch.common.ext.getTemplateColorChart
import com.qomunal.opensource.androidresearch.databinding.ActivityPieChartBinding
import timber.log.Timber

/**
 * Created by faisalamircs on 30/09/2025
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 */


class PieChartActivity : BaseActivity<ActivityPieChartBinding>() {

    override fun setupViewBinding(): ActivityPieChartBinding {
        return ActivityPieChartBinding.inflate(layoutInflater)
    }


    override fun initUI() {
        title = "PieChartActivity"
        setupPieChart()
        setupPieChartData(4, 5.toFloat())
    }

    override fun initObserver() {}

    private fun setupPieChart() {
        binding.chart.apply {

            setUsePercentValues(true)
            description.isEnabled = false
            isDrawHoleEnabled = false
            setDrawCenterText(false)

            setRotationAngle(0f)
            // enable rotation of the chart by touch
            isRotationEnabled = true
            isHighlightPerTapEnabled = true

            // add a selection listener
            setOnChartValueSelectedListener(object : OnChartValueSelectedListener {
                override fun onValueSelected(
                    e: Entry?,
                    h: Highlight,
                ) {
                    if (e == null) return
                    Timber.tag("VAL SELECTED").i(("Value: " + e.y + ", index: " + h.x + ", DataSet index: " + h.dataSetIndex))
                }

                override fun onNothingSelected() {
                    Timber.tag("PieChart").i("nothing selected")
                }
            })

            animateY(1400, Easing.EaseInOutQuad)

            // spin(2000, 0, 360);
            legend.apply {
                verticalAlignment = Legend.LegendVerticalAlignment.BOTTOM
                horizontalAlignment = Legend.LegendHorizontalAlignment.LEFT
                orientation = Legend.LegendOrientation.HORIZONTAL
                setDrawInside(true)
                xEntrySpace = 7f
                yEntrySpace = 0f
                yOffset = 0f
            }

            // entry label styling
            setEntryLabelColor(Color.WHITE)
            setEntryLabelTextSize(12f)
        }
    }

    private fun setupPieChartData(count: Int, range: Float) {
        val entries = ArrayList<PieEntry?>()
        for (i in 0..<count) {
            entries.add(
                PieEntry(
                    ((Math.random() * range) + range / 5).toFloat(),
                    parties[i % parties.size],
                )
            )
        }

        val dataSet = PieDataSet(entries, "Election Results").apply {
            setDrawIcons(false)
            setSliceSpace(0f)
            setIconsOffset(MPPointF(0f, 40f))
            selectionShift = 5f
            colors = getTemplateColorChart()
        }

        val data = PieData(dataSet).apply {
            setValueFormatter(PercentFormatter())
            setValueTextSize(11f)
            setValueTextColor(Color.WHITE)
        }

        binding.chart.setData(data)
        binding.chart.highlightValues(null)
        binding.chart.invalidate()
    }

}