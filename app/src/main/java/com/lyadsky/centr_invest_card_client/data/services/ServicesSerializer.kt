package com.lyadsky.centr_invest_card_client.data.services

import androidx.datastore.core.Serializer
import com.lyadsky.centr_invest_card_client.data.services.models.Services
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import java.io.InputStream
import java.io.OutputStream


class ServicesSerializer : Serializer<Services> {
    override val defaultValue: Services
        get() = Services()

    override suspend fun readFrom(input: InputStream): Services =
        try {
            Json.decodeFromString(
                deserializer = Services.serializer(),
                string = input.readBytes().decodeToString()
            )
        } catch (e: Exception) {
            println(e.stackTrace)
            defaultValue
        }

    override suspend fun writeTo(t: Services, output: OutputStream) =
        withContext(Dispatchers.IO) {
            output.write(
                Json.encodeToString(
                    serializer = Services.serializer(),
                    value = t
                ).encodeToByteArray()
            )
        }
}