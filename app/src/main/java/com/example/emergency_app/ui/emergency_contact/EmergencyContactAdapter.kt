package com.example.emergency_app.ui.emergency_contact

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.emergency_app.R
import com.example.emergency_app.model.EmergencyContact

class EmergencyContactAdapter (
    private val items: List<EmergencyContact>
) : RecyclerView.Adapter<EmergencyContactAdapter.VH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_emergency_contact, parent, false)
        return VH(v)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val contactName: TextView = itemView.findViewById(R.id.tvContactNameRel)
        private val contactPhone: TextView = itemView.findViewById(R.id.tvPhone)
        private val contactEmail: TextView = itemView.findViewById(R.id.tvEmail)
        private val contactPriority: TextView = itemView.findViewById(R.id.tvPriority)
        private val contactAdress: TextView = itemView.findViewById(R.id.tvAddress)

        private val btnCall: ImageButton = itemView.findViewById(R.id.btnCall)

        fun bind(contact: EmergencyContact) {
            contactName.text = "${contact.name} - ${contact.relationship}"
            contactPhone.text = "Phone: ${contact.phoneNumber}"
            contactEmail.text = "Email: ${contact.email ?: "N/A"}"
            contactPriority.text = "Priority: ${contact.priority}"
            contactAdress.text = "Address: ${contact.address ?: "N/A"}"

            // to implement btnCall functionality later
        }
    }
}