import Login from './components/LoginPage'
import { BrowserRouter as Router, Switch, Route, Redirect} from "react-router-dom";
import StudentPage from './components/StudentPage';

function App(){
  return(
    <Router>
      <Switch>
      <Route path="/student/:uid">
        <StudentPage></StudentPage>
      </Route>
      <Route path="/login">
        <Login></Login>
      </Route>
      <Route exact path="/">
        <Redirect to="/login" />
      </Route>
      </Switch>
    </Router>
  )
}
export default App;
