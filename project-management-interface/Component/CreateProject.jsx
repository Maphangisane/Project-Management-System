import React, { useState, useEffect } from 'react';
import axios from 'axios'; // Import axios for making HTTP requests
import Sidebar from './Sidebar';
import Navbar from './Navbar';

function CreateProject() {
  const [contact, setContact] = useState({ title: '', description: '' });
  const updateContact = async () => {
    try {
      const response = await axios.post("http://localhost:8080/contact", contact);
      setContact(response.data);
      alert("Project Created")
    } catch (error) {
      console.error("Error creating project: ", error);
    }
  };

  const handleInputChange = (e) => {
    setContact({
      ...contact,
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
            <div className="Create_Project_Header"><h1>Create Project</h1></div>
            <div className="Create_Project_Para"><p>Lorem ipsum dolor sit amet consectetur. Volutpat est egestas elementum accumsan lorem et. Consequat condimentum dui enim natoque molestie volutpat sollicitudin tellus semper. Dolor nibh mauris sed sed tempor. Duis amet mauris morbi neque.</p></div>
            <div className="Form_Title_section">
              <p>Title</p>
              <input type="text" name="title" value={contact.title} onChange={handleInputChange} />
            </div>
            <div className="Form_Description_section">
              <p>Description</p>
              <textarea name="description" value={contact.description} onChange={handleInputChange} />
            </div>
            <div className="create_project_button_section">
              <button onClick={updateContact}>Create Project</button>
            </div>
          </div>
        </div>
      </div>
    </>
  );
}

export default CreateProject;
