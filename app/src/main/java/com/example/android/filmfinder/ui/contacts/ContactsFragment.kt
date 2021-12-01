package com.example.android.filmfinder.ui.contacts

import android.Manifest
import android.content.pm.PackageManager
import android.database.Cursor
import android.os.Bundle
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.android.filmfinder.R
import com.example.android.filmfinder.databinding.FragmentContactsBinding

class ContactsFragment : Fragment() {
    private var _binding: FragmentContactsBinding? = null
    private val binding get() = _binding!!

    private val permissionResult = registerForActivityResult(ActivityResultContracts.RequestPermission()) { result ->
        if (result) {
            getContacts()
        } else {
            Toast.makeText(
                context,
                getString(R.string.permission_to_read_contacts),
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentContactsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkPermission()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun addView(name: String) = with(binding) {
        containerForContacts.addView(TextView(requireContext()).apply {
            text = name
            textSize = resources.getDimension(R.dimen.main_container_text_size)
        })
    }

    private fun checkPermission() {
        context?.let { notNullContext ->
            when (PackageManager.PERMISSION_GRANTED) {
                ContextCompat.checkSelfPermission(notNullContext, Manifest.permission.READ_CONTACTS) -> {
                    //Access to contacts on the phone
                    getContacts()
                }
                else -> {
                    //Requesting permission
                    requestPermission()
                }
            }
        }
    }

    private fun requestPermission() {
        permissionResult.launch(Manifest.permission.READ_CONTACTS)
    }

    private fun getContacts() {
        context?.let { nonNullContext ->
            // We send a request to receive contacts and receive a response in the form Cursor
            val cursorWithContacts: Cursor? = nonNullContext.contentResolver.query(
                ContactsContract.Contacts.CONTENT_URI,
                null,
                null,
                null,
                ContactsContract.Contacts.DISPLAY_NAME + " ASC"
            )

            cursorWithContacts?.let { cursor ->
                for (i in 0..cursor.count) {
                    // We go to a position to Cursor
                    if (cursor.moveToPosition(i)) {
                        // We take from Cursor a column with the name
                        val name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))
                        addView(name)
                    }
                }
            }
            cursorWithContacts?.close()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = ContactsFragment()
    }
}