# Use a multi-stage build to optimize the final image size
# First stage: Build the Quarkus application
FROM maven:3.8.3-openjdk-17 AS build
COPY . /app
WORKDIR /app
RUN mvn clean package -Dquarkus.package.type=native -Pprod

# Second stage: Create a minimal runtime image
FROM debian:bullseye-slim

RUN mkdir /app
COPY --from=build /app/target/*-runner /app/application
CMD ["/app/application", "-Dquarkus.http.host=0.0.0.0"]