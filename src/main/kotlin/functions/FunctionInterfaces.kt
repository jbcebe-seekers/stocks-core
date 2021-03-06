package org.cerion.stocks.core.functions

import org.cerion.stocks.core.PriceList
import org.cerion.stocks.core.arrays.FloatArray
import org.cerion.stocks.core.arrays.ValueArray
import org.cerion.stocks.core.functions.types.IFunctionEnum
import org.cerion.stocks.core.functions.types.Indicator


interface IFunction {
    val name: String
    val resultType: Class<out ValueArray>
    val id: IFunctionEnum
    val params: List<Number>
    fun eval(list: PriceList): ValueArray
    fun setParams(vararg params: Number)
}

interface IIndicator : IFunction {
    override val id: Indicator
}

interface IOverlay : IFunction

interface IPriceOverlay : IOverlay

interface ISimpleOverlay : IOverlay {
    fun eval(arr: FloatArray): ValueArray
}
