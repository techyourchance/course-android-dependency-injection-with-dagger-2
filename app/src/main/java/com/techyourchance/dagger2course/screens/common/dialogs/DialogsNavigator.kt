package com.techyourchance.dagger2course.screens.common.dialogs

import androidx.fragment.app.FragmentManager
import javax.inject.Inject

class DialogsNavigator @Inject constructor(private val fragmentManager: FragmentManager) {

    fun showServerErrorDialog() {
        fragmentManager.beginTransaction()
                .add(ServerErrorDialogFragment.newInstance(), null)
                .commitAllowingStateLoss()
    }
}