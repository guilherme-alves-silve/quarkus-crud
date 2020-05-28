# quarkus-crud project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Execute MySQL DB

docker run --network host -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=teste -d --rm mysql:8.0.19

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```
./mvnw quarkus:dev
```

## Packaging and running the application

The application can be packaged using `./mvnw package`.
It produces the `quarkus-crud-1.0-SNAPSHOT-runner.jar` file in the `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

The application is now runnable using `java -jar target/quarkus-crud-1.0-SNAPSHOT-runner.jar`.

## Creating a native executable

You can create a native executable using: `./mvnw package -Pnative`.

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: `./mvnw package -Pnative -Dquarkus.native.container-build=true`.

If you have problems with the compiling process, do the command: `./mvnw package -Pnative -Dquarkus.native.container-build=true -X`.

If you want to skip tests too, use: `./mvnw package -Dmaven.test.skip=true -Pnative -X`

You can then execute your native executable with: `./target/quarkus-crud-1.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/building-native-image.

## Running the application in the container using the same host as mysql-db

### Running the quarkus without being native
docker run --network host -i --rm -p 8080:8080 quarkus/quarkus-crud-jvm   

### Running the quarkus being native                
docker run --network host -i --rm -p 8080:8080 quarkus/quarkus-crud                 
