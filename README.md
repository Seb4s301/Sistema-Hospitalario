# Sistema Hospitalario — Documentación Técnica

## 1. Visión General

Sistema de gestión hospitalaria desarrollado en Java Swing, siguiendo arquitectura MVC con patrones de diseño Singleton, Facade, Strategy y Template Method. Gestiona pacientes, médicos, recepcionistas, administradores, citas médicas, historiales clínicos y reportes médicos.

**Total de archivos Java:** 46  
**Dependencia externa:** JFreeChart (gráficos del dashboard)

---

## 2. Arquitectura del Sistema

```
main.java (Punto de entrada)
    │
    ├── Precarga de datos en estructuras
    │
    └── FrmPrincipal (JFrame principal)
            │
            ├── JpLogin              → Autenticación
            ├── JpAdmin              → Dashboard con gráficos
            ├── JpPacientes          → CRUD Pacientes
            ├── JpMedicos            → CRUD Médicos
            ├── JpAgendarCita        → Agendamiento de citas
            ├── JpCitasMedico        → Citas del médico
            ├── JpHistorialesHospitalarios → Historiales
            ├── JpReportesHospitalarios    → Reportes médicos
            └── JpCerrarSesion       → Cierre de sesión
```

### Capas

| Capa | Paquete | Función |
|------|---------|---------|
| **Modelo** | `modelos/` | Entidades de dominio (POJOs) |
| **Nodos** | `nodos/` | Nodos de estructuras de datos |
| **Estructuras** | `estructuras/`, `arbol/` | Estructuras de datos personalizadas |
| **Controladores** | `controladores/` | Lógica de negocio, autenticación, tablas |
| **Fachada** | `facade/` | API unificada para las vistas |
| **Vistas** | `vistas/` | Interfaz gráfica (Java Swing) |
| **Precarga** | `hospitaljy/` | Carga inicial de datos de prueba |

---

## 3. Patrones de Diseño

### 3.1 Singleton
Implementado en 8 clases: `ArbolPaciente`, las 6 listas dobles (`ListaDobleAdmin`, `ListaDobleMedico`, `ListaDobleRecepcionista`, `ListaDobleCita`, `ListaDobleHistorial`, `ListaDobleReporte`) y `HospitalFacade`. Inicialización lazy con método `getInstancia()`.

### 3.2 Facade
`HospitalFacade` encapsula toda la complejidad interna (estructuras, autenticación, generación de tablas, reportes). Todas las vistas interactúan exclusivamente con esta clase.

### 3.3 Strategy
`AutenticacionStrategy` (interfaz) con 3 implementaciones concretas: `AdminAutenticacionStrategy`, `MedicoAutenticacionStrategy`, `RecepcionistaAutenticacionStrategy`. `GestorAutenticacion` itera las estrategias hasta encontrar una que retorne un `Usuario`.

### 3.4 Template Method
`Precargador` (clase abstracta) define el molde: `precargarFijo()` → `precargarAleatorios()`. Las 4 subclases (`PrecargadorPacientes`, `PrecargadorAdmins`, `PrecargadorMedicos`, `PrecargadorRecepcionistas`) implementan los pasos específicos.

---

## 4. Estructuras de Datos

### 4.1 Árbol Binario de Búsqueda (BST)
- **Clase:** `ArbolPaciente`
- **Nodo:** `NodoArbolPaciente` (hijo izquierdo/derecho)
- **Clave:** DNI del paciente (String)
- **Operaciones:** Insertar, buscar, modificar, eliminar (sucesor in-order), recorrido in-orden
- **Complejidad:** O(log n) promedio, O(n) peor caso

### 4.2 Listas Doblemente Enlazadas (6)
- **Clases:** `ListaDobleAdmin`, `ListaDobleMedico`, `ListaDobleRecepcionista`, `ListaDobleCita`, `ListaDobleHistorial`, `ListaDobleReporte`
- **Nodos:** `NodoAdmin`, `NodoMedico`, `NodoRecepcionista`, `NodoCita`, `NodoHistorial`, `NodoReporte`
- **Punteros:** `ini` (inicio), `fin` (final)
- **Operaciones:** Insertar, buscar, modificar, eliminar, obtenerTodos
- **Complejidad:** O(n) para búsqueda lineal

### 4.3 Regla de Negocio en Citas
`ListaDobleCita.validarSeparacion15Minutos()` verifica que no exista otra cita para el mismo médico dentro de 15 minutos de la fecha propuesta.

---

## 5. Modelos de Dominio

### 5.1 Paciente
| Campo | Tipo | Validación |
|-------|------|------------|
| `dni` | String | 8 dígitos numéricos |
| `nombres` | String | No vacío |
| `apellidos` | String | No vacío |
| `fechaNacimiento` | Date | Formato dd/MM/yyyy |
| `celular` | String | 9 dígitos numéricos |
| `seguro` | String | Nombre del asegurador |

### 5.2 Medico
| Campo | Tipo | Nota |
|-------|------|------|
| `codigo` | String | Prefijo "M" + DNI |
| `nombres` | String | |
| `apellidos` | String | |
| `turno` | Date | Fecha/hora del turno (dd/MM/yyyy HH:mm) |
| `celular` | String | 9 dígitos |
| `especialidad` | String | JComboBox con 9 opciones |

