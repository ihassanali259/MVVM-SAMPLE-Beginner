package com.example.task_123.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.task_123.R
import com.example.task_123.adapter.LanguageAdapter
import com.example.task_123.data.ApiResponse
import com.example.task_123.databinding.BaseFragmentBinding
import com.example.task_123.model.LanguageModel

class BaseFragment : Fragment() {

    private val viewModel by viewModels<BaseViewModel>()
    private lateinit var binding: BaseFragmentBinding
    private lateinit var languageList: ArrayList<LanguageModel>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.base_fragment, container, false)

        languageList = ArrayList()
        binding.re.layoutManager = LinearLayoutManager(requireContext())
        binding.re.hasFixedSize()

        viewModel.response.observe(viewLifecycleOwner) { response ->
            when (response) {
                is ApiResponse.Success -> {
                    binding.progressBar.visibility=View.GONE
                    response.data?.let {
                        for (i in it) {
                            val j =i.languages[0]
                                languageList.add(LanguageModel(j.name))

                        }
                        binding.re.adapter = LanguageAdapter(languageList.distinct().sortedBy { it.languageName })


                    }
                }
                is ApiResponse.Error -> {
                    Toast.makeText(requireContext(), "An error occurred", Toast.LENGTH_SHORT).show()
                }
                is ApiResponse.Loading -> {
                    binding.progressBar.visibility=View.VISIBLE
                    Log.d("CALLED", "onCreateView:loading ")
                }

            }
        }

        viewModel.fetchResults()

        return binding.root
    }


}