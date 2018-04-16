package sample.ui.login

import com.fasterxml.jackson.annotation.JsonProperty
import sample.network.ResponseBaseModel

class LoginResponse : ResponseBaseModel()
{
    @JsonProperty
    var data: Data? = null
}