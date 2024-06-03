# Usar uma imagem base do JDK 11 ou 17
FROM openjdk:17-jdk-alpine

# Definir o diretório de trabalho no container
WORKDIR /app

# Copiar o arquivo JAR do projeto para o diretório de trabalho no container
COPY target/jedi-0.0.1-SNAPSHOT.jar app.jar

# Expor a porta que a aplicação irá rodar
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]