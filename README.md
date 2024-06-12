# Hospital management api
- *I. Note *
  - [CRUD]
  - [Path base (/hospital)
  - [10 Endpoints with focus in 3 entities (Hospital, Doctor, Patient)]

 <>Example findAll output JSON<>

> Doctor. /hospital/doctors
>     {
    "_embedded": {
        "doctors": [
            {
                "name": "Dr. Silva",
                "crm": "123456",
                "doctorEspecialization": {
                    "especialization": "Cardiologia"
                },
                "doctorState": {
                    "state": "busy"
                },
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/hospital/doctors/1"
                    },
                    "doctor": {
                        "href": "http://localhost:8080/hospital/doctors/1"
                    }
                }
            },
            {
                "name": "Dr. Santos",
                "crm": "654321",
                "doctorEspecialization": {
                    "especialization": "Ortopedia"
                },
                "doctorState": {
                    "state": "unoccupied"
                },
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/hospital/doctors/2"
                    },
                    "doctor": {
                        "href": "http://localhost:8080/hospital/doctors/2"
                    }
                }
            }
------------------
> Patient. hospital/patients
>     {
    "_embedded": {
        "patients": [
            {
                "name": "João Sebastião",
                "cep": "12345-678",
                "sickness": "Gripe",
                "patientState": {
                    "state": "discharged"
                },
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/hospital/patients/1"
                    },
                    "patient": {
                        "href": "http://localhost:8080/hospital/patients/1"
                    }
                }
            },
            {
                "name": "Maria das graças assis",
                "cep": "98765-432",
                "sickness": "Fratura",
                "patientState": {
                    "state": "not_discharged"
                },
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/hospital/patients/2"
                    },
                    "patient": {
                        "href": "http://localhost:8080/hospital/patients/2"
                    }
                }
            }
    
------------------
> Hospital. /hospital/hospitals
>     {
    "_embedded": {
        "hospitals": [
            {
                "name": "Hospital A",
                "cep": "12345-678",
                "attendant": {
                    "name": "Ana",
                    "cpf": "12345678901"
                },
                "service": {
                    "localService": {
                        "hospitalization": {
                            "room": {
                                "number": "101",
                                "roomState": {
                                    "roomStateEnum": "occupied"
                                }
                            },
                            "_links": {
                                "patient": {
                                    "href": "http://localhost:8080/hospital/patients/1"
                                },
                                "doctor": {
                                    "href": "http://localhost:8080/hospital/doctors/1"
                                }
                            }
                        }
                    },
                    "emergencyService": {
                        "ambulance": {
                            "plate": "XYZ5678",
                            "ambulanceState": {
                                "ambulanceStateEnum": "active"
                            }
                        }
                    }
                },
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/hospital/hospitals/1"
                    },
                    "hospital": {
                        "href": "http://localhost:8080/hospital/hospitals/1"
                    }
                }
            }

===========================================================================







> UML
![umlhp](https://github.com/Mizugue/Hospital-management-api/assets/126506298/c4c493b9-f0b4-4dc4-9255-a9aa24db4bf8)

