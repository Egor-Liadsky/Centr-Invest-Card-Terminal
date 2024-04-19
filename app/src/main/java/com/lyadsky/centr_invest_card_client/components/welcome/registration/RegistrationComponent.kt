package com.lyadsky.centr_invest_card_client.components.welcome.registration

import com.arkivanov.decompose.value.Value
import com.lyadsky.centr_invest_card_client.components.welcome.auth.AuthState

interface RegistrationComponent {

    val viewStates: Value<AuthState>
}