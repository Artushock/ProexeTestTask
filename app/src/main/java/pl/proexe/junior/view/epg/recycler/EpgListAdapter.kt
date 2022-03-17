package pl.proexe.junior.view.epg.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import pl.proexe.junior.databinding.EpgListItemBinding
import pl.proexe.junior.model.data.TvProgramme
import java.text.SimpleDateFormat

class EpgListAdapter(private val programmes: List<TvProgramme>): RecyclerView.Adapter<EpgListAdapter.EpgViewHolder>() {

    class EpgViewHolder(private val binding: EpgListItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(programme: TvProgramme) {
            binding.epgItemTitle.text = programme.title

            val formatter = SimpleDateFormat("HH:mm")
            val startTime = formatter.format(programme.startTime)
            val endTime = formatter.format(programme.endTime)
            binding.epgItemDescription.text = "$startTime - $endTime | ${programme.type}"

            binding.epgItemProgress.progress = programme.progressPercent


            Glide.with(binding.epgItemLogo)
                .load(programme.imageUrl)
                .into(binding.epgItemLogo)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpgViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = EpgListItemBinding.inflate(inflater, parent, false)
        return EpgViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EpgViewHolder, position: Int) {
        holder.bind(programmes[position])
    }

    override fun getItemCount() = programmes.size
}