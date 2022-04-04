package com.test.moviehub.presentation.dialogs

import android.app.Dialog
import android.content.Context
import com.test.moviehub.R
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.scopes.FragmentScoped
import javax.inject.Inject

/** loading dialog to show for loading process*/
@FragmentScoped
class LoadingDialog @Inject constructor(@ActivityContext private val context: Context) {

    private var dialog: Dialog? = null

    init {
        dialog = Dialog(context)
        parseView()
    }

    fun show() {
        dialog?.show()
    }

    fun hide() {
        if (dialog != null) {
            dialog!!.dismiss()
        }
    }

    private fun parseView() {
        dialog?.apply {
            setContentView(R.layout.dialog_loading)
            window!!.setBackgroundDrawableResource(android.R.color.transparent)
            setCancelable(false)
            setCanceledOnTouchOutside(false)
        }
    }

}