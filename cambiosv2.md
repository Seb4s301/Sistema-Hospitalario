# Changelog v2 — Cambios realizados en la sesión

## 1. Eliminación del paquete `controladores/estrategias/`

**Archivos eliminados:**
- `src/controladores/estrategias/EstrategiaAutenticacion.java`
- `src/controladores/estrategias/EstrategiaAdmin.java`
- `src/controladores/estrategias/EstrategiaMedico.java`
- `src/controladores/estrategias/EstrategiaRecepcionista.java`

**Justificación:** Paquete completo nunca referenciado desde fuera de sí mismo. El sistema de autenticación funcional vive en `src/controladores/AutenticacionStrategy.java` con sus implementaciones `AdminAutenticacionStrategy`, `MedicoAutenticacionStrategy` y `RecepcionistaAutenticacionStrategy`.

**Verificación:** Se ejecutó `grep` buscando `import controladores.estrategias.` en todo el proyecto — 0 resultados. Se eliminó el directorio con `rmdir /s /q`. Compilación exitosa posterior.

---

## 2. Corrección A1 — Comparación de fecha vacía en `JpCitasMedico`

**Archivo:** `src/vistas/JpCitasMedico.java:183`

**Problema:** El `MaskFormatter` con patrón `##/##/####` produce como valor vacío `"  /  /    "` (con espacios), no `"/  /"`. La comparación `fechaTexto.equals("/  /")` nunca era verdadera, por lo que si el usuario dejaba el campo vacío y presionaba "Buscar Por Fecha", se intentaba parsear `"  /  /    "` como fecha, lanzando `ParseException` y mostrando error en vez de cargar todas las citas.

**Cambio:**
```java
// Antes:
if (fechaTexto.equals("/  /") || fechaTexto.isEmpty()) {

// Después:
if (fechaTexto.equals("  /  /    ") || fechaTexto.trim().isEmpty()) {
```

**Detalles técnicos:**
- Se cambió el literal de comparación al placeholder real del `MaskFormatter`
- Se agregó `.trim()` antes de `.isEmpty()` para manejar casos donde el usuario ingresa solo espacios

---

## 3. Corrección de constructor en `FrmPrincipal`

**Archivo:** `src/vistas/FrmPrincipal.java`

**Problema:** En `conectarPaneles()` (línea 32) se llamaba `new JpCitasMedico()` sin argumentos, pero el constructor fue modificado para recibir `String codigoMedico`. Esto causaba error de compilación.

**Cambio:** Se eliminó la línea `panelCitasMedico = new JpCitasMedico()` de `conectarPaneles()`. Ahora `JpCitasMedico` se instancia únicamente en el bloque del médico dentro de `iniciarSesion()`.

---

## 4. Implementación completa de `JpCitasMedico`

**Archivo:** `src/vistas/JpCitasMedico.java`

**Cambios realizados:**

### 4.1 Constructor modificado
```java
// Antes:
public JpCitasMedico() {
    initComponents();
}

// Después:
public JpCitasMedico(String codigoMedico) {
    this.codigoMedico = codigoMedico;
    this.facade = HospitalFacade.getInstancia();
    this.modeloTabla = new DefaultTableModel(null, new String[]{
        "DNI Paciente", "Paciente", "Especialidad", "Fecha"
    }) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    initComponents();
    tblCitasMedico.setModel(modeloTabla);
    cargarCitasMedico();
}
```

**Detalles:**
- Se agregaron campos `final`: `codigoMedico`, `facade`, `modeloTabla`
- El modelo de tabla se crea con 4 columnas (no editables) y se asigna después de `initComponents()` para sobreescribir el modelo por defecto del diseñador
- Se llama `cargarCitasMedico()` al final del constructor para mostrar las citas al abrir el panel

### 4.2 Método `cargarCitasMedico()`
```java
private void cargarCitasMedico() {
    ArrayList<Cita> todas = facade.obtenerCitas();
    ArrayList<Cita> filtradas = new ArrayList<>();
    for (Cita c : todas) {
        if (c.getDniMedico().equals(codigoMedico)) {
            filtradas.add(c);
        }
    }
    mostrarCitas(filtradas);
}
```