### 5.3 Cita
| Campo | Tipo | Nota |
|-------|------|------|
| `dniPaciente` | String | DNI del paciente |
| `nombrePaciente` | String | Datos denormalizados |
| `apellidoPaciente` | String | |
| `dniMedico` | String | Código con prefijo "M" |
| `nombreMedico` | String | Datos denormalizados |
| `apellidoMedico` | String | |
| `especialidad` | String | |
| `fecha` | Date | Fecha de la cita |

**Clave compuesta:** dniPaciente + especialidad

### 5.4 ReporteMedico
| Campo | Tipo | Nota |
|-------|------|------|
| `dniPaciente` | String | |
| `dniMedico` | String | Médico que creó el reporte |
| `sintomas` | String | Obligatorio |
| `alergias` | String | Obligatorio |
| `enfermedades` | String | Obligatorio |
| `tratamiento` | String | Obligatorio |
| `observaciones` | String | Opcional |
| `fecha` | Date | Auto-generada al insertar |

**Clave compuesta:** dniPaciente + fecha

### 5.5 HistorialClinico
| Campo | Tipo |
|-------|------|
| `dniPaciente` | String |
| `tipoSangre` | String |
| `alergias` | String |
| `enfermedadesCronicas` | String |
| `observacionesMedicas` | String |

### 5.6 Admin / Recepcionista
- **Admin:** Código con prefijo "A", cargo (por defecto "Administrador")
- **Recepcionista:** Código con prefijo "R", turno (Manana/Tarde/Noche)

---

## 6. Funcionalidades por Rol

### 6.1 Administrador
| Pestaña | Funcionalidad |
|---------|---------------|
| Dashboard | Gráfico de barras (demanda por especialidad), gráfico circular (pacientes por seguro), botón refrescar |
| Médicos | Insertar, modificar, eliminar médicos |
| Pacientes | Insertar, modificar, eliminar pacientes |
| Historiales | Buscar historial por DNI, ver observaciones |
| Agendar Citas | Buscar paciente/médico, agendar citas |
| Sesión | Cerrar sesión |

### 6.2 Médico
| Pestaña | Funcionalidad |
|---------|---------------|
| Citas | Ver citas asignadas, filtrar por DNI o fecha |
| Reportes | Crear/modificar reportes médicos (solo los suyos) |
| Historiales | Buscar historial de pacientes |
| Sesión | Cerrar sesión |

### 6.3 Recepcionista
| Pestaña | Funcionalidad |
|---------|---------------|
| Pacientes | Insertar, modificar, eliminar pacientes |
| Agendar Citas | Buscar paciente/médico, agendar citas |
| Sesión | Cerrar sesión |

---

## 7. Autenticación

### Códigos de usuario
| Rol | Formato | Ejemplo |
|-----|---------|---------|
| Administrador | `A` + DNI | `A10000000` |
| Médico | `M` + DNI | `M10000000` |
| Recepcionista | `R` + DNI | `R10000000` |

### Flujo
1. Usuario ingresa código y contraseña
2. `GestorAutenticacion` itera las 3 estrategias
3. Cada estrategia busca por código primero, luego por DNI
4. Si encuentra y la contraseña es `"12345"`, retorna `Usuario` con el rol
5. `FrmPrincipal` muestra las pestañas según el rol

---

## 8. Precarga de Datos

Al iniciar la aplicación se cargan datos de prueba:

| Entidad | Fijos | Aleatorios | Total |
|---------|-------|------------|-------|
| Pacientes | 1 (Pedro García, DNI 10000000) | 10 | 11 |
| Médicos | 1 (Dr. Carlos Vargas, DNI 10000000) | 5 | 6 |
| Recepcionistas | 1 (Laura Mendoza, DNI 10000000) | 3 | 4 |
| Administradores | 1 (Admin Principal, DNI 10000000) | 0 | 1 |

### Especialidades médicas disponibles
Traumatología, Pediatría, Oftalmología, Neurología, Endocrinología, Oncología, Dermatología, Cardiología, Gastroenterología

---

## 9. API del Facade (HospitalFacade)

### Autenticación
- `Usuario login(String codigo, String password)`

### Pacientes
- `boolean insertarPaciente(Paciente p)`
- `Paciente buscarPaciente(String dni)`
- `boolean modificarPaciente(Paciente p)`
- `boolean eliminarPaciente(String dni)`
- `ArrayList<Paciente> obtenerPacientes()`
- `DefaultTableModel modeloTablaPacientes()`

### Médicos
- `boolean insertarMedico(Medico m)`
- `Medico buscarMedico(String dni)`
- `Medico buscarMedicoPorCodigo(String codigo)`
- `Medico buscarMedicoTurno(Date turno)`
- `boolean modificarMedico(Medico m)`
- `boolean eliminarMedico(String dni)`
- `ArrayList<Medico> obtenerMedicos()`
- `DefaultTableModel modeloTablaMedicos()`

