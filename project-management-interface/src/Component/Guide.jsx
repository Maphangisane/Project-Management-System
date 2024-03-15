import React from 'react';
import Navbar from './Navbar';
import Sidebar from './Sidebar';


function Guide() {
  return (
    <>
      <div className="page-row">
        <Sidebar />
        <div className="project-wrapper">
          <Navbar />
          <div className="guide-section">
          {/* <div className="guide__section"> */}
            <div className="container">
              <div className="Header_section">
                <span>our guide page</span>
                <h1>Getting Started</h1>
              </div>
              <p id='Paragraph_section'>Hello and welcome to ProjectMaster! We're delighted to have you join
               our community of project managers and teams who are achieving remarkable success with our powerful project
                management platform.We're excited to be a part of your project management journey and can't wait to see the amazing things you'll achieve!
              </p>
              <h6 id='steps_title'>Our Easy to use steps: </h6>
              <div className="Cards_section">
                
                <div className="Cards">
                  <div className="icon"><i className="lni lni-user"></i></div>
                  <h4>Paragraph one</h4>
                  <p> dui enim natoque molestie volutpat sollicitudin tellus semper. Dolor nibh mauris sed sed tempor. Duis amet mauris morbi neque.</p>
                </div>
                <div className="dashed-line-1"></div>
                <div className="Cards special">
                  <div className="icon"><i className="lni lni-agenda"></i></div>
                  <h4>SubTitle</h4>
                  <p> dui enim natoque molestie volutpat sollicitudin tellus semper. Dolor nibh mauris sed sed tempor. Duis amet mauris morbi neque.</p>
                </div>
                <div className="dashed-line-2"></div>
                <div className="Cards">
                  <div className="icon"><i className="lni lni-upload"></i></div>
                  <h4>SubTitle</h4>
                  <p> dui enim natoque molestie volutpat sollicitudin tellus semper. Dolor nibh mauris sed sed tempor. Duis amet mauris morbi neque.</p>
                </div>
                <div className="Cards special">
                    <div className="icon"><i className="lni lni-agenda"></i></div>
                    <h4>SubTitle</h4>
                    <p> dui enim natoque molestie volutpat sollicitudin tellus semper. Dolor nibh mauris sed sed tempor. Duis amet mauris morbi neque.</p>
                </div>
              </div>
              <div className="button_section">
                <a href='createproject'>Create Project</a>
              </div>
            </div>
            
            {/* </div> */}
          </div>
        </div>
      </div>
    </>
  )
}

export default Guide;
