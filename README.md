# Security Notes for StudentGrades Application

## Security Note 1
The application properties, without the store password is like this:

```properties
spring.application.name=studentgrades

#server.port=8443
server.port=8080
server.ssl.key-store=classpath:studentgrades.p12
server.ssl.key-store-password=yourPassword
server.ssl.key-store-type=PKCS12
server.ssl.key-alias=studentgrades
spring.main.allow-circular-references=true
```

You need to replace "yourPassword" with a password, without quotes: e.g. `server.ssl.key-store-password=pass123`:


## Security Note 2: 

To create the password needed for the file application.properties, you should use the command:

```properties
keytool -genkeypair -alias studentgrades -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore studentgrades.p12 -validity 3650
```

## Security Note 3: 

The file "studentgrades.p12" must be put inside the "resources" folder
