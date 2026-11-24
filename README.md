# CxdElite Launcher

A Java 21 + JavaFX desktop launcher project for Minecraft: Java Edition.

## Current milestone

- Branded desktop launcher window
- Version selector UI
- Windows EXE packaging workflow through GitHub Actions

## Build locally

Requirements: JDK 21, Gradle 9.2.0, and WiX Toolset (for the Windows EXE installer).

```powershell
gradle run
gradle jpackage
```

The Windows installer is generated under `build/jpackage`.

## Development roadmap

1. Desktop launcher UI
2. Microsoft account authentication
3. Minecraft version metadata and asset/library downloads
4. Java runtime management
5. Game launch process and profiles
6. Installer polish, signing, and release automation

Authentication and game launching are not implemented in the first UI milestone yet.
