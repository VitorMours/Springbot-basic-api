# Etapa 1: Usar uma imagem base do Maven para compilar o projeto
FROM maven:3.8.4-openjdk-17-slim AS build

# Definir o diretório de trabalho no contêiner
WORKDIR /app

# Copiar os arquivos do projeto para o contêiner
COPY . /app/

# Baixar dependências e compilar o projeto (inclui um comando de clean install)
RUN mvn clean install -DskipTests

# Etapa 2: Criar a imagem para rodar a aplicação (imagem base do OpenJDK)
FROM openjdk:17-jdk-slim

# Definir o diretório de trabalho no contêiner
WORKDIR /app

# Copiar o JAR gerado da etapa de build para o contêiner
COPY --from=build /app/target/diorailway-0.0.1-SNAPSHOT.jar /app/diorailway.jar

# Expor a porta da aplicação Spring Boot (padrão 8080)
EXPOSE 8080

# Comando para iniciar o aplicativo Spring Boot
CMD ["java", "-jar", "/app/diorailway.jar"]
