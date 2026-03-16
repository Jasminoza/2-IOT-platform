val appVersion: String by project
val javaVersion: String by project

plugins {
  java
  id("org.springframework.boot") version "4.0.3"
  id("io.spring.dependency-management") version "1.1.7"
}

group = "org.yolkin"
version = "$appVersion"

java {
  toolchain {
    languageVersion = JavaLanguageVersion.of(javaVersion)
  }
}

repositories {
  mavenCentral()
  maven {
    url = uri("https://packages.confluent.io/maven/")
  }
}

dependencies {
  implementation("org.springframework.boot:spring-boot-starter-web")

  testImplementation("org.springframework.boot:spring-boot-starter-test") {
    exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
  }
}

tasks.test {
  useJUnitPlatform()  // ← Обязательно для JUnit 5!
  testLogging {
    events("passed", "skipped", "failed")
  }
}
