# Java Spring Boot MyCars

A simple REST API web service that returns CRUD operation on cars, based on "Car", "Marca" and "Modelo".






## Installation

Requirements

```bash
  Java JDK 17
  Build your project with the dockerfile

```
    
## Deployment

To deploy your own app:

```bash
  - Choose your desired host
  - Dockerfile will build and deploy the project automatically
```


## 🔗 Follow me on
[![github](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://github.com/cMaggessi/)
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/caio-maggessi-912763189/)


## Endpoints


Car
- /v1/cars GET
- /v1/cars POST
- /v1/cars/{id} PUT
- /v1/cars/{id} DELETE

Modelo
- /v1/cars/modelo GET
- /v1/cars/modelo POST
- /v1/cars/modelo/marca GET
- /v1/cars/modelo/{id} GET
- /v1/cars/modelo/{id} PUT
- /v1/cars/modelo/{id} DELETE

Marca 
- /v1/cars/marca GET
- /v1/cars/marca POST
- /v1/cars/marca/{id} PUT
- /v1/cars/marca/{id} DELETE

