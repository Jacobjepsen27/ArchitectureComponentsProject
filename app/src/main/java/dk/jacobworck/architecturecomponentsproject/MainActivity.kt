package dk.jacobworck.architecturecomponentsproject

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import dk.jacobworck.architecturecomponentsproject.adapter.WordAdapter
import dk.jacobworck.architecturecomponentsproject.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    // Recycler view
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    // Viewmodel
    private lateinit var viewModel: MainActivityViewModel

    // Viewmodel factory
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as AACApplication).getWordComponent().inject(this)

        viewModel = ViewModelProviders.of(this, viewModelFactory)[MainActivityViewModel::class.java]

        viewModel.getWords().observe(this, Observer {
            val adapter = viewAdapter as WordAdapter
            adapter.setWordList(it!!)
        })

        btn_add.setOnClickListener {
            val intent = Intent(this, AddWordActivity::class.java)
            startActivity(intent)
        }

        viewManager = LinearLayoutManager(this)
        viewAdapter = WordAdapter(listOf())

        recyclerView.apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter

        }
    }
}
