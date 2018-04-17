package sample.ui.dashboard.student.response

import com.fasterxml.jackson.annotation.JsonProperty

open class CourseResponse
{

    @JsonProperty
    var id: Long? = null

    @JsonProperty
    var name: String? = null

    @JsonProperty
    var section: String? = null

    override fun toString(): String {
        return "$name $section"
    }


}