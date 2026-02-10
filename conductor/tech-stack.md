# Carteira do Cabral (FlashGastos) - Tech Stack

## Core Architecture
*   **Language:** Kotlin (1.9+)
*   **UI Framework:** Jetpack Compose (Material 3)
*   **Architecture Pattern:** MVVM (Model-View-ViewModel) + Clean Architecture
    *   **Presentation Layer:** Composables, ViewModels
    *   **Domain Layer:** UseCases, Repository Interfaces, Models
    *   **Data Layer:** Repository Implementations, Room DAOs, Data Sources
*   **Dependency Injection:** Hilt (Dagger)
*   **Concurrency:** Kotlin Coroutines + Flow

## Data Persistence (Local Only)
*   **Database:** Room Persistence Library (SQLite)
*   **Key-Value Storage:** Jetpack DataStore (Preferences)
*   **Encryption (Optional):** SQLCipher for Room

## Android Integrations
*   **Widgets:** Jetpack Glance (App Widgets)
*   **Quick Settings:** TileService API
*   **Location:** Google Play Services Location (Geofencing API)
*   **Voice:** Android SpeechRecognizer (Offline)
*   **Background Tasks:** WorkManager

## Testing & Quality
*   **Unit Testing:** JUnit 5, Mockk
*   **UI Testing:** Espresso, Compose Test Rule
*   **Linting:** Ktlint
*   **Performance:** Google Play Vitals, Timber (Logging)

## Build & CI
*   **Build System:** Gradle (Kotlin DSL)
*   **Min SDK:** 26 (Android 8.0)
*   **Target SDK:** 34 (Android 14)
