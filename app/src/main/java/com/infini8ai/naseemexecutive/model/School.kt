package com.infini8ai.naseemexecutive.model

import java.io.Serializable

data class School(
    var _id: String? = null,
    var _rev: String? = null,
    var location: String? = null,
    var schoolName: String? = null,
    var seen: Boolean? = null,
    var status: Boolean? = null,
    var organizationID: String? = null,
    var created_at: String? = null,
    var disable: Boolean? = null,
    ): Serializable
