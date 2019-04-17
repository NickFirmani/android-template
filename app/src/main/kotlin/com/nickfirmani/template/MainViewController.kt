package com.nickfirmani.template

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.autodispose.ControllerScopeProvider
import com.hannesdorfmann.mosby3.mvp.conductor.MvpController
import com.jakewharton.rxbinding3.view.clicks
import com.nickfirmani.template.annotations.PerController
import com.uber.autodispose.ScopeProvider
import com.uber.autodispose.autoDisposable
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import kotlinx.android.synthetic.main.controller_main.view.*

class MainViewController : MvpController<Main.View, Main.Presenter>(), Main.View {

  override fun createPresenter(): Main.Presenter {
    return TemplateApp.component.mainComponent()
      .mainPresenterModule(MainPresenterModule(ControllerScopeProvider.from(this))).build().presenter()
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
    val view = inflater.inflate(R.layout.controller_main, container, false)
    view.controllerMainButton.clicks()
      .autoDisposable(ScopeProvider.UNBOUND)
      .subscribe { presenter.pollText() }
    return view
  }

  override fun showText(text: String) {
    view?.controllerMainText?.text = text
  }
}

@PerController
@Subcomponent(
  modules = [
    MainPresenterModule::class,
    GoogleApiModule::class
  ]
)
interface MainComponent {

  @PerController
  fun presenter(): MainPresenter

  @Subcomponent.Builder
  interface Builder {
    fun mainPresenterModule(module: MainPresenterModule): Builder
    fun build(): MainComponent
  }
}

@Module
class MainPresenterModule(private val controllerScopeProvider: ControllerScopeProvider) {

  @PerController
  @Provides
  fun provideMainPresenter(factory: MainPresenterFactory): MainPresenter = factory.create(controllerScopeProvider)
}

