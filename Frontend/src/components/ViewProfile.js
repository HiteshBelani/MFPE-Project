import { useState } from "react";

const ViewProfile = () => {
  const [id, setId] = useState("");
  const [customer, setCustomer] = useState(null);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);

  const handleSubmit = async (e) => {
    e.preventDefault();
    setLoading(true);

    try {
      const token = localStorage.getItem("token");
      const response = await fetch(`http://localhost:8082/customer/getcustomer/${id}`, {
        method: "GET",
        headers: {
          "Content-Type": "application/json",
          "Authorization": `Bearer ${token}`
        }
      });

      if (response.ok) {
        const data = await response.json();
        setCustomer(data);
      } else {
        const error = await response.text();
        throw new Error(error);
      }
    } catch (error) {
      setError(error.message);
    } finally {
      setLoading(false);
    }
  };

  if (loading) {
    return <p>Loading customer data...</p>;
  }

  return (
    <div className="container">
      <form onSubmit={handleSubmit}>
        <input type="text" value={id} onChange={(e) => setId(e.target.value)} />
        <button type="submit">Enter Your Customer Id </button>
      </form>
      {error && <p>{error}</p>}
      {customer && (
        <div className="customer-container">
          <h2>Customer Data:</h2>
          <p>ID: {customer.id}</p>
          <p>Name: {customer.name}</p>
          <p>Email: {customer.emailId}</p>
          <p>Phone: {customer.phoneNo}</p>
          <p>Address: {customer.address}</p>
        </div>
      )}
    </div>
  );
};

export default ViewProfile;
