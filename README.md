# Sistema Hospitalario - Gestión de Citas Médicas

Sistema de gestión hospitalaria para la administración de pacientes, médicos, recepcionistas, historiales clínicas y citas médicas.

---

## Funcionalidades

| Módulo | Descripción |
|--------|-------------|
| **Login** | Autenticación por código y contraseña según rol |
| **Dashboard** | Gráficos de demanda por especialidad y distribución de seguros (JFreeChart) |
| **Pacientes** | CRUD completo con búsqueda por DNI (Árbol Binario de Búsqueda) |
| **Médicos** | CRUD completo con búsqueda por código (Lista Doblemente Enlazada) |
| **Historiales Clínicos** | Gestión de historial médico por paciente |
| **Agendar Citas** | Programación de citas médicas |

---

## Roles y Permisos

| Rol | Código Login | Acceso |
|-----|--------------|--------|
| Administrador | `admin` | Dashboard, Médicos, Pacientes, Historiales, Citas |
| Recepcionista | `R{DNI}` | Pacientes, Agendar Citas |
| Médico | `M{DNI}` | Historiales Clínicos |

> **Contraseña por defecto:** `12345`

---

## Datos de Prueba (Precarga)

### Usuarios Fijos
| Tipo | Código | Nombre |
|------|--------|--------|
| Admin | `admin` | Admin Principal |
| Médico | `M10000000` | Dr. Carlos Vargas |
| Recepcionista | `R10000000` | Laura Mendoza |
| Paciente | `10000000` | Pedro García |

### Datos Aleatorios
- 10 pacientes con DNIs y seguros aleatorios
- 5 médicos con especialidades variadas
- 3 recepcionistas con turnos rotativos

---

## Arquitectura del Proyecto

```
src/
├── hospitaljy/              # Clase principal y precarga
│   ├── main.java
│   ├── Precargador.java     # Clase abstracta (Template Method)
│   ├── PrecargadorPacientes.java
│   ├── PrecargadorMedicos.java
│   ├── PrecargadorRecepcionistas.java
│   └── PrecargadorAdmins.java
│
├── facade/                  # Patrón Facade
│   └── HospitalFacade.java  # Acceso unificado a todo el sistema
│
├── modelos/                 # Capa de modelos de dominio
│   ├── Paciente.java
│   ├── Medico.java
│   ├── Recepcionista.java
│   ├── Admin.java
│   ├── Usuario.java
│   ├── Cita.java
│   ├── HistorialClinico.java
│   └── Trabajador.java      # Interfaz
│
├── estructuras/             # Estructuras de datos (Singleton)
│   ├── ListaDobleMedico.java
│   ├── ListaDobleRecepcionista.java
│   ├── ListaDobleAdmin.java
│   ├── ListaDobleCita.java
│   └── ListaDobleHistorial.java
│
├── nodos/                   # Nodos para estructuras
│   ├── NodoMedico.java
│   ├── NodoRecepcionista.java
│   ├── NodoAdmin.java
│   ├── NodoCita.java
│   ├── NodoHistorial.java
│   └── NodoArbolPaciente.java
│
├── Arbol/                   # Árbol Binario de Búsqueda
│   └── ArbolPaciente.java   # (Singleton)
│
├── controladores/           # Capa de lógica de negocio
│   ├── GestorAutenticacion.java
│   ├── GestorTablas.java
│   ├── GestorReportes.java
│   ├── AutenticacionStrategy.java     # Interfaz Strategy
│   ├── AdminAutenticacionStrategy.java
│   ├── MedicoAutenticacionStrategy.java
│   └── RecepcionistaAutenticacionStrategy.java
│
├── vistas/                  # Capa de presentación (Swing)
│   ├── FrmPrincipal.java
│   ├── JpLogin.java
│   ├── JpAdmin.java
│   ├── JpPacientes.java
│   ├── JpMedicos.java
│   ├── JpHistorialesClinicos.java
│   └── JpAgendarCita.java
│
└── img/
    └── hospital.png
```

---

## Patrones de Diseño Aplicados

### 1. Facade Pattern (Acceso Unificado)
```java
// Las vistas solo dependen del Facade
private HospitalFacade facade = HospitalFacade.getInstancia();

// En lugar de múltiples imports y singletons:
// private ArbolPaciente arbol = ArbolPaciente.getInstancia();
// private ListaDobleMedico lista = ListaDobleMedico.getInstancia();
// private GestorTablas gestor = new GestorTablas();
// private GestorReportes reportes = new GestorReportes();

// Operaciones simplificadas
facade.login(codigo, password);
facade.insertarPaciente(p);
facade.buscarMedico(dni);
facade.modeloTablaCitas();
facade.obtenerDemandaPorEspecialidad();
```

### 2. Strategy Pattern (Autenticación)
```java
// Interfaz
public interface AutenticacionStrategy {
    Usuario autenticar(String codigo, String password);
    String getRol();
}

// Implementaciones concretas
AdminAutenticacionStrategy
MedicoAutenticacionStrategy
RecepcionistaAutenticacionStrategy
```

### 3. Template Method (Precarga de Datos)
```java
// Clase abstracta
public abstract class Precargador {
    public final void precargar() throws Exception {
        precargarFijo();        // abstract
        precargarAleatorios();  // abstract
    }
}

// Implementaciones
PrecargadorPacientes
PrecargadorMedicos
PrecargadorRecepcionistas
PrecargadorAdmins
```

