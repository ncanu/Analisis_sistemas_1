package sample.ui.dashboard.student.response

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

open class StudentResponse
{
    @JsonProperty
    var id: Long? = null

    @JsonProperty
    var name: String? = null

    @JsonProperty
    var lastName: String? = null

    @JsonProperty
    var carnet: String? = null

    @JsonProperty
    var email: String? = null

    @JsonProperty
    var createdAt: Date? = null
}