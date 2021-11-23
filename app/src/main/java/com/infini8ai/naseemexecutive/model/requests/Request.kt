package com.infini8ai.naseemexecutive.model.requests


data class Request(
    var method: String,
    var data: Data?= null
)
