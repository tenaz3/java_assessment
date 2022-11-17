INSERT INTO quiz_type (id, type_name)
VALUES ('188a8b5a-4ad7-4814-8d4d-9755a5a9969f', 'geography'),
       ('72cbcc3b-6afd-4734-9309-9f5ce2ce20d6', 'science');


INSERT INTO quiz (id, quiz_type_id, title)
VALUES ('47b6dd82-78ab-408f-9b15-01e9d76316fe', '188a8b5a-4ad7-4814-8d4d-9755a5a9969f', 'Capital Quiz'),
       ('fcd5d9ea-7252-47bf-9843-1bf05d7ac3af', '72cbcc3b-6afd-4734-9309-9f5ce2ce20d6', 'Class Quiz'),
       ('946d906e-b385-4e24-8bfa-c8d301d8432b', '188a8b5a-4ad7-4814-8d4d-9755a5a9969f', 'Mountain Quiz');

INSERT INTO question (id, quiz_id, question)
VALUES ('188a8b5a-4ad7-4814-8d4d-9755a5a9969f', '47b6dd82-78ab-408f-9b15-01e9d76316fe', 'What is the capital of US?'),
       ('72cbcc3b-6afd-4734-9309-9f5ce2ce20d6', '47b6dd82-78ab-408f-9b15-01e9d76316fe', 'What is the capital of Brazil?'),
       ('37b6dc82-78ab-408f-9b15-01e9d76316fe', '47b6dd82-78ab-408f-9b15-01e9d76316fe', 'What is the capital of Germany?'),
       ('dcd5d9ea-7252-47bf-9843-1bf05d7ac3af', 'fcd5d9ea-7252-47bf-9843-1bf05d7ac3af', 'What is the formula of water?'),
       ('846d906e-b385-4e24-8bfa-c8d301d8432b', '946d906e-b385-4e24-8bfa-c8d301d8432b', 'What is the highest mountain in the world?');


INSERT INTO answer (id, quiz_id, question_id, is_correct, answer)
VALUES ('7624574b-9fa3-4a69-a112-d1fbf5bddeae', '47b6dd82-78ab-408f-9b15-01e9d76316fe', '188a8b5a-4ad7-4814-8d4d-9755a5a9969f', false, 'New York'),
       ('3624574b-9fa3-4a69-a112-d1fbf5bddea1', '47b6dd82-78ab-408f-9b15-01e9d76316fe', '188a8b5a-4ad7-4814-8d4d-9755a5a9969f', false, 'Chicago'),
       ('f98b8777-beb0-46f6-bb05-73a05431e936', '47b6dd82-78ab-408f-9b15-01e9d76316fe', '188a8b5a-4ad7-4814-8d4d-9755a5a9969f', true, 'Washington'),
       ('f78b8777-beb0-46f6-bb05-73a05431e935', '47b6dd82-78ab-408f-9b15-01e9d76316fe', '72cbcc3b-6afd-4734-9309-9f5ce2ce20d6', true, 'Brasilia'),
       ('d4228678-ac4e-4d04-a54b-6009fcd375ae', '47b6dd82-78ab-408f-9b15-01e9d76316fe', '72cbcc3b-6afd-4734-9309-9f5ce2ce20d6', false, 'Rio de Janeiro'),
       ('64228678-ac4e-4d04-a54b-6009fcd373de', '47b6dd82-78ab-408f-9b15-01e9d76316fe', '72cbcc3b-6afd-4734-9309-9f5ce2ce20d6', false, 'São Paulo'),
       ('a336e333-51a0-467f-bef0-10722380d272', '47b6dd82-78ab-408f-9b15-01e9d76316fe', '37b6dc82-78ab-408f-9b15-01e9d76316fe', true, 'Berlin'),
       ('5a58322f-9d17-4cfa-9dc9-92bccec55d9d', '47b6dd82-78ab-408f-9b15-01e9d76316fe', '37b6dc82-78ab-408f-9b15-01e9d76316fe', false, 'Munich'),
       ('3f53b20d-7bf0-489e-8449-092d6534ecc9', '47b6dd82-78ab-408f-9b15-01e9d76316fe', '37b6dc82-78ab-408f-9b15-01e9d76316fe', false, 'Hamburg'),
       ('df33b20d-7bf0-489e-8449-092d6534ecc6', 'fcd5d9ea-7252-47bf-9843-1bf05d7ac3af', 'dcd5d9ea-7252-47bf-9843-1bf05d7ac3af', false, 'Oxygen'),
       ('f6abf8ba-c680-4dc3-9e59-6277004e819b', 'fcd5d9ea-7252-47bf-9843-1bf05d7ac3af', 'dcd5d9ea-7252-47bf-9843-1bf05d7ac3af', true, 'H2O'),
       ('f6baf8ba-c680-4dc3-9e59-6277004e819a', '946d906e-b385-4e24-8bfa-c8d301d8432b', '846d906e-b385-4e24-8bfa-c8d301d8432b', false, 'Andes'),
       ('47c15933-962f-49ae-b675-e0a610e11bec', '946d906e-b385-4e24-8bfa-c8d301d8432b', '846d906e-b385-4e24-8bfa-c8d301d8432b', false, 'K2'),
       ('a6b49f45-f254-4a72-86de-aa59a9d49a33', '946d906e-b385-4e24-8bfa-c8d301d8432b', '846d906e-b385-4e24-8bfa-c8d301d8432b', true, 'Mount Everest');
