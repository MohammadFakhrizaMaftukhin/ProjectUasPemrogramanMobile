package com.k1.bmikalkulator_kelompok

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.k1.bmikalkulator_kelompok.Riwayat
import de.hdodenhof.circleimageview.CircleImageView

class RiwayatAdapter(private val data: List<Riwayat>) : RecyclerView.Adapter<RiwayatAdapter.RiwayatViewHolder>() {

    class RiwayatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val profileImage: CircleImageView = itemView.findViewById(R.id.profile_image)
        val genderIcon: ImageView = itemView.findViewById(R.id.gender)
        val textGender: TextView = itemView.findViewById(R.id.textViewGender)
        val textTinggi: TextView = itemView.findViewById(R.id.textViewTinggi)
        val textBerat: TextView = itemView.findViewById(R.id.textViewBerat)
        val textUmur: TextView = itemView.findViewById(R.id.textViewUmur)
        val textHasil: TextView = itemView.findViewById(R.id.textViewHasil)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RiwayatViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_riwayat, parent, false)
        return RiwayatViewHolder(view)
    }

    override fun onBindViewHolder(holder: RiwayatViewHolder, position: Int) {
        val item = data[position]
        holder.profileImage.setImageResource(item.profileImage)
        holder.genderIcon.setImageResource(item.genderIcon)
        holder.textGender.text = item.gender
        holder.textTinggi.text = "Tinggi Badan: ${item.tinggi}"
        holder.textBerat.text = "Berat Badan: ${item.berat}"
        holder.textUmur.text = "Umur: ${item.umur}"
        holder.textHasil.text = item.hasil
    }

    override fun getItemCount(): Int = data.size
}
