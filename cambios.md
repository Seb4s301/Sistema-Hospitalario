# Historial de Cambios - Sistema Hospitalario

## [Fecha: 15 de julio de 2026]

### 1. Búsqueda de médicos por turno en JpAgendarCita

**Archivos modificados:**
- `src/estructuras/ListaDobleMedico.java`
- `src/facade/HospitalFacade.java`
- `src/vistas/JpAgendarCita.java`

**Cambios:**
- `ListaDobleMedico.buscarPorTurno()`: Cambiado parámetro de `String` a `Date` para comparar correctamente contra el campo `turno` (tipo `Date`) del modelo `Medico`
- `HospitalFacade.buscarMedicoTurno()`: Cambiado parámetro de `String` a `Date` para coincidir con la estructura
- `JpAgendarCita.imprimirMedico()`: Reescrito completamente:
  - Si `txtDniMedico` tiene texto → busca por DNI
  - Si `txtTurno` tiene texto → parsea la fecha con `SimpleDateFormat("dd/MM/yyyy HH:mm")` y busca por turno
  - Si ambos vacíos → llama `listar()` para mostrar todos
  - Manejo de errores de formato de fecha

---

### 2. Análisis completo del proyecto

**Se identificaron los siguientes problemas:**

#### Crash críticos
- `FrmPrincipal.java`: `panelCitasMedico` nunca se inicializaba → NPE al iniciar sesión como Médico
- `FrmPrincipal.java`: `panelReportesClinicos` nunca se inicializaba → NPE al iniciar sesión como Médico

#### Funcionalidades rotas
- `JpAgendarCita.java`: `imprimirMedico()` descartaba el resultado de `buscarMedico()` — la tabla nunca se actualizaba
- `JpReportesClinicos.java`: `addRow()` pasaba 5 valores pero la tabla tenía 6 columnas — columna DNI siempre `null`
- `JpReportesClinicos.java`: Accedía directamente a `ListaDobleReporte` en vez del Facade
- `JpCitasMedico.java`: Panel completamente sin implementar

#### Código muerto eliminado
- `src/modelos/Trabajador.java`: Interface nunca implementada (eliminado)
- `JpCerrarSesion.java`: Botón renombrado de `btnIngresar1` a `btnCerrarSesion`

---

### 3. JpReportesClinicos - Acceso al Facade

**Archivos modificados:**
- `src/vistas/JpReportesClinicos.java`

**Cambios:**
- Eliminado acceso directo a `ListaDobleReporte.getInstancia()`
- `btnInsertar`: Usa `facade.buscarReporte()`, `facade.insertarReporte()`, `facade.modeloTablaReportes()`
- `btnModificar`: Usa `facade.modificarReporte()`, `facade.modeloTablaReportes()`
- La columna DNI ahora se muestra correctamente (antes siempre era `null`)

---

### 4. Implementación completa de Reportes Clínicos con soporte para múltiples reportes por paciente

**Archivos modificados:**
- `src/modelos/ReporteMedico.java`
- `src/estructuras/ListaDobleReporte.java`
- `src/facade/HospitalFacade.java`
- `src/controladores/GestorTablas.java`
- `src/vistas/JpReportesClinicos.java`
- `src/vistas/FrmPrincipal.java`
- `src/vistas/JpHistorialesClinicos.java`

#### Cambios detallados:

**`ReporteMedico.java`:**
- Agregado campo `dniMedico` (String) — identifica qué médico creó el reporte
- Agregado campo `fecha` (Date) — fecha de creación del reporte
- Constructor actualizado con los nuevos parámetros
- Agregados getters/setters para los nuevos campos

**`ListaDobleReporte.java`:**
- `buscar()`: Ahora recibe `dniPaciente` + `fecha` como clave compuesta
- `modificar()`: Ahora busca por `dniPaciente` + `fecha`
- `eliminar()`: Ahora busca por `dniPaciente` + `fecha`
- Agregado `buscarPorMedico(String dniMedico)`: Retorna todos los reportes de un médico
- Agregado `buscarPorPaciente(String dniPaciente)`: Retorna todos los reportes de un paciente
- Agregado import de `java.util.Date`

