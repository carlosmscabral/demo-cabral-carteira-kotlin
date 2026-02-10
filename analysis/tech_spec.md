# Tech Spec: Carteira do Cabral

## Stack
Android Native (Kotlin + Jetpack Compose) / None (Local Logic) / Room (SQLite)

## Detailed Spec
# Technical Specification: Carteira do Cabral (Concept: 1Click Money)

## 1. Executive Summary
**Carteira do Cabral** is a high-performance, offline-first Android expense tracker focused on friction reduction. Unlike traditional finance apps that focus on dashboards, this application focuses on input speed, aiming for a "3-second entry" workflow via a Calculator-First interface, Home Screen Widgets, and Context-Aware features.

## 2. System Architecture
Since the app is **Offline-First**, there is no client-server architecture. The app follows the **MVVM (Model-View-ViewModel)** pattern with **Clean Architecture** principles.

### Layers
1.  **UI Layer (Presentation):** Jetpack Compose Activities, Widgets (Glance), and TileService.
2.  **Domain Layer:** Pure Kotlin UseCases (e.g., `AddTransactionUseCase`, `DetectCategoryByLocationUseCase`).
3.  **Data Layer:** Repository implementations using Room (DAO) and DataStore (Preferences).

## 3. Detailed Technology Stack

*   **Language:** Kotlin.
*   **UI Toolkit:** Jetpack Compose (Material 3).
*   **Dependency Injection:** Hilt.
*   **Async Operations:** Coroutines & Flow.
*   **Database:** Room (SQLite wrapper).
*   **Background Tasks:** WorkManager (for recurring transactions).
*   **System Integrations:**
    *   `Glance`: For creating responsive Home Screen widgets.
    *   `TileService`: For the Quick Settings dropdown shortcut.
    *   `LocationManager/Geofencing`: For location-based category suggestions.
    *   `SpeechRecognizer`: For offline voice commands.

## 4. Database Schema (Room)

### Table: `transactions`
Core table for storing financial entries.
*   `id` (Long, PK): Auto-increment.
*   `amount` (Long): Stored in cents (e.g., 2500 for R$ 25,00) to avoid floating-point errors.
*   `categoryId` (Int, FK): Links to Category.
*   `timestamp` (Long): Epoch time.
*   `description` (String): Optional note.
*   `locationLat` (Double): Optional.
*   `locationLng` (Double): Optional.
*   `source` (Enum): MANUAL, WIDGET, VOICE, RECURRING.

### Table: `categories`
*   `id` (Int, PK).
*   `name` (String): e.g., "Alimentação".
*   `icon` (String): Emoji or Resource ID.
*   `color` (String): Hex code.
*   `defaultGeoLat` (Double): Learned location latitude.
*   `defaultGeoLng` (Double): Learned location longitude.

### Table: `recurring_rules`
*   `id` (Int, PK).
*   `description` (String): "Netflix".
*   `amount` (Long).
*   `dayOfMonth` (Int): 1-31.
*   `categoryId` (Int).
*   `active` (Boolean).

## 5. Feature Specifications

### 5.1 Calculator-First Interface (MainActivity)
*   **Startup:** `windowBackground` must match the UI color to simulate instant load.
*   **UI:** A large numeric keypad takes up 60% of the screen. Top 40% shows the input stream (e.g., "25.00") and a horizontal scroll of Category Icons.
*   **Logic:** Tapping a category immediately saves the transaction and minimizes the app (configurable).

### 5.2 Android Widgets (Jetpack Glance)
*   **Macro Widget:** Grid of 4 user-defined buttons (e.g., "Café R$5", "Almoço R$30").
    *   *Action:* `Intent` that fires a `BroadcastReceiver` to insert data silently via `GlobalScope` or WorkManager without opening the UI.
*   **Balance Widget:** A simple text view querying `SELECT SUM(amount) ...` for the current month vs Budget.

### 5.3 Quick Settings Tile
*   **Component:** Extends `TileService`.
*   **Behavior:** On click, opens a transparent Activity (`Theme.Translucent`) containing only the Keypad Dialog overlaying the current screen.

### 5.4 Geofencing & Smart Suggestion
*   **Learning:** When user saves "Mercado" at coords (X, Y), update `categories.defaultGeoLat/Lng`.
*   **Predicting:** On app open, check `FusedLocationProvider.getLastLocation()`.
    *   If current location is within 100m of a Category GeoTag -> Highlight that category and pulse the icon.
    *   *Privacy:* Location permission requested only for "While Using the App".

### 5.5 Offline Voice Command
*   **Input:** Microphone button on keypad.
*   **Processing:** Use `SpeechRecognizer` intent.
*   **Regex Parser:** Parse string "[VALOR] reais [CATEGORIA/DESCRIÇÃO]".
    *   *Example:* "Trinta reais gasolina" -> Amount: 3000, Category: "Transporte" (fuzzy match on "gasolina").

### 5.6 Recurring Transactions
*   **Engine:** `WorkManager` `PeriodicWorkRequest` (runs daily).
*   **Logic:** Check `recurring_rules`. If `dayOfMonth == today` AND not already inserted -> Insert transaction automatically.

## 6. Security & Backup
*   **Biometrics:** `BiometricPrompt` protects the "History" and "Charts" tabs. The "Input" tab remains unlocked for speed.
*   **Backup:**
    *   **Auto:** Android AllowBackup=true (Encrypted in user's Google Drive).
    *   **Manual:** Export to CSV/JSON to local file system using `Storage Access Framework`.

## 7. Development Roadmap
1.  **Phase 1 (MVP):** Calculator UI, Room DB, basic Categories, CSV Export.
2.  **Phase 2 (Speed):** Widgets (Glance), Quick Settings Tile, Biometrics.
3.  **Phase 3 (Smarts):** Geolocation learning, Voice input, Recurring WorkManager.