**Lógica:** Filtra todas las citas del sistema quedándose solo con las que tienen `dniMedico` igual al `codigoMedico` del médico logueado (ej: `"M12345678"`).

### 4.3 Método `mostrarCitas()`
```java
private void mostrarCitas(ArrayList<Cita> citas) {
    modeloTabla.setRowCount(0);
    SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy", new Locale("es", "PE"));
    for (Cita c : citas) {
        modeloTabla.addRow(new Object[]{
            c.getDniPaciente(),
            c.getNombrePaciente() + " " + c.getApellidoPaciente(),
            c.getEspecialidad(),
            c.getFecha() != null ? fmt.format(c.getFecha()) : ""
        });
    }
}
```

**Detalles:**
- Limpia la tabla con `setRowCount(0)` antes de cargar
- Formatea la fecha con `SimpleDateFormat("dd/MM/yyyy")` y locale español peruano
- Maneja `null` en `getFecha()` mostrando string vacío

### 4.4 Botón "Buscar por DNI"
```java
private void BtnBuscarDNIActionPerformed(...) {
    String dni = txtDNI.getText().trim();
    if (dni.isEmpty()) {
        cargarCitasMedico(); // Si está vacío, muestra todas
        return;
    }
    ArrayList<Cita> todas = facade.obtenerCitas();
    ArrayList<Cita> filtradas = new ArrayList<>();
    for (Cita c : todas) {
        if (c.getDniMedico().equals(codigoMedico) && c.getDniPaciente().equals(dni)) {
            filtradas.add(c);
        }
    }
    mostrarCitas(filtradas);
}
```

**Lógica:** Filtra por DNI médico **y** DNI paciente. Si el campo está vacío, recarga todas las citas del médico.

### 4.5 Botón "Buscar por Fecha"
```java
private void btnBuscarFechaActionPerformed(...) {
    String fechaTexto = txtFecha.getText().trim();
    if (fechaTexto.equals("  /  /    ") || fechaTexto.isEmpty()) {
        cargarCitasMedico();
        return;
    }
    SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy", new Locale("es", "PE"));
    try {
        Date fechaBusqueda = fmt.parse(fechaTexto);
        ArrayList<Cita> todas = facade.obtenerCitas();
        ArrayList<Cita> filtradas = new ArrayList<>();
        for (Cita c : todas) {
            if (c.getDniMedico().equals(codigoMedico) && c.getFecha() != null
                    && fmt.format(c.getFecha()).equals(fmt.format(fechaBusqueda))) {
                filtradas.add(c);
            }
        }
        mostrarCitas(filtradas);
    } catch (ParseException ex) {
        JOptionPane.showMessageDialog(this, "Fecha inválida. Use formato dd/MM/yyyy");
    }
}
```

**Lógica:**
1. Valida el placeholder del MaskFormatter
2. Parsea la fecha del usuario con `SimpleDateFormat`
3. Compara la fecha formateada de cada cita con la fecha formateada de búsqueda (comparación string a string tras formatear)
4. Filtra por médico + coincidencia de fecha

### 4.6 MaskFormatter modificado
```java
// Antes:
txtFecha.setFormatterFactory(new ...MaskFormatter("##/##/#### ##:##"));

// Después:
txtFecha.setFormatterFactory(new ...MaskFormatter("##/##/####"));
```

**Razón:** Solo se busca por día, no por hora.

### 4.7 Modelo de tabla en initComponents actualizado
```java
// Antes: 5 columnas, 4 filas vacías
new Object [][] {
    {null, null, null, null, null},
    ...
},
new String [] {
    "Paciente", "DNI", "Teléfono", "Seguro", "Fecha y Hora"
}

// Después: 4 columnas, 4 filas vacías
new Object [][] {
    {null, null, null, null},
    ...
},
new String [] {
    "DNI Paciente", "Paciente", "Especialidad", "Fecha"
}
```

