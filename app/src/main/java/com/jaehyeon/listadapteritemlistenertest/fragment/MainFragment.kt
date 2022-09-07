package com.jaehyeon.listadapteritemlistenertest.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.ItemTouchHelper
import com.jaehyeon.listadapteritemlistenertest.R
import com.jaehyeon.listadapteritemlistenertest.adapter.MainAdapter
import com.jaehyeon.listadapteritemlistenertest.databinding.FragmentMainBinding
import com.jaehyeon.listadapteritemlistenertest.util.CustomItemTouchCallBack
import com.jaehyeon.listadapteritemlistenertest.viewmodel.MainViewModel
import kotlinx.coroutines.flow.collectLatest

/**
 * Created by Jaehyeon on 2022/09/07.
 */
class MainFragment: Fragment() {

    private lateinit var binding: FragmentMainBinding
    private val adapter = MainAdapter()
    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        binding.rv.adapter = adapter

        CustomItemTouchCallBack(adapter).also {
            ItemTouchHelper(it).apply {
                this.attachToRecyclerView(binding.rv)
            }
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            viewModel.state.collectLatest {
                adapter.submitList(it)
            }
        }
    }


}