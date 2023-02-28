import React, { useState } from "react";
import "./navbar.css";
import { NavLink } from "react-router-dom";

const Navbar = () => {
  const [showMediaIcons, setShowMediaIcons] = useState(false);
  const [showProductDropdown, setShowProductDropdown] = useState(false);
  const [showLoginDropdown, setShowLoginDropdown] = useState(false);

  return (
    <>
      <nav className="main-nav" style={{backgroundColor: ""}}>
        {/* 1st logo part  */}
        <div className="logo">
          <h2>
            <span>F</span>eedback
            <span>M</span>anagement
          </h2>
        </div>

        {/* 2nd menu part  */}
        <div
          className={
            showMediaIcons ? "menu-link mobile-menu-link" : "menu-link"
          }>
          <ul>
            <li>
              <NavLink to="/">Home</NavLink>
            </li>
            <li>
              <NavLink to="/about">about</NavLink>
            </li>
            {/* <li>
              <NavLink to="/product">Product</NavLink>
            </li> */}
            
            <li>
              <NavLink to="/contact">contact</NavLink>
            </li>
            
            <li className="dropdown">
              <span
                className="dropdown-title"
                onClick={() => setShowLoginDropdown(!showLoginDropdown)}
              >
                Login
              </span>
              {showLoginDropdown && (
                <ul className="dropdown-content">
                  <li>
                    <NavLink to="/Login">Login</NavLink>
                  </li>
                  <li>
                    <NavLink to="/Signup">Sign up</NavLink>
                  </li>
                  
                  
                </ul>
              )}
            </li>
          </ul>
        </div>
      </nav>
    </>
  );
};
export default Navbar;
