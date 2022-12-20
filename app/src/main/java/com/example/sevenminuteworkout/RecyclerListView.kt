package com.example.sevenminuteworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sevenminuteworkout.databinding.ActivityRecyclerListViewBinding

class RecyclerListView : AppCompatActivity() {
    private var binding: ActivityRecyclerListViewBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerListViewBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        var adapter = ListViewAdapter(TaskList.list)
        binding?.rvListView?.adapter = adapter
    }

    public override fun onDestroy() {
        binding = null
        super.onDestroy()
    }
}