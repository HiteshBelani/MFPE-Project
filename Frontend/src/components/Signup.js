import React, { useState } from 'react';

const Signup = () => {
  const [name, setName] = useState('');
  const [emailId, setEmailId] = useState('');
  const [phoneNo, setPhoneNo] = useState('');
  const [address, setAddress] = useState('');
  const [userName, setuserName] = useState('');
  const [password, setpassword] = useState('');
  const [errorMessage, setErrorMessage] = useState('');

  function saveData() {
    // Check if email address is valid before submitting form data
    if (!emailId.includes('@')) {
      setErrorMessage('Invalid email address');
      return;
    }
    // Check if phone number is valid before submitting form data
    if (phoneNo.length !== 10) {
      setErrorMessage('Phone number should be 10 digits');
      return;
    }
    if (password.length < 6) {
      setErrorMessage('Password should be at least 6 characters');
      return;
    }
    let data = {
      name,
      emailId,
      phoneNo,
      address,
      userName,
      password
    };

    fetch('http://localhost:8082/customer/registercustomer', {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(data)
    })
    .then((resp) => {
      resp.json()
      .then((result) => {
        console.warn('result', result);
        // Redirect to home page after successful registration
        window.location.href = '/Login';
      })
    })
  }

  return (
    <div style={{display: 'flex', flexDirection: 'column', alignItems: 'center', backgroundColor: '#f2f2f2'}}>
      <h1>Register</h1>
      <form style={{display: 'flex', flexDirection: 'column', width: '300px'}}>
        <label>Name:</label>
        <input type='text' name='name' value={name} onChange={(e) => {setName(e.target.value)}} />
        <label>Email:</label>
        <input type='text' name='email' value={emailId} onChange={(e) => {setEmailId(e.target.value)}} />
        <span style={{ color: 'red' }}>{errorMessage}</span>
        <label>Phone:</label>
        <input type='text' name='phone' value={phoneNo} onChange={(e) => {setPhoneNo(e.target.value)}} />
        <label>Address:</label>
        <input type='text' name='address' value={address} onChange={(e) => {setAddress(e.target.value)}} />
        <label>Username:</label>
        <input type='text' name='username' value={userName} onChange={(e) => {setuserName(e.target.value)}} />
        <label>Password:</label>
        <input type='password' name='password' value={password} onChange={(e) => {setpassword(e.target.value)}} />
        <button type='button' onClick={saveData}>Submit</button>
      </form>
    </div>
  );
}

export default Signup;
