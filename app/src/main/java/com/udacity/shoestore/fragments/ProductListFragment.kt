package com.udacity.shoestore.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentProductListBinding
import com.udacity.shoestore.viewModels.ProductViewModel
import com.udacity.shoestore.widget.ShoeItemLayout


class ProductListFragment : Fragment() {

    private lateinit var binding: FragmentProductListBinding
    private lateinit var viewModel: ProductViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_product_list, container, false)

        viewModel = ViewModelProvider(this).get(ProductViewModel::class.java)

        binding.productViewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.shoeList.observe(viewLifecycleOwner, Observer { shoeList ->
            if (!shoeList.isNullOrEmpty()) {
                shoeList.forEach { shoe ->
                    val shoeItem = ShoeItemLayout(context)
                    shoeItem.setProductViewDetails(
                        shoe.images[0],
                        shoe.name,
                        shoe.description,
                        shoe.company,
                        shoe.size
                    )
                    val myLayout: LinearLayout = binding.shoeContainer

                    shoeItem.layoutParams = ConstraintLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT
                    )
                    myLayout.addView(shoeItem)
                }
            }
        })

        binding.goToDetailBtn.setOnClickListener {
            findNavController().navigate(ProductListFragmentDirections.actionShoeListFragmentToProductDetailsFragment())
        }

        return binding.root
    }

}