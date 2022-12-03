import React from 'react'
import {
    Button,
  } from "antd";
const courses = ({ course }) => {
    const getStudent = () => {
        window.location.replace(`/student/${course.courseID}`)
    }
    console.log(course)
    return (
          course.courseSchedules.map(cs =>
            course.specializationList.map(sp=>
              
              <tr>
                <td><Button onClick={getStudent}>{course.name}</Button></td>
                <td>{course.year}</td>
                <td>{course.courseCode}</td>
                <td>{cs.building}</td>
                <td>{cs.time}</td>
                <td>{cs.day}</td>
                <td>{cs.room}</td>
                <td>{sp.name}</td>
              </tr>
              
            )
          )          
    )
}
export default courses