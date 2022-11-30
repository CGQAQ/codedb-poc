import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.7.6-SNAPSHOT"
	id("io.spring.dependency-management") version "1.1.0"
	kotlin("jvm") version "1.6.21"
	kotlin("plugin.serialization") version "1.6.21"

	id("org.jetbrains.kotlin.jupyter.api") version "0.11.0-89-1"
}

group = "org.archguard.codedb"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
	maven { url = uri("https://repo.spring.io/milestone") }
	maven { url = uri("https://repo.spring.io/snapshot") }
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-data-mongodb-reactive")
	implementation("org.springframework.boot:spring-boot-starter-webflux")

	implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

	implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")

	implementation("com.phodal.chapi:chapi-domain:2.0.0-beta.4")

	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")

	// DSL
	implementation("org.jetbrains.kotlinx:kotlin-jupyter-api:0.11.0-89-1")
	implementation("org.jetbrains.kotlinx:kotlin-jupyter-kernel:0.11.0-89-1")
	compileOnly("org.jetbrains.kotlin:kotlin-scripting-jvm:1.6.21")

	implementation("org.slf4j:slf4j-api:2.0.3")

	developmentOnly("org.springframework.boot:spring-boot-devtools")

	// for tasking
	implementation("org.jetbrains.kotlin:kotlin-reflect:1.6.21")

	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.1")

	testImplementation("io.kotest:kotest-assertions-core:5.5.4")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("io.projectreactor:reactor-test")

	testImplementation("de.flapdoodle.embed:de.flapdoodle.embed.mongo")

	testImplementation("com.phodal.chapi:chapi-ast-java:2.0.0-beta.9")
	testImplementation("com.phodal.chapi:chapi-domain:2.0.0-beta.9")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
