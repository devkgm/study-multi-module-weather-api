tasks.getByName("bootJar"){
    enabled=true
}
tasks.getByName("jar"){
    enabled=false
}
dependencies {
    implementation (project(":domain:weather-domain"))
    implementation (project(":internal:common"))
    implementation ("org.springframework.boot:spring-boot-starter-web")

}

