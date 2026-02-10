---
name: carteira-do-cabral-android
description: Native Android development context for Carteira do Cabral (FlashGastos). Focuses on "3-second rule" speed, offline-first Room DB, and Jetpack Compose UI.
---

# Carteira do Cabral - Android Context

## 📂 Context Files reference
The following files contain the detailed specifications for this project:
- `01-Product-Overview.md`: Vision & Strategy (Extreme speed, friction-less entry)
- `02-User-Flows.md`: Critical user journeys (2-tap transaction flow)
- `03-Feature-Specs.md`: Detailed feature requirements (Calculator UI, Widgets, Tiles)
- `04-Data-Model.md`: Room Database schema and local entities
- `05-API-Specs.md`: N/A (Local-first architecture)
- `06-UI-Specs.md`: Design tokens (Tactile Pop style) & Component library
- `07-Tech-Stack.md`: Android Native implementation details
- `08-MVP-Scope.md`: Implementation roadmap and P0 prioritization

## 📱 Product Vision
"If it takes more than 3 seconds to log, the user quits." Carteira do Cabral is an **instant-entry** expense tracker. It bypasses dashboards and goes straight to a numeric keypad. It leverages Android-native features like Home Screen Widgets, Quick Settings Tiles, and local Geofencing to predict spending habits without ever compromising privacy or requiring a cloud account.

## 🛠 Android Tech Stack
| Component | Choice |
|-----------|--------|
| Language | Kotlin |
| UI Toolkit | Jetpack Compose (Material 3) |
| Architecture | MVVM + Clean Architecture |
| DI | Hilt |
| Async/Streams | Coroutines + Flow |
| Local DB | Room (SQLite) |
| Navigation | Jetpack Navigation Compose |
| Widgets | Glance (Compose for Widgets) |
| Location | Google Play Services Location (Local processing) |

## 🔌 Data Architecture
The app is strictly **Offline-First**. There is no remote API.
- **Repository Pattern:** The repository interacts solely with the Room DAO.
- **Data Sovereignty:** Backups are handled via Android’s Auto Backup (Google Drive/Encrypted) or manual CSV export.
- **Geofencing:** Coordinates are stored locally to map "Location -> Category" for UI prioritization.

## 📦 Project Structure
```
com.cabral.carteira
├── data
│   ├── local
│   │   ├── dao        # Room DAOs
│   │   ├── entities   # Room Tables
│   │   └── AppDatabase.kt
│   └── repository     # Single source of truth (Local only)
├── di                 # Hilt Modules
├── domain
│   ├── model          # UI Models
│   └── usecase        # GetBalance, SaveTransaction, GetSuggestedCategory
├── ui
│   ├── components     # Custom Calculator, Emoji Grid
│   ├── theme          # Tactile Pop (Indigo, Pink, Emerald)
│   ├── screens
│   │   ├── entry      # P0: Calculator-first screen
│   │   ├── history    # List of transactions
│   │   └── settings   # Export/Import CSV
│   └── shortcuts      # Widget & Quick Tile providers
└── MainActivity.kt
```

## ✅ MVP Checklist (P0 Priority)
- [ ] **Calculator-First UI:** Main Activity opens directly to numeric input.
- [ ] **One-Tap Categorization:** Grid of emoji buttons immediately saves the transaction.
- [ ] **Room Implementation:** Save `Transaction` entity with `timestamp`, `amount`, and `category`.
- [ ] **Budget Glance:** Simple "Remaining Budget" calculation displayed on the main input screen.
- [ ] **Haptic Feedback:** Tactile vibrations on keypad and save confirmation.

## 🎨 UI Guidelines (Tactile Pop)
- **Primary Color:** `#6366F1` (Indigo)
- **Secondary Color:** `#EC4899` (Pink)
- **Success/Income:** `#10B981` (Emerald)
- **Background:** `#F8FAFC` (Slate 50)
- **Interaction:** Large hit targets for buttons (min 48dp), rounded corners (24dp+), and spring animations.

## ⚠️ Known Constraints
- **Strictly Local:** Do not implement Firebase or any networking libraries unless for CSV backup to a user-chosen URI.
- **Speed is King:** Avoid heavy splash screens or complex navigation transitions.
- **Privacy:** Biometric prompt must be optional and non-blocking for the initial value input (only for viewing reports).