### Citas
- `boolean insertarCita(Cita c)` — con validación de 15 minutos
- `boolean modificarCita(Cita c)`
- `boolean eliminarCita(String dniPaciente, String especialidad)`
- `ArrayList<Cita> obtenerCitas()`
- `DefaultTableModel modeloTablaCitas()`

### Historiales
- `boolean insertarHistorial(HistorialClinico h)`
- `HistorialClinico buscarHistorial(String dniPaciente)`
- `boolean modificarHistorial(HistorialClinico h)`
- `boolean eliminarHistorial(String dniPaciente)`
- `DefaultTableModel modeloTablaHistoriales(ArrayList<HistorialClinico>)`

### Reportes Médicos
- `boolean insertarReporte(ReporteMedico r)`
- `ReporteMedico buscarReporte(String dniPaciente, Date fecha)`
- `boolean modificarReporte(ReporteMedico r)`
- `ArrayList<ReporteMedico> obtenerReportesPorMedico(String dniMedico)`
- `ArrayList<ReporteMedico> obtenerReportesPorPaciente(String dniPaciente)`
- `DefaultTableModel modeloTablaReportes(ArrayList<ReporteMedico>)`

### Analytics
- `HashMap<String, Integer> obtenerDemandaPorEspecialidad()`
- `HashMap<String, Integer> obtenerPacientesPorSeguro()`

---

## 10. Tabla de Archivos

| # | Archivo | Líneas | Función |
|---|---------|--------|---------|
| 1 | `main.java` | 63 | Punto de entrada, precarga, configuración visual |
| 2 | `Precargador.java` | 51 | Clase abstracta Template Method |
| 3 | `PrecargadorPacientes.java` | 58 | Precarga 11 pacientes |
| 4 | `PrecargadorMedicos.java` | 58 | Precarga 6 médicos |
| 5 | `PrecargadorRecepcionistas.java` | 44 | Precarga 4 recepcionistas |
| 6 | `PrecargadorAdmins.java` | 34 | Precarga 1 admin |
| 7 | `Usuario.java` | 42 | DTO de sesión |
| 8 | `Paciente.java` | 81 | Modelo paciente |
| 9 | `Medico.java` | 90 | Modelo médico |
| 10 | `Admin.java` | 86 | Modelo administrador |
| 11 | `Recepcionista.java` | 90 | Modelo recepcionista |
| 12 | `Cita.java` | 94 | Modelo cita |
| 13 | `HistorialClinico.java` | 62 | Modelo historial |
| 14 | `ReporteMedico.java` | 92 | Modelo reporte |
| 15 | `NodoArbolPaciente.java` | 39 | Nodo BST |
| 16 | `NodoAdmin.java` | 39 | Nodo lista admin |
| 17 | `NodoMedico.java` | 39 | Nodo lista médico |
| 18 | `NodoRecepcionista.java` | 39 | Nodo lista recepcionista |
| 19 | `NodoCita.java` | 40 | Nodo lista cita |
| 20 | `NodoHistorial.java` | 39 | Nodo lista historial |
| 21 | `NodoReporte.java` | 42 | Nodo lista reporte |
| 22 | `ArbolPaciente.java` | 115 | BST de pacientes |
| 23 | `ListaDobleAdmin.java` | 100 | Lista admin |
| 24 | `ListaDobleMedico.java` | 120 | Lista médico |
| 25 | `ListaDobleRecepcionista.java` | 100 | Lista recepcionista |
| 26 | `ListaDobleCita.java` | 114 | Lista cita |
| 27 | `ListaDobleHistorial.java` | 94 | Lista historial |
| 28 | `ListaDobleReporte.java` | 119 | Lista reporte |
| 29 | `AutenticacionStrategy.java` | 8 | Interfaz Strategy |
| 30 | `AdminAutenticacionStrategy.java` | 27 | Auth admin |
| 31 | `MedicoAutenticacionStrategy.java` | 27 | Auth médico |
| 32 | `RecepcionistaAutenticacionStrategy.java` | 27 | Auth recepcionista |
| 33 | `GestorAutenticacion.java` | 24 | Orquestador auth |
| 34 | `GestorTablas.java` | 143 | Generador de tablas |
| 35 | `GestorReportes.java` | 43 | Analytics |
| 36 | `HospitalFacade.java` | 259 | Fachada central |
| 37 | `FrmPrincipal.java` | 113 | JFrame principal |
| 38 | `JpLogin.java` | 212 | Panel login |
| 39 | `JpAdmin.java` | 133 | Dashboard gráficos |
| 40 | `JpPacientes.java` | 326 | CRUD pacientes |
| 41 | `JpMedicos.java` | 331 | CRUD médicos |
| 42 | `JpAgendarCita.java` | 318 | Agendamiento |
| 43 | `JpCitasMedico.java` | 216 | Citas del médico |
| 44 | `JpHistorialesHospitalarios.java` | 185 | Historiales |
| 45 | `JpReportesHospitalarios.java` | 325 | Reportes médicos |
| 46 | `JpCerrarSesion.java` | 117 | Cierre de sesión |