**`HospitalFacade.java`:**
- `insertarReporte()`: Eliminado check de DNI duplicado (un paciente puede tener múltiples reportes)
- `buscarReporte()`: Ahora recibe `dniPaciente` + `fecha`
- Agregado `obtenerReportesPorMedico(String dniMedico)`: Retorna reportes de un médico específico
- Agregado `obtenerReportesPorPaciente(String dniPaciente)`: Retorna reportes de un paciente específico

**`GestorTablas.java`:**
- `modeloTablaReportes()`: Agregada columna "Fecha" (ahora 7 columnas)
- Tabla configurada como no editable (`isCellEditable` retorna `false`)
- Formato de fecha: `SimpleDateFormat("dd/MM/yyyy HH:mm")`

**`JpReportesClinicos.java`:**
- Constructor ahora recibe `dniMedico` como parámetro
- Agregado campo `dniMedico` y `fechaSeleccionada`
- Agregado método `listar()` que filtra reportes por médico
- `listar()` se llama en el constructor (la tabla carga datos al abrir)
- `btnInsertar`: 
  - Eliminada verificación de DNI duplicado
  - Observaciones es opcional (quitado de validación de campos vacíos)
  - Fecha se auto-genera con `new Date()` (fecha actual)
  - `dniMedico` se asigna automáticamente del médico logueado
- `btnModificar`:
  - Usa `fechaSeleccionada` para identificar el reporte a modificar
  - Valida que se haya seleccionado un reporte de la tabla
- Agregado `jTable2MouseClicked`: Clic en tabla carga datos en los campos
- Etiqueta de observaciones cambiada a "Observaciones (opcional):"
- Tabla default model actualizado con 7 columnas

**`FrmPrincipal.java`:**
- Eliminada creación de `panelReportesClinicos` en `conectarPaneles()`
- `iniciarSesion()`: Para rol "Medico", crea `JpReportesClinicos(dniMedico)` pasando el DNI del médico (extraído de `usuario.getUsername().substring(1)`)

**`JpHistorialesClinicos.java`:**
- `btnBuscarActionPerformed`: Cambiado de `facade.buscarReporte(dniBusqueda)` a `facade.obtenerReportesPorPaciente(dniBusqueda)`
- Ahora muestra todos los reportes de un paciente (no solo el primero)
- Default model de jTable1 actualizado con 7 columnas (incluyendo "Fecha")

---

### 5. Corrección de gráficos en JpAdmin

**Archivos modificados:**
- `src/vistas/JpAdmin.java`

**Cambios:**
- `generarGraficoEspecialidades()`: 
  - Eliminado `removeAll()` duplicado (ya lo hace `actualizarDashboard()`)
  - Agregado `panelGraficoEspecialidades.repaint()` después de `validate()` — fuerza a Swing a redibujar el contenido
- `generarGraficoSeguros()`:
  - Eliminado `removeAll()` duplicado
  - Agregado `panelGraficoSeguros.repaint()` después de `validate()`

**Problema que resuelve:** Los gráficos no se actualizaban visualmente al hacer clic en "Refrescar" porque `validate()` solo recalcula layout pero no dibuja. `repaint()` fuerza el redibujado.

---

## Resumen de archivos modificados

| Archivo | Cambios realizados |
|---------|-------------------|
| `src/modelos/ReporteMedico.java` | Agregados campos `dniMedico` y `fecha` |
| `src/estructuras/ListaDobleMedico.java` | `buscarPorTurno()` cambió parámetro a `Date` |
| `src/estructuras/ListaDobleReporte.java` | Clave compuesta DNI+fecha, nuevos métodos de búsqueda |
| `src/facade/HospitalFacade.java` | Nuevos métodos, eliminado check duplicado |
| `src/controladores/GestorTablas.java` | Columna "Fecha" en reportes, tabla no editable |
| `src/vistas/JpReportesClinicos.java` | Reescritura completa con Facade, listar, clic en tabla |
| `src/vistas/JpAgendarCita.java` | Búsqueda de médico por DNI o turno |
| `src/vistas/JpAdmin.java` | Fix de.repaint() en gráficos |
| `src/vistas/FrmPrincipal.java` | Creación de JpReportesClinicos con dniMedico |
| `src/vistas/JpHistorialesClinicos.java` | Mostrar todos los reportes de un paciente |
| `src/vistas/JpCerrarSesion.java` | Botón renombrado a `btnCerrarSesion` |
| `src/modelos/Trabajador.java` | Eliminado (código muerto) |
