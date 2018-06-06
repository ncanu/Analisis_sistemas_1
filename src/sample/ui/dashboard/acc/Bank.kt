package sample.ui.dashboard.acc

import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigDecimal

open class Bank
{
    @JsonProperty
    var id: Long? = null

    @JsonProperty
    var number: String? = null

    @JsonProperty
    var bank: String? = null

    @JsonProperty
    var balance: BigDecimal? = null
}