package com.rtukpe.fixtures.data.model

import java.util.*

class FixturesResponse {
    lateinit var timeFrameStart: String
    lateinit var timeFrameEnd: String
    @JvmField
    var count: Int = 0
    lateinit var fixtures: ArrayList<Fixture>
}
