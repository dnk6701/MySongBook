package com.example.mysongbook

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.mysongbook.adapters.UserDataListAdapter
import com.example.mysongbook.databinding.FragmentAboutBinding
import com.example.mysongbook.list.ListFragmentViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AboutFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AboutFragment : Fragment() {
    lateinit var binding: FragmentAboutBinding
//    lateinit var viewModel: ListFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAboutBinding.inflate(inflater)
//        viewModel = ViewModelProvider(requireActivity())[ListFragmentViewModel::class.java]
        return binding.root
    }


/*    fun justGo() {
        Navigation.findNavController(binding.root).navigate((R.id.action_aboutFragment_to_listFragment))
    }
*/
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//    val adapter = UserDataListAdapter()
//    binding.

//    viewModel.list.observe(requireActivity()) {
//        adapter.items = it
//    }

    binding.nextImageButton.setOnClickListener {
        Navigation.findNavController(it).navigate(R.id.action_listFragment_to_editFragment)
    }
    }

    fun callToSupport() {
        val intentCallToSupport = Intent(Intent.ACTION_CALL)
        intentCallToSupport.data = Uri.parse("tel: +79148883019")
        startActivity(intentCallToSupport)
    }

/*    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AboutFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AboutFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }*/
}