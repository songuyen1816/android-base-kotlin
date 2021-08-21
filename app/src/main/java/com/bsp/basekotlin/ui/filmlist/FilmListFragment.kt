package com.bsp.basekotlin.ui.filmlist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bsp.basekotlin.R
import com.bsp.basekotlin.databinding.FragmentFilmListBinding
import com.bsp.basekotlin.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FilmListFragment : BaseFragment<FragmentFilmListBinding>() {

    private val viewModel: FilmViewModel by viewModels()
    private var filmAdapter = FilmListAdapter()

    override fun layoutId(): Int = R.layout.fragment_film_list

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getListFilm()
    }

    override fun setupViews() {
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = filmAdapter
    }

    override fun createObserver() {
        viewModel.listFilm.observe(viewLifecycleOwner) { filmAdapter.submitList(it) }
    }

}