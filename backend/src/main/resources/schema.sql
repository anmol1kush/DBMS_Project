CREATE TABLE IF NOT EXISTS rooms (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    room_type VARCHAR(255),
    room_number INT,
    price_per_night DOUBLE
);
