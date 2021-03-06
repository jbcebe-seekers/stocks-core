package org.cerion.stocks.core.indicators

import org.cerion.stocks.core.PriceList
import org.cerion.stocks.core.arrays.FloatArray
import org.cerion.stocks.core.arrays.MACDArray
import org.cerion.stocks.core.functions.types.Indicator

class PercentagePriceOscillator(p1: Int, p2: Int, signal: Int) : IndicatorBase(Indicator.PPO, p1, p2, signal) {

    constructor() : this(12, 26, 9)

    override val name: String = "Percentage Price Oscillator"

    override fun eval(list: PriceList): MACDArray {
        //Percentage version of MACD
        return getPercentMACD(list.close, getInt(0), getInt(1), getInt(2))
    }

    companion object {

        // Shared with PVO
        fun getPercentMACD(arr: FloatArray, p1: Int, p2: Int, signal: Int): MACDArray {
            val result = MACDArray(arr.size, signal)
            val ema1 = arr.ema(p1)
            val ema2 = arr.ema(p2)

            for (i in 0 until arr.size)
                result[i] = 100 * (ema1[i] - ema2[i]) / ema2[i]

            return result
        }
    }

}
