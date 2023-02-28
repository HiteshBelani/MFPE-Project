import React, { useState } from "react";
import axios from "axios";

const Login = () => {
  const [userName, setUserName] = useState("");
  const [password, setpassword] = useState("");
  const [errorMessage, setErrorMessage] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await axios.post("http://localhost:8400/auth/authenticate", { userName, password });
      const token = response.data.token;

      // Store token in local storage
      localStorage.setItem("token", token);
      localStorage.setItem("username", userName);
      // Redirect to dashboard or home page
      window.location.href = "/product";
    } catch (err) {
      console.error(err);
      setErrorMessage("Invalid login credentials");
    }
  };

  return (
    <div style={{ display: "flex", justifyContent: "center", alignItems: "center", height: "100vh", background: "#55d99f" }}>
      <form style={{ width: "30%", padding: "2rem", borderRadius: "10px", background: "#fff" }} onSubmit={handleSubmit}>
        <h1 style={{ textAlign: "center", marginBottom: "2rem" }}>Login</h1>
        <div style={{ marginBottom: "1rem" }}>
          <label htmlFor="username">Username:</label>
          <input type="text" id="userName" name="username" style={{ width: "100%", padding: ".5rem" }} onChange={(e) => setUserName(e.target.value)} />
        </div>
        <div style={{ marginBottom: "1rem" }}>
          <label htmlFor="password">Password:</label>
          <input type="password" id="password" name="password" style={{ width: "100%", padding: ".5rem" }} onChange={(e) => setpassword(e.target.value)} />
        </div>
        <button type="submit" style={{ width: "100%", padding: ".5rem", background: "blue", border: "none", borderRadius: "5px", color: "#fff" }}>
          Submit
        </button>
        {errorMessage && <div style={{ color: "red", marginTop: "1rem", textAlign: "center" }}>{errorMessage}</div>}
      </form>
    </div>
  );
};

export default Login;
