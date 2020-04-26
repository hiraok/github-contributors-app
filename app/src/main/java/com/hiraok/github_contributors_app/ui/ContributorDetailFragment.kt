package com.hiraok.github_contributors_app.ui

import android.app.Dialog
import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.hiraok.github_contributors_app.R
import com.hiraok.github_contributors_app.databinding.FragmentDetailBinding
import kotlinx.android.parcel.Parcelize


class ContributorDetailFragment : DialogFragment() {

    companion object {

        const val KEY = "dto"
        val TAG = ContributorDetailFragment::class.java.canonicalName

        fun show(
            fragmentManager: FragmentManager,
            dto: DetailDto
        ) {
            return ContributorDetailFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(KEY, dto)
                }
            }.show(fragmentManager, TAG)
        }
    }

    private val dto by lazy { arguments?.getParcelable<DetailDto>(KEY) }

    lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return DataBindingUtil.inflate<FragmentDetailBinding>(
            inflater,
            R.layout.fragment_detail,
            null,
            false
        ).also {
            binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {
            binding.lifecycleOwner = viewLifecycleOwner
            binding.contributor = dto
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val dialog: Dialog? = dialog
        dialog?.let {
            val lp: WindowManager.LayoutParams = it.window?.attributes ?: return
            val metrics = resources.displayMetrics
            val dialogWidth = (metrics.widthPixels * 1.0).toInt()
            val dialogHeight = (metrics.heightPixels * 0.5).toInt()
            lp.width = dialogWidth
            lp.height = dialogHeight
            it.window?.setAttributes(lp)
        }

    }

    @Parcelize
    data class DetailDto(
        val name: String,
        val avatarUrl: String
    ) : Parcelable

}