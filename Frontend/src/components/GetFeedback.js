import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useLocation } from 'react-router-dom';
import Navbar1 from './Navbar1';

const GetFeedback = () => {
  const location = useLocation();
  const [productId, setProductId] = useState(new URLSearchParams(location.search).get('productId') || '');
  const [productData, setProductData] = useState([]);

  const handleSubmit = async (event) => {
    event.preventDefault();
    const pid = event.target.elements.productId.value;
    try {
      const response = await axios.get(`http://localhost:8083/feedback/getfeedback/${pid}`, {
        headers: { 'Access-Control-Allow-Origin': '*' },
        proxy: { 
          host: 'http://cors-anywhere.herokuapp.com/',
          port: 80
        }
      });
      setProductData(response.data);
      console.log(response.data);
    } catch (error) {
      console.error(error);
    }
  };

  useEffect(()=>{
      axios.get(`http://localhost:8083/feedback/getfeedback/${productId}`)
      .then(result => {
        setProductData(result.data)
      }).catch(error => {

      })
},[])

  return (
    <>
    <Navbar1 />
    <div className="feedback-container">
      <center><h3>Product Feedbacks</h3></center>
      {productData.map((feedback, index) => (
        <div className="feedback" key={index}>
          <p><b>Product Id:</b> {feedback.productId}</p>
          <p><b>User:</b> {feedback.userName}</p>
          <p><b>Feedback:</b> {feedback.feedback}</p>
          <p><b>Rating:</b> {feedback.rating}</p>
        </div>
      ))}
    </div>
    </>
  );
};

export default GetFeedback;
