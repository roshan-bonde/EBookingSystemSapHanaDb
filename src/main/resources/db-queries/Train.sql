INSERT INTO public.train(
	date_of_journey, number_of_coaches, price, train_speed, arrival_time, departure_time, from_city, id, mid_stations, operator_name, to_city, train_name, train_number, train_type)
	VALUES (current_timestamp, 18, 3500, 180, current_timestamp, current_timestamp, 'Nagpur', 1, 'Hyderabad, Secunderabad', 'Indian Railways', 'Bangalore', 'SBC Rajhdani', 26922,'AC');
    