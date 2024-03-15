import CreateProject from "./Component/CreateProject"
import Guide from "./Component/Guide"
import ProjectSection from "./Component/ProjectSection";
import "./Component/styles/stylesheet.css"
import Home from "./Component/Home";
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';

function App() {
  return (
    <Router>
      <Routes>
        <Route  path="/project" element={<Home/>} />
        <Route  path="/" element={<Guide/>} />
        <Route  path="/createproject" element={<CreateProject/>} />
      </Routes>
    </Router>
  )
}

export default App
