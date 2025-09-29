# Laboratorio6 — PokeAPI + Retrofit + Jetpack Compose

Aplicación Android de laboratorio que consume la **PokeAPI** para:
1. Listar los **primeros 100 Pokémon**.
2. Mostrar el **detalle** de cada Pokémon con sus **4 sprites** (Front, Back, Front Shiny, Back Shiny).

> Proyecto en **Kotlin** con **Jetpack Compose**, **Navigation Compose**, **Retrofit + Moshi**, **OkHttp** y **Coil**.

---

## 📱 Demo (Screenshots)

| Lista | Detalle |
|-------|---------|
| ![Lista](docs/screenshots/list.png) | ![Detalle](docs/screenshots/detail.png) |


---

## 🛠️ Tech Stack

- **Kotlin** + **Coroutines**
- **Jetpack Compose** (UI declarativa)
- **Material 3**
- **Navigation Compose**
- **Lifecycle ViewModel**
- **Retrofit** + **Moshi** (JSON)
- **OkHttp** (+ Logging Interceptor)
- **Coil** (carga de imágenes)

---

## 🗂️ Estructura del proyecto

```
app/src/main/java/com/example/laboratorio6/
├─ data/
│  ├─ model/ (PokemonListResponse, PokemonDetail, Sprites)
│  └─ remote/ (ApiClient, PokeApi)
├─ ui/
│  ├─ list/ (PokemonListViewModel, PokemonListScreen)
│  └─ detail/ (PokemonDetailViewModel, PokemonDetailScreen)
├─ Nav.kt
└─ MainActivity.kt

docs/screenshots/
 ├─ list.png
 └─ detail.png
```

---

## 🌐 API utilizada

- **Base URL**: `https://pokeapi.co/api/v2/`
- **Endpoints**:
  - Listado: `GET /pokemon?limit=100`
  - Detalle: `GET /pokemon/{id}`

> Gracias a **[PokeAPI](https://pokeapi.co/)** por proveer este servicio público.

---

## 🚀 Requisitos

- Android Studio **Koala+**
- **JDK 17**
- **minSdk**: 24
- **compileSdk**: 35 / 36

---

## ▶️ Ejecución

1. Clona este repositorio:
   ```bash
   git clone https://github.com/Junjey123-mx/Laboratorio6.git
   ```
2. Abre el proyecto en **Android Studio**.
3. Sincroniza Gradle.
4. Ejecuta en un emulador o dispositivo:
   - Botón **Run ▶ app**  
   - O desde terminal:
     ```bash
     ./gradlew assembleDebug
     ```

---

## 🔒 Permisos

- `INTERNET` — necesario para consultar la PokeAPI.

---

## ✨ Mejoras futuras

- Búsqueda y filtrado por nombre.
- Paginación con `offset/limit`.
- Pull-to-refresh en la lista.
- Placeholders y manejo de errores en Coil.
- Tests unitarios para repositorios y ViewModels.

---

## 📄 Licencia

Este proyecto es de carácter **educativo**.  
El contenido visual (sprites) pertenece a sus autores originales y proviene de **PokeAPI**.

---
