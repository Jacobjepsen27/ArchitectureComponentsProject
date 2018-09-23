package dk.jacobworck.architecturecomponentsproject.adapter

import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import dk.jacobworck.architecturecomponentsproject.R
import dk.jacobworck.model.Word
import org.w3c.dom.Text

class WordAdapter(private var wordList: List<Word>):   RecyclerView.Adapter<WordAdapter.MyViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just a string in this case that is shown in a TextView.
    class MyViewHolder : RecyclerView.ViewHolder{

        private lateinit var textView: TextView

        constructor(view: View): super(view){
            textView = view.findViewById(R.id.item_textview)
        }

        fun setText(text: String){
            this.textView.text = text
        }
    }


    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordAdapter.MyViewHolder {
        // create a new view
        val constraintLayout = LayoutInflater.from(parent.context).inflate(R.layout.word_item, parent, false) as ConstraintLayout
        return MyViewHolder(constraintLayout)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.setText(wordList[position].word)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = wordList.size

    fun setWordList(wordList: List<Word>){
        this.wordList = wordList
    }

}