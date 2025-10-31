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

**configuracion HPA para backend:**
![microk8s status](screenshots/v2.0/configurarHPAparabackend.png)

**kubectl version:**
![microk8s status](screenshots/v2.0/kubectl_version.png)

**configurar MetalLB:**
![microk8s status](screenshots/v2.0/configurar_metallb_ip.png)

**Estado de todos los recursos:**
![microk8s status](screenshots/v2.0/estado_de_todos_los_recursos.png)

**ingress routing HTTP:**
![microk8s status](screenshots/v2.0/Paso6Ingress-rountungHTTP.png)

**Proyecto Integrado Springboot:**
![microk8s status](screenshots/v2.0/springbootAPI_proyecto_integrador.png)

**Probando Funcionalidad:**
![microk8s status](screenshots/v2.0/probando_funcionalidad_crear_usuario.png)



## Parte 2: Backend v2.1
**se edita el archivo controller con el siguiente codigo**
```java
@GetMapping("/api/info")
public ResponseEntity<Map<String, Object>> getInfo() {
    Map<String, Object> info = new HashMap<>();
    info.put("alumno", "TU NOMBRE COMPLETO");
    info.put("version", "v2.1");
    info.put("curso", "Docker & Kubernetes - i-Quattro");
    info.put("timestamp", LocalDateTime.now().toString());
    info.put("hostname", System.getenv("HOSTNAME"));
    return ResponseEntity.ok(info);
}
```

### Código Agregado

### Screenshots
**Cambio nuevo end point:**
![microk8s status](screenshots/v2.1/nuevo_end_point.png)

**aplicar cambios:**
![microk8s status](screenshots/v2.1/aplicar_cambios_estado_rollout.png)

**crearcion de imagen:**
![microk8s status](screenshots/v2.1/imagen_JC_creada_correctamentev2-1.png)

**pods actualizandoce:**
![microk8s status](screenshots/v2.1/pods_actualizandose.png)

**prueba curl json:**
![microk8s status](screenshots/v2.1/prueba_nuevo_enpoint_curl_json.png)

**publicar imagen en Docker:**
![microk8s status](screenshots/v2.1/publicar_imagen_en_docker.png)

**verifica imagen en la web Docker HUB:**
![microk8s status](screenshots/v2.1/verifica_imagen_en_web_dockerHub.png)




## Parte 3: Frontend v2.2
#### 3.1 Modificar Frontend Angular
Agregar funcionalidad en el frontend para consumir el nuevo endpoint `/api/info`, versionar como v2.2 y desplegar.

### Screenshots

**modificando componente TS:**
![microk8s status](screenshots/v2.2/modificando_component-ts-html.png)

**modificando componente HTML:**
![microk8s status](screenshots/v2.2/modificacion_appcomponent_html.png)

**`kubectl get pods -w` durante el rolling update del frontend**
![microk8s status](screenshots/v2.2/rollouts-status_PODS.png)

**IMAGEN EN DOCKER HUB- VER BOTON E INFORMACION DEL SISTEMA:**
![microk8s status](screenshots/v2.2/mostrando_boton_info_e_informacion_sistema.png)

**VERIFICANDO CAMBIO A V2.2 EN DOCKER HUB:**
![microk8s status](screenshots/v2.2/verificacion_cambiov2-2-webdocker.png)




## Parte 4: Gestión de Versiones

### ¿Qué hace kubectl rollout undo?

kubectl rollout undo es un comando crucial para la gestión de versiones y la recuperación de desastres en Kubernetes. Permite revertir una implementación (deployment) a una revisión anterior de forma rápida y segura. Cuando un nuevo despliegue causa problemas, rollout undo desactiva la versión problemática y vuelve a desplegar una versión estable previa. Esto se logra manteniendo el historial de revisiones del deployment. Por ejemplo, si la versión actual es la 3 y hubo problemas, rollout undo la revertirá a la versión 2 , EN MI CASO A LA 6.


### Screenshots

**rollout history backend:**
![microk8s status](screenshots/parte4/rollout_histori_backend.png)

**rollout history frontend:**
![microk8s status](screenshots/parte4/rollout_history_frontend.png)

**proceso de rollback (undo)**
![microk8s status](screenshots/parte4/proceso_rollback_undo_status.png)

**rollforward (undo --to-revision=2)**
![microk8s status](screenshots/parte4/verificandorollforwart_undo_revision6.png)

**verificando que `/api/info` volvió a funcionar**
![microk8s status](screenshots/parte4/verificandorollforwart_undo_revision6.png)

**verificando que `/api/info`**
![microk8s status](screenshots/parte4/verificar_api_info.png)



## Parte 5: Ingress + MetalLB

**IP del Ingress:**
### Screenshots

**mostrando ip asignada y mostrando rutas configuradas**
![microk8s status](screenshots/parte5/verificar_configuracion_ingress.png)

**mostrando navegador accediendo (FRONTEND)**
![microk8s status](screenshots/parte5/navegador_accediendo_metallb_frontend.png)

**mostrando navegador accediendo (FRONTEND)**
![microk8s status](screenshots/parte5/api-info.png)


**mostrando CURL ACTUADOR HEALTH**
![microk8s status](screenshots/parte5/curl_actuador-health.png)

**IP del Ingress**
![microk8s status](screenshots/parte5/ip_ingress_anotar.png)


## Conclusiones
### Aprendizajes principales
Comprensión profunda del ciclo de vida de una aplicación con Docker y Kubernetes, desde la creación de imágenes hasta el despliegue en un cluster.
Habilidad para orquestar contenedores utilizando manifiestos de Kubernetes, incluyendo Deployments, Services, ConfigMaps y Secrets.
Manejo de herramientas clave como kubectl, microk8s y la integración con Docker Hub.
Implementación y gestión de Ingress para exponer servicios externamente de forma eficiente.

### Dificultades encontradas
Configuración inicial de MetalLB en MicroK8s: Tuve problemas para definir el rango de IPs correcto y que el servicio de MetalLB reconociera los IPs disponibles. Lo resolví revisando la documentación de MicroK8s y ajustando el ConfigMap de MetalLB hasta que los Load Balancers obtuvieron IPs.
Depuración de manifiestos de Kubernetes: Errores sutiles en la sintaxis YAML o en la referencia de nombres me causaron frustración. La resolví usando kubectl describe y kubectl logs para obtener más detalles y el validador YAML en mi editor de código.


### Reflexión
Este proyecto me ha proporcionado una base sólida para entender cómo las aplicaciones modernas se construyen, empaquetan y despliegan a escala. Aplicaría esto en un proyecto real para asegurar despliegues consistentes y escalables, utilizando CI/CD para automatizar las actualizaciones y rollbacks. Es fundamental para la entrega continua y la resiliencia de la infraestructura.



