val appVersion: String by project
val javaVersion: String by project
val lombokVersion: String by project

plugins {
  java
  id("org.springframework.boot") version "4.0.3"
  id("io.spring.dependency-management") version "1.1.7"
}

group = "org.yolkin"
version = appVersion

java {
  toolchain {
    languageVersion = JavaLanguageVersion.of(javaVersion)
  }
}

repositories {
  mavenCentral()
}

dependencies {
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("org.springframework.kafka:spring-kafka")

  implementation("org.projectlombok:lombok:$lombokVersion")

  compileOnly("org.projectlombok:lombok:$lombokVersion")

  annotationProcessor(
    "org.projectlombok:lombok:$lombokVersion",
  )

  testImplementation("org.springframework.boot:spring-boot-starter-test") {
    exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
  }

  testCompileOnly("org.projectlombok:lombok:${lombokVersion}")

  testAnnotationProcessor(
    "org.projectlombok:lombok:$lombokVersion",
  )
}

tasks.test {
  useJUnitPlatform()
  testLogging {
    events("passed", "skipped", "failed")
  }
}
