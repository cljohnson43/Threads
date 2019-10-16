package com.example.threads.adapters

import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("setCustomersWaiting")
fun setCustomersWaiting(textView: TextView, numWaiting: String) {
    textView.text = "Customers Waiting\n$numWaiting"
}

@BindingAdapter("setNowServingText")
fun setNowServingText(textView: TextView, nowServing: String) {
    textView.text = "Now Serving\n$nowServing"
}
