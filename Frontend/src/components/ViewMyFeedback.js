import axios from "axios";
import { useEffect, useState } from "react";
import Navbar1 from "./Navbar1";

function ViewMyFeedback(){
    const userName = localStorage.getItem('username');
    const [data,setData] = useState([]);
    const [productName,setProductName] = useState();
    const [id,setId] = useState(1);
    const [successMessage, setSuccessMessage] = useState("");
  const [errorMessage, setErrorMessage] = useState("");
    useEffect(()=>{
        axios.get(`http://localhost:8083/feedback/getmyfeedback/${userName}`
       )
       .then(result=>{
           setData(result.data);
          
       }).catch(error=>{
        //    alert(error)
        setErrorMessage(`You have not given any feedback until now!!!Go to products to give Feedback`);
       })
        
   },[])

    return (
        <>
    <Navbar1 />
    <div>
    <span style={{ color: 'red' , fontSize: '20px',paddingTop: '25px', marginTop:'30px', marginLeft: '30%'}}>{errorMessage}</span>
        {data.map((item) => (
        <div className="feedback" key={item.id}>
          <p><b>Product ID:</b> {item.productId}</p> 
          <p><b>Product Name:</b> {item.productName}</p>
          <p><b>Feedback:</b> {item.feedback}</p>
          <p><b>Rating:</b> {item.rating}</p>
        </div>
      ))}
    </div>
    </>
    )
}

export default ViewMyFeedback;