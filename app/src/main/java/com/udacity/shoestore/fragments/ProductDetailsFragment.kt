package com.udacity.shoestore.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentProductDetailsBinding
import com.udacity.shoestore.viewModels.ProductViewModel

class ProductDetailsFragment : Fragment() {

    private lateinit var binding: FragmentProductDetailsBinding
    private lateinit var viewModel: ProductViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_product_details, container, false)

        viewModel = ViewModelProvider(this).get(ProductViewModel::class.java)
        binding.productViewModel = viewModel
        binding.lifecycleOwner = this

        binding.cancelBtn.setOnClickListener {
            findNavController().navigate(ProductDetailsFragmentDirections.actionProductDetailsFragmentToShoeListFragment())
        }

        binding.saveBtn.setOnClickListener {
            val productName = binding.productNameEt.text.toString()
            val productDescription = binding.productDescriptionEt.text.toString()
            val companyName = binding.companyNameEt.text.toString()
            val productSize = binding.productSizeEt.text.toString()
            saveProduct(productName, productSize.toDouble(), companyName, productDescription)
            findNavController().navigate(ProductDetailsFragmentDirections.actionProductDetailsFragmentToShoeListFragment())
        }

        return binding.root
    }

    private fun saveProduct(name: String, size: Double, companyName: String, description: String) {
        viewModel.addProduct(name, size, companyName, description)
    }

}