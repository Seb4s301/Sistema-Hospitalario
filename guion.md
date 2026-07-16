# Guion de Exposición — Sistema Hospitalario

**Duración:** 15 minutos  
**Expositores:** 5 personas  
**Formato:** Exposición oral con demostración en vivo

---

## Estructura General

| Orden | Expositor | Tema | Tiempo |
|-------|-----------|------|--------|
| 1 | Expositor 1 | Introducción y Arquitectura | 3 min |
| 2 | Expositor 2 | Estructuras de Datos | 3 min |
| 3 | Expositor 3 | Funcionalidades (Médicos y Pacientes) | 3 min |
| 4 | Expositor 4 | Autenticación y Citas | 3 min |
| 5 | Expositor 5 | Historiales, Reportes y Mejoras | 3 min |

---

## Expositor 1 — Introducción y Arquitectura (3 min)

### Diálogo

> Buenas tardes, presentamos el **Sistema Hospitalario**, una aplicación de escritorio desarrollada en **Java Swing** para la gestión integral de un hospital.

> **Arquitectura:** El sistema sigue el patrón **MVC** (Modelo-Vista-Controlador), con una capa de **Fachada** (`HospitalFacade`) que centraliza toda la lógica de negocio.

> **Patrones utilizados:**
> - **Singleton:** Garantiza una única instancia de cada estructura de datos (árboles y listas).
> - **Facade:** `HospitalFacade` es la puerta de entrada única para todas las operaciones.
> - **Strategy:** La autenticación usa 3 estrategias diferentes según el rol.
> - **Template Method:** La precarga de datos usa una clase abstracta con pasos fijos y personalizables.

> **Roles del sistema:** Administrador, Médico y Recepcionista. Cada uno tiene permisos distintos y una interfaz adaptada a sus necesidades.

---

## Expositor 2 — Estructuras de Datos (3 min)

### Diálogo

> Para almacenar la información utilizamos **dos tipos de estructuras de datos**, implementadas desde cero sin usar librerías externas.

> **Árbol Binario de Búsqueda (BST):** Se usa para almacenar pacientes. La clave es el DNI. Permite búsquedas eficientes en **O(log n)** en promedio. Soporta inserción, búsqueda, modificación y eliminación con sucesor in-order.

> **Listas Doblemente Enlazadas:** Se usan para médicos, recepcionistas, administradores, citas, historiales clínicos y reportes médicos. Cada lista tiene operaciones de insertar, buscar, modificar y eliminar.

> **Dato clave:** Las citas médicas tienen una validación especial: **no se pueden agendar dos citas para el mismo médico con menos de 15 minutos de diferencia**. Esto se implementa en `ListaDobleCita.validarSeparacion15Minutos()`.

> Demostración: *[Abrir sistema, mostrar estructura de datos con 11 pacientes en el árbol]*

---

## Expositor 3 — Funcionalidades: Médicos y Pacientes (3 min)

### Diálogo

> Ahora veamos las funcionalidades principales para la gestión de **pacientes** y **médicos**.

> **Pacientes:** El sistema permite insertar, modificar y eliminar pacientes. El DNI siempre debe ser de **8 dígitos numéricos** y el celular de **9 dígitos**. Los datos se almacenan en el árbol BST.

> **Médicos:** Similar a pacientes, pero con campos adicionales como **turno** (fecha y hora de disponibilidad) y **especialidad**. Hay 9 especialidades disponibles: Traumatología, Pediatría, Oftalmología, Neurología, Endocrinología, Oncología, Dermatología, Cardiología y Gastroenterología.

> **Búsqueda de médicos:** Se puede buscar por **DNI** o por **turno** (fecha de disponibilidad). El sistema parsea la fecha ingresada y compara con los turnos registrados.

> Demostración: *[Insertar un paciente, buscar un médico por turno, modificar datos]*

---

## Expositor 4 — Autenticación y Citas (3 min)

### Diálogo

> El sistema tiene un módulo de **autenticación** seguro y flexible.

> **Códigos de usuario:**
> - Administrador: `A` + DNI (ej: A10000000)
> - Médico: `M` + DNI (ej: M10000000)
> - Recepcionista: `R` + DNI (ej: R10000000)

> **Autenticación:** Usa el patrón **Strategy**. `GestorAutenticacion` itera 3 estrategias: `AdminAutenticacionStrategy`, `MedicoAutenticacionStrategy` y `RecepcionistaAutenticacionStrategy`. Cada una busca por código primero, luego por DNI.

> **Citas médicas:** Para agendar una cita se busca al paciente y al médico, y se valida que no haya conflictos de horario. El sistema verifica automáticamente que no exista otra cita para el mismo médico dentro de 15 minutos.

> **Interfaz por rol:** Administrador ve 6 pestañas (Dashboard, Médicos, Pacientes, Historiales, Agendar Citas, Sesión). Médico ve 3 (Citas, Reportes, Sesión). Recepcionista ve 3 (Pacientes, Agendar Citas, Sesión).

> Demostración: *[Iniciar sesión como médico, agendar una cita, mostrar validación de 15 minutos]*

---

## Expositor 5 — Historiales, Reportes y Mejoras (3 min)

### Diálogo

> Finalmente, veamos los módulos de **historiales clínicos** y **reportes médicos**, y las mejoras futuras.

> **Historiales clínicos:** Cada paciente tiene un historial con tipo de sangre, alergias, enfermedades crónicas y observaciones médicas. El historial se busca por DNI del paciente.

> **Reportes médicos:** Los reportes usan una **clave compuesta**: DNI del paciente + fecha. Un paciente puede tener múltiples reportes. Cada médico solo ve **sus propios reportes**, no los de otros médicos. El campo observaciones es opcional; en la tabla se muestra "Sí" o "N/A" para no revelar información sensible.

> **Dashboard:** El administrador ve gráficos de **barras** (demanda por especialidad) y **circular** (pacientes por aseguradora) usando JFreeChart.

> **Mejoras futuras:**
> - Persistencia en base de datos (actualmente todo es en memoria)
> - Encriptación de contraseñas
> - Interfaz web
> - Exportación de reportes a PDF

> Demostración: *[Crear un reporte médico, mostrar filtrado por médico, ver gráficos del dashboard]*

---

## Preguntas Frecuentes

**¿Por qué no se usa base de datos?**
> Es un proyecto académico. La persistencia en memoria permite enfocarnos en las estructuras de datos y patrones de diseño.

**¿Cómo se maneja la seguridad?**
> Las contraseñas están en texto plano (limitación conocida). Se podría mejorar con hash bcrypt.

**¿Por qué 15 minutos de separación?**
> Es una regla de negocio realista para evitar saturación de consultorios.

**¿Qué pasa si se cierra la aplicación?**
> Se pierden todos los datos (es en memoria). Las mejoras futuras incluirán persistencia.
