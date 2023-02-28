import React, { useState } from 'react';
import axios from 'axios';
import Navbar1 from './Navbar1';

const ProductName = () => {
  const [productName, setProductName] = useState('');
  const [productData, setProductData] = useState(null);
  const [error, setError] = useState('');

  const handleSubmit = async (event) => {
    event.preventDefault();
    const name = event.target.elements.productName.value;
    try {
      const response = await axios.get(`http://localhost:8081/product/productname/${name}`, {
        headers: { 'Access-Control-Allow-Origin': '*' },
        proxy: {
          host: 'http://cors-anywhere.herokuapp.com/',
          port: 80,
        },
      });
      setProductData(response.data);
      setError('');
    } catch (error) {
      console.error(error);
      setProductData(null);
      setError('Product not found!');
    }
  };

  return (
    <>
    <Navbar1 />
    <div className="product-name-container">
      <h1 className="product-name-header"> </h1>
      <form onSubmit={handleSubmit} className="product-name-form">
        <label htmlFor="product-name" className="product-name-label">
          Enter Product Name:
        </label>
        <div className="product-name-input-wrapper">
          <input
            type="text"
            id="product-name"
            name="productName"
            className="product-name-input"
            placeholder="E.g. Product Name"
            value={productName}
            onChange={(event) => setProductName(event.target.value)}
          />
          <button type="submit" className="product-name-submit">
            Lookup
          </button>
        </div>
        {error && <p className="product-name-error">{error}</p>}
      </form>
      {productData && (
        <div className="product-details">
          <h2 className="product-details-header">Product Details</h2>
          <table className="product-details-table">
            <tbody>
              <tr>
                <td className="product-details-label">Product Name:</td>
                <td className="product-details-value">{productData.productName}</td>
              </tr>
              <tr>
                <td className="product-details-label">Company Name:</td>
                <td className="product-details-value">{productData.companyName}</td>
              </tr>
              <tr>
                <td className="product-details-label">Category:</td>
                <td className="product-details-value">{productData.category}</td>
              </tr>
              <tr>
                <td className="product-details-label">Price:</td>
                <td className="product-details-value">{productData.price.toFixed(2)}</td>
              </tr>
              <tr>
                <td className="product-details-label">Rating:</td>
                <td className="product-details-value">{productData.rating.toFixed(1)}</td>
              </tr>
            </tbody>
          </table>
        </div>
      )}
    </div>
    </>
  );
};

export default ProductName;
