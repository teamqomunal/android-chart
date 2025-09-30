package com.qomunal.opensource.androidresearch.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.qomunal.opensource.androidresearch.common.base.BaseActivity
import com.qomunal.opensource.androidresearch.common.ext.showToast
import com.qomunal.opensource.androidresearch.databinding.ActivityMainBinding
import com.qomunal.opensource.androidresearch.ui.chart.LineChartActivity
import com.qomunal.opensource.androidresearch.ui.chart.PieChartActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val viewModel: MainViewModel by viewModels()
    private val router: MainRouter by lazy {
        MainRouter(this)
    }

    override fun setupViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun initUI() {
        binding.apply {
            btnPieChart.setOnClickListener {
                startActivity(Intent(this@MainActivity, PieChartActivity::class.java))
            }

            btnLineChart.setOnClickListener {
                startActivity(Intent(this@MainActivity, LineChartActivity::class.java))
            }
        }
    }

    override fun initObserver() {
        viewModel.apply {

        }
    }

}