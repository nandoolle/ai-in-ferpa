plugins {
	java
	id("org.springframework.boot") version "3.4.0"
	id("io.spring.dependency-management") version "1.1.6"
	id("org.hibernate.orm") version "6.6.2.Final"
	id("org.graalvm.buildtools.native") version "0.10.3"
}

group = "codingferpa"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(23)
	}
}

repositories {
	mavenCentral()
	// JitPack URL for JPlayer
	maven { setUrl("https://jitpack.io") }
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	// JPlayer
	implementation("com.github.umjammer:jlayer:1.0.3")
	// Gson
	implementation("com.google.code.gson:gson:2.11.0")
	// LangChain4j
	implementation("dev.langchain4j:langchain4j-core:0.36.2")
	implementation("dev.langchain4j:langchain4j:0.36.2")
	implementation("dev.langchain4j:langchain4j-open-ai-spring-boot-starter:0.36.2")
	// Resend
	implementation("com.resend:resend-java:3.1.0")

	compileOnly("org.projectlombok:lombok")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	runtimeOnly("com.h2database:h2")
	annotationProcessor("org.projectlombok:lombok")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	// LangChain4j

	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

hibernate {
	enhancement {
		enableAssociationManagement = true
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
