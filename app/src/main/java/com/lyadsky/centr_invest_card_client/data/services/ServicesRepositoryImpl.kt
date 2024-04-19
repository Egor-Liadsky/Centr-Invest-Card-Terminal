package com.lyadsky.centr_invest_card_client.data.services

import android.content.Context
import androidx.datastore.core.Serializer
import androidx.datastore.dataStore
import com.lyadsky.centr_invest_card_client.data.services.models.Service
import com.lyadsky.centr_invest_card_client.data.services.models.Services
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.last

class ServicesRepositoryImpl(
    private val context: Context,
    serializer: Serializer<Services>
) : ServicesRepository {
    private val Context.dataStore by dataStore("services.json", serializer)

    private val servicesFlow: Flow<Services>
        get() = context.dataStore.data

    override suspend fun getServices(): Services = servicesFlow.last()

    override suspend fun addService(service: Service) {
        val services = getServices()
        if (service !in services.data)
            context.dataStore.updateData { current ->
                current.copy(data = services.data + service)
            }
    }

    override suspend fun removeService(service: Service) {
        val services = getServices()
        context.dataStore.updateData { current ->
            current.copy(data = services.data - service)
        }
    }

}