package sample.ui.dashboard.acc

import com.fasterxml.jackson.annotation.JsonProperty
import sample.network.ResponseBaseModel

class BankResponse : ResponseBaseModel()
{
    @JsonProperty
    var data: List<Bank>? = null
}