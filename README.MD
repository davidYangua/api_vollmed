# 🩺 VollMed API

**VollMed** es una API RESTful desarrollada en **Java 17** utilizando el framework **Spring Boot**. Su propósito es gestionar el registro de médicos, permitiendo operaciones CRUD completas (crear, leer, actualizar y eliminar) sobre los datos de los profesionales de la salud. La persistencia de datos se maneja mediante **MySQL**, y el versionado de la base de datos está gestionado con **Flyway**.

La API también implementa seguridad robusta mediante **Spring Security**, utilizando **JWT (JSON Web Tokens)** para autenticación y soporte para **OAuth 2.0**, permitiendo proteger los endpoints y gestionar el acceso de forma segura y escalable.

---

## 🚀 Tecnologías utilizadas

- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA**
- **MySQL**
- **Flyway**
- **Spring Validation**
- **Spring Web**
- **Spring Security**
- **JWT (JSON Web Token)**
- **OAuth **

---

## 🔐 Seguridad

La autenticación de usuarios y protección de endpoints se gestiona con:

- ✅ **JWT (JSON Web Tokens):** Se genera un token al iniciar sesión, el cual debe ser enviado en cada petición protegida.
- 🔒 **OAuth 2.0 (Soporte):** Preparado para integrarse con proveedores externos de autenticación.
- 🔐 **Filtros personalizados de seguridad:** Para interceptar y validar cada solicitud.

---

## 📦 Funcionalidades principales

La API VollMed ofrece un conjunto de endpoints para la gestión de médicos registrados en el sistema. Las principales funcionalidades incluyen:

- ✅ Registrar un nuevo médico
- 🔍 Consultar información detallada de un médico
- ✏️ Actualizar datos de un médico existente
- ❌ Eliminar (o desactivar) un registro médico
- 📄 Listar todos los médicos registrados (con paginación y filtros opcionales)

---

