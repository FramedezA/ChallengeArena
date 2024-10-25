package com.example.network.di.provider

import com.example.network.di.NetworkComponent

interface NetworkComponentProvider {
    fun getNetworkComponent(): NetworkComponent
}