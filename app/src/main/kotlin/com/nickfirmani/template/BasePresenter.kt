package com.nickfirmani.template

import com.bluelinelabs.conductor.autodispose.ControllerScopeProvider
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import com.hannesdorfmann.mosby3.mvp.MvpView

open class BasePresenter<V: MvpView>(val scopeProvider: ControllerScopeProvider): MvpBasePresenter<V>()
