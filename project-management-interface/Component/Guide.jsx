import React from 'react';
import Navbar from './Navbar';
import Sidebar from './Sidebar';
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faLightbulb, faHouse } from '@fortawesome/free-solid-svg-icons';

function Guide() {
  return (
    <>
      <div className="page-row">
        <Sidebar />
        <div className="project-wrapper">
          <Navbar />
          <div className="guide-section">
          {/* <div className="guide__section"> */}
            <div className="Header_section_Guide">
              <p>OUR GUIDE</p>
            </div>
            <div className="Header_section">
              <h1>Getting Started</h1>
            </div>
            <div className="Paragraph_section">
              <p>Lorem ipsum dolor sit amet consectetur. Volutpat est egestas elementum accumsan lorem et. Consequat condimentum dui enim natoque molestie volutpat sollicitudin tellus semper. Dolor nibh mauris sed sed tempor. Duis amet mauris morbi neque.</p>
            </div>
            <div className="Cards_section">
              <div className="Cards">
                <div className="icon"><i className="lni lni-user"></i></div>
                <div className="Card_Content">
                <h4>SubTitle</h4>
                <p>Lorem ipsum dolor sit amet consectetur. Volutpat est egestas elementum accumsan lorem et. Consequat condimentum dui enim natoque molestie volutpat sollicitudin tellus semper. Dolor nibh mauris sed sed tempor. Duis amet mauris morbi neque.</p>
                </div>
              </div>
              <div className="dashed-line-1"></div>
              <div className="Cards special">
                <div className="icon"><i className="lni lni-agenda"></i></div>
                <div className="Card_Content">
                <h4>SubTitle</h4>
                <p>Lorem ipsum dolor sit amet consectetur. Volutpat est egestas elementum accumsan lorem et. Consequat condimentum dui enim natoque molestie volutpat sollicitudin tellus semper. Dolor nibh mauris sed sed tempor. Duis amet mauris morbi neque.</p>
                </div></div>
              <div className="dashed-line-2"></div>
              <div className="Cards">
                <div className="icon"><i className="lni lni-upload"></i></div>
                <div className="Card_Content">
                <h4>SubTitle</h4>
                <p>Lorem ipsum dolor sit amet consectetur. Volutpat est egestas elementum accumsan lorem et. Consequat condimentum dui enim natoque molestie volutpat sollicitudin tellus semper. Dolor nibh mauris sed sed tempor. Duis amet mauris morbi neque.</p>
                </div></div>
            </div>
            <div className="button_section">
              <button>Create Project</button>
            </div>
            
            {/* </div> */}
          </div>
        </div>
      </div>
    </>
  )
}

export default Guide;