### 4. Singleton (Estructuras de Datos)
```java
ArbolPaciente.getInstancia()
ListaDobleMedico.getInstancia()
ListaDobleRecepcionista.getInstancia()
ListaDobleAdmin.getInstancia()
ListaDobleCita.getInstancia()
ListaDobleHistorial.getInstancia()
HospitalFacade.getInstancia()
```

---

## API del Facade

### Autenticación
| Método | Retorna | Descripción |
|--------|---------|-------------|
| `login(codigo, password)` | `Usuario` | Valida credenciales |

### Pacientes
| Método | Retorna | Descripción |
|--------|---------|-------------|
| `insertarPaciente(p)` | `boolean` | Inserta paciente |
| `buscarPaciente(dni)` | `Paciente` | Busca por DNI |
| `modificarPaciente(p)` | `boolean` | Modifica paciente |
| `eliminarPaciente(dni)` | `boolean` | Elimina paciente |
| `obtenerPacientes()` | `ArrayList<Paciente>` | Lista todos |
| `modeloTablaPacientes()` | `DefaultTableModel` | Modelo para JTable |

### Médicos
| Método | Retorna | Descripción |
|--------|---------|-------------|
| `insertarMedico(m)` | `boolean` | Inserta médico |
| `buscarMedico(dni)` | `Medico` | Busca por código |
| `modificarMedico(m)` | `boolean` | Modifica médico |
| `eliminarMedico(dni)` | `boolean` | Elimina médico |
| `obtenerMedicos()` | `ArrayList<Medico>` | Lista todos |
| `modeloTablaMedicos()` | `DefaultTableModel` | Modelo para JTable |

### Citas
| Método | Retorna | Descripción |
|--------|---------|-------------|
| `insertarCita(c)` | `boolean` | Inserta cita |
| `modificarCita(c)` | `boolean` | Modifica cita |
| `eliminarCita(dniPac, especialidad)` | `boolean` | Elimina cita |
| `obtenerCitas()` | `ArrayList<Cita>` | Lista todas |
| `modeloTablaCitas()` | `DefaultTableModel` | Modelo para JTable |

### Historiales
| Método | Retorna | Descripción |
|--------|---------|-------------|
| `insertarHistorial(h)` | `boolean` | Inserta historial |
| `buscarHistorial(dniPaciente)` | `HistorialClinico` | Busca por paciente |
| `modificarHistorial(h)` | `boolean` | Modifica historial |
| `eliminarHistorial(dniPaciente)` | `boolean` | Elimina historial |

### Reportes
| Método | Retorna | Descripción |
|--------|---------|-------------|
| `obtenerDemandaPorEspecialidad()` | `HashMap<String, Integer>` | Citas por especialidad |
| `obtenerPacientesPorSeguro()` | `HashMap<String, Integer>` | Pacientes por seguro |

---

## Estructuras de Datos

| Estructura | Tipo | Uso |
|------------|------|-----|
| `ArbolPaciente` | Árbol Binario de Búsqueda | Almacenar y buscar pacientes por DNI |
| `ListaDobleMedico` | Lista Doblemente Enlazada | Almacenar y buscar médicos por código |
| `ListaDobleRecepcionista` | Lista Doblemente Enlazada | Almacenar recepcionistas |
| `ListaDobleAdmin` | Lista Doblemente Enlazada | Almacenar administradores |
| `ListaDobleCita` | Lista Doblemente Enlazada | Almacenar citas médicas |
| `ListaDobleHistorial` | Lista Doblemente Enlazada | Almacenar historiales clínicos |

---

## Credenciales de Prueba

| Usuario | Código | Contraseña | Rol |
|---------|--------|------------|-----|
| Admin | `admin` | `12345` | Administrador |
| Médico | `M10000000` | `12345` | Médico |
| Recepcionista | `R10000000` | `12345` | Recepcionista |
| Paciente | `10000000` | - | Paciente |

---

## Tecnologías Utilizadas

- **Lenguaje:** Java (Swing)
- **IDE:** Apache NetBeans 24
- **Gráficos:** JFreeChart
- **Construcción:** Apache Ant

---

## Ejecución

1. Abrir el proyecto en NetBeans
2. Ejecutar `src/hospitaljy/main.java`
3. Se cargarán automáticamente los datos de prueba
4. Iniciar sesión con las credenciales de la tabla anterior

---

## Diagrama de Componentes

```
┌─────────────────────────────────────────────────────────┐
│                      VISTAS (Swing)                     │
│  JpLogin  JpAdmin  JpPacientes  JpMedicos  JpCitas...  │
└─────────────────────────┬───────────────────────────────┘
                          │
                          ▼
┌─────────────────────────────────────────────────────────┐
│              FACADE (HospitalFacade)                    │
│         Acceso unificado a todo el sistema              │
└───────┬──────────┬──────────┬──────────┬───────────────┘
        │          │          │          │
        ▼          ▼          ▼          ▼
┌──────────┐ ┌──────────┐ ┌──────────┐ ┌──────────┐
│ Auth     │ │ Paciente │ │ Médico   │ │ Cita     │
│ Strategy │ │  Árbol   │ │  Lista   │ │  Lista   │
└──────────┘ └──────────┘ └──────────┘ └──────────┘
```

---

## Modelo de Datos

```
┌─────────────┐
│  Trabajador  │ (Interfaz)
└──────┬──────┘
       │
       ├── Admin
       ├── Medico
       └── Recepcionista

┌─────────────┐
│   Paciente   │
└─────────────┘
       │
       ├── HistorialClinico (1:1)
       └── Cita (1:N)

┌─────────────┐
│    Cita      │
└─────────────┘
   │       │
Paciente  Medico
```