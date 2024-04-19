package com.lyadsky.centr_invest_card_client.components.welcome.auth

import com.arkivanov.decompose.ComponentContext
import com.lyadsky.centr_invest_card_client.components.BaseComponent
import com.lyadsky.centr_invest_card_client.components.welcome.auth.AuthState

class AuthComponentImpl(
    componentContext: ComponentContext
): BaseComponent<AuthState>(componentContext, AuthState()) {


}