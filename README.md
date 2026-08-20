# 🎉 Sistema de Gestión de Eventos - API REST

API REST desarrollada con **Spring Boot** para la gestión de eventos (crear, listar, actualizar y eliminar). Proyecto desarrollado como parte de mi formación en desarrollo backend con Java.

## 📋 Descripción

Este proyecto es una API REST que permite gestionar eventos de forma sencilla. Implementa una arquitectura en capas (Model - Service - Controller) siguiendo buenas prácticas de diseño de software en Java.

## 🚀 Tecnologías utilizadas

- **Java 17**
- **Spring Boot 3.1.5**
- **Maven** (gestión de dependencias y build)
- **PostgreSQL** *(próximamente: persistencia en base de datos)*
- **Postman / cURL** (testing de endpoints)

## 🏗️ Arquitectura

El proyecto sigue una arquitectura en capas:

```
com.eventos/
├── model/          → Entidades (Evento)
├── service/         → Lógica de negocio
├── controller/       → Endpoints REST
└── SistemaEventosApp.java   → Clase principal
```

## 📌 Funcionalidades

- ✅ Crear eventos
- ✅ Listar todos los eventos
- ✅ Obtener un evento por ID
- ✅ Actualizar información de un evento
- ✅ Eliminar un evento
- ✅ Contar total de eventos

## 🔗 Endpoints disponibles

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/api/eventos` | Obtiene todos los eventos |
| GET | `/api/eventos/{id}` | Obtiene un evento por ID |
| POST | `/api/eventos` | Crea un nuevo evento |
| PUT | `/api/eventos/{id}` | Actualiza un evento existente |
| DELETE | `/api/eventos/{id}` | Elimina un evento |
| GET | `/api/eventos/count/total` | Cuenta el total de eventos |

### Ejemplo de request (POST)

```json
{
  "nombre": "Tech Conference 2026",
  "descripcion": "Conferencia de tecnología",
  "fecha": "2026-08-20",
  "ubicacion": "Buenos Aires",
  "capacidad": 500
}
```

### Ejemplo de response

```json
{
  "id": 1,
  "nombre": "Tech Conference 2026",
  "descripcion": "Conferencia de tecnología",
  "fecha": "2026-08-20",
  "ubicacion": "Buenos Aires",
  "capacidad": 500
}
```

## ⚙️ Cómo ejecutar el proyecto localmente

### Prerrequisitos

- Java 17 o superior
- Maven instalado

### Pasos

1. Clonar el repositorio:
```bash
git clone https://github.com/Dominguezkev/sistema-eventos.git
cd sistema-eventos
```

2. Compilar el proyecto:
```bash
mvn clean compile
```

3. Ejecutar la aplicación:
```bash
mvn spring-boot:run
```

4. La API estará disponible en:
```
http://localhost:8080/api/eventos
```

### Probar con cURL

```bash
# Crear un evento
curl -X POST http://localhost:8080/api/eventos \
  -H "Content-Type: application/json" \
  -d '{"nombre":"Mi Evento","descripcion":"Descripción","fecha":"2026-09-01","ubicacion":"Online","capacidad":100}'

# Obtener todos los eventos
curl http://localhost:8080/api/eventos
```

## 🛣️ Roadmap / Próximas mejoras

- [ ] Persistencia con PostgreSQL (Spring Data JPA)
- [ ] Validaciones de datos (Bean Validation)
- [ ] Manejo de excepciones personalizado
- [ ] Tests unitarios con JUnit
- [ ] Documentación de API con Swagger/OpenAPI
- [ ] Autenticación y autorización (JWT)
- [ ] Dockerización del proyecto

## 👨‍💻 Autor

**Kevin Domínguez**
Estudiante de Analista en Sistemas de Computación

- GitHub: [Dominguezkev](https://github.com/Dominguezkev)
- LinkedIn: www.linkedin.com/in/kevin-dominguez-1
- Workana: *(Falta verificacion)*

## 📄 Licencia

Este proyecto es de uso educativo y demostrativo.
