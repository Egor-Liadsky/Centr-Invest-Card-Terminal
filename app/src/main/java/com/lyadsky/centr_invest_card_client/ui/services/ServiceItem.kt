package com.lyadsky.centr_invest_card_client.ui.services

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.lyadsky.centr_invest_card_client.data.services.models.Service
import com.lyadsky.centr_invest_card_client.data.services.models.Services

@Composable
fun ServiceItem(service: Service) {
    Box(
        Modifier.padding(16.dp)
    ) {
        Column(
            Modifier.fillMaxSize()
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Absolute.SpaceBetween
            ) {
                Text(text = service.name)
                Text(text = "${service.cost}₽")
            }
            Text(
                text = service.description,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }

    Spacer(Modifier.height(16.dp))
}