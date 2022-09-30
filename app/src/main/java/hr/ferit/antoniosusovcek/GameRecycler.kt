package hr.ferit.antoniosusovcek

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class GameRecycler(private val items: List<Games>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return GameViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.games_layout, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is GameViewHolder -> {
                holder.bind(items[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }


    class GameViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val gameThumbnail: ImageView = itemView.findViewById(R.id.gameThumbnail)
        private val gameName: TextView = itemView.findViewById(R.id.gameName)
        private val gameText: TextView = itemView.findViewById(R.id.gameText)
        private val gameCategory: TextView = itemView.findViewById(R.id.gameCategory)

        fun bind(games: Games){
            Glide
                .with(itemView.context)
                .load(games.thumbnail)
                .into(gameThumbnail)
            gameName.text = games.title
            gameText.text = games.short_description
            gameCategory.text = games.genre

        }
    }
}