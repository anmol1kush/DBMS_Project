import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import "./Signup.css";

const Signup = () => {
  const [userType, setUserType] =  useState("");
  const navigate = useNavigate();

  const handleProceed = () => {
    if (userType === "guest") {
      navigate("/guest-signup");
    } else if (userType === "staff") {
      navigate("/staff-signup");
    }
  };

  return (
    <div className="signup-container">
      <div className="signup-form">
        <h2>Signup</h2>
        <label>
          <input
            type="radio"
            name="userType"
            value="guest"
            onChange={(e) => setUserType(e.target.value)}
          />
          Guest
        </label>
        <label>
          <input
            type="radio"
            name="userType"
            value="staff"
            onChange={(e) => setUserType(e.target.value)}
          />
          Staff
        </label>
        <button onClick={handleProceed} disabled={!userType}>Proceed</button>
      </div>
    </div>
  );
};

export default Signup;
