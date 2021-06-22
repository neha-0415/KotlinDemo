package com.example.myapp

class DataManager {

    var courses = HashMap<String,CourseInfo>()
    var notes = ArrayList<NoteInfo>()

    init{
        initCourse()
    }


    private fun initCourse(){
        var course = CourseInfo("sonet2021-kotlin","Android development with Kotlin")
        courses.put(course.courseID,course)

        course = CourseInfo("sonet2021-react","Android development with ReactJS")
        courses.put(course.courseID,course)

        course = CourseInfo("sonet2021-ML","Machine Learning")
        courses.put(course.courseID,course)
    }
}