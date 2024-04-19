package com.lyadsky.centr_invest_card_client.ui.services

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Card
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.lyadsky.centr_invest_card_client.data.services.models.Service

@Composable
fun AddServiceModal(
    onDismissRequest: () -> Unit = {},
    onConfirmation: (Service) -> Unit,
) {
    val name = remember { mutableStateOf("") }
    val description = remember { mutableStateOf("") }
    val cost = remember { mutableIntStateOf(0) }

    Dialog(onDismissRequest = { onDismissRequest() }) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                OutlinedTextField(
                    value = name.value,
                    onValueChange = { name.value = it })
                OutlinedTextField(
                    value = description.value,
                    onValueChange = { description.value = it })
                OutlinedTextField(
                    value = cost.intValue.toString(),
                    onValueChange = { cost.intValue = it.toInt() },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))

                TextButton(onClick = {
                    onConfirmation(Service())
                }) {
                    Text("Добавить услугу")
                }
            }
        }
    }
}