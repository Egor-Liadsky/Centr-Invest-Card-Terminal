package com.lyadsky.centr_invest_card_client.components.welcome.registration

import com.arkivanov.decompose.ComponentContext
import com.lyadsky.centr_invest_card_client.components.BaseComponent
import com.lyadsky.centr_invest_card_client.components.welcome.auth.AuthState

class RegistrationComponentImpl(
    componentContext: ComponentContext
): BaseComponent<AuthState>(componentContext, AuthState()) {


}