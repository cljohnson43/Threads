package com.example.threads.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.threads.data.Customer
import com.example.threads.data.Waiter

class RestaurantViewModel : ViewModel() {
    val list: MutableList<Customer> = mutableListOf()
    lateinit var customersWaiting: MutableLiveData<List<Customer>>
    val waitersWorking: MutableList<Waiter> by lazy { mutableListOf<Waiter>() }
    private var nextCustomerId = 1

    init {
        customersWaiting = MutableLiveData()
        customersWaiting.value = list
    }

    fun addCustomer() {
        list.add(Customer(nextCustomerId))
        customersWaiting.value = list
        nextCustomerId += 1
    }
}