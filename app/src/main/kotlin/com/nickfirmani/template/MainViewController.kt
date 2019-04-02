package com.nickfirmani.template

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.autodispose.ControllerScopeProvider
import com.hannesdorfmann.mosby3.mvp.conductor.MvpController
import com.jakewharton.rxbinding3.view.clicks
import com.uber.autodispose.autoDisposable
import kotlinx.android.synthetic.main.controller_main.view.*

class MainViewController : MvpController<Main.View, Main.Presenter>(), Main.View {

  override fun createPresenter(): Main.Presenter = MainPresenter(ControllerScopeProvider.from(this))

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View  {
    val view = inflater.inflate(R.layout.controller_main, container, false)
    view.controllerMainButton.clicks()
      .autoDisposable(ControllerScopeProvider.from(this))
      .subscribe { presenter.pollText() }
    return view
  }

  override fun showText(text: String) {
    view?.controllerMainText?.text = text
  }
}

