import { useState, useEffect } from "react";

const Dummy = () => {
  const [productId, setProductId] = useState("");
  const [rating, setRating] = useState("");
  const [productData, setProductData] = useState([]);

  const handleProductIdChange = (event) => {
    setProductId(event.target.value);
  };

  const handleRatingChange = (event) => {
    setRating(event.target.value);
  };

  const handleSubmit = (event) => {
    event.preventDefault();

    fetch("http://localhost:8081/product/updaterating", {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ productId, rating }),
    })
      .then((response) => {
        if (!response.ok) {
          throw new Error("Failed to update rating");
        }
        return response.json();
      })
      .then((data) => {
        console.log("Success:", data);
        // Update the product data state with the updated product data
        setProductData([data]);
      })
      .catch((error) => {
        console.error("Error:", error);
        // Optionally display an error message to the user
      });
  };

  useEffect(() => {
    fetch("http://localhost:8081/product/product/" + productId)
      .then((response) => {
        if (!response.ok) {
          throw new Error("Failed to fetch product");
        }
        return response.json();
      })
      .then((data) => {
        setProductData([data]);
      })
      .catch((error) => {
        console.error("Error:", error);
        // Optionally display an error message to the user
      });
  }, [productId]);

  return (
    <div className="update-rating">
      <h2>Update Rating</h2>
      <form onSubmit={handleSubmit}>
        <label htmlFor="product-id">Product ID:</label>
        <input
          type="text"
          id="product-id"
          value={productId}
          onChange={handleProductIdChange}
        />
        <label htmlFor="rating">Rating:</label>
        <input
          type="number"
          id="rating"
          min="1"
          max="5"
          value={rating}
          onChange={handleRatingChange}
        />
        <button type="submit">Update</button>
      </form>
      {productData.map((product, index) => (
        <div key={index}>
          <p><b>Product ID:</b> {product.id}</p>
          <p><b>Product Name:</b> {product.productName}</p>
          <p><b>Company Name:</b> {product.companyName}</p>
          <p><b>Category:</b> {product.category}</p>
          <p><b>Price:</b> {product.price}</p>
          <p><b>Rating:</b> {product.rating}</p>
        </div>
      ))}
    </div>
  );
};

export default Dummy;
