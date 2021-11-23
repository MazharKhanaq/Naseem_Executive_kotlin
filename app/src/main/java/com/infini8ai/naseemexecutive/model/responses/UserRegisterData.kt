package com.infini8ai.naseemexecutive.model.responses

import com.infini8ai.naseemexecutive.model.Organization
import com.infini8ai.naseemexecutive.model.School


data class UserRegisterData(
    val user: String,
    val error: String,



    val result: String,
    val organization : Organization,
    var schools: Collection<School>,


//    var dashboard_array: Collection<DispatchItem>,
//    var consignmentsByCity: Collection<Consignment>
)



