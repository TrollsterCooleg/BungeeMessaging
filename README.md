# BungeeMessaging
Little API/Plugin to make BungeeCord messaging simpler.

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
	      <version>v1.0.1</version>
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
    compileOnly 'com.github.TrollsterCooleg:BungeeMessaging:v1.0.1'
}
```
