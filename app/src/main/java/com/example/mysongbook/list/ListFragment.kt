package com.example.mysongbook.list

import android.app.SearchManager
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.mysongbook.R
import com.example.mysongbook.adapters.UserDataListAdapter
import com.example.mysongbook.databinding.FragmentListBinding
import com.example.mysongbook.room.UserData

class ListFragment : Fragment() {

    lateinit var binding: FragmentListBinding
    lateinit var viewModel: ListFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?    ): View? {

        binding = FragmentListBinding.inflate(inflater)
        viewModel = ViewModelProvider(requireActivity())[ListFragmentViewModel::class.java]
        return binding.root
             }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = UserDataListAdapter()
        adapter.itemClick {
            Navigation.findNavController(binding.root).navigate((R.id.action_listFragment_to_textFragment))
        }
        binding.songListRecyclerView.adapter = adapter
        viewModel.list.observe(requireActivity()){
        adapter.items = it
        }
        binding.addNewSongfloatingActionButton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_listFragment_to_editFragment)
        }

        fun makeSearch(view: View){
            val intentToSearchSomething = Intent(Intent.ACTION_WEB_SEARCH)
            intentToSearchSomething.putExtra(SearchManager.QUERY,"Советские песни")
            startActivity(intentToSearchSomething)
        }

        /*       binding.songListRecyclerView.setOnClickListener {
                   Navigation.findNavController(it).navigate((R.id.action_listFragment_to_textFragment))
               }*/
    }
}