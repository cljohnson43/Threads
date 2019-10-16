package com.example.threads.uicontrollers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.threads.R
import com.example.threads.adapters.WaitersAdapter
import com.example.threads.data.Customer
import com.example.threads.data.Waiter
import com.example.threads.databinding.ActivityMainBinding
import com.example.threads.viewmodels.RestaurantViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val restaurantViewModel: RestaurantViewModel by lazy {
        ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(RestaurantViewModel::class.java)
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        val waiters: List<Waiter> = listOf(
            Waiter("Sally Joe").apply { nowServing = 21 },
            Waiter("Tom John").apply { nowServing = 43 }
        )
        val adapter = WaitersAdapter(waiters)
        binding.rvWaiters.adapter = adapter
        binding.rvWaiters.layoutManager = LinearLayoutManager(this)

        restaurantViewModel.customersWaiting.observe(this, Observer {
            binding.tvCustomersWaiting.text = it.size.toString()
        })
    }

    fun onClick(view: View) {
        when (view.id) {
            R.id.btn_add_customer -> restaurantViewModel.addCustomer()
        }
    }
}
