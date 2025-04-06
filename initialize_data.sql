INSERT INTO employees (firstname, lastname, username, email, password, role) VALUES
('Alice', 'Anderson', 'alice', 'alice.anderson@timex.com', 'alice', 'employee'),
('Bob', 'Brown', 'bob', 'bob.brown@timex.com', 'bob', 'admin'),
('Charlie', 'Clark', 'charlie', 'charlie.clark@timex.com', 'charlie', 'employee'),
('Diana', 'Davis', 'diana', 'diana.davis@timex.com', 'diana', 'admin'),
('Ethan', 'Edwards', 'ethan', 'ethan.edwards@timex.com', 'ethan', 'employee'),
('Fiona', 'Foster', 'fiona', 'fiona.foster@timex.com', 'fiona', 'employee'),
('George', 'Green', 'george', 'george.green@timex.com', 'george', 'admin'),
('Hannah', 'Hill', 'hannah', 'hannah.hill@timex.com', 'hannah', 'employee'),
('Isaac', 'Irwin', 'isaac', 'isaac.irwin@timex.com', 'isaac', 'employee'),
('Julia', 'Jordan', 'julia', 'julia.jordan@timex.com', 'julia', 'admin'),
('Kevin', 'King', 'kevin', 'kevin.king@timex.com', 'kevin', 'employee'),
('Luna', 'Long', 'luna', 'luna.long@timex.com', 'luna', 'admin'),
('Mason', 'Moore', 'mason', 'mason.moore@timex.com', 'mason', 'employee'),
('Nina', 'Nelson', 'nina', 'nina.nelson@timex.com', 'nina', 'employee'),
('Oliver', 'Owens', 'oliver', 'oliver.owens@timex.com', 'oliver', 'admin'),
('Paula', 'Parker', 'paula', 'paula.parker@timex.com', 'paula', 'employee');


INSERT INTO attendance (employee_id, time_in, time_out, date) VALUES
-- Alice
(1, '2024-12-01 09:00:00', '2024-12-01 17:00:00', '2024-12-01'),
(1, '2024-12-02 08:30:00', '2024-12-02 16:30:00', '2024-12-02'),
(1, '2024-12-03 09:15:00', '2024-12-03 17:15:00', '2024-12-03'),

-- Bob
(2, '2024-12-01 10:00:00', '2024-12-01 18:00:00', '2024-12-01'),
(2, '2024-12-03 09:45:00', '2024-12-03 17:45:00', '2024-12-03'),

-- Charlie
(3, '2024-12-02 08:00:00', '2024-12-02 16:00:00', '2024-12-02'),
(3, '2024-12-04 09:00:00', '2024-12-04 17:00:00', '2024-12-04'),

-- Diana
(4, '2024-12-01 09:30:00', '2024-12-01 17:30:00', '2024-12-01'),
(4, '2024-12-03 08:15:00', '2024-12-03 16:15:00', '2024-12-03'),
(4, '2024-12-04 09:00:00', '2024-12-04 17:00:00', '2024-12-04'),

-- Ethan
(5, '2024-12-02 07:45:00', '2024-12-02 15:45:00', '2024-12-02'),
(5, '2024-12-04 08:00:00', '2024-12-04 16:00:00', '2024-12-04'),

-- Fiona
(6, '2024-12-01 09:15:00', '2024-12-01 17:15:00', '2024-12-01'),
(6, '2024-12-02 08:30:00', '2024-12-02 16:30:00', '2024-12-02'),

-- George
(7, '2024-12-01 10:00:00', '2024-12-01 18:00:00', '2024-12-01'),
(7, '2024-12-03 09:45:00', '2024-12-03 17:45:00', '2024-12-03'),

-- Hannah
(8, '2024-12-02 08:30:00', '2024-12-02 16:30:00', '2024-12-02'),
(8, '2024-12-04 09:15:00', '2024-12-04 17:15:00', '2024-12-04'),

-- Isaac
(9, '2024-12-01 09:00:00', '2024-12-01 17:00:00', '2024-12-01'),
(9, '2024-12-03 08:30:00', '2024-12-03 16:30:00', '2024-12-03'),

-- Julia
(10, '2024-12-01 09:15:00', '2024-12-01 17:15:00', '2024-12-01'),
(10, '2024-12-02 08:45:00', '2024-12-02 16:45:00', '2024-12-02'),

-- Kevin
(11, '2024-12-03 09:00:00', '2024-12-03 17:00:00', '2024-12-03'),
(11, '2024-12-04 08:15:00', '2024-12-04 16:15:00', '2024-12-04'),

-- Luna
(12, '2024-12-01 10:00:00', '2024-12-01 18:00:00', '2024-12-01'),
(12, '2024-12-03 09:45:00', '2024-12-03 17:45:00', '2024-12-03'),

-- Mason
(13, '2024-12-02 08:30:00', '2024-12-02 16:30:00', '2024-12-02'),
(13, '2024-12-04 09:00:00', '2024-12-04 17:00:00', '2024-12-04'),

-- Nina
(14, '2024-12-01 07:45:00', '2024-12-01 15:45:00', '2024-12-01'),
(14, '2024-12-03 08:00:00', '2024-12-03 16:00:00', '2024-12-03'),

-- Oliver
(15, '2024-12-01 09:30:00', '2024-12-01 17:30:00', '2024-12-01'),
(15, '2024-12-04 08:15:00', '2024-12-04 16:15:00', '2024-12-04'),

-- Paula
(16, '2024-12-02 09:15:00', '2024-12-02 17:15:00', '2024-12-02'),
(16, '2024-12-04 09:00:00', '2024-12-04 17:00:00', '2024-12-04');
