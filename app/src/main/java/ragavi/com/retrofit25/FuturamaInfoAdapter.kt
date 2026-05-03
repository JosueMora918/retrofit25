package ragavi.com.retrofit25

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FuturamaInfoAdapter (
    private val list: List<FuturamaInfo>
) : RecyclerView.Adapter<FuturamaInfoAdapter.FuturamaViewHolder>() {

    class FuturamaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
       val txtYears: TextView = view.findViewById(R.id.txtYears)
        val txtSynopsis: TextView = view.findViewById(R.id.txtSynopsis)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FuturamaViewHolder {
        // Cambiamos R.layout.item_futurama por tu nuevo diseño (ej. item_futurama)
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_futurama, parent, false)
        return FuturamaViewHolder(view)
    }

    override fun onBindViewHolder(holder: FuturamaViewHolder, position: Int) {
        val info = list[position]

        holder.txtYears.text = "Años en emisión: ${info.yearsAired}"
        holder.txtSynopsis.text = info.synopsis
    }

    override fun getItemCount() = list.size
}