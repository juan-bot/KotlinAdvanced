package com.example.profile.di.modules

import com.example.profile.domain.repository.GetInfoRepository
import com.example.profile.domain.repository.LoginRepository
import com.example.profile.domain.usecase.GetInfoUseCase
import com.example.profile.domain.usecase.LoginUseCase
import com.example.profile.presentation.vm.GetInfViewModel
import com.example.profile.presentation.vm.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.scope.get
import org.koin.dsl.module

val appModule = module {
    single { LoginRepository() }
    single { LoginUseCase(get()) }
    viewModel { LoginViewModel(get()) }
}
val appModuleDashboard = module {
    single { GetInfoRepository() }
    single { GetInfoUseCase(get()) }
    viewModel { GetInfViewModel(get()) }
}
