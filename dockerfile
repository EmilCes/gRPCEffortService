# Etapa 1: Compilar la aplicación
FROM openjdk:11-jdk-slim AS build

# Crear un directorio para la aplicación
WORKDIR /app

# Copiar los archivos de configuración de Gradle y el código fuente
COPY build.gradle settings.gradle gradlew /app/
COPY gradle /app/gradle
COPY src /app/src

# Dar permisos de ejecución al wrapper de Gradle
RUN chmod +x gradlew

# Compilar el código fuente
RUN ./gradlew build

# Etapa 2: Ejecutar la aplicación
FROM openjdk:11-jre-slim

# Crear un directorio para la aplicación
WORKDIR /app

# Copiar el JAR compilado desde la etapa de compilación
COPY --from=build /app/build/libs/*.jar app.jar

# Copiar la carpeta de recursos al contenedor
COPY src/main/resources/uploads /app/resources/uploads

# Crear el directorio de uploads si no existe
RUN mkdir -p /app/resources/uploads

# Establecer el directorio de trabajo
WORKDIR /app

# Exponer el puerto en el que el servidor gRPC escucha
EXPOSE 50051

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "app.jar"]
