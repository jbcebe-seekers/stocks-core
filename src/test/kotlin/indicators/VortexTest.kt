package org.cerion.stocks.core.indicators

import org.cerion.stocks.core.TestBase
import org.junit.Test

class VortexTest : TestBase() {

    @Test
    fun eval() {
        val arr = Vortex(14).eval(priceList)
        assertEqual(1.0, arr.neg(0), "vortex (-) 0")
        assertEqual(1.0, arr.pos(0), "vortex (+) 0")
        assertEqual(0.83, arr.neg(1), "vortex (-) 0")
        assertEqual(0.17, arr.pos(1), "vortex (+) 0")
        assertEqual(1.08, arr.neg(27), "vortex (-) 2p-1")
        assertEqual(0.92, arr.pos(27), "vortex (+) 2p-1")
        assertEqual(1.10, arr.neg(28), "vortex (-) 2p")
        assertEqual(0.96, arr.pos(28), "vortex (+) 2p")
        assertEqual(0.98, arr.neg(arr.size - 1), "vortex (-) last")
        assertEqual(0.94, arr.pos(arr.size - 1), "vortex (+) last")
        assertEqual(-0.04, arr.diff(arr.size - 1), "vortex diff last")
    }
}