import React from "react";
import { useLocation } from "react-router-dom";  // Import useLocation to access the state
import "./RoomsDetails.css";

const RoomDetails = () => {
  const location = useLocation();
  const { room } = location.state;  // Get the room details passed via state

  return (
    <div className="room-details-container">
      <h2 className="room-details-title">Room Details</h2>
      <div className="room-details-card">
        <div className="room-details-image-container">
          <img src={room.photo_url} alt={`Room ${room.room_number}`} className="room-details-image" />
        </div>
        <div className="room-details-info">
          <h3 className="room-number">Room {room.room_number}</h3>
          <span className="room-type">{room.room_type}</span>
          <div className="room-price">
            <span className="discounted-price">₹{room.price_per_night}</span>
            <span className="taxes">+₹150 taxes & fees per night</span>
          </div>
          <ul className="room-features">
            {room.features.map((feature, index) => (
              <li key={index}>✅ {feature}</li>
            ))}
          </ul>
          <div className="room-status">
            Status: <span className={`status-${room.status}`}>{room.status}</span>
          </div>
          <div className="room-capacity">
            Max Capacity: {room.max_capacity} persons
          </div>
          <button className="book-now-btn">Book Now</button>
        </div>
      </div>
    </div>
  );
};

export default RoomDetails;
