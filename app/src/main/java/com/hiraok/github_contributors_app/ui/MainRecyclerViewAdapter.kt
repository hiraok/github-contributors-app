package com.hiraok.github_contributors_app.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.hiraok.github_contributors_app.R
import com.hiraok.github_contributors_app.databinding.ItemContributorBinding
import com.hiraok.github_contributors_app.model.Contributor

class MainRecyclerViewAdapter(
    private val clickListener: OnItemClickListener
) : PagedListAdapter<Contributor, MainRecyclerViewAdapter.ContributorViewHolder>(callback) {

    companion object {
        val callback = object : DiffUtil.ItemCallback<Contributor>() {
            override fun areItemsTheSame(oldItem: Contributor, newItem: Contributor): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Contributor, newItem: Contributor): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContributorViewHolder {
        val binding: ItemContributorBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_contributor,
            parent,
            false
        )

        return ContributorViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContributorViewHolder, position: Int) {
        val contributor = getItem(position)
        contributor?.let { data ->
            holder.binding.contributor = data
            holder.binding.container.setOnClickListener {
                clickListener.onClick(
                    ContributorDetailFragment.DetailDto(
                        data.id,
                        data.avatarUrl
                    )
                )
            }
        }
    }

    class ContributorViewHolder(val binding: ItemContributorBinding) :
        RecyclerView.ViewHolder(binding.root)

    interface OnItemClickListener {
        fun onClick(dto: ContributorDetailFragment.DetailDto)
    }
}