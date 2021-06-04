package com.udacity.shoestore.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.udacity.shoestore.R


/**
 * Created by Ahmad Mansour on 07/06/2021
 * Dubai, UAE.
 */


class ShoeItemLayout : ConstraintLayout {

    private var productImage: ImageView? = null
    private var productNameTextView: TextView? = null
    private var productDescriptionTextView: TextView? = null
    private var companyNameTextView: TextView? = null
    private var productSizeTextView: TextView? = null


    constructor(context: Context?) : super(context!!) {
        initialize()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context!!, attrs) {
        initialize()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int)
            : super(context!!, attrs, defStyleAttr) {
        initialize()
    }

    private fun initialize() {
        LayoutInflater.from(context)
            .inflate(R.layout.layout_shoe_item, this)
        productImage = findViewById(R.id.product_image_View)
        productNameTextView = findViewById(R.id.name_text)
        productDescriptionTextView = findViewById(R.id.description_text)
        companyNameTextView = findViewById(R.id.company_name_text)
        productSizeTextView = findViewById(R.id.product_size_text)
    }


    fun setProductViewDetails(
        image: Int, productName: String, productDescription: String,
        companyName: String, productSize: Double
    ) {
        productImage?.setBackgroundResource(image)
        productNameTextView?.text = productName
        productDescriptionTextView?.text = productDescription
        companyNameTextView?.text = companyName
        productSizeTextView?.text = productSize.toString()
    }
}