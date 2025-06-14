INSERT INTO public.bus(id, 
	date_of_journey, price, total_seats, amenities, arrival_time, bus_company_name, bus_number, bus_type, departure_time, driver_details, from_city, mid_stations, seat_configuration, to_city)
	VALUES (1, current_timestamp(0), 2000, 30, 'wifi, ac', current_timestamp(0), 'Sharad Bus Services', 12345, 'Slepper', current_timestamp(0), 'Sharad Kumar', 'Nagpur', 'Pune', '1+2', 'Ratnagiri');

	select * from public.bus
