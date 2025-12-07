package com.example.emergency_app.ui.emergency_contact

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.emergency_app.databinding.FragmentEmergencyContactBinding
import com.example.emergency_app.model.EmergencyContact



class EmergencyContactFragment : Fragment() {

    private var _binding: FragmentEmergencyContactBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEmergencyContactBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.username.text = "John Doe"

        val contacts = listOf(
            EmergencyContact(
                name = "Jane Smith",
                phoneNumber = "123-456-7890",
                relationship = "Sister",
                email = "jane@example.com",
                priority = 1,
                address = "123 Main St, Cityville"
            ),
            EmergencyContact(
                name = "Mike Johnson",
                phoneNumber = "987-654-3210",
                relationship = "Father",
                email = "mike@example.com",
                priority = 2,
                address = "456 Elm St, Townsville"
            )
        )

        binding.contactsRv.layoutManager = LinearLayoutManager(requireContext())
        binding.contactsRv.adapter = EmergencyContactAdapter(contacts)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}