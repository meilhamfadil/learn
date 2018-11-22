package com.jmasagi.uptdjabar2.modules.inspectors

import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jmasagi.uptdjabar2.R
import com.jmasagi.uptdjabar2.data.entity.ModelInspectors
import com.jmasagi.uptdjabar2.databinding.ContentInspectorsBinding
import com.jmasagi.uptdjabar2.util.decoration.ListPaddingDecoration
import kotlinx.android.synthetic.main.content_inspectors.view.*

class InspectorsMainFragment : Fragment() {

    private lateinit var inspectorAdapter: InspectorsRVAdapter
    private lateinit var ctx: Context
    private lateinit var binding: ContentInspectorsBinding
    private lateinit var content: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.content_inspectors, container, false)
        content = binding.root
        ctx = content.context
        initRecyclerView()
        return content
    }

    private fun initRecyclerView() {
        val recyclerView = content.list
        recyclerView.run {
            layoutManager = LinearLayoutManager(ctx)
            addItemDecoration(ListPaddingDecoration(ctx))
            inspectorAdapter = InspectorsRVAdapter(getData())
            adapter = inspectorAdapter
        }
    }

    private fun getData(): ArrayList<InspectorsViewModel> {
        val inspectors = ArrayList<InspectorsViewModel>()
        for (i in 1..9) {
            val post = InspectorsViewModel(
                ModelInspectors.Data(
                    i, "nama $i", "email $i", "jabatan $i", "alamat $i", "phone $i", "pic $i"
                )
            )
            inspectors.add(post)
        }
        return inspectors
    }

}