package com.example.shemajamebeli

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ItemModel(var name: String, var lastName: String, var email: String) : Parcelable {
}