package com.test.restaurant.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.restaurant.utils.Resource
import com.example.restaurant.utils.autoCleared
import com.test.restaurant.R
import com.test.restaurant.data.model.Shop
import com.test.restaurant.databinding.FragmentDetailBinding
import com.test.restaurant.presentation.viewModels.GetDetailsVM
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetailFragment : Fragment(R.layout.fragment_detail) {

    private var binding: FragmentDetailBinding by autoCleared()
    private val viewModel: GetDetailsVM by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getString("id")?.let { viewModel.getDetails(it) }.toString()
        setupObservers()
    }

    private fun setupObservers() {

        viewModel.movie.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    bindCharacter(it.data)
                    binding.progressBar.visibility = View.GONE
                    binding.shopCl.visibility = View.VISIBLE
                }

                Resource.Status.ERROR ->
                    Toast.makeText(activity, it.message, Toast.LENGTH_SHORT).show()

                Resource.Status.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.shopCl.visibility = View.GONE
                }
            }
        })
    }

    private fun bindCharacter(shop: Shop?) {
        binding.name.text = "Name: "+shop?.name
        binding.accessText.text = "Access: "+ shop?.access
        binding.address.text = "Address: "+ shop?.address
        binding.band.text = "Band: "+ shop?.band
        binding.barrierFree.text = "Barrier Free: "+shop?.barrierFree
        binding.budgetAverage.text = "Budget Average: "+shop?.budget?.average
        binding.budgetCode.text = "Budget Code: "+shop?.budget?.budgetCode
        binding.budgetName.text = "Budget Name: "+shop?.budget?.budgetName
        binding.budgetMemo.text = "Budget Memo: "+shop?.budgetMemo
        binding.capacity.text = "Capacity: "+shop?.capacity
        binding.card.text = "Card: "+shop?.card
        binding.catchText.text = "Catch: "+shop?.catch
        binding.charter.text = "Charter: "+shop?.charter
        binding.child.text = "Child: "+shop?.child
        binding.close.text = "Close: "+shop?.close
        binding.course.text = "Course: "+shop?.course
        binding.english.text = "English: "+shop?.english
        binding.freeDrink.text = "Free Drink: "+shop?.freeDrink
        binding.freeFood.text = "Free Food: "+shop?.freeFood
        binding.genreCatch.text = "Genre Catch: "+shop?.genre?.catch
        binding.genreCode.text = "Genre Code: "+shop?.genre?.genreCode
        binding.genreName.text = "Genre Name: "+shop?.genre?.genreName
        binding.horigotatsu.text = "Horigotatsu: "+shop?.horigotatsu
        binding.karaoke.text ="Karaoke: "+ shop?.karaoke
        binding.ktaiCoupon.text = "ktaiCoupon"+shop?.ktaiCoupon
        binding.largeAreaCode.text = "Large Area Code: "+shop?.largeArea?.largeAreaCode
        binding.largeAreaName.text = "Large Area Name: "+shop?.largeArea?.largeAreaName
        binding.largeServiceCode.text = "Large Service Area Code: "+shop?.largeServiceArea?.largeServiceAreaCode
        binding.largeServiceName.text = "Large Service Area Name: "+shop?.largeServiceArea?.largeServiceAreaName
        binding.lat.text = "Lat: "+shop?.lat
        binding.lng.text = "Lng: "+shop?.lng
        binding.lunch.text = "Lunch: "+shop?.lunch
        binding.middleAreaCode.text = "Middle Area Code: "+shop?.middleArea?.middleAreaCode
        binding.middleAreaName.text = "Middle Area Name: "+shop?.middleArea?.middleAreaName
        binding.midnight.text = "Midnight: "+shop?.midnight
        binding.mobileAccess.text = "MobileAccess: "+shop?.mobileAccess
        binding.nameKana.text = "NameKana: "+shop?.nameKana
        binding.nonSmoking.text = "NonSmoking: "+shop?.nonSmoking
        binding.open.text = "open: "+shop?.open
        binding.otherMemo.text = "OtherMemo: "+shop?.otherMemo
        binding.parking.text = "Parking: "+shop?.parking
        binding.partyCapacity.text = "Party Capacity: "+shop?.partyCapacity
        binding.pet.text = "Pet: "+shop?.pet
        binding.privateRoom.text = "PrivateRoom: "+shop?.privateRoom
        binding.serviceAreaCode.text = "Service Area Code: "+shop?.serviceArea?.serviceAreaCode
        binding.serviceAreaName.text = "Service Area Name: "+shop?.serviceArea?.serviceAreaName
        binding.shopDetailsMemo.text = "ShopDetailMemo: "+shop?.shopDetailMemo
        binding.show.text = "Show: "+shop?.show
        binding.smallAreaCode.text = "Small Area Code: "+shop?.smallArea?.smallAreaCode
        binding.smallAreaName.text = "Small Area Name: "+shop?.smallArea?.smallAreaName
        binding.stationName.text = "StationName: "+shop?.stationName
        binding.subGenreCode.text = "Sub Genre Code: "+shop?.subGenre?.subGenreCode
        binding.subGenreName.text = "Sub Genre Name: "+shop?.subGenre?.subGenreName
        binding.tatami.text = "Tatami: "+shop?.tatami
        binding.tv.text = "Tv: "+shop?.tv
        binding.wedding.text = "Wedding: "+shop?.wedding
        binding.wifi.text = "Wifi: "+shop?.wifi

        Glide.with(binding.root)
            .load(shop?.photo?.mobile?.longSize)
            .into(binding.photo)

        binding.backButton.setOnClickListener(View.OnClickListener {
            findNavController().navigate(
                R.id.fragment_main
            )
        })
    }

}