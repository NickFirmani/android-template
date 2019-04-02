package com.nickfirmani.template

import com.bluelinelabs.conductor.autodispose.ControllerScopeProvider
import com.uber.autodispose.autoDisposable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class MainPresenter(scopeProvider: ControllerScopeProvider) : BasePresenter<Main.View>(scopeProvider), Main.Presenter {

  override fun pollText() {
    Observable.interval(1, TimeUnit.SECONDS, Schedulers.computation())
      .takeUntil { it > 100 }
      .map { "Here's some text: $it" }
      .observeOn(AndroidSchedulers.mainThread())
      .autoDisposable(scopeProvider)
      .subscribe { ifViewAttached { view -> view.showText(it) } }
  }

}
