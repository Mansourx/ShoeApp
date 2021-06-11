package com.udacity.shoestore.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
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

        viewModel = ViewModelProvider(requireActivity()).get(ProductViewModel::class.java)
        binding.productViewModel = viewModel
        binding.lifecycleOwner = this

        // this cancel live data to observe if the cancel button clicked so we naviage back to the
        // shoe list fragment again.
        viewModel.cancel.observe(viewLifecycleOwner, Observer { _cancel ->
            if (_cancel) {
                findNavController().navigate(ProductDetailsFragmentDirections.actionProductDetailsFragmentToShoeListFragment())
                viewModel.resetCancel()
            }
        })

        // This Variable to observe if the shoe is added or not if it's added we navigate back to the
        // shoe list fragment. if not we know we have a missing fields and we show a toast error message!
        viewModel.isAdded.observe(viewLifecycleOwner, Observer { _isAdded ->
            if (_isAdded) {
                findNavController().navigate(ProductDetailsFragmentDirections.actionProductDetailsFragmentToShoeListFragment())
                viewModel.resetIsAdded()
            }
        })

        return binding.root
    }

}