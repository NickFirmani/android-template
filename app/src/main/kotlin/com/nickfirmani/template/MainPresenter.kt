package com.nickfirmani.template

import com.bluelinelabs.conductor.autodispose.ControllerScopeProvider
import com.google.auto.factory.AutoFactory
import com.google.auto.factory.Provided
import com.nickfirmani.template.base.BasePresenter
import com.uber.autodispose.autoDisposable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

@AutoFactory
class MainPresenter constructor(
  @Provided val googleApi: GoogleApi,
  scopeProvider: ControllerScopeProvider) : BasePresenter<Main.View>(scopeProvider), Main.Presenter {

  override fun pollText() {
    googleApi.generate204()
      .observeOn(AndroidSchedulers.mainThread())
      .doOnSuccess { ifViewAttached { view -> view.showText("Generated 204") } }
      .ignoreElement()
      .andThen(Observable.interval(1, TimeUnit.SECONDS, Schedulers.computation()))
      .takeUntil { it > 100 }
      .map { "Here's some text: $it" }
      .observeOn(AndroidSchedulers.mainThread())
      .autoDisposable(scopeProvider)
      .subscribe { ifViewAttached { view -> view.showText(it) } }
  }
}
