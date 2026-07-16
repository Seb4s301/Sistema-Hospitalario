# Plan de Mejoras — Sistema Hospitalario

## Críticas (Alta Prioridad)

### 1. Persistencia en Base de Datos
**Problema:** Todo se almacena en memoria. Se pierden los datos al cerrar la aplicación.

**Solución:**
- Implementar MySQL/PostgreSQL como backend
- Crear tablas: `pacientes`, `medicos`, `recepcionistas`, `administradores`, `citas`, `historiales`, `reportes`
- Reemplazar las estructuras de datos en memoria por queries SQL
- Mantener el patrón Facade como capa de abstracción

**Esfuerzo estimado:** 2-3 semanas

### 2. Encriptación de Contraseñas
**Problema:** Las contraseñas están en texto plano (`"12345"`).

**Solución:**
- Implementar hash **bcrypt** o **SHA-256** con sal
- Cambiar `boolean autenticar(String password)` para comparar hashes
- Migrar contraseñas existentes

**Esfuerzo estimado:** 2-3 días

### 3. Gestión de Errores
**Problema:** Errores se muestran con `JOptionPane.showMessageDialog()` genérico, sin logging.

**Solución:**
- Implementar sistema de logging (java.util.logging o Log4j)
- Crear clase `ManejadorExcepciones` centralizada
- Mostrar mensajes más descriptivos al usuario

**Esfuerzo estimado:** 1 semana

---

## Importantes (Media Prioridad)

### 4. Separación de Datos de Prueba
**Problema:** Los datos de prueba se generan en `Precargador` con datos hardcodeados.

**Solución:**
- Mover datos de prueba a archivos JSON o CSV
- Crear script de inicialización de la base de datos
- Separar entorno de desarrollo de producción

**Esfuerzo estimado:** 3-4 días

### 5. Validación Centralizada
**Problema:** Las validaciones (DNI 8 dígitos, celular 9 dígitos) están duplicadas en múltiples vistas.

**Solución:**
- Crear clase `Validador` con métodos estáticos
- Mover toda la lógica de validación ahí
- Usar en todas las vistas

**Esfuerzo estimado:** 1-2 días

### 6. Interfaz Responsive
**Problema:** El diseño usa `setBounds()` con posiciones fijas, no se adapta a diferentes tamaños de pantalla.

**Solución:**
- Migrar a `GridBagLayout` o `SpringLayout`
- Usar `JPanel` con layouts anidados
- Probar en diferentes resoluciones

**Esfuerzo estimado:** 1-2 semanas

### 7. Paginación en Tablas
**Problema:** Las tablas muestran todos los registros de una vez.

**Solución:**
- Implementar paginación en `GestorTablas`
- Agregar botones "Anterior"/"Siguiente"
- Mostrar 10-20 registros por página

**Esfuerzo estimado:** 3-4 días

---

## Deseables (Baja Prioridad)

### 8. Exportación de Reportes
**Solución:** Generar PDFs de reportes médicos usando iText o Apache PDFBox.

### 9. Búsqueda Avanzada
**Solución:** Implementar filtros combinados (por ejemplo, buscar pacientes por nombre Y especialidad).

### 10. Interfaz Web
**Solución:** Migrar la lógica de negocio a un backend REST (Spring Boot) y crear frontend con React/Angular.

### 11. Notificaciones
**Solución:** Enviar recordatorios de citas por email o SMS usando APIs externas.

### 12. Auditoría
**Solución:** Registrar todas las acciones (insertar, modificar, eliminar) con timestamp y usuario.

---

## Priorización

| # | Mejora | Prioridad | Esfuerzo | Impacto |
|---|--------|-----------|----------|---------|
| 1 | Base de datos | Alta | Alto | Alto |
| 2 | Encriptación contraseñas | Alta | Bajo | Alto |
| 3 | Gestión de errores | Alta | Medio | Alto |
| 4 | Separar datos de prueba | Media | Bajo | Medio |
| 5 | Validación centralizada | Media | Bajo | Medio |
| 6 | Interfaz responsive | Media | Alto | Medio |
| 7 | Paginación tablas | Media | Medio | Medio |
| 8 | Exportación PDF | Baja | Medio | Bajo |
| 9 | Búsqueda avanzada | Baja | Bajo | Bajo |
| 10 | Interfaz web | Baja | Alto | Alto |
| 11 | Notificaciones | Baja | Alto | Bajo |
| 12 | Auditoría | Baja | Medio | Medio |
