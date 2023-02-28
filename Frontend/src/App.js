import React, { useState } from "react";
import Navbar from "./components/Navbar";
import { Switch, Route } from "react-router-dom";
import Product from "./components/Product";
import ProductId from "./components/ProductId";
 import Dummy from "./components/Dummy";
import Dummy2 from "./components/Dummy2";
import All from "./components/All";
import Electronic from "./components/Electronic";
import Fashion from "./components/Fashion";
import Sports from "./components/Sports";
import Name from "./components/Name";
import Samsung from "./components/Samsung";
import TopRatedProducts from "./components/TopRatedProducts";
import LeastRatedProducts from "./components/LeastRatedProducts";
import Adidas from "./components/Adidas";
import Vivo from "./components/Vivo";
import Asus from "./components/Asus";
import Realme from "./components/Realme";
import Nivia from "./components/Nivia";
import Marman from "./components/Marman";
import Louisphilippe from "./components/Louisphilippe";
import Yonex from "./components/Yonex";
import Boat from "./components/Boat";
import Apple from "./components/Apple";
import Nike from "./components/Nike";
import Login from "./components/Login";
import SignUp from "./components/Signup";
import AddFeedback from "./components/AddFeedback";
import GetFeedback from "./components/GetFeedback";
import UpdateRating from "./components/UpdateRating";
import UpdateProfile from "./components/UpdateProfile";
import ViewProfile from "./components/ViewProfile";
import ViewMyFeedback from "./components/ViewMyFeedback";


const Home = () => {
return (
<>
<Navbar />
<section className="hero-section">
<p>WELCOME </p>
<p>TO</p>
<h1> FEEDBACK MANAGEMENT SYSTEM </h1>
</section>
</>
);
};

const Category = () => {
return (
<div >
hello
</div>
);
};


// const Name = () => {
//   return (
//     <div className="dialog-container">
//       <div className="dialog-header">
//         <h3>Product Name</h3>
//         <button className="close-btn">x</button>
//       </div>
//       <div className="dialog-body">
//         <form>
//           <div className="form-group">
//             <label htmlFor="product-id">Enter the name of the products from the listed below:</label>
//             <input
//               type="text"
//               id="product-id"
//               className="form-control"
//               placeholder="Enter Product Name"
//             />
//           </div>
//           <button className="submit-btn">Submit</button>
//         </form>
//       </div>
//     </div>
//   );
// };

const About = () => {
return (
<>
<Navbar />
<section className="hero-section">
<p>Welcome to </p>
<h1> About Page</h1>
</section>
</>
);
};

 

// const Login = () => {
//   return (
//     <div style={{ display: "flex", justifyContent: "center", alignItems: "center", height: "100vh" }}>
//       <form style={{ width: "30%", padding: "2rem", background: "#f2f2f2", borderRadius: "10px" }}>
//         <h1 style={{ textAlign: "center", marginBottom: "2rem" }}>Login</h1>
//         <div style={{ marginBottom: "1rem" }}>
//           <label htmlFor="username">Username:</label>
//           <input type="text" id="username" name="username" style={{ width: "100%", padding: ".5rem" }} />
//         </div>
//         <div style={{ marginBottom: "1rem" }}>
//           <label htmlFor="password">Password:</label>
//           <input type="password" id="password" name="password" style={{ width: "100%", padding: ".5rem" }} />
//         </div>
//         <button type="submit" style={{ width: "100%", padding: ".5rem", background: "lightblue", border: "none", borderRadius: "5px", color: "#fff" }}>
//           Submit
//         </button>
//       </form>
//     </div>
//   );
// };

// const SignUp = () => {
//   return (
  
