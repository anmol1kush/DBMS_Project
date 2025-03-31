import React, { useState } from "react";
import "./GuestStaffSignup.css";

const StaffSignup = () => {
  const [staff, setStaff] = useState({
    username: "",
    password: "",
    fullName: "",
    email: "",
    phone: "",
    position: "",
    salary: "",
    hireDate: ""
  });

  const handleChange = (e) => {
    setStaff({ ...staff, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log("Staff Signup Data:", staff);
  };

  return (
    <div className="signup-container">
      <form className="signup-form" onSubmit={handleSubmit}>
        <h2>Staff Signup</h2>
        <input type="text" name="username" placeholder="Username" onChange={handleChange} required />
        <input type="password" name="password" placeholder="Password" onChange={handleChange} required />
        <input type="text" name="fullName" placeholder="Full Name" onChange={handleChange} required />
        <input type="email" name="email" placeholder="Email" onChange={handleChange} required />
        <input type="tel" name="phone" placeholder="Phone" onChange={handleChange} required />
        <input type="text" name="position" placeholder="Position" onChange={handleChange} required />
        <input type="number" name="salary" placeholder="Salary" onChange={handleChange} required />
        <input type="date" name="hireDate" onChange={handleChange} required />
        <button type="submit">Sign Up</button>
      </form>
    </div>
  ) ;
};

export default StaffSignup;
