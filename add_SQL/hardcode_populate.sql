INSERT INTO patient_state (state)
VALUES
    ('discharged'),
    ('not discharged');

INSERT INTO patient (name, cep, sickness, id_pat_state)
VALUES
    ('João', '12345-678', 'Gripe', 1),
    ('Maria', '98765-432', 'Fratura', 2),
    ('Pedro', '45678-901', 'Dor de cabeça', 2);

INSERT INTO ambulance_state (state)
VALUES
    ('parked'),
    ('active');

INSERT INTO ambulance (plate, id_amb_state)
VALUES
    ('ABC1234', 1),
    ('XYZ5678', 2),
    ('DEF9876', 1);

INSERT INTO emergency_service (id_ambulance)
VALUES
    (2),
    (3);

INSERT INTO doctor_state (state)
VALUES
    ('busy'),
    ('unoccupied');

INSERT INTO especialization (especialization)
VALUES
    ('Cardiologia'),
    ('Ortopedia'),
    ('Pediatria');

INSERT INTO doctor (name, crm, id_specialization, id_doc_state)
VALUES
    ('Dr. Silva', '123456', 1, 1),
    ('Dr. Santos', '654321', 2, 2),
    ('Dra. Oliveira', '789012', 3, 2);

INSERT INTO room_state (state)
VALUES
    ('occupied'),
    ('vacant');

INSERT INTO room (number, id_room_state)
VALUES
    ('101', 1),
    ('102', 2),
    ('103', 1);

INSERT INTO hospitalization (id_doctor, id_patient, id_room)
VALUES
    (1, 1, 1),
    (2, 2, 2),
    (3, 3, 1);

INSERT INTO local_service (id_hospitalization)
VALUES
    (1),
    (2),
    (3);

INSERT INTO service (id_local_service, id_emergency_service)
VALUES
    (1, 1),
    (2, 2),
    (3, 2);

INSERT INTO attendant (name, cpf)
VALUES
    ('Ana', '12345678901'),
    ('Carlos', '98765432109');

INSERT INTO hospital (name, cep, id_attendant, id_service)
VALUES
    ('Hospital A', '12345-678', 1, 1),
    ('Hospital B', '98765-432', 2, 2);
