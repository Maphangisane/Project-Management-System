import React from 'react'
import logo from "../assets/logo.png";

function Sidebar() {
  return (
    <>
    <div className="sidebar">
        <h6 className='logo'><img src={logo} alt="" /><span> Algoexperts</span></h6>
        <a href='/createproject' id='sidebar-create-btn'>Create project <i class="lni lni-plus"></i></a>
        <div className="sidebar-links">
            <span id='sidebar-subtitle'>dashboard</span>
            <a href=""><i className="lni lni-briefcase"></i> School project  </a>
            <a href="/">  <i id='info' className=" lni lni-information"></i> Guide </a>
        </div>
    </div>
    </>
  )
}

export default Sidebar