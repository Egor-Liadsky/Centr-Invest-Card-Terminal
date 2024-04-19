package com.lyadsky.centr_invest_card_client.di

import androidx.datastore.core.Serializer
import com.lyadsky.centr_invest_card_client.data.services.ServicesRepository
import com.lyadsky.centr_invest_card_client.data.services.ServicesRepositoryImpl
import com.lyadsky.centr_invest_card_client.data.services.ServicesSerializer
import com.lyadsky.centr_invest_card_client.data.services.models.Services
import org.koin.dsl.module

val servicesModule = module {

    single<Serializer<Services>> { ServicesSerializer() }

    single<ServicesRepository> { ServicesRepositoryImpl(get(), get()) }

}