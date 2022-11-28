package com.example.mysongbook.song_text

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.mysongbook.R
import com.example.mysongbook.databinding.FragmentEditBinding
import com.example.mysongbook.databinding.FragmentListBinding
import com.example.mysongbook.list.ListFragmentViewModel
import com.example.mysongbook.room.UserData

class TextFragment : Fragment() {
    lateinit var binding: FragmentListBinding
    lateinit var viewModel: ListFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater)
        viewModel = ViewModelProvider(requireActivity())[ListFragmentViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addNewSongfloatingActionButton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_textFragment_to_listFragment)
        }
    }
}