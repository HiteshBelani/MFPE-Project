import axios from "axios";
import { useEffect, useState } from "react";
import Navbar1 from "./Navbar1";

const UpdateProfile = () => {
  const [id, setId] = useState("");
  const [name, setName] = useState("");
  const [emailId, setEmailId] = useState("");
  const [phoneNo, setPhoneNo] = useState("");
  const [address, setAddress] = useState("");
  const [successMessage, setSuccessMessage] = useState("");
  const [errorMessage, setErrorMessage] = useState("");
  const [data, setData ] =useState("")
  const userName = localStorage.getItem('username');
  const token = localStorage.getItem('token');
  useEffect(()=>{
    axios.get(`http://localhost:8082/customer/getcustomer/${userName}`,
    { headers: { Authorization: `Bearer ${token}` } }
   )
   .then(result=>{
       setId(result.data.id);
       setName(result.data.name);
       setEmailId(result.data.emailId);
       setPhoneNo(result.data.phoneNo);
       setAddress(result.data.address);
      
   }).catch(error=>{
       alert(error)
   })
},[])
  const handleSubmit = async (e) => {
    e.preventDefault();

    const data = {
      id,
      name,
      emailId,
      phoneNo,
      address
    };
    

    const token = localStorage.getItem("token");

    const response = await fetch("http://localhost:8082/customer/updatecustomer", {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
        "Authorization": `Bearer ${token}`
      },
      body: JSON.stringify(data)
    });
    // axios.get(`http://localhost:8082/customer/getcustomer/${id}`)

    if (response.ok) {
      setSuccessMessage("Customer details updated successfully.");
      setErrorMessage("");
    } else {
      setSuccessMessage("");
      const error = await response.text();
      setErrorMessage(`Error updating customer details: ${error}`);
    }
  };

  return (
    <>
    <Navbar1 />
    <div style={{display: 'flex', flexDirection: 'column', alignItems: 'center', backgroundColor: '#f2f2f2'}}>
    <span style={{ color: 'red' , fontSize: '18px',paddingTop: '25px'}}>{errorMessage}</span>
    <span style={{ color: 'green' , fontSize: '18px',paddingTop: '25px'}}>{successMessage}</span>
    <form style={{display: 'flex', flexDirection: 'column', width: '300px'}} onSubmit={handleSubmit}>
        <label>ID:</label>
          <input type="text" value={id} onChange={(e) => setId(e.target.value)} />
        <br />
        <label>Name:</label>
          <input type="text" value={name} onChange={(e) => setName(e.target.value)} />
        <br />
        <label>Email: </label>
          <input type="text" value={emailId} onChange={(e) => setEmailId(e.target.value)} />
        <br />
        <label>Phone:</label>
          <input type="text" value={phoneNo} onChange={(e) => setPhoneNo(e.target.value)} />
        <br />
        <label>Address:</label>
          <input type="text" value={address} onChange={(e) => setAddress(e.target.value)} />
        <br />
        <button type="submit">Update</button>
        <br />
      </form>
    </div>
    </>
  );
};

export default UpdateProfile;