//     <div style={{ display: 'flex', flexDirection: 'column', alignItems: 'center', justifyContent: 'center', height: '100vh' }}>
//       <h2>Sign Up</h2>
//       <form style={{ display: 'flex', flexDirection: 'column', alignItems: 'center', justifyContent: 'center', width: '50%' }}>
//         <input type="text" placeholder="Name" style={{ margin: '10px 0', padding: '10px', width: '100%' }} />
//         <input type="email" placeholder="Email" style={{ margin: '10px 0', padding: '10px', width: '100%' }} />
//         <input type="tel" placeholder="Phone Number" style={{ margin: '10px 0', padding: '10px', width: '100%' }} />
//         <input type="text" placeholder="Address" style={{ margin: '10px 0', padding: '10px', width: '100%' }} />
//         <input type="text" placeholder="Username" style={{ margin: '10px 0', padding: '10px', width: '100%' }} />
//         <input type="password" placeholder="Password" style={{ margin: '10px 0', padding: '10px', width: '100%' }} />
//         <input type="password" placeholder="Re-enter Password" style={{ margin: '10px 0', padding: '10px', width: '100%' }} />
        
//         <button type="submit" style={{ margin: '10px 0', padding: '10px', width: '100%', backgroundColor: 'blue', color: 'white' }}>Sign Up</button>
//       </form>
//     </div>
//     );
//   };

const Contact = () => {
return (
<>
<Navbar />
<section className="hero-section">
<p>Group Members </p>
<h1> Hitesh</h1>
<h1>Rohith</h1>

</section>
</>
);
};
 



const App = () => {
  return (
    <Switch>
      <Route exact path="/">
        <Home />
      </Route>

      <Route path="/about">
        <About />
      </Route>

       

      <Route path="/contact">
        <Contact />
      </Route>

      <Route path="/category">
        <Category />
      </Route>


      <Route path="/product">
        <Product />
      </Route>
      <Route path="/dummy">
        <Dummy />
      </Route>

      <Route exact path="/login">
        <Login />
      </Route>

      <Route exact path="/productid">
        <ProductId />
      </Route>

      <Route exact path="/name">
        <Name /> 
      </Route>
      <Route exact path="/signup">
        <SignUp />
      </Route>
      <Route path="/dummy2">
          <Dummy2 />
        </Route>
        <Route exact path="/all">
        <All />
      </Route>
      <Route exact path="/electronic">
        <Electronic />
      </Route>
      <Route exact path="/fashion">
        <Fashion />
      </Route>
      <Route exact path="/sports">
        <Sports />
      </Route>

      <Route exact path="/samsung">
        <Samsung />
      </Route>
      <Route exact path="/topratedproducts">
        <TopRatedProducts />
      </Route>

      <Route exact path="/leastratedproducts">
        <LeastRatedProducts />
      </Route>
      <Route exact path="/adidas">
        <Adidas />
      </Route>
      <Route exact path="/vivo">
        <Vivo />
      </Route>
      <Route exact path="/asus">
        <Asus />
      </Route>
      <Route exact path="/realme">
        <Realme />
      </Route>

      <Route exact path="/nivia">
        <Nivia />
      </Route>
      <Route exact path="/marman">
        <Marman />
      </Route>

      <Route exact path="/Louis philippe">
        <Louisphilippe />
      </Route>

      <Route exact path="/Yonex">
        <Yonex />
      </Route>

      <Route exact path="/Boat">
        <Boat />
      </Route>

      <Route exact path="/Apple">
        <Apple />
      </Route>

      <Route exact path="/Nike">
        <Nike />
      </Route>

      <Route exact path="/login">
        <Login />
      </Route>

      <Route exact path="/sigup">
        <SignUp />
      </Route>
      <Route exact path="/addfeedback">
        <AddFeedback />
      </Route>
      <Route exact path="/getfeedback">
        <GetFeedback />
      </Route>
      <Route exact path="/updaterating">
        <UpdateRating />
      </Route>
       
      <Route exact path="/updateprofile">
        <UpdateProfile />
      </Route>
      <Route exact path="/viewprofile">
        <ViewProfile />
      </Route>

      <Route exact path="/ViewMyFeedback">
        <ViewMyFeedback />
      </Route>

    </Switch>
  );
};

export default App;
