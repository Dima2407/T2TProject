package com.e.t2tproject.common

import android.content.res.AssetManager
import java.io.IOException
import java.nio.charset.Charset

fun loadJSONFromAsset(assetManager: AssetManager, jsonPath: String): String? {
    val json: String?
    try {
        val inputStream = assetManager.open(jsonPath)
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        json = String(buffer, Charset.forName("UTF-8"))
    } catch (ex: IOException) {
        ex.printStackTrace()
        return null
    }
    return json
}
