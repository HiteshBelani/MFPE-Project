import { useState } from "react";

const AddFeedback = () => {
  const [productId, setProductId] = useState("");
  const [feedback, setFeedback] = useState("");
  const [rating, setRating] = useState("");

  const handleProductIdChange = (event) => {
    setProductId(event.target.value);
  };

  const handleFeedbackChange = (event) => {
    setFeedback(event.target.value);
  };

  const handleRatingChange = (event) => {
    setRating(event.target.value);
  };

  const handleSubmit = (event) => {
    event.preventDefault();
  
    fetch("http://localhost:8083/feedback/addfeedback", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ productId, feedback, rating }),
    })
      .then((response) => {
        if (response.ok) {
          alert("Feedback successfully added");
        } else {
          throw new Error("Failed to submit feedback");
        }
        return response.json();
      })
      .then((data) => {
        console.log("Success:", data);
        // Optionally display a success message or redirect the user to a thank you page
      })
      .catch((error) => {
        console.error("Error:", error);
        alert("Feedback cannot be added since the product with the given ID does not exists.");
        // Optionally display an error message to the user
      });
  };
  

  return (
    <div className="add-feedback">
      <h2>Add Feedback</h2>
      <form onSubmit={handleSubmit}>
        <label htmlFor="product-id">Product ID:</label>
        <input
          type="text"
          id="product-id"
          value={productId}
          onChange={handleProductIdChange}
        />
        <label htmlFor="feedback">Feedback:</label>
        <textarea
          id="feedback"
          value={feedback}
          onChange={handleFeedbackChange}
        />
        <label htmlFor="rating">Rating:</label>
        <input
  type="number"
  id="rating"
  min="1"
  max="5"
  step="0.1"
  value={rating}
  onChange={handleRatingChange}
/>

        <button type="submit">Submit</button>
      </form>
    </div>
  );
};

export default AddFeedback;
