package com.infini8ai.naseemexecutive.model.requests


data class Data(
//    var user: User? = null,
//    var consignment: Consignment? = null,

    var _id: String? = null,
    var _rev: String? = null,
    var city: String? = null,
    var phoneno: String? = null,
    var organization_id: String? = null,
    var school_id: String? = null,
    var gendar: String? = null,
    var access: ArrayList<String>? = null,
    val organizationName: String?=null,
    val location: String?=null,
    val userType: Int?=null,
    val userName: String?=null,
    val email: String?=null,
    val status: Boolean?=null

)
