package com.lyadsky.centr_invest_card_client.components.bottomNavigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.bringToFront
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.popTo
import com.arkivanov.decompose.value.Value
import com.lyadsky.centr_invest_card_client.components.bottomNavigation.BottomNavigationComponent.Child
import com.lyadsky.centr_invest_card_client.components.home.ServicesComponentImpl
import com.lyadsky.centr_invest_card_client.components.settings.SettingsComponentImpl
import kotlinx.serialization.Serializable

class BottomNavigationComponentImpl(
    componentContext: ComponentContext,
) : BottomNavigationComponent, ComponentContext by componentContext {

    private val navigation = StackNavigation<Config>()

    override val childStack: Value<ChildStack<*, Child>> =
        childStack(
            source = navigation,
            serializer = Config.serializer(),
            initialConfiguration = Config.Services,
            childFactory = ::childFactory
        )

    override fun onTabClicked(tab: MainNavTab) {
        when (tab) {
            MainNavTab.HOME -> navigation.bringToFront(Config.Home)
            MainNavTab.SETTINGS -> navigation.bringToFront(Config.Settings)
            MainNavTab.SERVICES -> navigation.bringToFront(Config.Services)
        }
    }

    override fun onBackClicked(toIndex: Int) {
        navigation.popTo(index = toIndex)
    }

    private fun childFactory(
        config: Config,
        componentContext: ComponentContext
    ): Child {
        return when (config) {
            Config.Home -> homeComponent(componentContext)
            Config.Settings -> settingsComponent(componentContext)
            Config.Services -> servicesComponent(componentContext)
        }
    }

    private fun homeComponent(componentContext: ComponentContext): BottomNavigationComponent.Child =
        Child.HomeChild(
            ServicesComponentImpl(componentContext = componentContext)
        )

    private fun settingsComponent(componentContext: ComponentContext): BottomNavigationComponent.Child =
        Child.SettingsChild(
            SettingsComponentImpl(componentContext = componentContext)
        )

    private fun servicesComponent(componentContext: ComponentContext): BottomNavigationComponent.Child =
        Child.ServicesChild(
            ServicesComponentImpl(componentContext = componentContext)
        )


    @Serializable
    private sealed interface Config {

        @Serializable
        data object Home : Config

        @Serializable
        data object Settings : Config

        @Serializable
        data object Services : Config
    }
}