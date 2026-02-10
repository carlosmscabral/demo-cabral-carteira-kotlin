# Track Specification: Setup & Calculator-First UI (P0)

## 1. Goal
Initialize the Android project with the defined technology stack and implement the "Calculator-First" (P0) user interface, enabling the user to enter an amount, select a category, and save the transaction to the local Room database.

## 2. Scope
This track covers the foundation of the application and the primary user journey (The "3-Second Rule").

### In Scope
*   **Project Configuration:** Adding dependencies for Room, Hilt, Navigation Compose, and Lifecycle.
*   **Architecture Setup:** Configuring Hilt for Dependency Injection and setting up the MVVM structure.
*   **Data Layer:** Implementing the Room Database, Entities (`Transaction`, `Category`), and DAOs.
*   **Domain Layer:** Basic UseCases for saving transactions.
*   **UI Layer:**
    *   Implementing the "Tactile Pop" design system (Colors, Typography, Shapes).
    *   Creating the Custom Numeric Keypad Composable.
    *   Creating the "Calculator-First" Screen (Input + Category Grid).
*   **Functionality:**
    *   User can type an amount (auto-formatted).
    *   User can select a category from a pre-defined list.
    *   "Save" action persists data to Room and resets the UI.

### Out of Scope
*   Home Screen Widgets (Glance).
*   Quick Settings Tile.
*   Geofencing/Location Logic.
*   Voice Input.
*   History/Dashboard Screens.
*   Recurring Expenses.

## 3. Technical Requirements

### 3.1 Dependencies
Update `libs.versions.toml` and `app/build.gradle.kts` to include:
*   `androidx.room:room-runtime`, `room-ktx`, `room-compiler`
*   `com.google.dagger:hilt-android`, `hilt-compiler`
*   `androidx.hilt:hilt-navigation-compose`
*   `androidx.navigation:navigation-compose`
*   `androidx.lifecycle:lifecycle-runtime-compose`

### 3.2 Data Model (Room)
*   **Entity:** `Category` (Pre-populate with: Food, Transport, Home, Shopping, Others)
*   **Entity:** `Transaction` (id, amount_cents, category_id, timestamp)
*   **DAO:** `TransactionDao` (Insert), `CategoryDao` (Query All)

### 3.3 UI Components
*   **`NumericKeypad`:** A 4x3 grid of buttons (1-9, ., 0, Backspace).
*   **`AmountDisplay`:** Large text showing current input.
*   **`CategoryGrid`:** Horizontal or Grid list of category icons.
*   **`MainEntryScreen`:** The composable hosting the above components.

## 4. Acceptance Criteria
*   [ ] The app builds and runs without errors.
*   [ ] The app opens immediately to the "Calculator-First" screen.
*   [ ] User can type "250" and see "2.50" (or "2,50").
*   [ ] Tapping a category icon saves the transaction to the database.
*   [ ] A "Success" animation or feedback occurs upon saving.
*   [ ] The input field resets after saving.
*   [ ] Data persists after app restart.
