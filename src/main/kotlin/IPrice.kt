package org.cerion.stocks.core

import java.util.*

interface IPrice {
    val date: Date
    val open: Float
    val close: Float
    val high: Float
    val low: Float
    val volume: Float
}