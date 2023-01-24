plugins {
    val kotlinVersion = "1.7.10"
    kotlin("jvm") version kotlinVersion
    kotlin("plugin.serialization") version kotlinVersion
    id ("com.github.johnrengelman.shadow") version "7.1.2"
    application
    id("net.mamoe.mirai-console") version "2.13.2"

}

group = "cn.pprocket"
version = "0.1.0"

repositories {
    maven("https://maven.aliyun.com/repository/public")
    mavenCentral()
}
dependencies {
    implementation("net.mamoe:mirai-console-terminal:2.13.2") // 自行替换版本
    implementation("net.mamoe:mirai-core:2.13.2")
    // https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-annotations
    implementation("com.fasterxml.jackson.core:jackson-annotations:2.14.1")
    implementation ("cn.hutool:hutool-all:5.8.10")
    implementation("com.google.code.gson:gson:2.10")
    compileOnly ("org.projectlombok:lombok:1.18.12")
    annotationProcessor ("org.projectlombok:lombok:1.18.12")
    testCompileOnly ("org.projectlombok:lombok:1.18.12")
    testAnnotationProcessor ("org.projectlombok:lombok:1.18.12")
    implementation ("com.github.promeg:tinypinyin:2.0.3")
    implementation("com.alibaba.fastjson2:fastjson2:2.0.21")
}
tasks {
    named<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar>("shadowJar") {
        this.isZip64 = true
    }
}
application {
    mainClass.set("cn.pprocket.DemoKt")
    mainClassName = "cn.pprocket.DemoKt"
}

