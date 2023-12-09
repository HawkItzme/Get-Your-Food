package com.example.getyourfood.View

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.getyourfood.ViewModel.MainViewModel
import com.example.getyourfood.R
import com.example.getyourfood.databinding.FragmentJuiceBinding
import com.example.getyourfood.data.model.Business

class JuiceFragment : Fragment() {

    lateinit var binding : FragmentJuiceBinding

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val apiService = RetrofitClient.createService(YelpApiService::class.java)
//        val repository = YelpRepository(apiService)
        // Use ViewModelProvider with ViewModelFactory
        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_juice, container, false)

        viewModel.searchJuice(33.16017034638842, -96.68231175805475)
        binding.juiceRV.layoutManager = LinearLayoutManager(requireContext())
        viewModel.juiceList.observe(viewLifecycleOwner, Observer { businesses ->
            businesses?.let {
                val adapter = BusinessAdapter( it){business ->
                    openGoogleMaps(business)
                }
                binding.juiceRV.adapter = adapter
            }
        })
        return binding.root
    }
    private fun openGoogleMaps(business: Business) {
        val location = business.coordinates
        val uri = "geo:${location.latitude},${location.longitude}?q=${business.location.address1}"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
        intent.setPackage("com.google.android.apps.maps")
        startActivity(intent)
    }

}