package com.qomunal.opensource.androidresearch.ui.chart

import android.graphics.Color
import android.os.Bundle
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.github.mikephil.charting.listener.OnChartValueSelectedListener
import com.qomunal.opensource.androidresearch.R
import com.qomunal.opensource.androidresearch.common.base.BaseActivity
import com.qomunal.opensource.androidresearch.common.ext.initLineDataSet
import com.qomunal.opensource.androidresearch.databinding.ActivityLineChartBinding
import timber.log.Timber

/**
 * Created by faisalamircs on 30/09/2025
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 */


class LineChartActivity : BaseActivity<ActivityLineChartBinding>() {

    override fun setupViewBinding(): ActivityLineChartBinding {
        return ActivityLineChartBinding.inflate(layoutInflater)
    }

    override fun initObserver() {
    }

    override fun initUI() {
        title = "LineChartActivity1Custom"
        setupLineChart()
        setupLineChartData(10, 180f)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private fun setupLineChart() {
        binding.chart.apply {

            setBackgroundColor(Color.WHITE)
            setTouchEnabled(true)
            setDrawGridBackground(false)
            description.isEnabled = false
            axisRight.isEnabled = false

            // set listeners
            setOnChartValueSelectedListener(object : OnChartValueSelectedListener {
                override fun onValueSelected(e: Entry, h: Highlight?) {
                    Timber.tag("Entry selected").i(e.toString())
                    Timber.tag("LOW HIGH")
                        .i("low: ${getLowestVisibleX()}, high: ${getHighestVisibleX()}")
                    Timber.tag("MIN MAX")
                        .i("xMin: $xChartMin, xMax: $xChartMax, yMin: $yChartMin, yMax: $yChartMax")
                }

                override fun onNothingSelected() {
                    Timber.tag("Nothing selected").i("Nothing selected.")
                }
            })


            // create marker to display box when values are selected
            val mv = MyMarkerView(this@LineChartActivity, R.layout.custom_marker_view)

            // Set the marker to the chart
            mv.chartView = this
            marker = mv

            setDragEnabled(true)
            setScaleEnabled(true)
            setPinchZoom(true)

            val xAxis = xAxis
            xAxis.enableGridDashedLine(10f, 10f, 0f)
            xAxis.position = XAxis.XAxisPosition.BOTTOM
            xAxis.granularity = 1f
            xAxis.valueFormatter = IndexAxisValueFormatter(
                listOf(
                    "Jan",
                    "Feb",
                    "Mar",
                    "Apr",
                    "May",
                    "Jun",
                    "Jul",
                    "Aug",
                    "Sep",
                    "Oct",
                    "Nov",
                    "Dec"
                )
            )

            val yAxis = axisLeft
            // disable dual axis (only use LEFT axis)
            axisRight.isEnabled = false

            // horizontal grid lines
            yAxis.enableGridDashedLine(10f, 10f, 0f)

            // axis range
            yAxis.setAxisMinimum(0f)

            // draw limit lines behind data instead of on top
            yAxis.setDrawLimitLinesBehindData(true)
            xAxis.setDrawLimitLinesBehindData(true)

            legend.isEnabled = false

            // draw points over time
            animateX(1500)
        }
    }

    private fun setupLineChartData(count: Int, range: Float) {
        val values1 = ArrayList<Entry?>()
        val values2 = ArrayList<Entry?>()
        val values3 = ArrayList<Entry?>()

        for (i in 0..<count) {
            val `val` = (Math.random() * range).toFloat() - 30
            values1.add(Entry(i.toFloat(), `val`))
        }

        for (i in 0..<count) {
            val `val` = (Math.random() * range).toFloat() - 30
            values2.add(Entry(i.toFloat(), `val`))
        }

        for (i in 0..<count) {
            val `val` = (Math.random() * range).toFloat() - 30
            values3.add(Entry(i.toFloat(), `val`))
        }

        val set1 = initLineDataSet("DataSet 1", Color.GREEN, values1)
        val set2 = initLineDataSet("DataSet 2", Color.YELLOW, values2)
        val set3 = initLineDataSet("DataSet 3", Color.BLACK, values3)

        val dataSets = ArrayList<ILineDataSet?>()
        dataSets.add(set1) // add the data sets
        dataSets.add(set2) // add the data sets
        dataSets.add(set3) // add the data sets

        // create a data object with the data sets
        val data = LineData(dataSets)

        // set data
        binding.chart.setData(data)
    }




}