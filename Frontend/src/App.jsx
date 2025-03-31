import { useState } from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom"; // Correct import
import Navbar from "./components/shared/Navbar";
import Footer from "./components/shared/Footer";
import Home from "./components/Home";
import Login from "./components/auth/Login"
import Rooms from "./components/rooms/Rooms"
import RoomsDetails from "./components/rooms/RoomsDetails"
import Contact from "./components/Contact"
import Signup from "./components/auth/Signup";
import GuestSignup from "./components/auth/GuestSignup";
import StaffSignup from "./components/auth/StaffSignup";

function App() { 
  return (
    <>
      {/* Wrap everything inside Router */}
      <Router>
        {/* Pass refs correctly if needed */}
        <Navbar />

        {/* Define your routes here */}
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/about" element={<h1>ℹ️ About Us</h1>} />
          <Route path="/contact" element={<Contact />} />
          <Route path="/login" element={<Login />} />
          <Route path="/signup" element={<Signup />} />
          <Route path="/rooms" element={<Rooms />} />
          <Route path="/room-details/:room_id" component={<RoomsDetails />} />

          <Route path="/" element={<Signup />} />
          <Route path="/guest-signup" element={<GuestSignup />} />
          <Route path="/staff-signup" element={<StaffSignup />} />
        </Routes>

        {/* Add Footer here if needed */}
        <Footer />
      </Router>
    </>
  );
}

export default App;
