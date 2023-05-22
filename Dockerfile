# Define a imagem base
FROM openjdk:21-ea-17-slim-buster

# Define o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copia o arquivo JAR (gerado após a construção do projeto) para o contêiner
COPY target/interview-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta em que o servidor Spring Boot está configurado para escutar
EXPOSE 8080

# Define o comando de inicialização do contêiner
ENTRYPOINT ["java", "-jar", "app.jar"]