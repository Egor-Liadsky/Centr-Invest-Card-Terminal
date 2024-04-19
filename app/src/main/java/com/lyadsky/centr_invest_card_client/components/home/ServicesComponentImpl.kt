package com.lyadsky.centr_invest_card_client.components.home

import com.arkivanov.decompose.ComponentContext
import com.lyadsky.centr_invest_card_client.components.BaseComponent
import com.lyadsky.centr_invest_card_client.data.services.ServicesRepository
import com.lyadsky.centr_invest_card_client.data.services.models.Service
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class ServicesComponentImpl(
    componentContext: ComponentContext
) : BaseComponent<ServicesState>(componentContext, ServicesState()), ServicesComponent, KoinComponent {

    private val servicesRepository: ServicesRepository by inject()

    init {
        scope.launch {
            updateServices()
        }
    }

    private suspend fun updateServices() {
        viewState = viewState.copy(
            services = servicesRepository.getServices().data
        )
    }

    fun addService(service: Service) = scope.launch {
        servicesRepository.addService(service)
        updateServices()
    }

    fun removeService(service: Service) = scope.launch {
        servicesRepository.removeService(service)
        updateServices()
    }

}