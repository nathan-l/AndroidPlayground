package org.athaliapps.twilist.Utils

import android.databinding.BindingAdapter
import android.support.v7.widget.AppCompatButton
import android.view.View

@BindingAdapter("customOnClickCoroutine")
fun customOnClickCoroutine(btn: AppCompatButton, job: () -> Unit)
{
    println("hello")
    btn.setOnClickListener { job() }
//    println("this is a test with a $btn and a $job")
}