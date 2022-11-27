package com.example.mysongbook.edit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.mysongbook.R
import com.example.mysongbook.databinding.FragmentEditBinding
import com.example.mysongbook.list.ListFragmentViewModel
import com.example.mysongbook.room.UserData


class EditFragment : Fragment() {
    lateinit var binding: FragmentEditBinding
    lateinit var viewModel: ListFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditBinding.inflate(inflater)
        viewModel = ViewModelProvider(requireActivity())[ListFragmentViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.saveButton.setOnClickListener {
//            val number = size
            val songName = binding.songName.text.toString()
            val songComposer = binding.songComposer.text.toString()
            val songLirics = binding.songLirics.text.toString()
            val songArtist = binding.songArtist.text.toString()
            val songTon = binding.songTon.text.toString()
            val songText = binding.songText

            val user = UserData(songName, songComposer, songLirics, songArtist, songTon, songText)
            viewModel.insert(user)
            Navigation.findNavController(it).navigate(R.id.action_editFragment_to_listFragment)
        }
    }

}