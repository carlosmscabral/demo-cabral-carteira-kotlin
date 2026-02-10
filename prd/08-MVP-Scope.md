# 08-MVP-Scope.md

## MVP Prioritization Matrix

The core objective of the MVP is to prove the **"3-Second Rule"**: any transaction must be completed within 3 seconds of opening the app or interacting with a system shortcut.

| Priority | Feature Name | Description | User Value |
| :--- | :--- | :--- | :--- |
| **P0** | **Calculator-First Entry** | App launches directly into a large numeric keypad. No "Add" button required to start. | Eliminates navigation friction for immediate data entry. |
| **P0** | **One-Tap Categorization** | A persistent grid of emoji-based category icons (🍔, 🚗, 🛒) immediately below the value input. | Reduces cognitive load; transforms "data entry" into a "two-tap" flow. |
| **P0** | **Offline Room DB** | Local-only SQLite implementation for transaction storage using Jetpack Room. | Ensures instant performance and 100% privacy (no network latency). |
| **P0** | **Simple Budget Glance** | A "Resta: R$ XXX" (Remaining) counter displayed at the top of the entry screen. | Provides instant feedback on financial health without opening reports. |
| **** | **---** | **---** | **---** |
| **P1** | **Macro Widgets** | Home screen shortcuts that log a fixed amount/category instantly (e.g., "R$ 5.00 Coffee"). | Zero-app-open entry for frequent, repetitive micro-expenses. |
| **P1** | **Recurring Engine** | Logic to auto-generate fixed transactions (Netflix, Rent, Gym) on specific dates. | Automates ~30% of monthly entries, leaving only variables for the user. |
| **P1** | **Quick Settings Tile** | A custom Android system tile that opens a floating input overlay. | Allows entry without leaving the current app (e.g., while inside a banking app). |
| **P1** | **Local CSV/JSON Export** | Manual trigger to generate a portable file of all recorded data. | Provides "The Privacy Purist" with data sovereignty and backup peace of mind. |
| **P1** | **Geofence Highlighting** | UI highlights the most likely category based on GPS coordinates (e.g., Pulse "🛒" if at Carrefour). | Further reduces the 3-second window by predicting user intent. |
| **** | **---** | **---** | **---** |
| **Out** | **Cloud Sync / Auth** | No Firebase, no AWS, no Login screens. | Maintains "Privacy First" and "Speed First" pillars. |
| **Out** | **Bank Connectivity** | No Open Finance or SMS scraping. | Eliminates technical fragility and security concerns. |
| **Out** | **Shared Accounts** | No "Family/Partner" syncing. | Keeps the data model simple and strictly local. |
| **Out** | **Advanced AI Voice** | Complex LLM-based voice processing. | Avoids cloud dependency; stick to native Android speech-to-text if implemented later. |

## Success Metrics for MVP
1.  **Time-to-Log:** Average time from "App Icon Tap" to "Transaction Saved" must be < 3 seconds.
2.  **Retention:** High frequency of daily usage (3+ times/day) for variable spending.
3.  **App Size:** Binary size < 10MB (Native performance expectation).