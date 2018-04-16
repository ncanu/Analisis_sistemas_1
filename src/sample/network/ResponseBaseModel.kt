package sample.network

import com.fasterxml.jackson.annotation.JsonProperty

open class ResponseBaseModel
{
    @JsonProperty
    var success: Boolean? = null

    @JsonProperty
    var message: String? = null


}