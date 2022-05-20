package com.newcore.movieapptask.presintation.ui.movieslist.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.newcore.movieapptask.common.Resources
import com.newcore.movieapptask.databinding.ItemsMoviesSectionBinding
import com.newcore.movieapptask.presintation.ui.movieslist.viewentities.ViewSection

class SectionAdapter : RecyclerView.Adapter<SectionAdapter.SectionListViewHolder>() {

    open class SectionListViewHolder(private val binding: ItemsMoviesSectionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        operator fun invoke(section: ViewSection) = binding.apply {
            binding.rvViewList.apply {
                tvSectionTitle.text = section.sectionTitle
                when (section.sectionList) {
                    is Resources.Error -> {
                        container.isVisible = false
                        loading.isVisible = false
                    }
                    is Resources.Loading -> {
                        container.isVisible = false
                        loading.isVisible = true
                    }
                    is Resources.Success -> {
                        container.isVisible = true
                        loading.isVisible = false
                        adapter = (if (section.isBig) BigMovieListAdapter() else MediumMovieListAdapter())
                            .apply {
                                movies = section.sectionList.data ?: emptyList()
                            }
                        layoutManager = LinearLayoutManager(
                            binding.root.context,
                            LinearLayoutManager.HORIZONTAL,
                            false
                        )
                    }
                }

            }
        }
    }


    var sections: List<ViewSection> = emptyList()
        set(value) {
            field = value
            notifyItemRangeChanged(0, value.size)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SectionListViewHolder {
        return SectionListViewHolder(ItemsMoviesSectionBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false,
        ))
    }

    override fun onBindViewHolder(holder: SectionListViewHolder, position: Int) {
        holder(sections[position])
    }

    override fun getItemCount() = sections.size

}