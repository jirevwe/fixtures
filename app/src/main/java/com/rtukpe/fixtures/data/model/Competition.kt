package com.rtukpe.fixtures.data.model

import java.util.*

class Competition {
    @JvmField
    var id: Int = 0
    lateinit var caption: String
    lateinit var league: String
    lateinit var year: String
    @JvmField
    var currentMatchday: Int = 0
    @JvmField
    var numberOfMatchdays: Int = 0
    @JvmField
    var numberOfTeams: Int = 0
    @JvmField
    var numberOfGames: Int = 0
    lateinit var lastUpdated: Date
}
