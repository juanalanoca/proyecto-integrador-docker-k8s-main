# Proyecto Final - Docker & Kubernetes

**Alumno:** JUAN CARLOS ALANOCA TICONA
**Fecha:** 31/10/2025
**Curso:** Docker & Kubernetes - i-Quattro

## Links de Docker Hub
- Backend v2.1: https://hub.docker.com/r/juanalanoca/springboot-api/tags
- Frontend v2.2: https://hub.docker.com/r/juanalanoca/angular-frontend/tags

## Parte 1: Setup del Ambiente

**Ambiente utilizado:**
- VirtualBox
- Nombre de VM/Instancia: juan-alanoca-k8
- Sistema operativo: Ubuntu (64-bit)
- Recursos: 4GB RAM, 2 CPU cores
- Red configurada:(13)I219-LM Intel
- Rango MetalLB: 10.241.2.240-10.241.2.250

### Screenshots
**configuracion maquina virtual:**
![microk8s status](screenshots/v2.0/confguracion_maquina_virtual.png)

**microk8s status:**
![microk8s status](screenshots/v2.0/microk8s_status.png)

![Pods running](screenshots/parte1-pods-running.png)
![Frontend via MetalLB](screenshots/parte1-frontend-browser.png)

## Parte 2: Backend v2.1
[Descripción de cambios realizados]

### Código Agregado
[Snippet del endpoint /api/info]

### Screenshots
![Docker build](screenshots/parte2-docker-build.png)
![Rollout](screenshots/parte2-rollout.png)
![API Info](screenshots/parte2-api-info.png)

## Parte 3: Frontend v2.2
[Descripción de cambios en Angular]

### Screenshots
![Frontend build](screenshots/parte3-frontend-build.png)
![Frontend UI](screenshots/parte3-frontend-ui.png)
![System info display](screenshots/parte3-system-info.png)

## Parte 4: Gestión de Versiones

### ¿Qué hace kubectl rollout undo?
[Tu explicación]

### Screenshots
![Rollback](screenshots/parte4-rollback.png)
![Rollforward](screenshots/parte4-rollforward.png)

## Parte 5: Ingress + MetalLB

**IP del Ingress:** [Tu IP de MetalLB]

### Screenshots
![Ingress config](screenshots/parte5-ingress.png)
![Acceso externo](screenshots/parte5-external-access.png)

## Conclusiones

### Aprendizajes principales
- [Punto 1]
- [Punto 2]
- [Punto 3]

### Dificultades encontradas
- [Dificultad 1 y cómo la resolviste]
- [Dificultad 2 y cómo la resolviste]

### Reflexión
[¿Cómo aplicarías esto en un proyecto real?]
