package com.test.moviehub.presentation.fragments

import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.restaurant.utils.Resource
import com.example.restaurant.utils.autoCleared
import com.test.moviehub.R
import com.test.moviehub.data.model.Shop
import com.test.moviehub.databinding.FragmentSearchBinding
import com.test.moviehub.presentation.adapters.ShopsAdapter
import com.test.moviehub.presentation.viewModels.SearchFragmentVM
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShopsFragment : Fragment(), ShopsAdapter.ShopItemListener {

    private var binding: FragmentSearchBinding  by autoCleared()
    private val viewModel: SearchFragmentVM by viewModels()
    private lateinit var adapter: ShopsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =  FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupObservers()
        getView()?.setFocusableInTouchMode(true)
        getView()?.requestFocus()
        getView()?.setOnKeyListener(object : View.OnKeyListener {
            override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {
                return if (keyCode == KeyEvent.KEYCODE_BACK) {
                    true
                } else false
            }
        })
    }

    private fun setupRecyclerView() {
        adapter = ShopsAdapter(this)
        binding.shopRv.layoutManager = LinearLayoutManager(requireContext())
        binding.shopRv.adapter = adapter
    }

  fun setupObservers() {
      viewModel.movie.observe(viewLifecycleOwner, Observer {
          when (it.status) {
              Resource.Status.SUCCESS -> {
                  binding.progressBar.visibility = View.GONE
                  binding.shimmerViewContainer.visibility = View.GONE
                  if (it.data != null) adapter.setItems(it.data as ArrayList<Shop>)
              }
              Resource.Status.ERROR ->{
                  Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
              }
              Resource.Status.LOADING ->{
                  binding.progressBar.visibility = View.VISIBLE
                  binding.shimmerViewContainer.visibility = View.VISIBLE
              }

          }
      })
    }

    override fun onClickedShops(shopId: String) {
        findNavController().navigate(
            R.id.action_fragment_main_to_fragment_detail,
            bundleOf("id" to shopId)
        )
    }

   override fun onPause() {
        super.onPause()
        binding.shimmerViewContainer.stopShimmerAnimation()
    }

  override fun onResume() {
        super.onResume()
        binding.shimmerViewContainer.startShimmerAnimation()
    }




}
