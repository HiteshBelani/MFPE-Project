import React, { useState } from 'react';
import axios from 'axios';
import Navbar1 from "./Navbar1";

const ProductId = () => {
  const [productId, setProductId] = useState('');
  const [productData, setProductData] = useState(null);
  const [error, setError] = useState('');

  const handleSubmit = async (event) => {
    event.preventDefault();
    const pid = event.target.elements.productId.value;
    try {
      const response = await axios.get(`http://localhost:8081/product/product/${pid}`, {
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
    <div className="product-id-container">
      <h1 className="product-id-header"> </h1>
      <form onSubmit={handleSubmit} className="product-id-form">
        <label htmlFor="product-id" className="product-id-label">
          Enter Product ID:
        </label>
        <div className="product-id-input-wrapper">
          <input
            type="text"
            id="product-id"
            name="productId"
            className="product-id-input"
            placeholder="E.g. 12345"
            value={productId}
            onChange={(event) => setProductId(event.target.value)}
          />
          <button type="submit" className="product-id-submit">
            Lookup
          </button>
        </div>
        {error && <p className="product-id-error">{error}</p>}
      </form>
      {productData && (
        <div className="product-details">
          <h2 className="product-details-header">Product Details</h2>
          <table className="product-details-table">
            <tbody>
              <tr>
                <td className="product-details-label">Product ID:</td>
                <td className="product-details-value">{productData.id}</td>
              </tr>
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

export default ProductId;
