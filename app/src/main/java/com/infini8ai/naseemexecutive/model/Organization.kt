package com.infini8ai.naseemexecutive.model

data class Organization(
    val _id : String,
    val _rev : String,
    val organizationName : String,
    val location : String,
    val userType : Int,
    val userName : String,
    val email : String,
    val status : Boolean,
    val created_at : Int,
    val modified_at : Int,
    val disabled : Boolean,
    val access : List<String>
)
