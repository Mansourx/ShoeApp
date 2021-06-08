package com.udacity.shoestore.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.models.Shoe


/**
 * Created by Ahmad Mansour on 29/05/2021
 * Dubai, UAE.
 */

class ProductViewModel : ViewModel() {

    private var _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: MutableLiveData<MutableList<Shoe>>
        get() = _shoeList

    init {
        initializeShoeList()
    }

    /**
     * Initialize the list of words and randomizes the order
     */
    private fun initializeShoeList() {
        val shoe1Images: ArrayList<Int> = ArrayList()
        shoe1Images.add(R.drawable.shoe_adidas)
        val shoe1 = Shoe(
            "Adidas Originals", 42.0, "Adidas", "Black Addis Original",
            shoe1Images
        )

        val shoe2Images: ArrayList<Int> = ArrayList()
        shoe2Images.add(R.drawable.shoe_rebook)
        val shoe2 = Shoe(
            "Reebok Originals", 38.0, "Reebok Company", "Black Rebook Original",
            shoe2Images
        )

        val shoe3Images: ArrayList<Int> = ArrayList()
        shoe3Images.add(R.drawable.shoe_nike)
        val shoe3 = Shoe(
            "Nike Originals", 44.0, "Nike Company", "Black Mike Original",
            shoe3Images
        )

        _shoeList.value = mutableListOf(shoe1, shoe2, shoe3)
    }

    fun addProduct(name: String, size: Double, companyName: String, description: String) {
        val shoeImages: ArrayList<Int> = ArrayList()
        shoeImages.add(R.drawable.shoe_adidas)
        val shoe = Shoe(name, size, companyName, description, shoeImages)
        _shoeList.value?.add(shoe)
    }
}