package com.example.challengearena.application

import android.app.Application
import android.content.Context
import android.util.Log
import com.example.achievements.data.AchievementsStorageImpl
import com.example.achievements.data.retrofit.AchievementsRetrofitServiceProvider
import com.example.achievements.domain.AchievementsRepositoryImpl
import com.example.achievements.presentation.AchievementsViewModelFactory
import com.example.achievements.presentation.AchievmentsServiceLocator
import com.example.auth.data.AuthStorageImpl
import com.example.auth.data.retrofit.AuthRetrofitServiceProvider
import com.example.auth.domain.AuthRepositoryImpl
import com.example.auth.presentation.AuthServiceLocator
import com.example.auth.presentation.AuthViewModelFactory
import com.example.challenges.data.ChallengesStorageImpl
import com.example.challenges.data.retrofit.ChallengesRetrofitServiceProvider
import com.example.challenges.data.retrofit.Interface.ChallengesRetrofitService
import com.example.home.data.retrofit.HomeRetrofitServiceProvider
import com.example.challenges.domain.ChallengesRepositoryImpl
import com.example.challenges.presentation.ChallengesServiceLocator
import com.example.challenges.presentation.ChallengesViewModelFactory
import com.example.challenges.presentation.picker_manager.PickerManagerImpl
//import com.example.auth.presentation.di.DaggerAuthComponent

import com.example.home.data.HomeStorageImpl
import com.example.home.domain.HomeRepositoryImpl
import com.example.home.presentation.HomeServiceLocator
import com.example.home.presentation.HomeViewModelFactory
import com.example.login.data.LoginStorageImpl
import com.example.login.data.retrofit.LoginRetrofitServiceProvider
import com.example.login.domain.LoginRepositoryImpl
import com.example.login.presentation.LoginServiceLocator
import com.example.login.presentation.LoginViewModelFactory
//import com.example.entry.presentation.di.DaggerEntryComponent
//import com.example.entry.presentation.di.EntryComponent
//import com.example.entry.presentation.di.provider.EntryComponentProvider
//import com.example.login.presentation.di.DaggerLoginComponent
import com.example.network.presentation.NetworkServiceLocator
import com.example.network.domain.TokenManager
import com.example.network.data.TokenStorageImpl
import com.example.network.data.retrofit.NetworkRetrofitServiceProvider
import com.example.network.domain.TokenGetterManager
import com.example.network.domain.TokenRepositoryImpl
import com.example.profile.data.ProfileStorageImpl
import com.example.profile.data.retrofit.ProfileRetrofitServiceProvider
import com.example.profile.domain.ProfileRepositoryImpl
import com.example.profile.presentation.ProfileServiceLocator
import com.example.profile.presentation.ProfileViewModelFactory
import com.example.splash.data.SplashStorageImpl
import com.example.splash.domain.SplashRepositoryImpl
import com.example.splash.presentation.SplashServiceLocator
import com.example.splash.presentation.SplashViewModelFactory

//import com.example.maps.presentation.di.DaggerMapsComponent
//import com.example.maps.presentation.di.DaggerProfileComponent
//import com.example.maps.presentation.di.MapsComponent
//import com.example.maps.presentation.di.ProfileComponent
//import com.example.maps.presentation.di.provider.MapsComponentProvider
//import com.example.place.presentation.di.DaggerPlaceComponent
//import com.example.place.presentation.di.PlaceComponent
//import com.example.place.presentation.di.provider.PlaceComponentProvider
//import com.example.profile.presentation.di.provider.ProfileComponentProvider
//import com.example.splash.presentation.di.DaggerSplashComponent

//import com.example.sport_path.BuildConfig
//import com.yandex.mapkit.MapKitFactory
//import com.example.network.di.DaggerNetworkComponent


class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        TokenStorageImpl(this).clearUserData()
        TokenStorageImpl(this).clearToken()

        setNetworkServiceLocator(this)
        setAuthServiceLocator(this)
        setLoginServiceLocator(this)
        setSplashServiceLocator(this)
        setHomeServiceLocator(this)
        setProfileServiceLocator(this)
        setChallengesServiceLocator()
        setAchievmentServiceLocator(this)

    }


    private fun setNetworkServiceLocator(context: Context) {
        NetworkServiceLocator.registerService(
            "TokenGetterManager",
            TokenGetterManager(
                TokenStorageImpl(context)
            )
        )
        NetworkServiceLocator.registerService(
            "TokenManager",
            TokenManager(
                TokenRepositoryImpl(
                    NetworkRetrofitServiceProvider.networkRetrofitService,
                    TokenStorageImpl(context)
                )
            )
        )
        Log.d("mLogId", LoginStorageImpl(this).getId()!!)
        Log.d("mLogTok", TokenStorageImpl(this).getToken()!!)

    }

    private fun setAuthServiceLocator(context: Context) {
        AuthServiceLocator.registerService(
            "AuthViewModelFactory",
            AuthViewModelFactory(
                AuthRepositoryImpl(
                    AuthRetrofitServiceProvider.authRetrofitService,
                    AuthStorageImpl(context)
                )
            )
        )
    }

    private fun setLoginServiceLocator(context: Context) {
        LoginServiceLocator.registerService(
            "loginViewModelFactory",
            LoginViewModelFactory(
                LoginRepositoryImpl(
                    LoginRetrofitServiceProvider.loginRetrofitService,
                    LoginStorageImpl(context)
                )
            )
        )
    }

    private fun setSplashServiceLocator(context: Context) {
        SplashServiceLocator.registerService(
            "splashViewModelFactory",
            SplashViewModelFactory(
                SplashRepositoryImpl(
                    SplashStorageImpl(context)
                )
            )
        )
    }

    private fun setHomeServiceLocator(context: Context) {
        HomeServiceLocator.registerService(
            "homeViewModelFactory",
            HomeViewModelFactory(
                HomeRepositoryImpl(HomeRetrofitServiceProvider.homeRetrofitService,
                    HomeStorageImpl(context)
                )
            )
        )
    }

    private fun setProfileServiceLocator(context: Context) {
        ProfileServiceLocator.registerService(
            "profileViewModelFactory",
            ProfileViewModelFactory(
                ProfileRepositoryImpl(
                    ProfileStorageImpl(context),
                    ProfileRetrofitServiceProvider.profileRetrofitService
                )
            )
        )
    }

    private fun setChallengesServiceLocator() {
        ChallengesServiceLocator.registerService(
            "challengesViewModelFactory",
            ChallengesViewModelFactory(
                ChallengesRepositoryImpl(
                    ChallengesRetrofitServiceProvider.challengesRetrofitService,
                    ChallengesStorageImpl(this)
                )
            )
        )
        ChallengesServiceLocator.registerService("pickerManager", PickerManagerImpl())
    }
    private fun setAchievmentServiceLocator(context: Context) {
        AchievmentsServiceLocator.registerService(
            "achievmentsViewModelFactory",
            AchievementsViewModelFactory(
                AchievementsRepositoryImpl(
                    AchievementsRetrofitServiceProvider.achievementsRetrofitService,
                    AchievementsStorageImpl(context)
                )
            )
        )
    }




}



