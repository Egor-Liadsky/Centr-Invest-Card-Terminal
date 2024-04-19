package com.lyadsky.centr_invest_card_client.data.services.models

import kotlinx.serialization.Serializable

@Serializable
data class Service(
    val name: String,
    val description: String,
    val cost: Int,
)
