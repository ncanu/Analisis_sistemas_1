package sample.ui.login

import com.fasterxml.jackson.annotation.JsonProperty

open class LoginRequest
{
    @JsonProperty
    var email: String? = null

    @JsonProperty
    var password: String? = null
}