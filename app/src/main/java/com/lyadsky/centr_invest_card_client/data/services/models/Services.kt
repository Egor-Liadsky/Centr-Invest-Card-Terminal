package com.lyadsky.centr_invest_card_client.data.services.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer

@Serializable
data class Services(
    val data: List<Service> = emptyList()
)
