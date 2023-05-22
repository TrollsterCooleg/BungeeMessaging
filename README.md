# BungeeMessaging
Little API/Plugin to make BungeeCord messaging simpler.

[Javadoc](https://bungeelib.cooleg.me/)

Import API into your plugins (Maven):
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
<dependencies>
    <dependency>
        <groupId>com.github.TrollsterCooleg</groupId>
        <artifactId>BungeeMessaging</artifactId>
        <version>v1.1.0</version>
        <scope>provided</scope>
    </dependency>
</dependencies>
```

Import API into your plugins (Gradle):
```groovy
repositories {
    maven { url 'https://jitpack.io' }
}
dependencies {
    compileOnly 'com.github.TrollsterCooleg:BungeeMessaging:v1.1.0'
}
```
