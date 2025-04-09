import { useEffect, useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import "./Rooms.css";

const Rooms = () => {
  const [rooms, setRooms] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    axios.get("http://localhost:9090/rooms")
      .then(response => setRooms(response.data))
      .catch(error => console.error("Error fetching rooms:", error));
  }, []);

  const handleViewDetails = (room) => {
    const isLoggedIn = localStorage.getItem("isLoggedIn") === "true";

    if (!isLoggedIn) {
      alert("Please login to view detail");
      navigate("/login");
      return;
    }
  
    
    navigate(`/bookings/${room.roomId}`, { state: { room } });
  };

  return (
    <div className="rooms-container">
      <h2 className="rooms-title">Available Rooms</h2>
      {rooms.map((room) => (
        <div key={room.roomId} className="hotel-card">
          <div className="hotel-image-container">
            <img 
              src={room.photoUrl || "/images/dining.jpg"} 
              alt={`Room ${room.roomNumber}`} 
              className="hotel-image" 
            />
          </div>
          <div className="hotel-info">
            {/* Left and Right Sections */}
            <div className="room-info-container">
              {/* Left Side - Room Number & Included Services */}
              <div className="room-left">
                <h3 className="hotel-name">Room {room.roomNumber}</h3>
                <p className="included-service">✅ Wifi Available</p>

                <p className="included-service">✅ Food Included</p>
                <p className="included-service">✅ Spa Included</p>
              </div>

              {/* Right Side - Room Type, Status & Max Capacity */}
              <div className="room-right">
                <span className="room-type">{room.roomType}</span>
                <span className="room-status">{room.status}</span>
                <span className="room-capacity">Max: {room.maxCapacity}</span>
              </div>
            </div>

            <div className="hotel-details">
              <ul className="hotel-features">
                {room.features?.map((feature, index) => (
                  <li key={index}>✅ {feature}</li>
                ))}
              </ul>
            </div>

            <div className="hotel-pricing">
              <div className="hotel-price">
                <span className="discounted-price">₹{room.pricePerNight}</span>
                <span className="taxes">+₹150 taxes & fees per night</span>
              </div>
            </div>
            
            <button className="details-btn" onClick={() => handleViewDetails(room)}>
              View Details
            </button>
          </div>
        </div>
      ))}
    </div>
  );
};

export default Rooms;
