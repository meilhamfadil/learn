package com.jmasagi.uptdjabar2.modules.inspections

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jmasagi.uptdjabar2.R
import com.jmasagi.uptdjabar2.data.Model
import com.jmasagi.uptdjabar2.databinding.ContentFragmentBinding

class InspectionsMainFragment : Fragment() {

    private lateinit var binding: ContentFragmentBinding
    private lateinit var content: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate<ContentFragmentBinding>(inflater, R.layout.content_fragment, container, false)
        content = binding.root
        modeling()

        return content
    }

    private fun modeling() {
        val text = Model("Fragment Inspections")
        binding.model = text
    }

}