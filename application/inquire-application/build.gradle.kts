tasks.getByName("bootJar"){
    enabled=true
}
tasks.getByName("jar"){
    enabled=false
}
dependencies {
    implementation (project(":domain:weather-domain"))
    implementation ("org.springframework.boot:spring-boot-starter-web")
    testImplementation ("org.springframework.boot:spring-boot-starter-test")
    implementation (project(":internal:common"))
}

