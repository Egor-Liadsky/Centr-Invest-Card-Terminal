package com.lyadsky.centr_invest_card_client.ui.services

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.lyadsky.centr_invest_card_client.components.home.ServicesComponent

@Composable
fun ServicesScreen(component: ServicesComponent) {

    val state by component.viewStates.subscribeAsState()
    val modalState = remember { mutableStateOf(false) }

    TopAppBar(title = "Услуги", description = "Выберите нужную услуги и примите оплату")

    if (modalState.value)
        AddServiceModal({
            modalState.value = false
        }) {
            modalState.value = false

        }

    LazyColumn(
        Modifier.fillMaxSize()
    ) {
        items(
            state.services.size
        ) {
            ServiceItem(state.services[it])
        }
    }
}

@Composable
fun TopAppBar(
    title: String,
    description: String,
    modifier: Modifier = Modifier
) {
    Column(
        Modifier.padding(16.dp)
    ) {
        Text(text = title)
        Text(text = description)
    }
}