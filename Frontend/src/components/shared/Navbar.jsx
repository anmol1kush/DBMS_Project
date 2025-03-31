import React from "react";
import { Link } from "react-router-dom";
import "./Navbar.css";

const Navbar = () => {
  return (
    <nav className="navbar">
      <div className="navbar-container">
        <Link to="/" className="navbar-logo">
          🏨 HotelHub
        </Link>

        <div className="navbar-links">
          <Link to="/" className="nav-link">
            Home
          </Link>
          <Link to="/rooms" className="nav-link">
            Rooms
          </Link>
          <Link to="/bookings" className="nav-link">
            Bookings
          </Link>
          <Link to="/contact" className="nav-link">
            Contact
          </Link>
          {/* <Link to="/profile" className="nav-link">
            Profile
          </Link> */}
          {/* <Link to="/admin/dashboard" className="nav-link admin-btn">
            Admin Panel
          </Link> */}
        </div>

        <div className="auth-buttons">
          <Link to="/login" className="nav-btn login-btn">
            Login
          </Link>
          <Link to="/signup" className="nav-btn signup-btn">
            Signup
          </Link>
        </div>
      </div>
    </nav>
  );
};

export default Navbar;
