package sample.ui.dashboard.inventory.response

import com.fasterxml.jackson.annotation.JsonProperty

open class Inventory
{
    @JsonProperty
    var id: Long? = null

    @JsonProperty
    var name: String? = null

    @JsonProperty
    var code: String? = null

    @JsonProperty
    var existence: Long? = null

    override fun toString(): String {
        return ""+name
    }


}