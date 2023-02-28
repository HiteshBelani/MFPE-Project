
import React, { useState } from "react";
import { NavLink } from "react-router-dom";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faUser } from '@fortawesome/free-solid-svg-icons';
import { faComment } from '@fortawesome/free-solid-svg-icons';
import { faBriefcase } from '@fortawesome/free-solid-svg-icons';
import { faStar } from '@fortawesome/free-solid-svg-icons';
import { faThLarge } from '@fortawesome/free-solid-svg-icons';
import { faFont } from '@fortawesome/free-solid-svg-icons';
import { faHashtag } from '@fortawesome/free-solid-svg-icons';
import { faThList } from '@fortawesome/free-solid-svg-icons';



const Navbar2 = () => {
    const [showCategoryDropdown, setShowCategoryDropdown] = useState(false);
    const [showCompanyDropdown, setShowCompanyDropdown] = useState(false);
    const [showRatedDropdown, setShowRatedDropdown] = useState(false);
    const [showFeedbackDropdown, setShowFeedbackDropdown] = useState(false);
     const [showProfileDropdown, setShowProfileDropdown] = useState(false);
    

return (
<>
<nav className="main-nav2" style={{ backgroundColor: "#8adbdb" }}>

{/* 1st logo part */}
<div className="logo">
<h2>
<span>F</span>eedback
<span>M</span>anagement
</h2>
</div>

{/* 2nd menu part  */}
<div className="menu-link">
      <ul>
      <li>
  <NavLink to="/all">
    <FontAwesomeIcon icon={faThLarge} /> All Products
  </NavLink>
</li>
        
<li style={{ marginLeft: "15px" }}>
  <NavLink to="/productid">
    <FontAwesomeIcon icon={faHashtag} /> Product Id
  </NavLink>
</li>


<li style={{ marginLeft: "15px" }}>
  <NavLink to="/name">
    <FontAwesomeIcon icon={faFont} />
    Product Name
  </NavLink>
</li>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<li className="dropdown">
<span
  className="dropdown-title"
  onClick={() => setShowCategoryDropdown(!showCategoryDropdown)}
>
  <FontAwesomeIcon icon={faThList} />
  <span className="dropdown-text">Category</span>
</span>
  {showCategoryDropdown && (
    <ul className="dropdown-content">
      <li>
        <NavLink to="/Electronic">Electronics</NavLink>
      </li>
      <li>
        <NavLink to="/fashion">Fashion</NavLink>
      </li>
      <li>
        <NavLink to="/sports">Sports</NavLink>
      </li>           
    </ul>
  )}
</li>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<li className="dropdown">
  <span
    className="dropdown-title"
    onClick={() => setShowCompanyDropdown(!showCompanyDropdown)}
  >
    <FontAwesomeIcon icon={faBriefcase} className="dropdown-icon" />
    Company
  </span>
  {showCompanyDropdown && (
    <ul className="dropdown-content">
      <li>
        <NavLink to="/Samsung ">Samsung</NavLink>
      </li>
      <li>
        <NavLink to="/Adidas">Adidas</NavLink>
      </li>
      <li>
        <NavLink to="/Vivo">Vivo</NavLink>
      </li>
      <li>
        <NavLink to="/Asus ">Asus </NavLink>
      </li>
      <li>
        <NavLink to="/Realme">Realme</NavLink>
      </li>
      <li>
        <NavLink to="/NIVIA">NIVIA</NavLink>
      </li>
      <li>
        <NavLink to="/MARMAN"> MARMAN</NavLink>
      </li>
      <li>
        <NavLink to="/Louis philippe">Louis philippe</NavLink>
      </li>
      <li>
        <NavLink to="/Yonex">Yonex</NavLink>
      </li>
      <li>
        <NavLink to="/Boat">Boat</NavLink>
      </li>
      <li>
        <NavLink to="/APPLE">APPLE</NavLink>
      </li>
      <li>
        <NavLink to="/Nike">Nike</NavLink>
      </li>                  
    </ul>
  )}
</li>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<li className="dropdown">
<span
  className="dropdown-title"
  onClick={() => setShowRatedDropdown(!showRatedDropdown)}
>
  Rated {' '}
  <FontAwesomeIcon icon={faStar} style={{ marginRight: '5px' }} />
</span>

              {showRatedDropdown && (
                <ul className="dropdown-content">
                  <li>
                    <NavLink to="/topratedproducts">Top Rated </NavLink>
                  </li>
                  <li>
                    <NavLink to="/leastratedproducts">Least Rated</NavLink>
                  </li>
                   
                   
                </ul>
              )}
            
            
        </li>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <li className="dropdown">
  <span
    className="dropdown-title"
    onClick={() => setShowFeedbackDropdown(!showFeedbackDropdown)}
  >
    <FontAwesomeIcon icon={faComment} />
    Feedback
  </span>
  {showFeedbackDropdown && (
    <ul className="dropdown-content">
      <li>
        <NavLink to="/addfeedback">Add Feedback </NavLink>
      </li>
      <li>
        <NavLink to="/getfeedback">View Feedback</NavLink>
      </li>
      {/* <li>
        <NavLink to="/updaterating">UpdateRating</NavLink>
      </li> */}
    </ul>
  )}
</li>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<li className="dropdown" style={{ marginLeft: "15px" }}>
  <span className="dropdown-title" onClick={() => setShowProfileDropdown(!showProfileDropdown)}>
    <FontAwesomeIcon icon={faUser} /> Profile
  </span>
  {showProfileDropdown && (
    <ul className="dropdown-content">
      <li>
        <NavLink to="/updateprofile">Update Profile </NavLink>
      </li>
      <li>
        <NavLink to="/viewprofile">View Profile</NavLink>
      </li>
      <li>
        <NavLink to="/">Log Out</NavLink>
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

export default Navbar2;