### 4.8 Actualización en FrmPrincipal.java
```java
// Antes:
panelCitasMedico = new JpCitasMedico();

// Después (línea 70):
panelCitasMedico = new JpCitasMedico(usuario.getUsername());
```

Se pasa `usuario.getUsername()` que contiene el código con prefijo (ej: `"M12345678"`).

---

## 5. Corrección C1 — Historial sobreescrito por reportes

### 5.1 Nuevo método en `GestorTablas.java`

**Archivo:** `src/controladores/GestorTablas.java`

```java
public DefaultTableModel modeloTablaHistorialCompleto(ArrayList<Cita> citas, ArrayList<ReporteMedico> reportes) {
    String[] columnas = {"Fecha", "Medico", "Especialidad", "Sintomas", "Enfermedades", "Tratamiento", "Observaciones"};
    DefaultTableModel modelo = new DefaultTableModel(null, columnas) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy", new Locale("es", "PE"));

    for (ReporteMedico r : reportes) {
        String fechaStr = r.getFecha() != null ? fmt.format(r.getFecha()) : "";
        String medico = "";
        String especialidad = "";

        for (Cita c : citas) {
            String codigoMedicoCita = c.getDniMedico();
            String dniMedicoCita = (codigoMedicoCita != null && codigoMedicoCita.length() > 1)
                    ? codigoMedicoCita.substring(1) : codigoMedicoCita;

            if (dniMedicoCita != null && dniMedicoCita.equals(r.getDniMedico())) {
                medico = c.getNombreMedico() + " " + c.getApellidoMedico();
                especialidad = c.getEspecialidad();
                break;
            }
        }

        modelo.addRow(new Object[]{
            fechaStr, medico, especialidad,
            r.getSintomas(), r.getEnfermedades(), r.getTratamiento(), r.getObservaciones()
        });
    }
    return modelo;
}
```

**Detalles técnicos:**
- Cruza `Cita` + `ReporteMedico` por DNI del médico (no por fecha)
- `Cita.dniMedico` almacena código con prefijo `"M12345678"` → se hace `substring(1)` para obtener el DNI crudo
- `ReporteMedico.dniMedico` almacena DNI sin prefijo `"12345678"`
- La comparación original por fecha fallaba porque `Cita.fecha` = turno del médico y `ReporteMedico.fecha` = `new Date()` (momento del reporte) — nunca coincidían
- Se agregó `import java.util.Locale` al archivo

### 5.2 Nuevo método en `HospitalFacade.java`

**Archivo:** `src/facade/HospitalFacade.java`

```java
public DefaultTableModel modeloTablaHistorialCompleto(String dniPaciente) {
    ArrayList<Cita> todasCitas = listaCitas.obtenerTodos();
    ArrayList<Cita> citasPaciente = new ArrayList<>();
    for (Cita c : todasCitas) {
        if (c.getDniPaciente().equals(dniPaciente)) {
            citasPaciente.add(c);
        }
    }
    ArrayList<ReporteMedico> reportes = listaReportes.buscarPorPaciente(dniPaciente);
    return gestorTablas.modeloTablaHistorialCompleto(citasPaciente, reportes);
}
```

**Flujo:**
1. Obtiene todas las citas del sistema
2. Filtra las del paciente por `dniPaciente`
3. Obtiene los reportes del paciente
4. Delega al `GestorTablas` el cruzamiento y generación del modelo

### 5.3 Reescritura de `JpHistorialesClinicos.java`

**Archivo:** `src/vistas/JpHistorialesClinicos.java`

**Cambios:**
- Se eliminaron los labels de datos del paciente (`lblDNI`, `lblNombre`, `lblTipoSangre`, `lblAlergias`, `lblEnfermedades`)
- Se eliminaron los labels descriptivos (`jLabel3`-`jLabel7`)
- Se eliminó el título `jLabel2` ("Historial Clínico del Paciente")
- Se eliminó el método `limpiarDatosPaciente()`
- Se agregó `jButton1` ("Ver Observaciones") con action listener
- Se agregó `txtObservaciones` (`JTextArea`, no editable, dentro de `jScrollPane3`)
- Tabla con 7 columnas: Fecha, Médico, Especialidad, Síntomas, Enfermedades, Tratamiento, Observaciones

