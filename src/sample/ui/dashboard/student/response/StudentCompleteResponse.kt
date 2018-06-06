package sample.ui.dashboard.student.response

import com.fasterxml.jackson.annotation.JsonProperty
import sample.network.ResponseBaseModel

class StudentCompleteResponse : ResponseBaseModel()
{
    @JsonProperty
    var data: List<StudentResponse>? = null
}