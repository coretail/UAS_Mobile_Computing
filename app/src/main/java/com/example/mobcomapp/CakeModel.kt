package com.example.mobcomapp

import android.provider.ContactsContract

data class CakeModel (
    val cakes: List<Data>
) {
    data class Data (val id: String?, val cake_name: String?, val cake_img: String?)
}