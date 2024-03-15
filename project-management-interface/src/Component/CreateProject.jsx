import React, { useState, useEffect } from 'react';
import axios from 'axios'; // Import axios for making HTTP requests
import Sidebar from './Sidebar';
import Navbar from './Navbar';


function CreateProject() {
  const [project, setProject] = useState({project_id:0, title: '', description: '', membersList:[], tables:[]});

  const createProject = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post(`http://localhost:8080/project/createProject/${1}`, project);
      sessionStorage.setItem("projectId",response.data);
      window.location.href = "project";
    } catch (error) {
      console.error("Error creating project: ", error);
    }
  };
  const handleInputChange = (e) => {
    setProject({
      ...project,
      [e.target.name]: e.target.value,
    });
  };

  return (
    <>
      <div className="page-row">
        <Sidebar />
        <div className="project-wrapper">
          <Navbar />
          <div className="create-project-section">
              <div className="container">
                <h1 className="Create_Project_Header">Create Project</h1>
                <p className="Create_Project_Para">Lorem ipsum dolor sit amet consectetur. Volutpat est egestas elementum accumsan lorem et. Consequat condimentum 
                dui enim natoque molestie volutpat sollicitudin tellus semper. Dolor nibh mauris 
                sed sed tempor. Duis amet mauris morbi neque.</p>
                <form action="">
                  <div className="Form_Title_section">
                    <p>Project title</p>
                    <input onChange={handleInputChange} placeholder='Write project title' type="text" name="title"/>
                  </div>
                  <div className="Form_Description_section">
                    <p>Description</p>
                    <textarea onChange={handleInputChange} placeholder='Describe your project' name="description"/>
                  </div>
                  <div className="create_project_button_section">
                    <button onClick={createProject }>Create Project</button>
                  </div>
                </form>
                
              </div>
          </div>
        </div>
      </div>
    </>
  );
}

export default CreateProject;
