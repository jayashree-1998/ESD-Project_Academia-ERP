import React from 'react'
import Student from './StudentList'

const Students = ({students}) => {
    if(students === [])
        return null
    return (
    <div className='m-5 p-2 rounded regular-shadow'>
      <h2 className='ml-2'>Students Enrolled</h2>
      <table className = 'table'cellPadding={10}>
        <tr>
          <th>Name</th>
          <th>Roll Number</th>
        </tr>
        { 
          students.map(s => <Student student={s}/>)
        }
      </table>
    </div>
    )
}

export default Students