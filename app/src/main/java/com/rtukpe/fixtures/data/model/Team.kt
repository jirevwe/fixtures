package com.rtukpe.fixtures.data.model

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

class Team {
    @SerializedName("id")
    @JvmField
    var id: Int = 0
    @SerializedName("name")
    lateinit var name: String
    @SerializedName("shortName")
    lateinit var shortName: String
    @SerializedName("crestUrl")
    lateinit var logo: String

    override fun toString(): String {
        return Gson().toJson(this)
    }
}
