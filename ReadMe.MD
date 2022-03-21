

Reqres Microservicios

RetoRest-Assured-Reqres_Sofka hecho por Juan Esteban Londoño Ruiz. Este proyecto esta realizado bajo el modelo POO(Programacion Orientada a Objetos) y bajo el Lenguaje de programacion Java bajo el gestor de dependencias Gradle🐘

Pre Requisitos 📋

Se debe de tener en el equipo a ejecutar Java version 11, update 191 o superior and JDK (Variables de entorno Configuradas). Eclipse IDE, IntelliJ IDEA, o NetBeans (version 2019 o superior)

Para clonar este repositorio localmente este es el comando el cual se debera ejecutar: git clone https://github.com/EstebanLonR/RetoRest-Assured-Reqres_Sofka.git Importar el proyecto a los IDE Eclipse,IntelliJ o NetBeans.

Explicacion del Proyecto🤓

En la carpeta de Documentos de pruebas estaran publicados en formato PDF el plan de pruebas construido para la verificacion de las funcionalidades de los microservicios. Igualmente en este siguiente Link tambien se encontrara publicado el mismo: https://fuzzy-gruyere-5cb.notion.site/Plan-De-Pruebas-Automatizadas-Reqres-9ecfc00f648f4b50a36bafcf255288f6

Variables y Funciones: Lower Camel Case. Ejemplo: nomenclaturaEjemplo. Class names: PascalCase or Upper Camel Case. Ejemplo: NomenclaturaEjemplo. Versionamiento 🔀 Git es usado para el control de Version.

La estructura completa del projecto es la siguiente :

SourcesPackage/


Package main/util: contiene todas las utilidades que seran necesarias para implementar en la automatizacion

Package test/runner: es la clase desde donde seran ejecutadas las automatizaciones.

Package test/stepdefinition: contiene los pasos necesarios con las que el runner podra correr la automatizacion.

Directory resources/features: se encuentran las historias de usuario y los escenarios propuestos para probar en lenguaje Gherkin

