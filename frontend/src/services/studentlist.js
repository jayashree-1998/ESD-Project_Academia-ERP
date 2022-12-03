import axios from 'axios'

const studentUrl = `http://localhost:8080/academia_3_4-1.0-SNAPSHOT/api/student/getStudentByCourseId`

const getStudentByCourseId = async (courseID)=> {

    const response = await axios.get(`${studentUrl}/${courseID}`)
    console.log(response.data)
    return response.data
}
const exportObject = {getStudentByCourseId}
export default exportObject