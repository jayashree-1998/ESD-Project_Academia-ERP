import '../App.css';
import LoginForm from './LoginForm'
import Logout from './Logout'
import loginService from '../services/login'
import courseService from '../services/course'
import CourseDetails from './CourseDetails'
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import { useState, useEffect } from 'react'

function LoginPage() {
    const [ user, setUser ] = useState(null)
    const [ course, setCourse] = useState([])
    const handleLogin = async (logincredentials) => {
        try {
            const userObject = await loginService.login(logincredentials)
            console.log(userObject)
            setUser(userObject)
            window.localStorage.setItem('loggedInUser', JSON.stringify(userObject))

            console.log("Success")
            toast.success(`Logged in successfully as ${userObject.firstName}!`);
            setCourse([])
        }
        catch (exception) {
            console.log("Unsuccessful")
            toast.error('Log in failed, check username and password entered');
            
        }
    }

    useEffect(() => {
        async function fetchData() {
          if (user) {
            const course = await courseService.getCourseByFaculty(user)
            setCourse(course)
          }
        }
        fetchData()
      }, [user])

    useEffect(() => {
        const loggedInUser = window.localStorage.getItem('loggedInUser')
        if (loggedInUser)
          setUser(JSON.parse(loggedInUser))
      }, [])

    return (
        <div>
            {
                user === null && <LoginForm showLogin = {handleLogin}/>
            }
            {
                user !== null && <CourseDetails course={course}/>
            }
            {
                user !== null && <Logout user={user} setUser={setUser}/>
            }
         <ToastContainer/>
        </div>
    );
}
export default LoginPage;