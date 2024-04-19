package com.lyadsky.centr_invest_card_client.data.services

import com.lyadsky.centr_invest_card_client.data.services.models.Service
import com.lyadsky.centr_invest_card_client.data.services.models.Services

interface ServicesRepository {

    suspend fun getServices(): Services

    suspend fun addService(service: Service)

    suspend fun removeService(service: Service)
}