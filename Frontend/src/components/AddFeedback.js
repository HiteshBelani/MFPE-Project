import React, { useState, useEffect } from "react";
import { useLocation } from "react-router-dom";
import Navbar1 from "./Navbar1";

const AddFeedback = () => {
  const location = useLocation();
  const productId = new URLSearchParams(location.search).get("productId");

  const [feedback, setFeedback] = useState("");
  const [rating, setRating] = useState("");
  const [alertMessage, setAlertMessage] = useState("");
  const userName = localStorage.getItem("username");

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
      body: JSON.stringify({ productId, feedback, rating , userName}),
    })
      .then((response) => {
        if (response.ok) {
          setAlertMessage(<span style={{fontSize: "1.9em", color: "green"}}>Feedback successfully added</span>);
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
        setAlertMessage("Feedback cannot be added since the product with the given ID does not exist.");
        // Optionally display an error message to the user
      });
  };

  useEffect(() => {
    if (alertMessage) {
      const timer = setTimeout(() => {
        setAlertMessage("");
      }, 5000);
      return () => clearTimeout(timer);
    }
  }, [alertMessage]);

  return (
    <>
    <Navbar1 />
    <div className="add-feedback">
      <h1>Add Feedback</h1>
      {alertMessage && <div className="alert">{alertMessage}</div>}
      <form onSubmit={handleSubmit}>
        {/* <label htmlFor="product-id">Product ID:</label> */}
        {/* <input type="text" id="product-id" value={productId} disabled /> */}
        <label htmlFor="feedback">Feedback:</label>
        <textarea id="feedback" value={feedback} onChange={handleFeedbackChange} />
        <label htmlFor="rating">Rating:</label>
        <input type="number" id="rating" min="1" max="5" step="0.1" value={rating} onChange={handleRatingChange} />

        <button type="submit">Submit</button>
      </form>
    </div>
    </>
  );
};

export default AddFeedback;
