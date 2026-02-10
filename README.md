# Carteira do Cabral (FlashGastos)

**Carteira do Cabral** is an "Input-First" Android application designed for near-instantaneous financial logging. Addressing the "Friction Gap" in personal finance, it adheres strictly to a **"3-Second Rule"**: from pocket to "Transaction Saved" in under 3 seconds.

By leveraging native Android integrations (Widgets, Quick Settings, Local Sensors) and an offline-first architecture, it eliminates the need for navigation, loading screens, or cloud accounts.

## 📱 Key Features

*   **⚡ The 3-Second Rule:** App launches directly to a numeric keypad. No dashboard, no loading.
*   **🎹 Calculator-First UI:** Log expenses like you are using a calculator. Type amount -> Tap Category -> Done.
*   **🔒 Offline-First & Privacy:** 100% Data Sovereignty. SQLite (Room) database on your device. No internet permissions. No cloud sync.
*   **👆 One-Tap Categorization:** Persistent grid of emoji-based category icons for immediate saving.
*   **🧩 Native Integrations (Planned):** Home Screen Widgets and Quick Settings Tiles for logging without opening the full app.

## 🛠 Tech Stack

*   **Language:** Kotlin (1.9+)
*   **UI Framework:** Jetpack Compose (Material 3)
*   **Architecture:** MVVM + Clean Architecture
*   **DI:** Hilt (Dagger)
*   **Persistence:** Room Database (SQLite)
*   **Async:** Coroutines + Flow
*   **Build:** Gradle (Kotlin DSL)

## 🏗 Architecture

The application follows a Clean Architecture approach:

*   **Presentation:** `ui/screens` (Composables) and `ui/viewmodels` (State management).
*   **Domain:** `domain/usecase` (Business logic) and `domain/model`.
*   **Data:** `data/repository` (Single source of truth) and `data/local` (Room Entities/DAOs).

## 🚀 Getting Started

1.  Clone the repository:
    ```bash
    git clone https://github.com/carlosmscabral/demo-cabral-carteira-kotlin.git
    ```
2.  Open in **Android Studio**.
3.  Sync Gradle project.
4.  Run on an emulator or device (Min SDK 26).

## 🎨 Design System

**"Tactile Pop"**
*   High contrast, clear boundaries, and immediate visual feedback.
*   **Primary:** Indigo-500 (`#6366F1`)
*   **Secondary:** Pink-500 (`#EC4899`)
*   **Success:** Emerald-500 (`#10B981`)

## 📄 License

This project is for educational and portfolio purposes.
