import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';
import Navbar2 from "./Navbar1";

const All = () => {
  const [data2, setData2] = useState(null);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axios.get(`http://localhost:8081/product/products`, {
          headers: { 'Access-Control-Allow-Origin': '*' },
          proxy: { 
            host: 'http://cors-anywhere.herokuapp.com/',
            port: 80
          } 
        });
        setData2(response.data);
      } catch (error) {
        console.error(error);
      }
    };
    fetchData();
  }, []);

  return (
    
    <div>
      <Navbar2 />
      {!data2 ? (
        <div style={{textAlign: 'center', padding: '20px'}}>Loading...</div>
      ) : (
        <div style={{display: 'flex', flexWrap: 'wrap', justifyContent: 'center', alignItems: 'center'}}>
          {data2.map(product => (
            <div style={{width: '400px', height: '200px', background: '#f2f2f2', margin: '40px', textAlign: 'center', padding: '20px'}} key={product.id}>
              <h2 style={{color: '#0000ff'}}>{product.productName}</h2>
              <p><b>Company Name:</b> {product.companyName}</p>
              <p><b>Category:</b> {product.category}</p>
              <p><b>Price:</b> {product.price}</p>
              <p><b>Rating:</b> {product.rating}</p>
              <div style={{display: 'flex', justifyContent: 'center', marginTop: '30px'}}>
              <div style={{ display: 'flex', justifyContent: 'center' }}>
  <Link to={`/addfeedback?productId=${product.id}`}>
    <button style={{ margin: '5px' }}>Add Feedback</button>
  </Link>
  <div style={{ width: '80px' }}></div>
  <Link to={`/getfeedback?productId=${product.id}`}>
    <button style={{ margin: '5px' }}>View Feedback</button>
  </Link>
</div>
<li></li>

              </div>
            </div>
          ))}
        </div>
      )}
    </div>
  );
};

export default All;
