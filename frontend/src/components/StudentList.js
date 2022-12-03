import React from 'react'
const student= ({ student }) => {
    return (
        <tr>
          <td>{student.first_name}</td>
          <td>{student.roll_number}</td>
        </tr>
      )
    }   
export default student