**Event handler `btnBuscarActionPerformed`:**
1. Valida DNI no vacío
2. Busca paciente en el árbol BST
3. Si no existe → limpia tabla y muestra error
4. Si existe → carga tabla con `facade.modeloTablaHistorialCompleto(dniBusqueda)`
5. Limpia `txtObservaciones`
6. Si la tabla queda vacía → muestra mensaje informativo

**Event handler `jButton1ActionPerformed`:**
1. Valida que haya fila seleccionada (`getSelectedRow()`)
2. Lee columna 6 (Observaciones) de la fila seleccionada
3. Si está vacía o es `null` → muestra "El paciente no cuenta con observaciones en esta cita"
4. Si tiene contenido → lo muestra en `txtObservaciones`

---

## 6. Corrección C2 — Descartada

**Original:** La fecha de la cita se tomaba de `m.getTurno()` (turno del médico) ignorando input del usuario.

**Resolución:** Se descartó porque `txtTurno` solo verifica si el médico tiene turno disponible. Si no tiene turno, no se agenda. La fecha de la cita **es** el turno del médico por diseño.

---

## 7. Resumen de bugs descartados

| # | Problema | Razón de descarte |
|---|----------|-------------------|
| A2 | `getDni()` con string vacío | Constructor por defecto es solo para sobrecarga; el usuario no puede ingresar DNI vacío (validado en JFrame) |
| C2 | Fecha de cita usa turno | Diseño intencional — turno = disponibilidad del médico |

---

## 8. Archivos modificados (resumen)

| Archivo | Cambios |
|---------|---------|
| `src/vistas/JpCitasMedico.java` | Constructor con parámetro, lógica de búsqueda por DNI y fecha, modelo de tabla |
| `src/vistas/FrmPrincipal.java` | Eliminación de `new JpCitasMedico()` de `conectarPaneles()`, creación en bloque médico |
| `src/vistas/JpHistorialesClinicos.java` | Reescritura completa: tabla de historial, botón observaciones, textArea |
| `src/controladores/GestorTablas.java` | Nuevo método `modeloTablaHistorialCompleto()`, import de `Locale` |
| `src/facade/HospitalFacade.java` | Nuevo método `modeloTablaHistorialCompleto(dniPaciente)` |
| `src/controladores/estrategias/` | Eliminación completa del directorio (4 archivos) |

---

## 9. Compilación verificada

Se ejecutó `javac -encoding UTF-8 -cp src -d bin` tras cada cambio significativo. Todos los archivos compilan sin errores.

---

## 10. Bugs pendientes de corrección

| # | Severidad | Problema |
|---|-----------|----------|
| C3 | CRÍTICO | Validación 15 min sin sentido (compara turno contra sí misma) |
| A3 | ALTO | NPE en `ListaDobleCita` si `getEspecialidad()` es null |
| A4 | ALTO | Package `arbol` vs directorio `Arbol` (case sensitivity en Linux/Mac) |
| M1 | MEDIO | `reportes.isEmpty()` puede NPE en `JpHistorialesClinicos:138` (código viejo) |
| M2 | MEDIO | Sin validación de duplicados al insertar |
| M3 | MEDIO | `Cita.dniMedico` almacena código con prefijo, `ReporteMedico.dniMedico` sin prefijo |
| M4 | MEDIO | Variables de instancia usadas como locales en `JpPacientes` y `JpMedicos` |
| M5 | MEDIO | `buscar()` y `buscarPorDni()` duplicados en `ListaDobleRecepcionista` |
| B2 | BAJO | `jTextArea1` y `jScrollPane2` invisibles en `JpPacientes` |
| B3 | BAJO | 4 JTabbedPane creados y destruidos en `FrmPrincipal` |
| B4 | BAJO | Métodos vacíos con TODO en `JpLogin`, `JpPacientes`, `JpCerrarSesion` |
| B5 | BAJO | Falta `eliminarAdmin`/`modificarAdmin` en facade |
