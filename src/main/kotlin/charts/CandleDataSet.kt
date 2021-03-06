package org.cerion.stocks.core.charts

import org.cerion.stocks.core.PriceList

class CandleDataSet(private val mList: PriceList, override val label: String, override val color: Int) : IDataSet {

    override val size: Int = mList.size - 1
    override val lineType: LineType = LineType.CANDLE

    fun getHigh(pos: Int): Float = mList.high[pos + 1]
    fun getLow(pos: Int): Float = mList.low[pos + 1]
    fun getOpen(pos: Int): Float = mList.open[pos + 1]
    fun getClose(pos: Int): Float = mList.close[pos + 1]
}
