package com.sun.training.ut

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.sun.training.ut.data.Constant
import com.sun.training.ut.ui.exercise_four.ExerciseFourViewModel
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class ExerciseFourTest {
    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    lateinit var viewModel: ExerciseFourViewModel

    @Before
    @Throws(Exception::class)
    fun setUp() {
        viewModel = ExerciseFourViewModel()
    }

    @Test
    fun calculateColor_holidays_saturday(){
        viewModel.onDateChanged(9,3)
        viewModel.calculateColor()
        Assert.assertEquals(Constant.Color.RED.toString(), viewModel.colorLiveData.value)
    }

    @Test
    fun calculateColor_holidays_sunday(){
        viewModel.onDateChanged(9,4)
        viewModel.calculateColor()
        Assert.assertEquals(Constant.Color.RED.toString(), viewModel.colorLiveData.value)
    }

    @Test
    fun calculateColor_holidays_normalDay(){
        viewModel.onDateChanged(3,30)
        viewModel.calculateColor()
        Assert.assertEquals(Constant.Color.RED.toString(), viewModel.colorLiveData.value)
    }

    @Test
    fun calculateColor_saturday(){
        viewModel.onDateChanged(11,19)
        viewModel.calculateColor()
        Assert.assertEquals(Constant.Color.BLUE.toString(), viewModel.colorLiveData.value)
    }

    @Test
    fun calculateColor_sunday(){
        viewModel.onDateChanged(11,20)
        viewModel.calculateColor()
        Assert.assertEquals(Constant.Color.RED.toString(), viewModel.colorLiveData.value)
    }

    @Test
    fun calculateColor_normalDay(){
        viewModel.onDateChanged(11,3)
        viewModel.calculateColor()
        Assert.assertEquals(Constant.Color.BLACK.toString(), viewModel.colorLiveData.value)
    }
}