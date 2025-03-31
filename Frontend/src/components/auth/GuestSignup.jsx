import React, { useState } from "react";
import "./GuestStaffSignup.css";

const GuestSignup = () => {
  const [guest, setGuest] = useState({
    username: "",
    password: "",
    fullName: "",
    email: "",
    phone: "",
    address: "",
    city: "",
    country: "",
    idProofType: "",
    idProofNumber: "" 
  });

  const handleChange = (e) => {
    setGuest({ ...guest, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log("Guest Signup Data:", guest);
  };

  return (
    <div className="signup-container">
      <form className="signup-form" onSubmit={handleSubmit}>
        <h2>Guest Signup</h2>
        <input type="text" name="username" placeholder="Username" onChange={handleChange} required />
        <input type="password" name="password" placeholder="Password" onChange={handleChange} required />
        <input type="text" name="fullName" placeholder="Full Name" onChange={handleChange} required />
        <input type="email" name="email" placeholder="Email" onChange={handleChange} required />
        <input type="tel" name="phone" placeholder="Phone" onChange={handleChange} required />
        <input type="text" name="address" placeholder="Address" onChange={handleChange} required />
        <input type="text" name="city" placeholder="City" onChange={handleChange} required />
        <input type="text" name="country" placeholder="Country" onChange={handleChange} required />
        <select name="idProofType" onChange={handleChange} required>
          <option value="">Select ID Proof</option>
          <option value="driver-license">Driver's License</option>
          <option value="passport">Passport</option>
          <option value="aadhar">Aadhar</option>
        </select>
        <input type="text" name="idProofNumber" placeholder="ID Proof Number" onChange={handleChange} required />
        <button type="submit">Sign Up</button>
      </form>
    </div>
  );
};

export default GuestSignup;
