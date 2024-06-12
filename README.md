# Hospital management api
- *I. Note *
  - [CRUD (findAll . findById . save . deleteById)]
  - [Path base (/hospital)
  - [Endpoints focused in management 3 entities (Hospital, Doctor, Patient)]

 <Example findAll output JSON

> Doctor. /hospital/doctors
>     {
        "id": 1,
        "name": "Dr. Silva",
        "crm": "123456",
        "doctorEspecialization": {
            "id": 1,
            "especialization": "Cardiologia"
        },
        "doctorState": {
            "id": 1,
            "state": "busy"
        }
    },
    {
        "id": 2,
        "name": "Dr. Santos",
        "crm": "654321",
        "doctorEspecialization": {
            "id": 2,
            "especialization": "Ortopedia"
        },
        "doctorState": {
            "id": 2,
            "state": "unoccupied"
        }
    }
------------------
> Patient. hospital/patients
>     {
        "id": 1,
        "name": "João Sebastião",
        "cep": "12345-678",
        "sickness": "Gripe",
        "patientState": {
            "id": 1,
            "state": "discharged"
        }
    },
    {
        "id": 2,
        "name": "Maria das graças assis",
        "cep": "98765-432",
        "sickness": "Fratura",
        "patientState": {
            "id": 2,
            "state": "not_discharged"
        }
    }
    
------------------
> Hospital. /hospital
>     {
        "id": 1,
        "name": "Hospital A",
        "cep": "12345-678",
        "attendant": {
            "id": 1,
            "name": "Ana",
            "cpf": "12345678901"
        },
        "service": {
            "id": 1,
            "localService": {
                "id": 1,
                "hospitalization": {
                    "id": 1,
                    "doctor": {
                        "id": 1,
                        "name": "Dr. Silva",
                        "crm": "123456",
                        "doctorEspecialization": {
                            "id": 1,
                            "especialization": "Cardiologia"
                        },
                        "doctorState": {
                            "id": 1,
                            "state": "busy"
                        }
                    },
                    "patient": {
                        "id": 1,
                        "name": "João Sebastião",
                        "cep": "12345-678",
                        "sickness": "Gripe",
                        "patientState": {
                            "id": 1,
                            "state": "discharged"
                        }
                    },
                    "room": {
                        "id": 1,
                        "number": "101",
                        "roomState": {
                            "id": 1,
                            "roomStateEnum": "occupied"
                        }
                    }
                }
            },
            "emergencyService": {
                "id": 1,
                "ambulance": {
                    "id": 2,
                    "plate": "XYZ5678",
                    "ambulanceState": {
                        "id": 2,
                        "ambulanceStateEnum": "active"
                    }
                }
            }
        }
    },

====================================================================================================







> UML
![umlhp](https://github.com/Mizugue/Hospital-management-api/assets/126506298/c4c493b9-f0b4-4dc4-9255-a9aa24db4bf8)

