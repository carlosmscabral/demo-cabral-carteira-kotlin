# 07 - Tech Stack

## Core Architecture
| Layer | Technology | Rationale |
| :--- | :--- | :--- |
| **Language** | Kotlin 1.9+ | Modern, concise, and the industry standard for robust Android development. |
| **UI Framework** | Jetpack Compose | Enables the "Tactile Pop" persona with declarative UI. High performance for calculator-style grids and smooth animations. |
| **Architecture** | MVVM + Clean Architecture | Separates local business logic (Recurrence/Geo-triggers) from the UI. Essential for maintaining a low-latency "Instant Open" experience. |
| **Dependency Injection** | Hilt (Dagger) | Simplifies the management of Room databases and Geofencing services. |

## 1. Frontend (UI/UX)
*   **Jetpack Compose:** Used for the primary "Calculator-First" interface.
*   **Jetpack Glance:** Specifically for the **Home Screen Widgets**. Glance allows building widgets using a Compose-style syntax while ensuring they are lightweight and responsive for the "3-second rule."
*   **Material 3 (M3):** Implementation of the "Tactile Pop" UI using customized `ColorScheme` (#6366F1, #EC4899, etc.) and `Shape` tokens for large, tactile buttons.
*   **Accompanist / Compose Permissions:** Streamlined handling of GPS and Voice permissions.

## 2. Database & Storage (Local-Only)
*   **Room Persistence Library (SQLite):** 
    *   *Why:* Handles complex queries for monthly reports and recurring expenses.
    *   *Version:* 2.6+ (Supports Kotlin Symbol Processing - KSP for faster builds).
*   **DataStore (Preferences):** Used for lightweight key-value pairs like "User Theme Preference" or "Last Used Category."
*   **SQLCipher:** (Optional/Pro) Extension for Room to provide hardware-accelerated encryption of the database file at rest.

## 3. Native Android Integration (The "Frictionless" Layer)
*   **Geofencing API (Google Play Services):**
    *   *Purpose:* To trigger "Smart Categorization" based on local coordinates without active GPS tracking or cloud data processing.
*   **TileService (Quick Settings Tile):**
    *   *Purpose:* Enables the "Quick Entry" pop-up accessible from the Android notification shade.
*   **SpeechRecognizer (Android Speech):**
    *   *Purpose:* Offline-capable "Voice-to-Transaction" processing. Uses `EXTRA_PARTIAL_RESULTS` for instant feedback.
*   **WorkManager:**
    *   *Purpose:* Handles the "Automatic Manual" recurrence engine. Schedules background tasks to inject entries (Rent, Netflix) even if the app isn't opened.

## 4. Security & Privacy
*   **BiometricPrompt API:** Standardized Fingerprint/FaceID integration. Allows the "Input" screen to remain open while locking "Analytics/Grants" views.
*   **Android Backup Service:** Uses Google’s native encrypted backup (Key/Value or Full Backup) to ensure data persists across device changes without the dev needing a backend.

## 5. Tooling & Analytics
*   **Google Play Vitals:** For anonymized performance monitoring (ANRs/Crashes) without tracking user spending habits.
*   **Timber:** Local-only logging for debugging.
*   **JUnit 5 & Espresso:** For testing the math logic of the calculator and the UI flow of the "1-Click" launch.

## 6. Deployment & Payments
*   **Google Play Billing Library:** To manage "Pro" feature unlocks (e.g., voice commands, unlimited widgets).
*   **ASO Focus:** Optimized for keywords like "No-Sync," "Private Finance," "Quick Expense," and "Offline Budget."

## Summary of Versions (Recommended)
*   **Min SDK:** 26 (Android 8.0) - Ensures compatibility with `TileService` and modern `NotificationChannels`.
*   **Target SDK:** 34 (Android 14) - For latest privacy and foreground service optimizations.
*   **Compose Compiler:** Latest stable (aligned with Kotlin version).