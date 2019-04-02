package com.nickfirmani.template

import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView

interface Main {

  interface View : MvpView {
    fun showText(text: String)
  }

  interface Presenter: MvpPresenter<View> {
    fun pollText()
  }
}
