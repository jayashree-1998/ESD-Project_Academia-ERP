import React from 'react'
import Course from './Course'
const courses = ({course}) => {
    if(course === [])
        return null
    return (
    <div className='m-5 p-2 rounded regular-shadow'>
      <h2 className='ml-2'>Your Schedule</h2>
      <table className= 'table'cellPadding={10}> 
        <tr>
          <th>Course Name</th>
          <th>Course Year</th>
          <th>Coure Code</th>
          <th>Building</th>
          <th>Time</th>
          <th>Day</th>
          <th>Room</th>
          <th>Specialization Name</th>
        </tr>
        { 
          course.map(c => <Course course={c} key={c.courseID}/>)
        }
      </table>
    </div>
    )
}
export default courses