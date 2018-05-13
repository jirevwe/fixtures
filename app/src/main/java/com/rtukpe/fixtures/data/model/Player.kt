package com.rtukpe.fixtures.data.model

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

class Player {
    @JvmField
    var id: Int = 0
    lateinit var nationality: String
    @SerializedName("dateOfBirth")
    lateinit var dateOfBirth: String
    @SerializedName("jerseyNumber")
    @JvmField
    var jerseyNumber: Int = 0
    lateinit var position: String
    lateinit var name: String

    override fun toString(): String {
        return Gson().toJson(this)
    }
}
