package com.lyadsky.centr_invest_card_client.components.home

import com.lyadsky.centr_invest_card_client.data.services.models.Service
import com.lyadsky.centr_invest_card_client.data.services.models.Services
import com.lyadsky.centr_invest_card_client.utils.LoadingState

data class ServicesState(
    val productsLoadingState: LoadingState = LoadingState.Loading,
    val services: List<Service> = emptyList()
)