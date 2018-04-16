package sample.ui.login

import com.fasterxml.jackson.annotation.JsonProperty

open class Data{

    @JsonProperty
    var token: String? = null

    @JsonProperty
    var loginTime: Long? = null
}